package es.valhalla.web.fermi.engine.renderer.renderContext.pdf

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.renderer.renderContext.BaseRenderContext
import org.apache.pdfbox.pdmodel.PDDocument
import java.io.File

data class PdfDocumentRenderContext(
	val pdfDocument: PDDocument,
	val destinationFile: File,
	override val parentBox: ComponentBox,
	override val currentComponentBeingRendered: Component
) : BaseRenderContext(
	parentBox = parentBox,
	currentComponentBeingRendered = currentComponentBeingRendered,
	parentComponentBeingRendered = null
)

