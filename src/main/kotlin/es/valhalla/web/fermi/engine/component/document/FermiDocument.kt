package es.valhalla.web.fermi.engine.component.document

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.ComponentId
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.layout.WrappedComponent
import es.valhalla.web.fermi.engine.component.style.Style
import java.util.UUID

class FermiDocument(
	val documentProperties: DocumentProperties,
	val documentSections: List<DocumentSection> = mutableListOf()
) : Component {
	val documentId = UUID.randomUUID().toString()
	override val componentId: ComponentId = UUID.randomUUID().toString()
	override val parentComponentId: ComponentId? = null
	override val boxModel: ComponentBox = documentProperties.documentBox
	override val style: Style = documentProperties.documentBaseStyle
	override val layout: LayoutType = LayoutType.NoLayout
	override val elements: MutableList<WrappedComponent>
		get() {
			return mutableListOf()
		}
}

typealias DocumentId = String
