package es.valhalla.web.fermi.engine.component.boxmodel

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BoxModelTest {
	@Test fun testA4ComponentBoxSize() {
		val a4BoxModel = BoxModel.PAGE_BASE_A4

		assertThat(a4BoxModel.width.points).isEqualTo(595.2756f)
		assertThat(a4BoxModel.height.points).isEqualTo(841.88983f)
	}

	@Test fun testEmptyComponentSize() {
		val emptyBoxModel = BoxModel.INLINE_COMPONENT_BOX_MODEL

		assertThat(emptyBoxModel.width.points)
			.describedAs("Check if the width of the empty component box is 0")
			.isEqualTo(0f)
		assertThat(emptyBoxModel.height.points)
			.describedAs("Check if the height of the empty component box is 0")
			.isEqualTo(0f)
	}

	@Test fun `test empty component effective size (in points) with padding size defined at 144 dpis`() {
		val emptyBoxModel = BoxModel.INLINE_COMPONENT_BOX_MODEL.copy(
			paddings = Paddings.buildSameSizePaddings(PixelSize(10f, dpi = 144))
		)

		assertThat(emptyBoxModel.effectiveWidth)
			.describedAs("Check if the effective width of the empty component box with padding is 10")
			.isEqualTo(10f)
		assertThat(emptyBoxModel.effectiveHeight)
			.describedAs("Check if the effective height of the empty component box with padding is 10")
			.isEqualTo(10f)
	}
}
