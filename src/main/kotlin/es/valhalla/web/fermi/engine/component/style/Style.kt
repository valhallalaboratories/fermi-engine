package es.valhalla.web.fermi.engine.component.style

import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox

open class Style(
	val styleId: StyleId? = null,
	val parentStyle: StyleId? = null,
	val boxModel: ComponentBox,
	val backgroundColor: Color = Colors.TRANSPARENT,
	val foregroundColor: Color = Colors.BLACK,
)

typealias StyleId = String
