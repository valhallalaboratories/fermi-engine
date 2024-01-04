package es.valhalla.web.fermi.engine.component.style

import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import java.util.UUID

open class Style(
	val styleId: StyleId? = null,
	val parentStyleId: StyleId? = null,
	val boxModel: ComponentBox,
	val backgroundColor: Color = Colors.TRANSPARENT,
	val foregroundColor: Color = Colors.BLACK,
) {
	companion object {
		val BASE_STYLE =
			Style(
				styleId = "BASE_STYLE",
				boxModel = ComponentBox.INLINE_COMPONENT_BOX_MODEL,
				backgroundColor = Colors.TRANSPARENT,
				foregroundColor = Colors.BLACK,
			)
	}

	fun copy(
		styleId: StyleId? = UUID.randomUUID().toString(),
		parentStyle: StyleId? = this.parentStyleId,
		boxModel: ComponentBox = this.boxModel,
		backgroundColor: Color = this.backgroundColor,
		foregroundColor: Color = this.foregroundColor,
	): Style {
		return Style(styleId, parentStyle, boxModel, backgroundColor, foregroundColor)
	}
}
typealias StyleId = String
