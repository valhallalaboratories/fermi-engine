package es.valhalla.web.fermi.engine.renderer.pdf

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.renderer.DocumentRenderer
import es.valhalla.web.fermi.engine.renderer.DocumentSectionRenderer
import es.valhalla.web.fermi.engine.renderer.renderContext.RenderContext
import es.valhalla.web.fermi.engine.renderer.renderContext.pdf.PdfDocumentRenderContext
import org.apache.pdfbox.pdmodel.PDDocument
import java.io.File


class PdfDocumentRenderer(private val document: FermiDocument) : DocumentRenderer {

	private val pdfDocument = PDDocument()

	override val documentSectionRenderer: DocumentSectionRenderer
		get() = PdfDocumentSectionRenderer()

	override val renderContext: RenderContext
		get() = PdfDocumentRenderContext(
			destinationFile = File(""),
			pdfDocument = pdfDocument,
			parentBox = document.boxModel,
			currentComponentBeingRendered = document
		)


	override fun render(
		component: Component
	): RenderContext {
		var currentRenderContext = renderContext

		for (item in document.documentSections) {
			currentRenderContext = documentSectionRenderer.render(item)
		}
		return currentRenderContext
	}


}


