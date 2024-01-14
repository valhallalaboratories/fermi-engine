package es.valhalla.web.fermi.engine.print

import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.render.renderer.PdfDocumentRenderContext
import es.valhalla.web.fermi.engine.render.renderer.PdfDocumentRenderer
import org.apache.pdfbox.pdmodel.PDDocument
import java.io.File

interface DocumentPrinter {

	val printOptions: PrintOptions

	fun printDocument(document: FermiDocument): PrintedDocument
}

class PrintOptions(
	val destinationFile: File
)

class PdfDocumentPrinter(
	override val printOptions: PrintOptions
) : DocumentPrinter {

	override fun printDocument(document: FermiDocument): PrintedDocument {
		val documentRenderer = PdfDocumentRenderer()

		val renderContext = documentRenderer.render(document, PdfDocumentRenderContext(pdfDocument = PDDocument(), renderingMilliseconds = 0)) as PdfDocumentRenderContext

		val destinationFile: File = printOptions.destinationFile

		val pdfDocument = renderContext.pdfDocument

		pdfDocument.save(destinationFile)
		pdfDocument.close()

		return PrintedDocument(
			renderingMilliseconds = renderContext.renderingMilliseconds,
			output = destinationFile
		)
	}
}
