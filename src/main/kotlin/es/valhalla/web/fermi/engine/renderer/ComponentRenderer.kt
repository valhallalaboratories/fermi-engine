package es.valhalla.web.fermi.engine.renderer

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.renderer.renderContext.RenderContext

/**
 * Interface for rendering components.
 *
 * This interface describes the methods that a component renderer must implement. A component renderer
 * is a class that takes a Component and produces a RenderContext, essentially turning a component's
 * data and behavior into something that can be concretely displayed.
 */
interface ComponentRenderer {
	/**
	 * The context in which the component will be rendered.
	 *
	 * This is typically initialized with the dimensions and other properties of the area
	 * in which the component will be rendered, prior to rendering the component.
	 */
	val renderContext: RenderContext

	/**
	 * Render a given component into render context.
	 *
	 * Implementations of this method should take the given Component, alter the renderContext
	 * to reflect the Component's data and behavior, and then return that renderContext.
	 *
	 * @param component The component to render.
	 * @return The altered renderContext.
	 */
	fun render(component: Component): RenderContext
}
