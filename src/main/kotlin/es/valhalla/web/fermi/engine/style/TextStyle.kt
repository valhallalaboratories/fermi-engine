package es.valhalla.web.fermi.engine.style

import es.valhalla.web.fermi.engine.color.Color
import es.valhalla.web.fermi.engine.component.text.Font

class TextStyle(
	override val styleId: StyleId? = null,
	override val parentStyleId: StyleId? = null,
	override val backgroundColor: Color = Color.TRANSPARENT,
	override val foregroundColor: Color = Color.BLACK,
	val font: Font,
	val fontSize: Float,
	val italic: Boolean = false,
	val underlined: Boolean = false,
) : Style(
	styleId = styleId,
	parentStyleId = parentStyleId,
	backgroundColor = backgroundColor,
	foregroundColor = foregroundColor
) {

	val textColor: Color
		get() = foregroundColor
}
