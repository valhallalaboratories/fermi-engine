package es.valhalla.web.fermi.engine.component.boxmodel

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SizeTest {
	@Test
	fun `sum pixel dimensions`() {
		val firstSize: Size = MetricSize(mm = 210f)
		val secondSize: Size = MetricSize(mm = 210f)
		val sum = firstSize + secondSize
		assertThat(sum.pixels).isEqualTo(firstSize.pixels + secondSize.pixels)
	}

	@Test
	fun `check conversion between metric and imperial dimensions`() {
		val metricDimension = MetricSize(mm = 210f)
		val expectedImperialDimension = ImperialSize(inches = 8.27f)

		assertThat(metricDimension.pixels).isEqualTo(expectedImperialDimension.pixels)
	}
}
