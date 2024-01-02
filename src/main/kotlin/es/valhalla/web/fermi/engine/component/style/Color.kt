package es.valhalla.web.fermi.engine.component.style

sealed interface Color

data class HexColor(
	val hexColor: String,
) : Color

/**
 * RGBA Colors
 */
data class RgbColor(
	val red: Int,
	val green: Int,
	val blue: Int,
	val alpha: Float = 1f,
) : Color

object Colors {
	val TRANSPARENT = RgbColor(0, 0, 0, 0f)
	val BLACK = RgbColor(0, 0, 0)
	val WHITE = RgbColor(255, 255, 255)
	val RED = RgbColor(255, 0, 0)
	val GREEN = RgbColor(0, 255, 0)
	val BLUE = RgbColor(0, 0, 255)
}
