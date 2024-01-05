package es.valhalla.web.fermi.engine.component

import es.valhalla.web.fermi.engine.component.layout.ContainerLayoutComponentWrapper
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.style.Style

interface Component {
	val componentId: ComponentId?
	val parentComponentId: ComponentId?
	val style: Style
	val layout: LayoutType
	val children: List<ContainerLayoutComponentWrapper>
}

typealias ComponentId = String
