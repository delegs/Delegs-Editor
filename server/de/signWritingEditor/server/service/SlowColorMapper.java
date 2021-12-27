package de.signWritingEditor.server.service;

import java.awt.image.LookupTable;

import de.signWritingEditor.shared.model.domainValue.Color;

/**
 * This obsolete implementation is only used as a test oracle inside
 * ColorMapperTest. Please use the fast implementation ColorMapper instead.
 */
class SlowColorMapper extends LookupTable {

	private int[] toNewColorForFormerBlack;
	private int[] toNewColorForFormerWhite;

	public SlowColorMapper() {
		super(0, 4);
	}

	public void init(Color newColorForFormerBlack, Color newColorForFormerWhite) {
		this.toNewColorForFormerBlack = new int[] { newColorForFormerBlack.getRed(), newColorForFormerBlack.getGreen(),
				newColorForFormerBlack.getBlue(), newColorForFormerBlack.getAlpha() };
		this.toNewColorForFormerWhite = new int[] { newColorForFormerWhite.getRed(), newColorForFormerWhite.getGreen(),
				newColorForFormerWhite.getBlue(), newColorForFormerWhite.getAlpha() };
	}

	@Override
	public int[] lookupPixel(int[] src, int[] dest) {

		if (dest == null) {
			dest = new int[src.length];
		}

		double redBrightness = src[0] / 255.0;
		double greenBrightness = src[1] / 255.0;
		double blueBrightness = src[2] / 255.0;

		double brightnessValue = (redBrightness + blueBrightness + 2 * greenBrightness) / 4.0;
		int[] newColor = new int[4];
		for (int i = 0; i < 3; i++) {
			if (brightnessValue < 0.5) {
				newColor[i] = (int) (toNewColorForFormerBlack[i] * (1 - brightnessValue) + (255 * brightnessValue));
			} else if (brightnessValue >= 0.5) {
				newColor[i] = (int) (toNewColorForFormerWhite[i] * (brightnessValue));
			}
		}

		newColor[3] = src[3];
		System.arraycopy(newColor, 0, dest, 0, newColor.length);

		return dest;
	}

}
