package es.valhalla.web.fermi.engine


data class Page(
	val header: LayoutBasedPageHeader,
	val body: PageBody,
	val footer: LayoutBasedPageFooter
) : Component {

	override val componentType: ComponentType = ComponentType.PAGE
}

interface PageHeader : Component

class LayoutBasedPageHeader : PageHeader {

	override val componentType: ComponentType = ComponentType.PAGE_HEADER
}

interface PageBody : Component

data class LayoutBasedPageBody(
	val stackedLayout: StackedLayout
) : PageBody {

	override val componentType: ComponentType = ComponentType.PAGE_BODY
}

interface PageFooter : Component

class LayoutBasedPageFooter : PageFooter {

	override val componentType: ComponentType = ComponentType.PAGE_FOOTER
}

