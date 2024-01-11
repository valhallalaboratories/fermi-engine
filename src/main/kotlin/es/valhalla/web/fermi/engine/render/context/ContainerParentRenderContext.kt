package es.valhalla.web.fermi.engine.render.context

interface ContainerParentRenderContext : RenderContext {
	val posX: Int
	val posY: Int
	override val parentContext: RenderContext
	override val renderingMilliseconds: Long
}

