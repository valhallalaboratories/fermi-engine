package es.valhalla.web.fermi.engine.component.boxmodel

import es.valhalla.web.fermi.engine.component.style.Color
import es.valhalla.web.fermi.engine.component.style.Colors

data class Margin(
	val direction: Direction,
	val value: Dimension = Dimension.NONE,
	val border: Border = Border.NO_BORDER,
)

enum class Direction {
	TOP,
	RIGHT,
	BOTTOM,
	LEFT,
}

data class Border(
	val width: Dimension = Dimension.NONE,
	val borderType: BorderType = BorderType.NO_BORDER,
	val borderColor: Color = Colors.BLACK,
) {
	companion object {
		val NO_BORDER: Border =
			Border(width = Dimension.NONE, borderType = BorderType.NO_BORDER, borderColor = Colors.BLACK)
	}
}

enum class BorderType {
	NO_BORDER,
	SOLID,
	DOTTED,
	DASHED,
}

data class Margins(
	val left: Margin,
	val top: Margin,
	val bottom: Margin,
	val right: Margin,
) {
	companion object {
		val NO_MARGINS =
			Margins(
				top = Margin(direction = Direction.TOP, value = Dimension.NONE),
				right = Margin(direction = Direction.RIGHT, value = Dimension.NONE),
				bottom = Margin(direction = Direction.BOTTOM, value = Dimension.NONE),
				left = Margin(direction = Direction.LEFT, value = Dimension.NONE),
			)
		val A4 =
			Margins(
				top = Margin(direction = Direction.TOP, value = PixelDimension(36)),
				right = Margin(direction = Direction.RIGHT, value = PixelDimension(36)),
				bottom = Margin(direction = Direction.BOTTOM, value = PixelDimension(36)),
				left = Margin(direction = Direction.LEFT, value = PixelDimension(36)),
			)
	}
}
