package es.valhalla.web.fermi.engine.component.document

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.component.layout.WrappedComponent

data class Page(
	val pageContainer: Container
) : WrappedComponent {
	override val component: Component
		get() = pageContainer
}
