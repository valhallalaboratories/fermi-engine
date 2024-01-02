package es.valhalla.web.fermi.engine.component.boxmodel

import org.junit.jupiter.api.Test

internal class DimensionTest {
	@Test
	fun `sum pixel dimensions`() {
		val firstDimension: Dimension = MetricDimension(mm = 210f)
		val secondDimension: Dimension = MetricDimension(mm = 210f)
		val sum = firstDimension + secondDimension
		assert(sum.pixels == firstDimension.pixels + secondDimension.pixels)
	}

	@Test
	fun `check conversion between metric and imperial dimensions`() {
		val metricDimension = MetricDimension(mm = 210f)
		val expectedImperialDimension = ImperialDimension(inches = 8.27f)

		assert(metricDimension.pixels == expectedImperialDimension.pixels)
	}
}
