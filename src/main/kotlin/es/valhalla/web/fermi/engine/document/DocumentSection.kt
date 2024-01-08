package es.valhalla.web.fermi.engine.document

import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.style.Style

class DocumentSection(
	val sectionBaseStyle: Style = Style.BASE_STYLE,
	val sectionBox: ComponentBox = ComponentBox.INLINE_COMPONENT_BOX_MODEL,
	val sectionRootContainer: Container = Container(boxModel = sectionBox, style = sectionBaseStyle)
)
