package es.valhalla.web.fermi.engine.component.document

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.ComponentId
import es.valhalla.web.fermi.engine.component.boxmodel.BoxModel
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.style.Style
import java.util.UUID

class DocumentSection(
	val sectionName: String,
	val sectionStyle: Style?,
	val pages: MutableList<Page>,
	override val layout: LayoutType,
	private val document: FermiDocument
) : Component {

	override val elements: MutableList<Page>
		get() = pages

	override val style
		get() = sectionStyle ?: document.documentProperties.documentBaseStyle

	override val componentId: ComponentId = UUID.randomUUID().toString()

	override val parentComponentId: ComponentId
		get() = document.componentId
	override val boxModel: BoxModel
		get() = document.boxModel
}
