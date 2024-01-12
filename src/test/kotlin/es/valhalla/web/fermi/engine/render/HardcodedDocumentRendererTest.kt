package es.valhalla.web.fermi.engine.render

import es.valhalla.web.fermi.engine.color.Color
import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.document.DocumentProperties
import es.valhalla.web.fermi.engine.component.document.DocumentSection
import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.component.document.Page
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.print.PdfDocumentPrinter
import es.valhalla.web.fermi.engine.print.PrintOptions
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.common.PDRectangle
import org.apache.pdfbox.pdmodel.font.PDType1Font
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class HardcodedDocumentRendererTest {

	@Test fun `test print non hardcoded document`() {

		val realFermiDocument = FermiDocument(
			documentProperties = DocumentProperties(
				documentBox = ComponentBox.PAGE_BASE_A4_WITH_BORDERS
			)
		)

		realFermiDocument.documentSections.addLast(
			DocumentSection(
				sectionName = "Empty section :D",
				sectionStyle = realFermiDocument.style,
				document = realFermiDocument,
				layout = LayoutType.NoLayout,
				pages = mutableListOf(
					Page(
						Container(
							parentComponentId = realFermiDocument.componentId,
							boxModel = realFermiDocument.boxModel,
							style = realFermiDocument.style.copy(backgroundColor = Color.WHITE, foregroundColor = Color.GREEN)
						)
					)
				)
			)
		)

		val printer = PdfDocumentPrinter(PrintOptions(destinationFile = File("demoFile.pdf")))

		val printedDocument = printer.printDocument(realFermiDocument)

		assertThat(realFermiDocument.documentId).isNotNull()
		assertThat(printedDocument.renderingMilliseconds).isNotEqualTo(0)


	}

	@Test fun `test print sample document`() {
		val document = PDDocument()
		val page = PDPage(PDRectangle.A4)

		document.addPage(page)

		val contentStream = PDPageContentStream(document, page)

		val tableTopY = page.mediaBox.height - 2f
		val tableRowHeight = 20f
		val tableColumnWidth = page.mediaBox.width / 3 - 2 * 2f
		val margin = 2f // changed margin here

		// Header
		contentStream.setNonStrokingColor(Color.BLACK.javaColor)
		contentStream.addRect(margin, tableTopY, page.mediaBox.width - 2 * margin, -tableRowHeight)
		contentStream.fill()

		// Draw header text
		contentStream.beginText()
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12f)
		contentStream.setNonStrokingColor(Color.WHITE.javaColor)
		contentStream.newLineAtOffset(margin + 3f, tableTopY - 15f)
		contentStream.showText("Country")
		contentStream.newLineAtOffset(tableColumnWidth, 0f)
		contentStream.showText("Population")
		contentStream.endText()

		// Draw table rows
		contentStream.setFont(PDType1Font.HELVETICA, 12f)
		contentStream.setNonStrokingColor(Color.GREEN.javaColor)

		var nextY = tableTopY - tableRowHeight

		val countries =
			listOf(
				Country("Germany", 83166711),
				Country("France", 67060000),
				Country("Italy", 60360000),
				// Add all the countries...
			).sortedByDescending {it.population}

		var totalPopulation = 0L

		for (country in countries) {
			contentStream.beginText()
			contentStream.newLineAtOffset(margin + 3f, nextY - 15f)
			contentStream.showText(country.name)
			contentStream.newLineAtOffset(tableColumnWidth, 0f)
			contentStream.showText(country.population.toString())
			contentStream.endText()
			nextY -= tableRowHeight
			totalPopulation += country.population
		}
		// Footer
		contentStream.addRect(margin, tableRowHeight, page.mediaBox.width - 2 * margin, -tableRowHeight)
		contentStream.fill()

		// Draw footer text
		contentStream.beginText()
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12f)
		contentStream.setNonStrokingColor(Color.WHITE.javaColor)
		contentStream.newLineAtOffset(margin + 3f, tableRowHeight + 5f)
		contentStream.showText("Total population: $totalPopulation")
		contentStream.endText()

		contentStream.close()

		document.save("example.pdf")
		document.close()
	}

}

class Country(
	val name: String,
	val population: Int
)
