package es.valhalla.web.fermi.engine.renderer

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.renderer.renderContext.RenderContext

/**
 * This interface provides methods to render a component with its document sections.
 *
 * @property documentSectionRenderer the renderer for document sections.
 */
interface DocumentRenderer : ComponentRenderer {

	val documentSectionRenderer: DocumentSectionRenderer

	/**
	 * Render a component to a document.
	 *
	 * @param component the component to render.
	 * @return RenderContext version after rendering the full document component tree.
	 */
	override fun render(component: Component): RenderContext

}
