package es.valhalla.web.fermi.engine.render.renderer.pdf

import es.valhalla.web.fermi.engine.component.document.DocumentSection
import es.valhalla.web.fermi.engine.render.context.DocumentRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfDocumentRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfDocumentSectionRenderContext
import es.valhalla.web.fermi.engine.render.renderer.DocumentSectionRenderer
import es.valhalla.web.fermi.engine.style.Style
import org.slf4j.LoggerFactory
import java.util.Date


class PdfDocumentSectionRenderer : DocumentSectionRenderer {

	private val log = LoggerFactory.getLogger(PdfDocumentSectionRenderer::class.java)

	override fun render(
		documentSection: DocumentSection,
		parentContext: DocumentRenderContext
	): DocumentRenderContext {
		val initTime = System.currentTimeMillis()

		val pages = documentSection.elements

		var sectionRenderContext = PdfDocumentSectionRenderContext(
			pageNumber = 0,
			sectionPageNumber = 0,
			parentContext = parentContext,
			style = documentSection.sectionStyle ?: Style.BASE_STYLE,
			componentBox = documentSection.boxModel,
			renderingMilliseconds = 0
		)

		log.info("PdfSectionPageRenderer.render started at: {}", Date(initTime))

		val documentRenderContext: PdfDocumentRenderContext = parentContext as PdfDocumentRenderContext

		val sectionPageRenderer = PdfSectionPageRenderer()

		//rendering each page of this section
		for (page in pages) {
			sectionRenderContext = sectionPageRenderer.render(page, sectionRenderContext) as PdfDocumentSectionRenderContext
		}

		val renderingMilliseconds = System.currentTimeMillis() - initTime

		log.info("PdfSectionPageRenderer.render finished, took: {} milliseconds", renderingMilliseconds)

		return documentRenderContext.copy(
			renderingMilliseconds = renderingMilliseconds
		)
	}

}
