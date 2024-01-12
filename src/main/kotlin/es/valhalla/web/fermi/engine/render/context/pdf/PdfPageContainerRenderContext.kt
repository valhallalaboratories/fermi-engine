package es.valhalla.web.fermi.engine.render.context.pdf

import es.valhalla.web.fermi.engine.render.context.DocumentSectionRenderContext
import es.valhalla.web.fermi.engine.render.context.PageContainerRenderContext

data class PdfPageContainerRenderContext(
	override val posX: Int = 0,
	override val posY: Int = 0,
	override val parentContext: DocumentSectionRenderContext,
	override val renderingMilliseconds: Long

) : PageContainerRenderContext(
	posX = posX,
	posY = posY,
	parentContext = parentContext,
	renderingMilliseconds = renderingMilliseconds
)
