package es.valhalla.web.fermi.engine


data class Container(
	override val frame: Frame
) : Component {

	override val absolutePosition: Point
		get() {
			return super.absolutePosition
		}
	override val componentType: ComponentType = ComponentType.CONTAINER
}
