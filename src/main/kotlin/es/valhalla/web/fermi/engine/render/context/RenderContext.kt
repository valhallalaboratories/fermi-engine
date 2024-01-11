package es.valhalla.web.fermi.engine.render.context

interface RenderContext {
	val parentContext: RenderContext?
	val renderingMilliseconds: Long

	val rootContext: RenderContext
		get() = parentContext?.rootContext ?: this

}

