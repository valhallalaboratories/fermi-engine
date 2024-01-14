package es.valhalla.web.fermi.engine.render.renderer

import es.valhalla.web.fermi.engine.component.boxmodel.BoxModel
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage

interface RenderContext {

	val renderingMilliseconds: Long
}

interface DocumentRenderContext : RenderContext

data class PdfDocumentRenderContext(
	val pdfDocument: PDDocument,
	override val renderingMilliseconds: Long = 0
) : DocumentRenderContext

interface SectionRenderContext : RenderContext {

	val documentRenderContext: DocumentRenderContext
	val sectionNumber: Int
	val initPageNumber: Int
	val pageNumber: Int
}

data class PdfSectionRenderContext(
	override val documentRenderContext: PdfDocumentRenderContext,
	override val sectionNumber: Int,
	override val initPageNumber: Int,
	override val pageNumber: Int,
	override val renderingMilliseconds: Long
) : SectionRenderContext

interface PageRenderContext : RenderContext {

	val pageNumber: Int
	val sectionRenderContext: SectionRenderContext
}

data class PdfPageRenderContext(
	val pdfPage: PDPage,
	override val sectionRenderContext: SectionRenderContext,
	override val pageNumber: Int = sectionRenderContext.initPageNumber + 1,
	override val renderingMilliseconds: Long = 0
) : PageRenderContext {

	val pdfDocument: PDDocument
		get() {
			val pdfDocumentRenderContext = sectionRenderContext.documentRenderContext as PdfDocumentRenderContext
			return pdfDocumentRenderContext.pdfDocument
		}
}

interface PageContainerRenderContext : RenderContext {

	val pageRenderContext: PageRenderContext
}

data class PdfPageContainerRenderContext(
	val pageRenderContext: PageRenderContext,
	override val renderingMilliseconds: Long = 0
) : RenderContext


class PdfContainerRenderContext(
	val renderContext: RenderContext,
	val pdfDocument: PDDocument,
	val pdfPage: PDPage,
	val parentBoxModel: BoxModel,
	override val renderingMilliseconds: Long = 0
) : RenderContext



