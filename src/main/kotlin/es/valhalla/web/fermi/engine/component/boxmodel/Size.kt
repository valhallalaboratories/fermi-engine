package es.valhalla.web.fermi.engine.component.boxmodel

import kotlin.math.round
import kotlin.math.roundToInt

interface Size {
	val points: Int

	companion object {
		const val MILLIMETERS_PER_INCH = 25.4f
		const val DEFAULT_DPI: Int = 72
		val ZERO: Size = PointSize(points = 0)
	}

	operator fun plus(another: Size): Size = PointSize(points = this.points + another.points)
}

open class PointSize(override val points: Int) : Size

open class PixelSize(
	val pixels: Int,
	val dpi: Int = Size.DEFAULT_DPI,
) : Size {
	override val points: Int
		get() = (pixels * 72.0 / dpi).roundToInt()
}

open class ImperialSize(
	val inches: Float,
	val dpi: Int = Size.DEFAULT_DPI,
) : Size {
	override val points: Int
		get() = (inches * dpi).roundToInt()
}

data class MetricSize(
	val mm: Float,
	val dpi: Int = Size.DEFAULT_DPI,
) : Size {
	override val points: Int
		get() = ((mm / Size.MILLIMETERS_PER_INCH) * dpi).roundToInt()
}

fun Float.round(decimals: Int): Float {
	var multiplier = 1f
	repeat(decimals) { multiplier *= 10 }
	return (round(this * multiplier) / multiplier)
}
