package es.valhalla.web.fermi.engine.component.boxmodel

data class Point(
	val x: Float = 0f,
	val y: Float = 0f,
)


data class Line(
	val from: Point,
	val to: Point
)
