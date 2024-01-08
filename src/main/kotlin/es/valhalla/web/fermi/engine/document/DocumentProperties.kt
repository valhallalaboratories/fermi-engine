package es.valhalla.web.fermi.engine.document

import es.valhalla.web.fermi.engine.component.style.Style
import java.util.UUID

class DocumentProperties(
	val author: String = "Valhalla Labs",
	val templateId: TemplateId = UUID.randomUUID().toString(),
	val documentBaseStyle: Style = Style.BASE_STYLE
)

typealias TemplateId = String
