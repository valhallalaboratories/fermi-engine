package es.valhalla.web.fermi.engine.renderer.renderContext

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox


interface RenderContext {
	val posX: Float
	val posY: Float
	val pageNumber: Int
	val parentBox: ComponentBox
	val currentComponentBeingRendered: Component
	val parentComponentBeingRendered: Component?
}

open class BaseRenderContext(
	override val posX: Float = 0f,
	override val posY: Float = 0f,
	override val pageNumber: Int = 0,
	override val parentBox: ComponentBox,
	override val currentComponentBeingRendered: Component,
	override val parentComponentBeingRendered: Component?
) : RenderContext


