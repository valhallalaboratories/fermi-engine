package es.valhalla.web.fermi.engine.render.context.pdf

import es.valhalla.web.fermi.engine.render.context.DocumentRenderContext
import es.valhalla.web.fermi.engine.render.context.RenderContext
import org.apache.pdfbox.pdmodel.PDDocument

data class PdfDocumentRenderContext(
	val pdfDocument: PDDocument,
	override val parentContext: RenderContext? = null,
	override val renderingMilliseconds: Long = 0
) : DocumentRenderContext

