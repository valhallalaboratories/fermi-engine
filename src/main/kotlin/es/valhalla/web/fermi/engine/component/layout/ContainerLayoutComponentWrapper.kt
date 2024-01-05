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

interface ContainerLayoutComponentWrapper {
	val component: Component
}

class RelativeLayoutComponentWrapper(
	val top: Size? = null,
	val right: Size? = null,
	val bottom: Size? = null,
	val left: Size? = null,
	override val component: Component,
) : ContainerLayoutComponentWrapper

sealed class StackedLayoutComponentWrapper(
	/**  Must start from position 0	 */
	val position: Byte = 0,
	override val component: Component,
) : ContainerLayoutComponentWrapper

data class ColumnLayoutComponentWrapper(
	private val columnNumber: Byte = 0,
	override val component: Component,
) : StackedLayoutComponentWrapper(position = columnNumber, component = component)

class RowLayoutComponentWrapper(
	private val rowNumber: Byte = 0,
	override val component: Component,
) : StackedLayoutComponentWrapper(position = rowNumber, component = component)
