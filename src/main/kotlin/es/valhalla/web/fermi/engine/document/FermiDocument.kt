package es.valhalla.web.fermi.engine.document

import java.util.UUID

class FermiDocument(
	val documentId: DocumentId = UUID.randomUUID().toString(),
	val documentRootSection: DocumentSection,
	val documentProperties: DocumentProperties,
)

typealias DocumentId = String
