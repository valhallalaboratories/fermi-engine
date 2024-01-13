package es.valhalla.web.fermi.engine.component

import es.valhalla.web.fermi.engine.component.boxmodel.BoxModel
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.layout.WrappedComponent
import es.valhalla.web.fermi.engine.style.Style

interface Component {
	val componentId: ComponentId?
	val parentComponentId: ComponentId?
	val boxModel: BoxModel
	val style: Style
	val layout: LayoutType
	val elements: MutableList<out WrappedComponent>
}

typealias ComponentId = String
