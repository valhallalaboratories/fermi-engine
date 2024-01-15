package es.valhalla.web.fermi.engine.render

import es.valhalla.web.fermi.engine.color.Color
import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.component.boxmodel.BoxModel
import es.valhalla.web.fermi.engine.component.boxmodel.PointSize
import es.valhalla.web.fermi.engine.component.document.DocumentProperties
import es.valhalla.web.fermi.engine.component.document.DocumentSection
import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.component.document.Page
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.layout.StackedComponent
import es.valhalla.web.fermi.engine.print.PdfDocumentPrinter
import es.valhalla.web.fermi.engine.print.PrintOptions
import org.apache.pdfbox.cos.COSArray
import org.apache.pdfbox.cos.COSDictionary
import org.apache.pdfbox.cos.COSFloat
import org.apache.pdfbox.cos.COSName
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.common.PDRectangle
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType2
import org.apache.pdfbox.pdmodel.font.PDType1Font
import org.apache.pdfbox.pdmodel.font.Standard14Fonts
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType2
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import java.io.File
import java.util.UUID

class HardcodedDocumentRendererTest {

	private val log = LoggerFactory.getLogger(HardcodedDocumentRendererTest::class.java)

	@Test fun `test print non hardcoded document`() {

		val realFermiDocument = FermiDocument(
			documentProperties = DocumentProperties(
				documentBox = BoxModel.PAGE_BASE_A4_WITH_BORDERS
			)
		)
		val documentMainSection = DocumentSection(
			sectionName = "Empty section :D",
			sectionStyle = realFermiDocument.style,
			document = realFermiDocument,
			layout = LayoutType.NoLayout,
			pages = mutableListOf()
		)
		realFermiDocument.documentSections.addFirst(documentMainSection)
		val firstPageContainer = Container(
			parentComponentId = documentMainSection.componentId,
			boxModel = documentMainSection.boxModel,
			layout = LayoutType.RowLayout,
			style = realFermiDocument.style.copy(backgroundColor = Color.WHITE, foregroundColor = Color.GREEN)
		)
		val firstPage = documentMainSection.sectionStyle?.let {
			Page(
				boxModel = documentMainSection.boxModel,
				parentComponentId = documentMainSection.parentComponentId,
				style = it
			)
		}
		firstPageContainer.elements.add(
			StackedComponent(
				componentId = UUID.randomUUID().toString(),
				parentComponentId = firstPageContainer.componentId,
				style = realFermiDocument.style.copy(backgroundColor = Color.WHITE, foregroundColor = Color.BLUE),
				boxModel = firstPageContainer.boxModel.copy(height = PointSize(100f)),
				expandWidth = true
			)
		)


		val printer = PdfDocumentPrinter(PrintOptions(destinationFile = File("demoFile.pdf")))

		val printedDocument = printer.printDocument(realFermiDocument)

		assertThat(realFermiDocument.documentId).isNotNull()
		// assertThat(printedDocument.renderingMilliseconds).isNotEqualTo(0)


	}

	@Test fun `render page with borders`() {
		val document = PDDocument()
		val page = PDPage(PDRectangle.A4)
		document.addPage(page)

		val margin = 36 * 72 / 96  // Convert pixels to points
		val headerHeight = 100 * 72 / 96  // Convert pixels to points
		val padding = 10 * 72 / 96  // Convert pixels to points
		val headerTopY = page.mediaBox.height - margin
		val headerBottomY = headerTopY - headerHeight

		val childWidth1 = 100 * 72 / 96  // Convert pixels to points for the first child
		val childX1 = margin + padding
		val childBottomY = headerBottomY + padding
		val childTextPadding = 2 * 72 / 96  // Convert pixels to points for padding inside the child box
		PDPageContentStream(document, page).use {cs ->
			// Set the color for the header background
			cs.setNonStrokingColor(Color.GRAY.javaColor)

			// Draw the header rectangle
			cs.addRect(margin.toFloat(), headerBottomY, page.mediaBox.width - 2 * margin, headerHeight.toFloat())
			cs.fill()

			// Draw the header top and bottom borders
			drawBorder(cs, margin.toFloat(), headerTopY, page.mediaBox.width - margin, true)
			drawBorder(cs, margin.toFloat(), headerBottomY, page.mediaBox.width - margin, true)

			// Set the color for the first child box
			cs.setNonStrokingColor(Color.WHITE.javaColor)  // Change this color as needed

			// Draw the first child box
			val childHeight = headerHeight - 2 * padding
			cs.addRect(childX1.toFloat(), headerBottomY + padding, childWidth1.toFloat(), childHeight.toFloat())
			cs.fill()

			cs.setNonStrokingColor(Color.BLACK.javaColor)

			// Add text inside the first child box
			val textX = childX1 + childTextPadding
			val textY = headerBottomY + padding + childHeight - childTextPadding - 8  // Start from the top inside the box

			val text = """
				Hello
				pdfbox
				world
				""".trimIndent()

			cs.beginText()

			val helveticaBold: PDType1Font = PDType1Font(Standard14Fonts.FontName.HELVETICA)
			val fontSize = 8f
			cs.setFont(helveticaBold, fontSize)
			val lineSpacing = 2
			cs.newLineAtOffset(textX.toFloat(), textY)
			val lineHeight = fontSize + lineSpacing  // Total height of a line including spacing

			for (line in text.split("\n")) {
				cs.showText(line)
				val widthValue = helveticaBold.getStringWidth(line) * fontSize / 1000
				log.info("This line with text '{}' has a width of {}", line, widthValue)
				val newLineOffset = -lineHeight  // Move to the next line, down by lineHeight
				cs.newLineAtOffset(0f, newLineOffset)
			}
			cs.endText()

			// Draw bottom border for the first child box
			drawBorder(cs, childX1.toFloat(), childBottomY, (childX1 + childWidth1).toFloat(), true)
		}

		document.save("Output.pdf")
		document.close()
	}

	private fun drawBorder(
		cs: PDPageContentStream,
		x: Float,
		y1: Float,
		y2: Float,
		isHorizontal: Boolean
	) {
		cs.setStrokingColor(Color.BLACK.javaColor)
		if (isHorizontal) {
			// Draw horizontal border
			cs.moveTo(x, y1)
			cs.lineTo(y2 - x, y1)
		} else {
			// Draw vertical border
			cs.moveTo(x, y1)
			cs.lineTo(x, y2)
		}
		cs.stroke()
	}


	@Test fun `testing `() {
		val document = PDDocument()
		val page = PDPage(PDRectangle.A4)
		document.addPage(page)

		val margin = 36 * 72 / 96  // Convert pixels to points
		val headerHeight = 100 * 72 / 96  // Convert pixels to points
		val padding = 10 * 72 / 96  // Convert pixels to points
		val headerBottomY = page.mediaBox.height - margin - headerHeight

		val childWidth = 100 * 72 / 96  // Convert pixels to points for the child boxes
		val childX1 = margin + padding
		val childX2 = 10 + childWidth + padding  // X position for the second child box
		val childHeight = headerHeight - 2 * padding

		PDPageContentStream(document, page).use {cs ->
			// Set the color for the header background
			cs.setNonStrokingColor(Color.GRAY.javaColor)
			// Draw the header rectangle
			cs.addRect(margin.toFloat(), headerBottomY, page.mediaBox.width - 2 * margin, headerHeight.toFloat())
			cs.fill()

			// Draw the first child box with blue background
			cs.setNonStrokingColor(Color.BLUE.javaColor)
			cs.addRect(childX1.toFloat(), headerBottomY + padding, childWidth.toFloat(), childHeight.toFloat())
			cs.fill()

			// Create an extended graphics state for transparency
			val transparency = PDExtendedGraphicsState().apply {

				nonStrokingAlphaConstant = 0.7f  // 20% transparency
			}
			cs.setGraphicsStateParameters(transparency)
			// Draw the second child box with green background and half height
			cs.setNonStrokingColor(Color.GREEN.javaColor)
			val secondChildHeight = childHeight / 2
			cs.addRect(childX2.toFloat(), headerBottomY + padding, childWidth.toFloat(), secondChildHeight.toFloat())
			cs.fill()

			cs.setGraphicsStateParameters(PDExtendedGraphicsState())
		}

		document.save("OutputOverlapping.pdf")
		document.close()
	}

	@Test fun `gradient`() {
		val document = PDDocument()
		val page = PDPage(PDRectangle.A4)
		document.addPage(page)

		val margin = 36f // Points
		val headerHeight = 100f // Points

		// Shading function from light gray to black
		val function = PDFunctionType2(COSDictionary().apply {
			setName(COSName.FUNCTION_TYPE, "2")
			val domain = COSArray().apply {
				add(COSFloat(0f))
				add(COSFloat(1f))
			}
			setItem(COSName.DOMAIN, domain)
			val c0 = COSArray().apply {
				add(COSFloat(0.8f)) // Light gray
				add(COSFloat(0.8f))
				add(COSFloat(0.8f))
			}
			setItem(COSName.C0, c0)
			val c1 = COSArray().apply {
				add(COSFloat(0f)) // Black
				add(COSFloat(0f))
				add(COSFloat(0f))
			}
			setItem(COSName.C1, c1)
			setItem(COSName.N, COSFloat(1f))
		})

		// Shading dictionary
		val shadingDict = COSDictionary().apply {
			setName(COSName.SHADING_TYPE, "1") // Axial shading
			setName(COSName.COLORSPACE, "DeviceRGB")
			val coords = COSArray().apply {
				add(COSFloat(margin)) // x0
				add(COSFloat(page.mediaBox.upperRightY - margin - headerHeight)) // y0
				add(COSFloat(margin)) // x1
				add(COSFloat(page.mediaBox.upperRightY - margin)) // y1
			}
			setItem(COSName.COORDS, coords)
			setItem(COSName.FUNCTION, function.cosObject)
		}

		val shading = PDShadingType2(shadingDict)

		PDPageContentStream(document, page).use {cs ->

			cs.addRect(margin, page.mediaBox.upperRightY - margin - headerHeight, page.mediaBox.width - 2 * margin, headerHeight)
			cs.clip()
			cs.shadingFill(shading)
		}

		document.save("OutputWithGradient.pdf")
		document.close()
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
		val helveticaBold: PDType1Font = PDType1Font(Standard14Fonts.FontName.HELVETICA)
		contentStream.setFont(helveticaBold, 12f)
		contentStream.setNonStrokingColor(Color.WHITE.javaColor)
		contentStream.newLineAtOffset(margin + 3f, tableTopY - 15f)
		contentStream.showText("Country")
		contentStream.newLineAtOffset(tableColumnWidth, 0f)
		contentStream.showText("Population")
		contentStream.endText()

		// Draw table rows
		contentStream.setFont(helveticaBold, 12f)
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
		contentStream.setFont(helveticaBold, 12f)
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
