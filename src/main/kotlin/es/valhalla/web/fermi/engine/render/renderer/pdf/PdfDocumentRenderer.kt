package es.valhalla.web.fermi.engine.render.renderer.pdf

import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.render.context.DocumentRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfDocumentRenderContext
import es.valhalla.web.fermi.engine.render.renderer.DocumentRenderer
import org.apache.pdfbox.pdmodel.PDDocument


class PdfDocumentRenderer(
	private val document: FermiDocument
) : DocumentRenderer {


	override fun render(document: FermiDocument): DocumentRenderContext {
		val pdfDocument = PDDocument()

		var currentDocumentRenderRenderContext: DocumentRenderContext = PdfDocumentRenderContext(pdfDocument)

		val documentSectionRenderer = PdfDocumentSectionRenderer()

		for (section in this.document.documentSections) {
			currentDocumentRenderRenderContext = documentSectionRenderer.render(section, currentDocumentRenderRenderContext)
		}

		return currentDocumentRenderRenderContext
	}


}


