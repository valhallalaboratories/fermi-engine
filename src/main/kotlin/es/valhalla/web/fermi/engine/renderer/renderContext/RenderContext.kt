package es.valhalla.web.fermi.engine.renderer.renderContext

import es.valhalla.web.fermi.engine.component.Component

interface RenderContext {
	val currentComponentBeingRendered: Component
	val parentContext: RenderContext?
	val renderingMilliseconds: Long
}

