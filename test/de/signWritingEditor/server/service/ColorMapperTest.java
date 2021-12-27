package de.signWritingEditor.server.service;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;

public class ColorMapperTest {
	private static final int NUM_TESTS = 10_000_000;

	@Test
	public void fastImplementationShouldGiveSimilarResultsAsSlowImplementationForRandomInputs() {
		Random random = new Random(2020_08_20);

		SlowColorMapper slowColorMapper = new SlowColorMapper();
		ColorMapper fastColorMapper = new ColorMapper();

		int[] randomInput = new int[4];
		int[] slowResult = new int[4];
		int[] fastResult = new int[4];

		long slowTime = 0;
		long fastTime = 0;
		long difference = 0;

		for (int n = NUM_TESTS; n > 0; --n) {
			Color newColorForFormerBlack = Color.makeFromARGB(random.nextInt());
			Color newColorForFormerWhite = Color.makeFromARGB(random.nextInt());

			slowColorMapper.init(newColorForFormerBlack, newColorForFormerWhite);
			fastColorMapper.init(newColorForFormerBlack, newColorForFormerWhite);

			int red = randomInput[0] = random.nextInt(256);
			int green = randomInput[1] = random.nextInt(256);
			int blue = randomInput[2] = random.nextInt(256);
			randomInput[3] = random.nextInt(256);
			int rggb = red + green + green + blue;

			// The slow implementation suffers from a rounding error at midpoint
			if (rggb != 510) {
				long a = System.nanoTime();
				slowColorMapper.lookupPixel(randomInput, slowResult);
				long b = System.nanoTime();
				fastColorMapper.lookupPixel(randomInput, fastResult);
				long c = System.nanoTime();

				slowTime += b - a;
				fastTime += c - b;

				// The slow and fast implementations round slightly differently
				assertEquals(slowResult[0], fastResult[0], 1.0);
				assertEquals(slowResult[1], fastResult[1], 1.0);
				assertEquals(slowResult[2], fastResult[2], 1.0);
				assertEquals(slowResult[3], fastResult[3]);

				int redDifference = (slowResult[0] - fastResult[0]) & 1;
				int greenDifference = (slowResult[1] - fastResult[1]) & 1;
				int blueDifference = (slowResult[2] - fastResult[2]) & 1;
				difference += redDifference + greenDifference + blueDifference;
			}
		}
		System.out.printf("%.2f%% speedup%n", 100.0 * slowTime / fastTime - 100.0);
		System.out.printf("%.4f average difference%n", (double) difference / NUM_TESTS);
	}
}
