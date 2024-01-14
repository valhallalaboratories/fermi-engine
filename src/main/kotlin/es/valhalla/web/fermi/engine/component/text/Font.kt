package es.valhalla.web.fermi.engine.component.text

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.font.PDFont
import org.apache.pdfbox.pdmodel.font.PDType0Font
import java.io.InputStream


interface Font

class StandardFont : Font

interface TrueTypeFont : Font {

	val fontStream: InputStream

	fun load(pdfDocument: PDDocument): PDFont {
		val mesloFont: PDFont = PDType0Font.load(pdfDocument, fontStream)
		return mesloFont
	}
}
