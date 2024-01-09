package es.valhalla.web.fermi.engine.document

import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.document.DocumentProperties
import es.valhalla.web.fermi.engine.component.document.DocumentSection
import es.valhalla.web.fermi.engine.component.document.FermiDocument
import es.valhalla.web.fermi.engine.component.layout.ExpandedComponent
import es.valhalla.web.fermi.engine.component.layout.LayoutType
import es.valhalla.web.fermi.engine.component.style.Colors
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FermiDocumentTest {

	@Test fun `create simple document with just one section`() {
		val document = FermiDocument(
			documentProperties = DocumentProperties(
				documentBox = ComponentBox.PAGE_BASE_A4
			)
		)

		document.documentSections.addLast(
			DocumentSection(
				sectionName = "Empty section :D",
				sectionStyle = document.style,
				document = document,
				layout = LayoutType.NoLayout,
				elements = mutableListOf(
					ExpandedComponent(
						Container(
							parentComponentId = document.componentId,
							style = document.style.copy(backgroundColor = Colors.BLUE)
						)
					)
				)
			)
		)


		assertThat(document.documentId).isNotNull()
		assertThat(document.componentId).isNotNull()
	}
}
