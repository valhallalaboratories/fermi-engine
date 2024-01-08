package es.valhalla.web.fermi.engine.component.boxmodel

import es.valhalla.web.fermi.engine.component.style.Color
import es.valhalla.web.fermi.engine.component.style.Colors

data class Margin(
	val direction: Direction,
	val size: Size = Size.ZERO,
	val border: Border = Border.NO_BORDER,
)

enum class Direction {
	TOP, RIGHT, BOTTOM, LEFT,
}

data class Border(
	val width: Size = Size.ZERO,
	val borderType: BorderType = BorderType.NO_BORDER,
	val borderColor: Color = Colors.BLACK,
) {
	companion object {
		val NO_BORDER: Border = Border(
			width = Size.ZERO,
			borderType = BorderType.NO_BORDER,
			borderColor = Colors.BLACK
		)
	}
}

enum class BorderType {
	NO_BORDER, SOLID, DOTTED, DASHED
}

data class Margins(
	val left: Margin,
	val top: Margin,
	val bottom: Margin,
	val right: Margin
) {
	companion object {
		val NO_MARGINS = Margins(
			top = Margin(direction = Direction.TOP, size = Size.ZERO),
			right = Margin(direction = Direction.RIGHT, size = Size.ZERO),
			bottom = Margin(direction = Direction.BOTTOM, size = Size.ZERO),
			left = Margin(direction = Direction.LEFT, size = Size.ZERO)
		)
		val A4 = Margins(
			top = Margin(direction = Direction.TOP, size = PixelSize(36)),
			right = Margin(direction = Direction.RIGHT, size = PixelSize(36)),
			bottom = Margin(direction = Direction.BOTTOM, size = PixelSize(36)),
			left = Margin(direction = Direction.LEFT, size = PixelSize(36))
		)
	}

	val horizontalMargin: Size
		get() = left.size + right.size

	val verticalMargin: Size
		get() = top.size + bottom.size
}
