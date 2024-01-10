package es.valhalla.web.fermi.engine.renderer.renderContext.pdf

import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.renderer.renderContext.DocumentRenderContext
import es.valhalla.web.fermi.engine.renderer.renderContext.RenderContext
import java.io.File

class PdfDocumentRenderContext(
	val destinationFile: File,
	override val currentComponentBeingRendered: FermiDocument,
	override val parentContext: RenderContext? = null,
	override val renderingMilliseconds: Long = 0
) : DocumentRenderContext(
	currentComponentBeingRendered = currentComponentBeingRendered,
	parentContext = parentContext
)

