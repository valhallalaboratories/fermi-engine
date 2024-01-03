package es.valhalla.web.fermi.engine.component.boxmodel

import kotlin.math.roundToInt

interface Size {
	val pixels: Int

	companion object {
		const val MILLIMETERS_PER_INCH = 25.4f
		const val DEFAULT_DPI: Int = 72
		val ZERO: Size = PixelSize(pixels = 0)
	}

	operator fun plus(another: Size): Size =
		PixelSize(
			pixels = this.pixels + another.pixels,
		)
}

open class PixelSize(
	override val pixels: Int,
) : Size

/**
 * Any real dimension must include dpi, which is required in order to convert real values to pixels
 */
interface RealDimension {
	val dpi: Int
}

open class ImperialSize(
	val inches: Float,
	override val dpi: Int = Size.DEFAULT_DPI,
) : PixelSize(
		pixels = (inches * Size.DEFAULT_DPI).roundToInt(),
	),
	RealDimension

/**
 * Given that pixel dimensions are based on dots per inch, metric dimension is a composition of RealDimension, based on inches
 */
data class MetricSize(
	val mm: Float,
	override val dpi: Int = Size.DEFAULT_DPI,
) : ImperialSize(
		inches = (mm / Size.MILLIMETERS_PER_INCH).round(2),
		dpi = dpi,
	)

fun Float.round(decimals: Int): Float {
	var multiplier = 1f
	repeat(decimals) { multiplier *= 10 }

	return (kotlin.math.round(this * multiplier) / multiplier)
}
