package es.valhalla.web.fermi.engine.document

import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.boxmodel.Paddings
import es.valhalla.web.fermi.engine.component.boxmodel.PixelSize
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.layout.RowLayoutComponentWrapper
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
						layout = LayoutType.ColumnLayout,
						children =
							listOf(
								RowLayoutComponentWrapper(
									0,
									Container(
										componentId = UUID.randomUUID().toString(),
										style =
											Style.BASE_STYLE.copy(
												boxModel = ComponentBox.INLINE_COMPONENT_BOX_MODEL.copy(paddings = tenPixelPaddings),
												backgroundColor = Colors.RED,
											),
									),
								),
								RowLayoutComponentWrapper(
									1,
									Container(
										componentId = UUID.randomUUID().toString(),
										style =
											Style.BASE_STYLE.copy(
												boxModel =
													ComponentBox(
														width = PixelSize(10),
														height = PixelSize(10),
														paddings = tenPixelPaddings,
													),
												backgroundColor = Colors.BLUE,
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
