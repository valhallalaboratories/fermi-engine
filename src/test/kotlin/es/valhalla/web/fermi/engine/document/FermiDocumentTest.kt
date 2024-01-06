package es.valhalla.web.fermi.engine.document

import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.boxmodel.Paddings
import es.valhalla.web.fermi.engine.component.boxmodel.PixelSize
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.layout.StackedComponentWrapper
import es.valhalla.web.fermi.engine.component.style.Colors
import es.valhalla.web.fermi.engine.component.style.Style
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.UUID

internal class FermiDocumentTest {
	@Test
	fun `create simple document with just one section`() {
		val tenPixelPaddings = Paddings.buildSameSizePaddings(PixelSize(10))
		val documentSection =
			DocumentSection(
				sectionRootContainer =
					Container(
						layout = LayoutType.RowLayout,
						children =
							StackedComponentWrapper(
								elements =
									listOf(
										Container(
											componentId = UUID.randomUUID().toString(),
											boxModel =
												ComponentBox.INLINE_COMPONENT_BOX_MODEL.copy(
													paddings = tenPixelPaddings,
													parentBox = ComponentBox.PAGE_BASE_A4,
												),
											style =
												Style.BASE_STYLE.copy(
													backgroundColor = Colors.RED,
												),
										),
									),
							),
					),
			)
		val document =
			FermiDocument(
				documentRootSection = documentSection,
				documentProperties = DocumentProperties(author = "Test"),
			)

		assertThat(document.documentId).isNotNull()
		assertThat(document.documentRootSection.sectionRootContainer.componentId).isNotNull()
	}
}
