package es.valhalla.web.fermi.engine.component.boxmodel

data class ComponentBox(
	val width: Size,
	val height: Size,
	val margins: Margins,
	val paddings: Paddings,
) {
	companion object {
		val INLINE_COMPONENT_BOX_MODEL =
			ComponentBox(
				width = Size.ZERO,
				height = Size.ZERO,
				paddings = Paddings.NO_PADDINGS,
				margins = Margins.NO_MARGINS,
			)
		val PAGE_BASE_A4 =
			ComponentBox(
				width = MetricSize(mm = 210f),
				height = MetricSize(mm = 297f),
				margins = Margins.A4,
				paddings = Paddings.NO_PADDINGS,
			)
	}

	fun getComponentEffectiveWidth() = PixelSize((width + paddings.left.size + paddings.right.size).pixels)

	fun getComponentEffectiveHeight() = PixelSize((height + paddings.top.size + paddings.bottom.size).pixels)
}
