package es.valhalla.web.fermi.engine.render.context

import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.style.Style

interface DocumentSectionRenderContext : RenderContext {
	val pageNumber: Int
	val sectionPageNumber: Int
	val style: Style
	val componentBox: ComponentBox
	override val parentContext: RenderContext?
	override val renderingMilliseconds: Long
}
