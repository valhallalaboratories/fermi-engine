package es.valhalla.web.fermi.engine.component

import es.valhalla.web.fermi.engine.component.layout.ContainerLayoutComponentWrapper
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.style.Style
import java.util.UUID

open class Container(
	override val componentId: ComponentId? = UUID.randomUUID().toString(),
	override val parentComponentId: ComponentId? = null,
	override val style: Style = Style.BASE_STYLE,
	override val layout: LayoutType = LayoutType.NoLayout,
	override val children: List<ContainerLayoutComponentWrapper> = emptyList(),
) : Component
