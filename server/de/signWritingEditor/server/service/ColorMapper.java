package de.signWritingEditor.server.service;

import java.awt.image.LookupTable;

import de.signWritingEditor.shared.model.domainValue.Color;

public class ColorMapper extends LookupTable {

	private Color newColorForFormerBlack;
	private Color newColorForFormerWhite;

	public ColorMapper() {
		super(0, 4);
	}

	public void init(Color newColorForFormerBlack, Color newColorForFormerWhite) {
		this.newColorForFormerBlack = newColorForFormerBlack;
		this.newColorForFormerWhite = newColorForFormerWhite;
	}

	@Override
	public int[] lookupPixel(int[] src, int[] dest) {

		if (dest == null) {
			dest = new int[src.length];
		}

		int red = src[0]; // 0..255
		int green = src[1]; // 0..255
		int blue = src[2]; // 0..255
		int rggb = red + green + green + blue; // 0..1020
		rggb += rggb >>> 8; // 0..1023 (without 256, 512 and 768)

		if (rggb < 512) {
			int scale = 1023 - rggb;
			int brightness = rggb << 8;

			dest[0] = (newColorForFormerBlack.getRed() * scale + brightness) >>> 10;
			dest[1] = (newColorForFormerBlack.getGreen() * scale + brightness) >>> 10;
			dest[2] = (newColorForFormerBlack.getBlue() * scale + brightness) >>> 10;
		} else {
			dest[0] = (newColorForFormerWhite.getRed() * rggb) >>> 10;
			dest[1] = (newColorForFormerWhite.getGreen() * rggb) >>> 10;
			dest[2] = (newColorForFormerWhite.getBlue() * rggb) >>> 10;
		}

		dest[3] = src[3];

		return dest;
	}
}
