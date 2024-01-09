package es.valhalla.web.fermi.engine.renderer

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.renderer.renderContext.RenderContext

interface DocumentSectionRenderer : ComponentRenderer {

	override fun render(component: Component): RenderContext

}
