package es.valhalla.web.fermi.engine.component.layout

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.boxmodel.Size

interface WrappedComponent {
	val component: Component
}

class StackedContainerWrappedComponent(
	val expandWidth: Boolean = false,
	val expandHeight: Boolean = false,
	override val component: Component
) : WrappedComponent {

	companion object {
		val FULL_EXPANSION = { com: Component ->
			StackedContainerWrappedComponent(
				component = com, expandWidth = true, expandHeight = true
			)
		}
	}
}

class RelativeContainerWrappedComponent(
	val top: Size? = null,
	val right: Size? = null,
	val bottom: Size? = null,
	val left: Size? = null,
	override val component: Component
) : WrappedComponent
