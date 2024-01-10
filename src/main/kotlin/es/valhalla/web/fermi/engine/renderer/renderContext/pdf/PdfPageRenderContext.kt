package es.valhalla.web.fermi.engine.renderer.renderContext.pdf

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.renderer.renderContext.DocumentSectionRenderContext
import es.valhalla.web.fermi.engine.renderer.renderContext.RenderContext
import org.apache.pdfbox.pdmodel.PDPage

class PdfPageRenderContext(
	val pdfPage: PDPage,
	override val currentComponentBeingRendered: Component,
	override val renderingMilliseconds: Long,
	override val parentContext: DocumentSectionRenderContext
) : RenderContext
