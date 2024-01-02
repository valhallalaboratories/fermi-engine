package es.valhalla.web.fermi.engine.component.boxmodel

data class ComponentBox(
	val width: Dimension,
	val height: Dimension,
	val margins: Margins,
	val paddings: Paddings,
) {
	companion object {
		val INLINE_COMPONENT_BOX_MODEL =
			ComponentBox(
				width = Dimension.NONE,
				height = Dimension.NONE,
				paddings = Paddings.NO_PADDINGS,
				margins = Margins.NO_MARGINS,
			)
		val PAGE_BASE_A4 =
			ComponentBox(
				width = MetricDimension(mm = 210f),
				height = MetricDimension(mm = 297f),
				margins = Margins.A4,
				paddings = Paddings.NO_PADDINGS,
			)
	}

	fun getComponentEffectiveWidth() = PixelDimension((width + paddings.left.size + paddings.right.size).pixels)

	fun getComponentEffectiveHeight() = PixelDimension((height + paddings.top.size + paddings.bottom.size).pixels)
}
