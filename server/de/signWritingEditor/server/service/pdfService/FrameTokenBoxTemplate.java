package de.signWritingEditor.server.service.pdfService;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import de.signWritingEditor.shared.layout.FrameTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;

public class FrameTokenBoxTemplate extends TokenBoxTemplate {

	private static final int BORDER_MARGIN_PX = 7;
	private static final int STANDARD_HEIGHT = 192;

	private FrameTokenBox frameTokenBox;
	private float pointsPerPixel;

	private float frameTokenBoxHeight_PT;
	private float frameTokenBoxWidth_PT;
	private int borderWidth_PT;

	private float yOffset_PT;

	public FrameTokenBoxTemplate(FrameTokenBox frameTokenBox, float pointsPerPixel) {

		assert frameTokenBox != null : "Precondition failed: freeTextBox != null";
		assert pointsPerPixel >= 0 : "Precondition failed: pointsPerPixel >= 0";

		this.frameTokenBox = frameTokenBox;
		this.pointsPerPixel = pointsPerPixel;
		this.frameTokenBoxHeight_PT = (float) (frameTokenBox.getHeight_PX() * pointsPerPixel);
		this.frameTokenBoxWidth_PT = frameTokenBox.getWidth_PX() * pointsPerPixel;

		this.yOffset_PT = (float) frameTokenBoxHeight_PT > (STANDARD_HEIGHT * pointsPerPixel) ? 0
				: (STANDARD_HEIGHT * pointsPerPixel) - frameTokenBoxHeight_PT;

		this.borderWidth_PT = (int) (frameTokenBox.getBorderWidth_PX() * pointsPerPixel);

	}

	@Override
	public void draw(PDPageContentStream contentStream, float x_PT, float y_PT) throws IOException {

		Color backgroundColor = frameTokenBox.getBackgroundColor() == null ? Color.WHITE
				: frameTokenBox.getBackgroundColor();

		contentStream.setNonStrokingColor(
				new java.awt.Color(backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue()));
		contentStream.addRect(x_PT, y_PT, frameTokenBoxWidth_PT - BORDER_MARGIN_PX * pointsPerPixel,
				frameTokenBoxHeight_PT + yOffset_PT);
		contentStream.fill();

		Color borderColor = frameTokenBox.getFrameColor() == null ? Color.BLACK : frameTokenBox.getFrameColor();

		contentStream.setStrokingColor(
				new java.awt.Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue()));

		contentStream.setLineDashPattern(new float[] { 3 }, 0);
		contentStream.setLineWidth(1 * pointsPerPixel);

		contentStream.moveTo(x_PT + 2 * borderWidth_PT, y_PT + 2 * borderWidth_PT);
		contentStream.lineTo(x_PT + 2 * borderWidth_PT, y_PT + frameTokenBoxHeight_PT - 2 * borderWidth_PT);
		contentStream.stroke();

		contentStream.moveTo(x_PT + 2 * borderWidth_PT, y_PT + frameTokenBoxHeight_PT - 2 * borderWidth_PT);
		contentStream.lineTo(x_PT + frameTokenBoxWidth_PT - 2 * borderWidth_PT - BORDER_MARGIN_PX * pointsPerPixel,
				y_PT + frameTokenBoxHeight_PT - 2 * borderWidth_PT);
		contentStream.stroke();

		contentStream.moveTo(x_PT + frameTokenBoxWidth_PT - 2 * borderWidth_PT - BORDER_MARGIN_PX * pointsPerPixel,
				y_PT + frameTokenBoxHeight_PT - 2 * borderWidth_PT);
		contentStream.lineTo(x_PT + frameTokenBoxWidth_PT - 2 * borderWidth_PT - BORDER_MARGIN_PX * pointsPerPixel,
				y_PT + 2 * borderWidth_PT);
		contentStream.stroke();

		contentStream.moveTo(x_PT + frameTokenBoxWidth_PT - 2 * borderWidth_PT - BORDER_MARGIN_PX * pointsPerPixel,
				y_PT + 2 * borderWidth_PT);
		contentStream.lineTo(x_PT + 2 * borderWidth_PT, y_PT + 2 * borderWidth_PT);
		contentStream.stroke();
	}

	@Override
	public float getWidth_PT() {
		return frameTokenBoxWidth_PT;
	}

	@Override
	public float getHeight_PT() {
		return frameTokenBoxHeight_PT;
	}

}
