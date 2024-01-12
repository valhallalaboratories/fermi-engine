package es.valhalla.web.fermi.engine.render.context

interface ContainerParentRenderContext : RenderContext {
	val posX: Int
	val posY: Int
	override val parentContext: RenderContext
	override val renderingMilliseconds: Long
}

open class PageContainerRenderContext(
	override val posX: Int = 0,
	override val posY: Int = 0,
	override val parentContext: DocumentSectionRenderContext,
	override val renderingMilliseconds: Long
) : ContainerParentRenderContext

