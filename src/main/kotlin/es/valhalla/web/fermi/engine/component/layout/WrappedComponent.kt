package es.valhalla.web.fermi.engine.component.layout

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.boxmodel.Size

interface WrappedComponent {
	val component: Component
}

class ExpandedComponent(
	override val component: Component,
	val expandWidth: Boolean = true,
	val expandHeight: Boolean = true
) : WrappedComponent

class RelativeContainerWrappedComponent(
	val top: Size? = null,
	val right: Size? = null,
	val bottom: Size? = null,
	val left: Size? = null,
	override val component: Component
) : WrappedComponent
