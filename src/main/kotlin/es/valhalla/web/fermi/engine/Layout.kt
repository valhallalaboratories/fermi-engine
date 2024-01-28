package es.valhalla.web.fermi.engine

open class Layout(
	override val elements: List<Component>
) : ComposedComponent {

	override val componentType: ComponentType = ComponentType.LAYOUT
}


open class StackedLayout(
	val stackedLayoutType: StackedLayoutType,
	override val elements: List<StackedComponent>
) : Layout(elements = elements)

class RowLayout(
	override val elements: List<StackedComponent>
) : StackedLayout(stackedLayoutType = StackedLayoutType.ROW, elements = elements)

class StackedComponent(
	override val componentType: ComponentType
) : WrappedComponent

enum class StackedLayoutType { ROW, COLUMN
}

