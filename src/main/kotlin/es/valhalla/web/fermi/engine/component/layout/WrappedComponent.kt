package es.valhalla.web.fermi.engine.component.layout

import es.valhalla.web.fermi.engine.component.Component
import es.valhalla.web.fermi.engine.component.ComponentId
import es.valhalla.web.fermi.engine.component.boxmodel.BoxModel
import es.valhalla.web.fermi.engine.component.boxmodel.Size
import es.valhalla.web.fermi.engine.style.Style

interface WrappedComponent : Component

class StackedComponent(

	val expandWidth: Boolean = true,
	val expandHeight: Boolean = true,
	override val componentId: ComponentId?,
	override val parentComponentId: ComponentId?,
	override val boxModel: BoxModel,
	override val style: Style
) : WrappedComponent

class RelativeContainerWrappedComponent(
	val top: Size? = null,
	val right: Size? = null,
	val bottom: Size? = null,
	val left: Size? = null,
	override val componentId: ComponentId?,
	override val parentComponentId: ComponentId?,
	override val boxModel: BoxModel,
	override val style: Style,
) : WrappedComponent
