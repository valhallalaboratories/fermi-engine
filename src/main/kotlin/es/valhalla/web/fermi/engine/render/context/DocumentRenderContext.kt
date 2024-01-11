package es.valhalla.web.fermi.engine.render.context


interface DocumentRenderContext : RenderContext {
	override val renderingMilliseconds: Long
}
