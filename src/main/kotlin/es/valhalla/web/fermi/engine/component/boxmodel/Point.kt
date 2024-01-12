package es.valhalla.web.fermi.engine.component.boxmodel

data class Point(
	val x: Int = 0,
	val y: Int = 0,
)


data class Line(
	val from: Point,
	val to: Point
)
