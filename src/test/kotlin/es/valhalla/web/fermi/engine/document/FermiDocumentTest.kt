package es.valhalla.web.fermi.engine.document

import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.boxmodel.Paddings
import es.valhalla.web.fermi.engine.component.boxmodel.PixelSize
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.layout.StackedContainerWrappedComponent
import es.valhalla.web.fermi.engine.component.style.Colors
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FermiDocumentTest {
	@Test fun `create simple document with just one section`() {
		val tenPixelPaddings = Paddings.buildSameSizePaddings(PixelSize(10))

		val documentSection = DocumentSection(
			sectionRootContainer = Container(layout = LayoutType.RowLayout),
			sectionBox = ComponentBox.PAGE_BASE_A4,
		)

		documentSection.sectionRootContainer.elements.add(
			StackedContainerWrappedComponent(
				component = Container(
					style = documentSection.sectionBaseStyle.copy(backgroundColor = Colors.GREEN),
					boxModel = ComponentBox.INLINE_COMPONENT_BOX_MODEL.copy(
						paddings = tenPixelPaddings,
						parentBox = documentSection.sectionBox,
					),
				),
			),
		)

		val document = FermiDocument(
			documentRootSection = documentSection,
			documentProperties = DocumentProperties(),
		)

		assertThat(document.documentId).isNotNull()
		assertThat(document.documentRootSection.sectionRootContainer.componentId).isNotNull()
	}
}
