@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package es.valhalla.web.fermi.engine.render.renderer

import es.valhalla.web.fermi.engine.component.document.DocumentSection
import es.valhalla.web.fermi.engine.render.context.DocumentRenderContext

interface DocumentSectionRenderer : ComponentRenderer<DocumentSection, DocumentRenderContext> {

	override fun render(
		documentSection: DocumentSection,
		parentContext: DocumentRenderContext
	): DocumentRenderContext

}
