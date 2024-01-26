package es.valhalla.web.fermi.engine


data class Page(
	override val frame: Frame,
	val header: LayoutBasedPageHeader,
	val body: PageBody,
	val footer: LayoutBasedPageFooter
) : Component {

	override val componentType: ComponentType = ComponentType.PAGE
}

interface PageHeader : Component

data class LayoutBasedPageHeader(override val frame: Frame) : PageHeader {

	override val componentType: ComponentType = ComponentType.PAGE_HEADER
}

interface PageBody : Component

data class LayoutBasedPageBody(
	override val frame: Frame,
	val stackedLayout: StackedLayout
) : PageBody {

	override val componentType: ComponentType = ComponentType.PAGE_BODY
}

interface PageFooter : Component

data class LayoutBasedPageFooter(override val frame: Frame) : PageFooter {

	override val componentType: ComponentType = ComponentType.PAGE_FOOTER
}

