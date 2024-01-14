package es.valhalla.web.fermi.engine.render.renderer

import es.valhalla.web.fermi.engine.component.document.Page
import org.slf4j.LoggerFactory

interface PageRenderer<RenderContextImpl : RenderContext> : ComponentRenderer<Page, RenderContextImpl> {

	override fun render(
		component: Page,
		renderContext: RenderContextImpl
	): PageRenderContext
}

class PdfPageRenderer : PageRenderer<PdfPageRenderContext> {

	private val log = LoggerFactory.getLogger(PdfPageRenderer::class.java)

	override fun render(
		component: Page,
		renderContext: PdfPageRenderContext
	): PdfPageRenderContext {
		val startedAt = System.currentTimeMillis()
		val pageInnerContainer = component.pageContainer

		val milliseconds = System.currentTimeMillis() - startedAt

		val containerRenderer = PdfContainerRenderer()

		val containerRenderContext = PdfContainerRenderContext(
			renderContext = renderContext,
			pdfPage = renderContext.pdfPage,
			pdfDocument = renderContext.pdfDocument,
			parentBoxModel = component.pageContainer.boxModel
		)
		val pageRenderedContainerContext = containerRenderer.render(pageInnerContainer, containerRenderContext)

		log.info("PdfPageRenderer.render finished, took: {} milliseconds", milliseconds)

		return renderContext.copy(
			pageNumber = renderContext.pageNumber + 1,
			renderingMilliseconds = renderContext.renderingMilliseconds + milliseconds
		)
	}
}
