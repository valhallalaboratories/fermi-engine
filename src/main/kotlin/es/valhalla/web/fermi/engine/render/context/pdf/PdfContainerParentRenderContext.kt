package es.valhalla.web.fermi.engine.render.context.pdf

import es.valhalla.web.fermi.engine.render.context.ContainerParentRenderContext
import es.valhalla.web.fermi.engine.render.context.RenderContext

data class PdfContainerParentRenderContext(
	override val parentContext: RenderContext,
	override val renderingMilliseconds: Long = 0,
	override val posX: Int = 0,
	override val posY: Int = 0
) : ContainerParentRenderContext
