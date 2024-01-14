@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package es.valhalla.web.fermi.engine.render.renderer

import es.valhalla.web.fermi.engine.component.document.FermiDocument
import org.slf4j.LoggerFactory

/**
 * This interface provides methods to render a component with its document sections.
 *
 */
interface DocumentRenderer<RenderContextImpl : RenderContext> : ComponentRenderer<FermiDocument, RenderContextImpl> {

	/**
	 * Render a component to a document.
	 *
	 * @param document the component to render.
	 * @return RenderContext version after rendering the full document component tree.
	 */
	override fun render(
		document: FermiDocument,
		renderContext: RenderContextImpl
	): RenderContext
}


class PdfDocumentRenderer : DocumentRenderer<PdfDocumentRenderContext> {

	private val log = LoggerFactory.getLogger(PdfDocumentRenderer::class.java)

	override fun render(
		component: FermiDocument,
		renderContext: PdfDocumentRenderContext
	): RenderContext {
		val documentSectionRenderer = PdfDocumentSectionRenderer()
		var documentSectionRenderContext = PdfSectionRenderContext(documentRenderContext = renderContext, sectionNumber = 0, initPageNumber = 0, pageNumber = 0, renderingMilliseconds = 0)

		for (section in component.documentSections) {
			documentSectionRenderContext = documentSectionRenderer.render(section, documentSectionRenderContext)
		}

		return renderContext
	}
}
