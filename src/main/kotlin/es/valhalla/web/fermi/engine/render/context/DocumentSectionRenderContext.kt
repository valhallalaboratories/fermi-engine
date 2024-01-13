package es.valhalla.web.fermi.engine.render.context

import es.valhalla.web.fermi.engine.component.boxmodel.BoxModel
import es.valhalla.web.fermi.engine.style.Style

interface DocumentSectionRenderContext : RenderContext {
	val pageNumber: Int
	val sectionPageNumber: Int
	val style: Style
	val boxModel: BoxModel
	override val parentContext: RenderContext?
	override val renderingMilliseconds: Long
}
