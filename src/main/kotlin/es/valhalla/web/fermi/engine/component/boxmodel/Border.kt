package es.valhalla.web.fermi.engine.component.boxmodel

import es.valhalla.web.fermi.engine.color.Color


data class Border(
	val width: Size = Size.ZERO,
	val borderType: BorderType = BorderType.NO_BORDER,
	val borderColor: Color = Color.BLACK,
) {
	companion object {
		val NO_BORDER: Border = Border(
			width = Size.ZERO,
			borderType = BorderType.NO_BORDER,
			borderColor = Color.BLACK
		)
	}
}

data class BorderLine(
	val line: Line,
	val size: Float
)

enum class BorderType {
	NO_BORDER, SOLID, DOTTED, DASHED
}
