@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package es.valhalla.web.fermi.engine.render.renderer.pdf

import es.valhalla.web.fermi.engine.color.RgbaColor
import es.valhalla.web.fermi.engine.component.Container
import es.valhalla.web.fermi.engine.component.boxmodel.Border
import es.valhalla.web.fermi.engine.component.boxmodel.BorderType
import es.valhalla.web.fermi.engine.component.boxmodel.ComponentBox
import es.valhalla.web.fermi.engine.component.boxmodel.Margins
import es.valhalla.web.fermi.engine.render.context.ContainerParentRenderContext
import es.valhalla.web.fermi.engine.render.context.PageContainerRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfDocumentRenderContext
import es.valhalla.web.fermi.engine.render.context.pdf.PdfPageRenderContext
import es.valhalla.web.fermi.engine.render.renderer.PageContainerRenderer
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.slf4j.LoggerFactory


class PdfPageContainerRenderer : PageContainerRenderer {

	private val log = LoggerFactory.getLogger(PdfSectionPageRenderer::class.java)


	override fun render(
		container: Container,
		parentContext: PageContainerRenderContext
	): ContainerParentRenderContext {
		val startedAt = System.currentTimeMillis()
		val pageRenderContext = parentContext as PdfPageRenderContext

		val rootContext = parentContext.rootContext as PdfDocumentRenderContext
		val pdfPage = parentContext.pdfPage

		val contentStream = PDPageContentStream(rootContext.pdfDocument, pdfPage)

		renderContainer(container, contentStream, pageRenderContext)

		contentStream.close()

		log.info("PdfSectionPageRenderer.render finished, took: {} milliseconds", startedAt - System.currentTimeMillis())

		return pageRenderContext
	}


	private fun renderContainer(
		container: Container,
		contentStream: PDPageContentStream,
		pageRenderContext: PdfPageRenderContext
	) {
		val containerBox = container.boxModel
		contentStream.setNonStrokingColor(container.style.backgroundColor.javaColor)

		//draw margins
		val margins = containerBox.margins // changed margin here


		// draw borders with transparent inner color from containerBox using the border variables (leftBorder,topBorder...)
		contentStream.moveTo(0f, 0f)

		contentStream.setNonStrokingColor(container.style.foregroundColor.javaColor) // Set the border color

		// Draw the container background
		contentStream.addRect(
			containerBox.margins.left.size.points.toFloat(),
			containerBox.margins.top.size.points.toFloat(),
			(containerBox.width.points - containerBox.margins.horizontalMargin.points).toFloat(),
			(containerBox.height.points - containerBox.margins.verticalMargin.points).toFloat()
		)

		contentStream.fill()

		strokeBorderLines(containerBox, margins = margins, contentStream)
	}

	private fun strokeBorderLines(
		box: ComponentBox,
		margins: Margins,
		contentStream: PDPageContentStream
	) {

		val topBorder = margins.top.border
		if (topBorder.borderType != BorderType.NO_BORDER && topBorder.width.points > 0) {
			val startX = margins.left.size.points
			val posY = box.height.points - margins.top.size.points
			val endX = box.width.points - margins.right.size.points
			drawBorderLine(contentStream, topBorder, startX, posY, endX, posY)
		}

		val bottomBorder = margins.bottom.border
		if (bottomBorder.borderType != BorderType.NO_BORDER && bottomBorder.width.points > 0) {
			val startX = margins.left.size.points
			val posY = margins.bottom.size.points

			val endX = box.width.points - margins.right.size.points
			drawBorderLine(contentStream, bottomBorder, startX, posY, endX, posY)
		}


		val leftBorder = margins.left.border
		if (leftBorder.borderType != BorderType.NO_BORDER && leftBorder.width.points > 0) {
			val posX = margins.left.size.points
			val startY = margins.bottom.size.points
			val endY = box.height.points - margins.top.size.points

			drawBorderLine(contentStream, leftBorder, posX, startY, posX, endY)
		}

		val rightBorder = margins.right.border
		if (rightBorder.borderType != BorderType.NO_BORDER && rightBorder.width.points > 0) {
			val posX = box.width.points - margins.right.size.points
			val startY = margins.bottom.size.points
			val endY = box.height.points - margins.top.size.points

			drawBorderLine(contentStream, rightBorder, posX, startY, posX, endY)
		}

	}

	private fun drawBorderLine(
		contentStream: PDPageContentStream,
		border: Border,
		startX: Float,
		startY: Float,
		endX: Float,
		endY: Float
	) {
		val color = border.borderColor.fade((Math.random() * 100).toInt()) as RgbaColor

		val fadedColor = color.copy(alpha = Math.random().toFloat())
		contentStream.setStrokingColor(fadedColor.javaColor)
		contentStream.setLineWidth(border.width.points.toFloat())
		//contentStream.setLineDashPattern(floatArrayOf(1f), 1f)
		contentStream.moveTo(startX.toFloat(), startY.toFloat())
		contentStream.lineTo(endX.toFloat(), endY.toFloat())

		contentStream.stroke()
	}

}
