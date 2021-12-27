package de.signWritingEditor.server.service.pdfService;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ErrorImage {

	private int width = 225;
	private int height = 161;
	private BufferedImage bufferedImage;

	public BufferedImage drawImage() {
		return drawImage(I18N.getImageNotFound());
	}

	public BufferedImage drawImage(String errorMessage) {
		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics2D graphics = bufferedImage.createGraphics();

		// draw background
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, width, height);

		// draw text
		graphics.setColor(Color.black);
		drawCenteredString(graphics, errorMessage);

		graphics.dispose();

		return bufferedImage;
	}

	private void drawCenteredString(Graphics2D graphics, String errorMessage) {
		graphics.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));

		FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());

		int x = (width - metrics.stringWidth(errorMessage)) / 2;
		int y;
		if (x < 0) {
			int endI = prettyLineBreak(errorMessage, metrics);
			if (errorMessage.charAt(endI) != ' ') {
				errorMessage = errorMessage.substring(0, endI) + "-"
						+ errorMessage.substring(endI, errorMessage.length());
				endI++;
			}
			String firstLine = errorMessage.substring(0, endI);

			y = height / 2 - metrics.getAscent();
			x = (width - metrics.stringWidth(firstLine)) / 2;
			graphics.drawString(firstLine, x, y);

			String secondLine = errorMessage.substring(endI);

			y = height / 2 + metrics.getAscent();
			x = (width - metrics.stringWidth(secondLine)) / 2;
			graphics.drawString(secondLine, x, y);
		} else {
			y = (height - metrics.getHeight()) / 2 + metrics.getAscent();
			graphics.drawString(errorMessage, x, y);
		}
	}

	private int prettyLineBreak(String message, FontMetrics metrics) {
		int result = -1;

		for (int i = 0; i < message.length(); i++) {
			if (width > metrics.stringWidth(message.substring(i))
					&& width > metrics.stringWidth(message.substring(0, i))) {
				result = message.substring(i).indexOf(' ');
				result += i;
				if (width > metrics.stringWidth(message.substring(result))
						&& width > metrics.stringWidth(message.substring(0, result))) {
					return result;
				} else {
					return i;
				}

			}
		}

		assert result < 0 : "PLZ einfügen der 3ten Zeile";
		return result;
	}

}