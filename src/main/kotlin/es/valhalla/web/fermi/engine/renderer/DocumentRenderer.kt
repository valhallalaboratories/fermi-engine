package es.valhalla.web.fermi.engine.renderer

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.renderer.renderContext.RenderContext

interface DocumentRenderer : ComponentRenderer {

	val documentSectionRenderer: DocumentSectionRenderer

	override fun render(component: Component): RenderContext

}
