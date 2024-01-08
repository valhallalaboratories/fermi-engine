package es.valhalla.web.fermi.engine.component

import es.valhalla.web.fermi.engine.component.layout.LayoutType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerTest {
	@Test fun `create empty container`() {
		val container = Container()

		assertThat(container.layout)
			.describedAs("an empty container must have no layout by default")
			.isEqualTo(LayoutType.NoLayout)
		assertThat(container.boxModel.effectiveHeight).isEqualTo(0)
		assertThat(container.boxModel.effectiveWidth).isEqualTo(0)
	}
}
