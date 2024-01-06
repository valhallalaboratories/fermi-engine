package es.valhalla.web.fermi.engine.component.layout

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.boxmodel.Size

enum class LayoutType {
	NoLayout,
	RelativeLayout,
	ComposedLayout,
	RowLayout,
	ColumnLayout,
}

interface ContainerComponentWrapper {
	val elements: List<Component>
}

class RelativeComponentWrapper(
	val top: Size? = null,
	val right: Size? = null,
	val bottom: Size? = null,
	val left: Size? = null,
	override val elements: List<Component>,
) : ContainerComponentWrapper

class StackedComponentWrapper(
	override val elements: List<Component> = listOf(),
) : ContainerComponentWrapper
