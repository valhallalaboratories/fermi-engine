package es.valhalla.web.fermi.engine.print

import java.io.File
import java.time.Instant

data class PrintedDocument(
	val renderedDate: Instant = Instant.now(),
	val renderingMilliseconds: Long,
	val output: File
)
