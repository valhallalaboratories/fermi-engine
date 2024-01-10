package es.valhalla.web.fermi.engine.renderer.renderContext


import es.valhalla.web.fermi.engine.component.document.FermiDocument

open class DocumentRenderContext(
	override val currentComponentBeingRendered: FermiDocument,
	override val parentContext: RenderContext? = null,
	override val renderingMilliseconds: Long = 0
) : RenderContext
