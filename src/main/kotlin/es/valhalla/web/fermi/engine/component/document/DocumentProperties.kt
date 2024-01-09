package es.valhalla.web.fermi.engine.component.document

import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.style.Style
import java.util.UUID

class DocumentProperties(
	val author: String = "Valhalla Labs",
	val templateId: TemplateId = UUID.randomUUID().toString(),
	val documentBox: ComponentBox,
	val documentBaseStyle: Style = Style.BASE_STYLE
)

typealias TemplateId = String
