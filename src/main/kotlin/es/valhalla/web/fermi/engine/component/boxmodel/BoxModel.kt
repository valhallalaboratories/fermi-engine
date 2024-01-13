package es.valhalla.web.fermi.engine.component.boxmodel

import org.apache.pdfbox.pdmodel.common.PDRectangle

data class BoxModel(
	val parentBox: BoxModel? = null,
	val width: Size,
	val height: Size,
	val margins: Margins = Margins.NO_MARGINS,
	val paddings: Paddings = Paddings.NO_PADDINGS,
) {
	companion object {
		val INLINE_COMPONENT_BOX_MODEL =
			BoxModel(
				width = Size.ZERO,
				height = Size.ZERO,
				paddings = Paddings.NO_PADDINGS,
				margins = Margins.NO_MARGINS
			)
		val PAGE_BASE_A4 =
			BoxModel(
				width = MetricSize(mm = 210f),
				height = MetricSize(mm = 297f),
				margins = Margins.A4,
				paddings = Paddings.NO_PADDINGS
			)

		val PAGE_BASE_A4_WITH_BORDERS =
			BoxModel(
				width = MetricSize(mm = 210f),
				height = MetricSize(mm = 297f),
				margins = Margins.A4_BORDERED,
				paddings = Paddings.NO_PADDINGS
			)
	}

	val pdRectangle: PDRectangle
		get() = PDRectangle(effectiveWidth.toFloat(), effectiveHeight.toFloat())

	val effectiveWidth: Float
		get() = (width + paddings.horizontalPadding).points

	val effectiveHeight: Float
		get() = (height + paddings.verticalPadding).points
}
