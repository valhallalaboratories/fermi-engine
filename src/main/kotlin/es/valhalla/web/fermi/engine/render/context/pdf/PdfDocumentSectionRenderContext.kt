package es.valhalla.web.fermi.engine.render.context.pdf

import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.render.context.DocumentRenderContext
import es.valhalla.web.fermi.engine.render.context.DocumentSectionRenderContext
import es.valhalla.web.fermi.engine.style.Style

data class PdfDocumentSectionRenderContext(
	override val parentContext: DocumentRenderContext,
	override val pageNumber: Int,

	override val sectionPageNumber: Int,
	override val renderingMilliseconds: Long = 0,
	override val style: Style,
	override val componentBox: ComponentBox
) : DocumentSectionRenderContext
