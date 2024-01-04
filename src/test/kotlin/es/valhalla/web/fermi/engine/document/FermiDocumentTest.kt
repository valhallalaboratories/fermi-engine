package es.valhalla.web.fermi.engine.document

import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.boxmodel.PixelSize
import es.valhalla.web.fermi.engine.component.layout.RowStackedLayoutInfo
import es.valhalla.web.fermi.engine.component.style.Colors
import es.valhalla.web.fermi.engine.component.style.Style
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FermiDocumentTest {
	@Test
	fun `create simple document with just one section`() {
		val rootContainer =
			Container(
				children =
					mapOf(
						RowStackedLayoutInfo(0) to
							Container(
								style =
									Style.BASE_STYLE.copy(
										backgroundColor = Colors.GREEN,
										boxModel = ComponentBox(width = PixelSize(10), height = PixelSize(10)),
									),
							),
						RowStackedLayoutInfo(1) to
							Container(
								style =
									Style.BASE_STYLE.copy(
										backgroundColor = Colors.RED,
										boxModel = ComponentBox(width = PixelSize(10), height = PixelSize(10)),
									),
							),
					),
			)
		val documentSection = DocumentSection(sectionRootContainer = rootContainer)
		val document =
			FermiDocument(
				documentRootSection = documentSection,
				documentProperties = DocumentProperties(author = "Test"),
			)

		assertThat(document.documentId).isNotNull()
		assertThat(document.documentRootSection.sectionRootContainer.componentId).isNotNull()
	}
}
