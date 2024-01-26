package es.valhalla.web.fermi.engine


interface ComponentRenderer<T : Component> {

	fun render(
		component: T,
		parentContext: RenderContext,
	): RenderContext
}


interface DocumentRenderer : ComponentRenderer<Document> {

	override fun render(
		component: Document,
		parentContext: RenderContext
	): RenderContext
}

