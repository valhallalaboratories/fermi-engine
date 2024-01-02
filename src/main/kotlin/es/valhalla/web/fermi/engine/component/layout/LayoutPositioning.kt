package es.valhalla.web.fermi.engine.component.layout

interface LayoutPositioning

class RelativeLayoutPositioning : LayoutPositioning {
	val x: Float? = null
	val y: Float? = null
}

sealed class StackedLayoutPositioning(
	/**  Must start from position 0	 */
	val position: Byte = 0,
) : LayoutPositioning

data class ColumnLayout(
	private val columnNumber: Byte = 0,
) : StackedLayoutPositioning(position = columnNumber)

class HorizontalLayout(
	private val rowNumber: Byte = 0,
) : StackedLayoutPositioning(position = rowNumber)
