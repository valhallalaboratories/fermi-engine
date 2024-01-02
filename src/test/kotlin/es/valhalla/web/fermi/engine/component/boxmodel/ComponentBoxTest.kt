package es.valhalla.web.fermi.engine.component.boxmodel

import org.junit.jupiter.api.Test

internal class ComponentBoxTest {
	@Test
	fun testA4ComponentBoxSize() {
		val a4ComponentBox = ComponentBox.PAGE_BASE_A4

		assert(a4ComponentBox.width.pixels == 595)
		assert(a4ComponentBox.height.pixels == 842)
	}

	@Test
	fun testEmptyComponentSize() {
		val emptyComponentBox = ComponentBox.INLINE_COMPONENT_BOX_MODEL

		assert(emptyComponentBox.width.pixels == 0)
		assert(emptyComponentBox.height.pixels == 0)
	}

	@Test
	fun testEmptyComponentWithPaddingsSize() {
		val emptyComponentBox =
			ComponentBox.INLINE_COMPONENT_BOX_MODEL.copy(
				paddings = Paddings.getSameDimensionPaddings(PixelDimension(10)),
			)

		assert(emptyComponentBox.getComponentEffectiveWidth().pixels == 20)
		assert(emptyComponentBox.getComponentEffectiveHeight().pixels == 20)
	}
}
