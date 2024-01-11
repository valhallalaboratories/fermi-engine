package es.valhalla.web.fermi.engine.render.renderer

import es.valhalla.web.fermi.engine.render.context.RenderContext

interface ComponentRenderer<Component, in Context : RenderContext> {

	/**
	 * Render a given component into render context.
	 *
	 * Implementations of this method should take the given Component, alter the context
	 * to reflect the Component's data and behavior, and then return that context.
	 *
	 * @param component The component to render.
	 * @return The altered context.
	 */

	fun render(component: Component): RenderContext = TODO()
	fun render(
		component: Component,
		parentContext: Context
	): RenderContext = TODO()
}
