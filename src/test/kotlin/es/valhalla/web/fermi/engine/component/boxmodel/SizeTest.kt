package es.valhalla.web.fermi.engine.component.boxmodel

import org.junit.jupiter.api.Test

internal class SizeTest {
	@Test
	fun `sum pixel dimensions`() {
		val firstSize: Size = MetricSize(mm = 210f)
		val secondSize: Size = MetricSize(mm = 210f)
		val sum = firstSize + secondSize
		assert(sum.pixels == firstSize.pixels + secondSize.pixels)
	}

	@Test
	fun `check conversion between metric and imperial dimensions`() {
		val metricDimension = MetricSize(mm = 210f)
		val expectedImperialDimension = ImperialSize(inches = 8.27f)

		assert(metricDimension.pixels == expectedImperialDimension.pixels)
	}
}
