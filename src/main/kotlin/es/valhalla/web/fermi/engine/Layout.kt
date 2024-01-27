package es.valhalla.web.fermi.engine

open class Layout(
	override val frame: Frame,
	override val elements: List<Component>
) : ComposedComponent {

	override val componentType: ComponentType = ComponentType.LAYOUT
}


open class StackedLayout(
	val stackedLayoutType: StackedLayoutType,
	override val frame: Frame,
	override val elements: List<StackedComponent>
) : Layout(frame = frame, elements = elements)

class RowLayout(
	override val frame: Frame,
	override val elements: List<StackedComponent>
) : StackedLayout(stackedLayoutType = StackedLayoutType.ROW, frame = frame, elements = elements)

class StackedComponent(
	override val frame: Frame,
	override val componentType: ComponentType
) : WrappedComponent

enum class StackedLayoutType { ROW, COLUMN
}

