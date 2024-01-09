package es.valhalla.web.fermi.engine.component.document

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.ComponentId
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.layout.WrappedComponent
import es.valhalla.web.fermi.engine.component.style.Style
import java.util.UUID

class DocumentSection(
	val sectionName: String,
	val sectionStyle: Style?,
	override val layout: LayoutType,
	override val elements: MutableList<WrappedComponent>,
	private val document: FermiDocument
) : Component {

	override val style
		get() = sectionStyle ?: document.documentProperties.documentBaseStyle

	override val componentId: ComponentId = UUID.randomUUID().toString()

	override val parentComponentId: ComponentId
		get() = document.componentId
	override val boxModel: ComponentBox
		get() = document.boxModel
}
