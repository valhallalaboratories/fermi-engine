@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package es.valhalla.web.fermi.engine.render.renderer

import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.render.context.DocumentRenderContext

/**
 * This interface provides methods to render a component with its document sections.
 *
 */
interface DocumentRenderer : ComponentRenderer<FermiDocument, DocumentRenderContext> {


	/**
	 * Render a component to a document.
	 *
	 * @param document the component to render.
	 * @return RenderContext version after rendering the full document component tree.
	 */
	override fun render(document: FermiDocument): DocumentRenderContext

}
