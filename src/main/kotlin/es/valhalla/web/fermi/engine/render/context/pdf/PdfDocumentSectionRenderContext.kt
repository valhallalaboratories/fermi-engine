package es.valhalla.web.fermi.engine.render.context.pdf

import es.valhalla.web.fermi.engine.render.context.DocumentRenderContext
import es.valhalla.web.fermi.engine.render.context.DocumentSectionRenderContext

data class PdfDocumentSectionRenderContext(
	override val parentContext: DocumentRenderContext,
	override val pageNumber: Int,
	override val sectionPageNumber: Int,
	override val renderingMilliseconds: Long = 0
) : DocumentSectionRenderContext
