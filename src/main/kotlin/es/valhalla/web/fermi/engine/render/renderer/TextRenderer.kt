package es.valhalla.web.fermi.engine.render.renderer

import es.valhalla.web.fermi.engine.component.text.Text

interface TextRenderer : ComponentRenderer<Text, PdfContainerRenderContext> {

	override fun render(
		component: Text,
		renderContext: PdfContainerRenderContext
	): PdfContainerRenderContext
}

class PDFTextRenderer : TextRenderer {

	override fun render(
		component: Text,
		renderContext: PdfContainerRenderContext
	): PdfContainerRenderContext {
		TODO()
	}
}
