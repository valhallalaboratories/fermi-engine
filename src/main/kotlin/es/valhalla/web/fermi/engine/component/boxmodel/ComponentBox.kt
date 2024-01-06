package es.valhalla.web.fermi.engine.component.boxmodel

data class ComponentBox(
	val parentBox: ComponentBox? = null,
	val width: Size,
	val height: Size,
	val margins: Margins = Margins.NO_MARGINS,
	val paddings: Paddings = Paddings.NO_PADDINGS,
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

	val effectiveWidth: Int
		get() = (width + paddings.horizontalPadding).pixels

	val effectiveHeight: Int
		get() = (height + paddings.verticalPadding).pixels
}
