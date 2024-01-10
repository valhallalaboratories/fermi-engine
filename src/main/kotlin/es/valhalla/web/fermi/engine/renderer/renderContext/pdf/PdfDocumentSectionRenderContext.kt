import es.valhalla.web.fermi.engine.component.document.DocumentSection
import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.renderer.renderContext.DocumentRenderContext
import es.valhalla.web.fermi.engine.renderer.renderContext.DocumentSectionRenderContext

class PdfDocumentSectionRenderContext(
	override val currentComponentBeingRendered: DocumentSection,
	override val parentContext: DocumentRenderContext,
	override val pageNumber: Int,
	override val sectionPageNumber: Int,
	private val document: FermiDocument
) : DocumentSectionRenderContext(
	currentComponentBeingRendered = currentComponentBeingRendered,
	pageNumber = pageNumber,
	sectionPageNumber = sectionPageNumber,
	parentContext = parentContext
)
