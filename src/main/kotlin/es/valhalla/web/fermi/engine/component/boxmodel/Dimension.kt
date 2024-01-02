package es.valhalla.web.fermi.engine.component.boxmodel

import kotlin.math.roundToInt

interface Dimension {
	val pixels: Int

	companion object {
		const val MILLIMETERS_PER_INCH = 25.4f
		const val DEFAULT_DPI: Int = 72
		val NONE: Dimension = PixelDimension(pixels = 0)
	}

	operator fun plus(another: Dimension): Dimension =
		PixelDimension(
			pixels = this.pixels + another.pixels,
		)
}

open class PixelDimension(
	override val pixels: Int,
) : Dimension

/**
 * Any real dimension must include dpi, which is required in order to convert real values to pixels
 */
interface RealDimension {
	val dpi: Int
}

open class ImperialDimension(
	val inches: Float,
	override val dpi: Int = Dimension.DEFAULT_DPI,
) : PixelDimension(
		pixels = (inches * Dimension.DEFAULT_DPI).roundToInt(),
	),
	RealDimension

/**
 * Given that pixel dimensions are based on dots per inch, metric dimension is a composition of RealDimension, based on inches
 */
data class MetricDimension(
	val mm: Float,
	override val dpi: Int = Dimension.DEFAULT_DPI,
) : ImperialDimension(
		inches = (mm / Dimension.MILLIMETERS_PER_INCH).round(2),
		dpi = dpi,
	)

fun Float.round(decimals: Int): Float {
	var multiplier = 1f
	repeat(decimals) { multiplier *= 10 }
	return (kotlin.math.round(this * multiplier) / multiplier)
}
