package es.valhalla.web.fermi.engine.component

import es.valhalla.web.fermi.engine.component.layout.LayoutPositioning
import es.valhalla.web.fermi.engine.component.style.Style

open class Component(
	val componentId: ComponentId?,
	val parentComponentId: ComponentId?,
	val style: Style,
	val children: Map<LayoutPositioning, Component>,
)

typealias ComponentId = String
