package es.valhalla.web.fermi.engine.renderer.renderContext

import es.valhalla.web.fermi.engine.component.Component

open class ContainerRenderContext(
	val posX: Int = 0,
	val posY: Int = 0,
	override val parentContext: RenderContext,
	override val currentComponentBeingRendered: Component,
	override val renderingMilliseconds: Long
) : RenderContext
