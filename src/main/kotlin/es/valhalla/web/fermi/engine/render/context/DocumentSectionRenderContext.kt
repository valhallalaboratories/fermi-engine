package es.valhalla.web.fermi.engine.render.context

interface DocumentSectionRenderContext : RenderContext {
	val pageNumber: Int
	val sectionPageNumber: Int
	override val parentContext: RenderContext?
	override val renderingMilliseconds: Long
}
