package es.valhalla.web.fermi.engine.component.document

import es.valhalla.web.fermi.engine.component.boxmodel.BoxModel
import es.valhalla.web.fermi.engine.style.Style
import java.util.UUID

class DocumentProperties(
    val author: String = "Valhalla Labs",
    val templateId: TemplateId = UUID.randomUUID().toString(),
    val documentBox: BoxModel,
    val documentBaseStyle: Style = Style.BASE_STYLE
)

typealias TemplateId = String
