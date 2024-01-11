package es.valhalla.web.fermi.engine.render.context.pdf

import es.valhalla.web.fermi.engine.render.context.DocumentSectionRenderContext
import es.valhalla.web.fermi.engine.render.context.RenderContext

data class PdfPageRenderContext(
	override val renderingMilliseconds: Long,
	override val parentContext: DocumentSectionRenderContext
) : RenderContext
