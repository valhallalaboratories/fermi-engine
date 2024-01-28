package es.valhalla.web.fermi.engine


data class Container(val name: String) : Component {

	override val absolutePosition: Point
		get() {
			return super.absolutePosition
		}
	override val componentType: ComponentType = ComponentType.CONTAINER
}
