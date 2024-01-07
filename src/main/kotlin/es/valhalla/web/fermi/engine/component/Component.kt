package es.valhalla.web.fermi.engine.component

import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.layout.WrappedComponent
import es.valhalla.web.fermi.engine.component.style.Style

interface Component {
	val componentId: ComponentId?
	val parentComponentId: ComponentId?
	val boxModel: ComponentBox
	val style: Style
	val layout: LayoutType
	val elements: MutableList<WrappedComponent>
}

typealias ComponentId = String
