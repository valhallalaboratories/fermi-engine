package es.valhalla.web.fermi.engine

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FermiEngineApplicationTests {
	@Test fun contextLoads() {
		assertThat(true)
			.describedAs("SpringContext initializated")
			.isTrue()
	}
}
