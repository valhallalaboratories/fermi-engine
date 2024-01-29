package es.valhalla.web.fermi.engine


interface Component {

	val componentType: ComponentType
	val absolutePosition: Point
		get() {
			when (componentType) {
				ComponentType.DOCUMENT -> TODO()
				ComponentType.DOCUMENT_SECTION -> TODO()
				ComponentType.PAGE -> TODO()
				ComponentType.PAGE_HEADER -> TODO()
				ComponentType.PAGE_BODY -> TODO()
				ComponentType.PAGE_FOOTER -> TODO()
				ComponentType.LAYOUT -> TODO()
				ComponentType.CONTAINER -> TODO()
			}
			return Point(0f, 0f)
		}
}

interface ComposedComponent : Component {

	val elements: List<Component>
}

interface WrappedComponent : Component

data class Document(
	val sections: List<DocumentSection>,
)


data class DocumentSection(
	val pages: MutableList<Page> = mutableListOf(),
)


object RendererRegistry {

	private val renderers = mapOf(
		Page::class.java to PdfPageRenderer(),
		Container::class.java to PdfContainerRenderer(),
	)

	fun render(
		component: Component,
		parentContext: RenderContext
	): RenderContext {
		val renderer = renderers[component::class.java]
			?: throw IllegalStateException("Renderer not registered for ${component::class.java.simpleName}")
		return (renderer as ComponentRenderer<in Component>).render(component, parentContext)
	}
}


data class RenderContext(
	val message: String = "",
	val parentContext: RenderContext? = null,
)

