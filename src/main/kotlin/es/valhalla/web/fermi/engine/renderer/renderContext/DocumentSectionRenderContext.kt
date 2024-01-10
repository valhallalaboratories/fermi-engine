package es.valhalla.web.fermi.engine.renderer.renderContext

import es.valhalla.web.fermi.engine.component.Component

open class DocumentSectionRenderContext(
	open val pageNumber: Int = 0,
	open val sectionPageNumber: Int = 0,
	override val currentComponentBeingRendered: Component,
	override val parentContext: RenderContext?,
	override val renderingMilliseconds: Long = 0
) : RenderContext
