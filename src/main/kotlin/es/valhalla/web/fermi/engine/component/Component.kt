package es.valhalla.web.fermi.engine.component

import es.valhalla.web.fermi.engine.component.layout.ContainerLayoutInfo
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.style.Style

interface Component {
	val componentId: ComponentId?
	val parentComponentId: ComponentId?
	val style: Style
}

class ComponentChildren(
	val layout: LayoutType,
	val elements: Map<ContainerLayoutInfo, Component>,
)
typealias ComponentId = String
