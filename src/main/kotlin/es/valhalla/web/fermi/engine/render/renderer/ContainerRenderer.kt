@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package es.valhalla.web.fermi.engine.render.renderer

import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.render.context.ContainerParentRenderContext

interface ContainerRenderer : ComponentRenderer<Container, ContainerParentRenderContext> {

	override fun render(
		container: Container,
		parentContext: ContainerParentRenderContext
	): ContainerParentRenderContext

}
