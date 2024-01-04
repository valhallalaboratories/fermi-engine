package es.valhalla.web.fermi.engine.component

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerTest {
	@Test
	fun `create empty container`() {
		val container = Container()
		assertThat(container.children).isEmpty()
		assertThat(container.style.boxModel.effectiveHeight).isEqualTo(0)
		assertThat(container.style.boxModel.effectiveWidth).isEqualTo(0)
	}
}
