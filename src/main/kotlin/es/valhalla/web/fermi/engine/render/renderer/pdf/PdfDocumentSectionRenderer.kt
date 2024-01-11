package es.valhalla.web.fermi.engine.render.renderer.pdf

import es.valhalla.web.fermi.engine.component.document.DocumentSection
import es.valhalla.web.fermi.engine.render.context.DocumentRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfDocumentRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfDocumentSectionRenderContext
import es.valhalla.web.fermi.engine.render.renderer.DocumentSectionRenderer
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

		val sectionRenderContext = PdfDocumentSectionRenderContext(
			pageNumber = 0,
			sectionPageNumber = 0,
			parentContext = parentContext,
			renderingMilliseconds = 0
		)

		log.info("PdfSectionPageRenderer.render started at: {}", Date(initTime))

		val documentRenderContext: PdfDocumentRenderContext = parentContext as PdfDocumentRenderContext

		val sectionPageRenderer = PdfSectionPageRenderer()

		for (page in pages) {
			sectionPageRenderer.render(page, sectionRenderContext)
		}
		val renderingMilliseconds = System.currentTimeMillis() - initTime

		log.info("PdfSectionPageRenderer.render finished, took: {} milliseconds", renderingMilliseconds)

		return documentRenderContext.copy(
			renderingMilliseconds = renderingMilliseconds
		)
	}

}
