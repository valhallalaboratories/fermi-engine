package es.valhalla.web.fermi.engine.render.renderer

interface ComponentRenderer<Component, in ComponentRenderContext : RenderContext> {

	/**
	 * Render a given component into render context.
	 *
	 * Implementations of this method should take the given Component, alter the context
	 * to reflect the Component's data and behavior, and then return that context.
	 *
	 * @param component The component to render.
	 * @param renderContext The RenderContext.
	 * @return The altered context.
	 */
	fun render(
		component: Component,
		renderContext: ComponentRenderContext
	): RenderContext


}
