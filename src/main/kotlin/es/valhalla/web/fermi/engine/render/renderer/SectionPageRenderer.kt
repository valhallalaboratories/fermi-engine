@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package es.valhalla.web.fermi.engine.render.renderer

import es.valhalla.web.fermi.engine.component.document.Page
import es.valhalla.web.fermi.engine.render.context.DocumentSectionRenderContext

interface SectionPageRenderer : ComponentRenderer<Page, DocumentSectionRenderContext> {


	override fun render(
		page: Page,
		parentContext: DocumentSectionRenderContext
	): DocumentSectionRenderContext

}
