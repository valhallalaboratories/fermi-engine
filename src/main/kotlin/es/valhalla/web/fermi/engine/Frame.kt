package es.valhalla.web.fermi.engine

data class Frame(
	val width: Float,
	val height: Float,
	val parentFrame: Frame?
)
