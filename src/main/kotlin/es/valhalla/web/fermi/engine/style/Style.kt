package es.valhalla.web.fermi.engine.style

import es.valhalla.web.fermi.engine.color.Color
import java.util.UUID

open class Style(
	open val styleId: StyleId? = null,
	open val parentStyleId: StyleId? = null,
	open val backgroundColor: Color = Color.TRANSPARENT,
	open val foregroundColor: Color = Color.BLACK
) {
	companion object {
		val BASE_STYLE =
			Style(
				styleId = "BASE_STYLE",
				backgroundColor = Color.TRANSPARENT,
				foregroundColor = Color.BLACK
			)
	}

	fun copy(
		styleId: StyleId? = UUID.randomUUID().toString(),
		parentStyle: StyleId? = this.parentStyleId,
		backgroundColor: Color = this.backgroundColor,
		foregroundColor: Color = this.foregroundColor
	): Style {
		return Style(styleId, parentStyle, backgroundColor, foregroundColor)
	}
}
typealias StyleId = String
