package es.valhalla.web.fermi.engine


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
