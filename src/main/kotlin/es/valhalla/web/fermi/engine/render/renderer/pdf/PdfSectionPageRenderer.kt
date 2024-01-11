package es.valhalla.web.fermi.engine.render.renderer.pdf

import es.valhalla.web.fermi.engine.component.document.Page
import es.valhalla.web.fermi.engine.render.context.ContainerParentRenderContext
import es.valhalla.web.fermi.engine.render.context.DocumentSectionRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfContainerParentRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfDocumentSectionRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfPageRenderContext
import es.valhalla.web.fermi.engine.render.renderer.SectionPageRenderer
import org.slf4j.LoggerFactory


class PdfSectionPageRenderer : SectionPageRenderer {

	private val log = LoggerFactory.getLogger(SectionPageRenderer::class.java)

	override fun render(
		page: Page,
		parentContext: DocumentSectionRenderContext
	): DocumentSectionRenderContext {
		val startedAt = System.currentTimeMillis()

		val context = parentContext as PdfDocumentSectionRenderContext

		val pageRenderContext = PdfPageRenderContext(
			parentContext = parentContext,
			renderingMilliseconds = 0
		)
		val containerRenderer: PdfContainerRenderer = PdfContainerRenderer()
		val pageContent = page.pageContainer

		val pageContainerRenderContext: ContainerParentRenderContext = PdfContainerParentRenderContext(parentContext = pageRenderContext)
		val parentContainerRenderContext = containerRenderer.render(pageContent, pageContainerRenderContext)

		return context.copy(
			renderingMilliseconds = System.currentTimeMillis() - startedAt
		)
	}

}
