package es.valhalla.web.fermi.engine.component.boxmodel

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComponentBoxTest {
	@Test
	fun testA4ComponentBoxSize() {
		val a4ComponentBox = ComponentBox.PAGE_BASE_A4

		assertThat(a4ComponentBox.width.pixels).isEqualTo(595)
		assertThat(a4ComponentBox.height.pixels).isEqualTo(842)
	}

	@Test
	fun testEmptyComponentSize() {
		val emptyComponentBox = ComponentBox.INLINE_COMPONENT_BOX_MODEL

		assertThat(emptyComponentBox.width.pixels == 0)
		assertThat(emptyComponentBox.height.pixels == 0)
	}

	@Test
	fun testEmptyComponentWithPaddingsSize() {
		val emptyComponentBox =
			ComponentBox.INLINE_COMPONENT_BOX_MODEL.copy(
				paddings = Paddings.buildSameSizePaddings(PixelSize(10)),
			)

		assertThat(emptyComponentBox.effectiveWidth == 20)
		assertThat(emptyComponentBox.effectiveHeight == 20)
	}
}
