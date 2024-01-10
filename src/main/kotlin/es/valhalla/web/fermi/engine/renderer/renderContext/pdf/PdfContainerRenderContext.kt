package es.valhalla.web.fermi.engine.renderer.renderContext.pdf

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.renderer.renderContext.ContainerRenderContext
import es.valhalla.web.fermi.engine.renderer.renderContext.RenderContext

data class PdfContainerRenderContext(
	override val parentContext: RenderContext,
	override val currentComponentBeingRendered: Component,
	override val renderingMilliseconds: Long
) : ContainerRenderContext(
	parentContext = parentContext,
	currentComponentBeingRendered = currentComponentBeingRendered,
	renderingMilliseconds = renderingMilliseconds
)
