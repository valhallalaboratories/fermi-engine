package es.valhalla.web.fermi.engine.component.document

import es.valhalla.web.fermi.engine.component.ComponentId
import es.valhalla.web.fermi.engine.component.boxmodel.BoxModel
import es.valhalla.web.fermi.engine.component.layout.WrappedComponent
import es.valhalla.web.fermi.engine.style.Style
import java.util.UUID

data class Page(
	override val componentId: ComponentId? = UUID.randomUUID().toString(),
	override val parentComponentId: ComponentId?,
	override val boxModel: BoxModel,
	override val style: Style
) : WrappedComponent
