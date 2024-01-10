package es.valhalla.web.fermi.engine.printer

import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.renderer.pdf.PdfDocumentRenderer
import es.valhalla.web.fermi.engine.renderer.renderContext.pdf.PdfDocumentRenderContext
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
		val documentRenderer = PdfDocumentRenderer(document)
		val renderContext = documentRenderer.render(document) as PdfDocumentRenderContext

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
