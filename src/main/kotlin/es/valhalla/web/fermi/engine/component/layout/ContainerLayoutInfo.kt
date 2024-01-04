package es.valhalla.web.fermi.engine.component.layout

import es.valhalla.web.fermi.engine.component.boxmodel.Size

enum class LayoutType {
	RelativeLayout,
	ComposedLayout,
	RowLayout,
	ColumnLayout,
}

interface ContainerLayoutInfo

class RelativeContainerLayoutInfo(
	val top: Size? = null,
	val right: Size? = null,
	val bottom: Size? = null,
	val left: Size? = null,
) : ContainerLayoutInfo {
	companion object {
		val TOP_LEFT =
			RelativeContainerLayoutInfo(
				top = Size.ZERO,
				left = Size.ZERO,
			)
	}
}

sealed class StackedLayoutInfo(
	/**  Must start from position 0	 */
	val position: Byte = 0,
) : ContainerLayoutInfo

data class ColumnStackedLayoutInfo(
	private val columnNumber: Byte = 0,
) : StackedLayoutInfo(position = columnNumber)

class RowStackedLayoutInfo(
	private val rowNumber: Byte = 0,
) : StackedLayoutInfo(position = rowNumber)
