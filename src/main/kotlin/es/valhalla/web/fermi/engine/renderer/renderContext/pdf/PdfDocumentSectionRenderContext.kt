package es.valhalla.web.fermi.engine.renderer.renderContext.pdf

import es.valhalla.web.fermi.engine.component.document.DocumentSection
import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.renderer.renderContext.BaseRenderContext

class PdfDocumentSectionRenderContext(
	override val currentComponentBeingRendered: DocumentSection,
	private val document: FermiDocument
) : BaseRenderContext(
	parentBox = document.boxModel,
	currentComponentBeingRendered = currentComponentBeingRendered,
	parentComponentBeingRendered = document
)
