package es.valhalla.web.fermi.engine

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FermiEngineApplication

fun main(args: Array<String>) {
	runApplication<FermiEngineApplication>(*args)
}
