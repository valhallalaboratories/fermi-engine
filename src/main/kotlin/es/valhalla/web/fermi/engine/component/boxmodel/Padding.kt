package es.valhalla.web.fermi.engine.component.boxmodel

data class Padding(val size: Dimension = Dimension.NONE)

data class Paddings(val top: Padding, val right: Padding, val bottom: Padding, val left: Padding) {
	companion object {
		val NO_PADDINGS =
			Paddings(
				top = Padding(),
				right = Padding(),
				bottom = Padding(),
				left = Padding(),
			)

		fun getSameDimensionPaddings(size: Dimension) =
			Paddings(
				top = Padding(size),
				right = Padding(size),
				bottom = Padding(size),
				left = Padding(size),
			)
	}
}
