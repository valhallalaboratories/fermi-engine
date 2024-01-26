package es.valhalla.web.fermi.engine

class PdfDocumentRenderer : ComponentRenderer<Document> {

	override fun render(
		component: Document,
		parentContext: RenderContext
	): RenderContext {
		TODO("Not yet implemented")
	}

}

class PdfDocumentSectionRenderer : ComponentRenderer<DocumentSection> {

	override fun render(
		component: DocumentSection,
		parentContext: RenderContext
	): RenderContext {
		return component.elements.fold(RenderContext("Document section  renderer", parentContext)) {context, nestedElement ->
			RendererRegistry.render(nestedElement, context)
		}
	}

}

class PdfPageRenderer : ComponentRenderer<Page> {

	override fun render(
		component: Page,
		parentContext: RenderContext
	): RenderContext {
		return RendererRegistry.render(component.body, RenderContext())
	}

}

class PdfContainerRenderer : ComponentRenderer<Container> {

	override fun render(
		component: Container,
		parentContext: RenderContext
	): RenderContext {
		return RendererRegistry.render(component, RenderContext())
	}

}
