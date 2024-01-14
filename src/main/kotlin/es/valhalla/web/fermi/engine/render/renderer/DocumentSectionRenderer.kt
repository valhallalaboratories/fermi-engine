@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package es.valhalla.web.fermi.engine.render.renderer

import es.valhalla.web.fermi.engine.component.document.DocumentSection
import org.apache.pdfbox.pdmodel.PDPage
import org.slf4j.LoggerFactory
import java.util.Date

interface DocumentSectionRenderer : ComponentRenderer<DocumentSection, PdfSectionRenderContext> {

	override fun render(
		documentSection: DocumentSection,
		renderContext: PdfSectionRenderContext
	): PdfSectionRenderContext
}

class PdfDocumentSectionRenderer : DocumentSectionRenderer {

	private val log = LoggerFactory.getLogger(PdfDocumentSectionRenderer::class.java)

	override fun render(
		documentSection: DocumentSection,
		renderContext: PdfSectionRenderContext
	): PdfSectionRenderContext {
		val initTime = System.currentTimeMillis()

		val pages = documentSection.elements

		log.info("PdfSectionPageRenderer.render started at: {}", Date(initTime))

		val pageRenderer = PdfPageRenderer()

		val pdfDocument = renderContext.documentRenderContext.pdfDocument

		var pageRenderContext: PdfPageRenderContext? = null

		for (page in pages) {
			val pdfPage = PDPage(documentSection.boxModel.pdRectangle)

			if (pageRenderContext == null) {
				pageRenderContext = PdfPageRenderContext(pdfPage = pdfPage, sectionRenderContext = renderContext)
			}

			pageRenderContext = pageRenderer.render(
				component = page,
				renderContext = pageRenderContext.copy(
					pdfPage = pdfPage,
					pageNumber = pageRenderContext.pageNumber + 1
				)
			)

			pdfDocument.addPage(pageRenderContext.pdfPage)
		}

		val milliseconds = System.currentTimeMillis() - initTime

		log.info("PdfSectionPageRenderer.render finished, took: {} milliseconds", milliseconds)

		return renderContext.copy(
			renderingMilliseconds = milliseconds,
			sectionNumber = renderContext.sectionNumber + 1,
			initPageNumber = (pageRenderContext?.pageNumber ?: 0) + 1
		)
	}

}

