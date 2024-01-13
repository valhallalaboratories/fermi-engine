package es.valhalla.web.fermi.engine.render.renderer.pdf

import es.valhalla.web.fermi.engine.component.document.Page
import es.valhalla.web.fermi.engine.render.context.DocumentSectionRenderContext
import es.valhalla.web.fermi.engine.render.context.PageContainerRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfDocumentRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfDocumentSectionRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfPageContainerRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfPageRenderContext
import es.valhalla.web.fermi.engine.render.renderer.SectionPageRenderer
import org.apache.pdfbox.pdmodel.PDPage
import org.slf4j.LoggerFactory


class PdfSectionPageRenderer : SectionPageRenderer {

	private val log = LoggerFactory.getLogger(PdfSectionPageRenderer::class.java)

	override fun render(
		page: Page,
		parentContext: DocumentSectionRenderContext
	): DocumentSectionRenderContext {
		val startedAt = System.currentTimeMillis()
		val pageInnerContainer = page.pageContainer
		val pdfPage = PDPage(parentContext.boxModel.pdRectangle)
		val rootContext = parentContext.rootContext as PdfDocumentRenderContext

		val documentSectionRenderContext: PdfDocumentSectionRenderContext = parentContext as PdfDocumentSectionRenderContext

		var pageRenderContext = PdfPageRenderContext(
			pdfPage = pdfPage,
			posX = 0,
			posY = 0,
			parentContext = parentContext,
			renderingMilliseconds = 0
		)

		val containerRenderer = PdfPageContainerRenderer()

		val pageContainerRenderContext: PageContainerRenderContext = PdfPageContainerRenderContext(
			parentContext = documentSectionRenderContext,
			renderingMilliseconds = 0
		)

		pageRenderContext = containerRenderer.render(pageInnerContainer, pageRenderContext) as PdfPageRenderContext

		rootContext.pdfDocument.addPage(pdfPage)

		return documentSectionRenderContext.copy(
			renderingMilliseconds = System.currentTimeMillis() - startedAt,
			pageNumber = documentSectionRenderContext.pageNumber + 1
		)
	}

}
