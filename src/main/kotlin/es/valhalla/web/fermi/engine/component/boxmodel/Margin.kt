package es.valhalla.web.fermi.engine.component.boxmodel

import es.valhalla.web.fermi.engine.color.Color


data class Margin(
	val direction: Direction,
	val size: Size = Size.ZERO,
	val border: Border = Border.NO_BORDER,
) {
	fun getBorderLine(box: ComponentBox): BorderLine {
		val line = when (direction) {
			Direction.TOP ->
				Line(
					from = Point(x = box.margins.left.size.points, y = box.margins.top.size.points),
					to = Point(x = box.effectiveWidth - box.margins.right.size.points, y = box.margins.top.size.points)
				)

			Direction.BOTTOM ->
				Line(
					from = Point(x = box.margins.left.size.points, y = box.effectiveHeight - box.margins.bottom.size.points),
					to = Point(x = box.effectiveWidth - box.margins.right.size.points, y = box.effectiveHeight - box.margins.bottom.size.points)
				)

			Direction.LEFT ->
				Line(
					from = Point(x = box.margins.left.size.points, y = box.margins.top.size.points),
					to = Point(x = box.margins.left.size.points, y = box.effectiveHeight - box.margins.bottom.size.points)
				)

			Direction.RIGHT ->
				Line(
					from = Point(x = box.effectiveWidth - box.margins.right.size.points, y = box.margins.top.size.points),
					to = Point(x = box.effectiveWidth - box.margins.right.size.points, y = box.effectiveHeight - box.margins.bottom.size.points)
				)
		}
		return BorderLine(line, size = border.width.points)
	}
}

enum class Direction {
	TOP, RIGHT, BOTTOM, LEFT,
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
			top = Margin(direction = Direction.TOP, size = PixelSize(36f)),
			right = Margin(direction = Direction.RIGHT, size = PixelSize(36f)),
			bottom = Margin(direction = Direction.BOTTOM, size = PixelSize(36f)),
			left = Margin(direction = Direction.LEFT, size = PixelSize(36f))
		)
		val A4_BORDERED = Margins(
			top = Margin(direction = Direction.TOP, size = PixelSize(36f), border = Border(width = PixelSize(1f), BorderType.SOLID, borderColor = Color.GRAY)),
			right = Margin(direction = Direction.RIGHT, size = PixelSize(36f), border = Border(width = PixelSize(1f), BorderType.SOLID, borderColor = Color.GRAY)),
			bottom = Margin(direction = Direction.BOTTOM, size = PixelSize(36f), border = Border(width = PixelSize(1f), BorderType.SOLID, borderColor = Color.GRAY)),
			left = Margin(direction = Direction.LEFT, size = PixelSize(36f), border = Border(width = PixelSize(1f), BorderType.SOLID, borderColor = Color.GRAY))
		)
	}

	val horizontalMargin: Size
		get() = left.size + right.size

	val verticalMargin: Size
		get() = top.size + bottom.size
}
