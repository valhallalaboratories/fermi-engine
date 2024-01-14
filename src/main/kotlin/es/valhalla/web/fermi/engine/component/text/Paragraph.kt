package es.valhalla.web.fermi.engine.component.text

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.ComponentId
import es.valhalla.web.fermi.engine.component.boxmodel.BoxModel
import es.valhalla.web.fermi.engine.style.TextStyle

class Paragraph(
	override val componentId: ComponentId?,
	override val parentComponentId: ComponentId?,
	override val boxModel: BoxModel,
	override val style: TextStyle
) : Component 
