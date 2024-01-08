package es.valhalla.web.fermi.engine.component.style

import java.util.UUID

open class Style(
	val styleId: StyleId? = null,
	val parentStyleId: StyleId? = null,
	val backgroundColor: Color = Colors.TRANSPARENT,
	val foregroundColor: Color = Colors.BLACK
) {
	companion object {
		val BASE_STYLE =
			Style(
				styleId = "BASE_STYLE",
				backgroundColor = Colors.TRANSPARENT,
				foregroundColor = Colors.BLACK
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
