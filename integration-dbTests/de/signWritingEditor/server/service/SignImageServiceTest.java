package de.signWritingEditor.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SignHistoryDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.User;

public class SignImageServiceTest {

	private SignImageService signImageService;
	private SymbolFactory symbolFactory;
	private DbConnector connector;

	@Before
	public void setUp() {
		ConfigurationService configurationService;
		try {
			configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
			connector = new DbConnector(configurationService);
			symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());

			UserDb userDb = new UserDb(connector);
			SignHistoryDB signHistoryDb = new SignHistoryDB(connector, userDb, configurationService, symbolFactory);

			signImageService = new SignImageService(configurationService, new DictionaryServiceImpl(
					new SignDB(connector, userDb, symbolFactory, configurationService), signHistoryDb));
		} catch (IOException e) {
			fail("Unable to initialize Configuration Service");
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testLoadSymbolImages() {
		try {
			SimpleSign sign = createDummySign();
			List<Image> symbolImages = signImageService.loadSymbolImages(sign.getPlainSymbols(), 1);
			assertEquals(sign.getPlainSymbols().size(), symbolImages.size());

			SimpleSign emptySign = new SimpleSign(new SignId(1235, "empty", SignLocale.DGS, SignSource.DELEGS),
					new User("unknown", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1),
					SignLocale.DGS, new Date(), "");
			List<Image> symbolImagesFromEmptySign = signImageService.loadSymbolImages(emptySign.getPlainSymbols(), 1);
			assertTrue(symbolImagesFromEmptySign.isEmpty());

		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public void testNormalizeSign() {
		doTestNormalizedSign(-5, -10);
		doTestNormalizedSign(0, 0);
		doTestNormalizedSign(50, 103);
		doTestNormalizedSign(-10, 20);
		doTestNormalizedSign(10, -20);
	}

	@Test
	public void testCreateSignImage() {
		try {
			SimpleSign sign1 = createDummySign();

			SimpleSign copiedSign = sign1.clone();
			int xOffset = 3;
			int yOffset = -10;
			for (PositionedSymbol positionedSymbol : sign1.getPlainSymbols()) {
				positionedSymbol.setX(xOffset + positionedSymbol.getX());
				positionedSymbol.setY(yOffset + positionedSymbol.getY());
			}

			BufferedImage sign1Image = signImageService.createSignImage(sign1, 1, false);
			BufferedImage copiedSignImage = signImageService.createSignImage(copiedSign, 1, false);

			// Width changes since Signs are not normalized in createSignImage
			// Signs in database have to be in a normalized state
			assertEquals(sign1Image.getWidth(), copiedSignImage.getWidth());
			assertEquals(sign1Image.getHeight(), copiedSignImage.getHeight());

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(sign1Image, "PNG", baos);
			byte[] sign1ImageAsBytes = baos.toByteArray();
			byte[] testImageByteArray = IOUtils
					.toByteArray(SignImageServiceTest.class.getResourceAsStream("TestSignImageServiceImage.png"));

			assertFalse(Arrays.equals(testImageByteArray, sign1ImageAsBytes));

			copiedSign = sign1.clone();
			copiedSign.getPlainSymbols().get(0).setX(800);
			copiedSignImage = signImageService.createSignImage(copiedSign, 1, false);
			baos = new ByteArrayOutputStream();
			ImageIO.write(copiedSignImage, "PNG", baos);
			byte[] copiedImageAsBytes = baos.toByteArray();

			assertFalse(Arrays.equals(copiedImageAsBytes, testImageByteArray));

		} catch (IOException e) {
			fail("Could not create Sign Image");
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateSignImageWithScaleFactor() {
		try {
			SimpleSign sign = createDummySign();

			double scaleFactor = 2;
			BufferedImage signImage = signImageService.createSignImage(sign, scaleFactor, false);

			assertEquals((int) (sign.getWidth() * scaleFactor), signImage.getWidth());
			assertEquals((int) (sign.getHeight() * scaleFactor), signImage.getHeight());

			scaleFactor = 1;
			signImage = signImageService.createSignImage(sign, scaleFactor, false);

			assertEquals((int) (sign.getWidth() * scaleFactor), signImage.getWidth());
			assertEquals((int) (sign.getHeight() * scaleFactor), signImage.getHeight());

			scaleFactor = 0.5;
			signImage = signImageService.createSignImage(sign, scaleFactor, false);

			assertEquals((int) (sign.getWidth() * scaleFactor), signImage.getWidth());
			assertEquals((int) (sign.getHeight() * scaleFactor), signImage.getHeight());

			scaleFactor = 2.7;
			signImage = signImageService.createSignImage(sign, scaleFactor, false);

			assertEquals((int) (sign.getWidth() * scaleFactor), signImage.getWidth());
			assertEquals((int) (sign.getHeight() * scaleFactor), signImage.getHeight());

		} catch (IOException e) {
			fail("Could not create Sign Image");
			e.printStackTrace();
		}
	}

	private void doTestNormalizedSign(int smallestXPosition, int smallestYPosition) {
		SimpleSign sign = createDummySign(smallestXPosition, smallestYPosition);

		sign.normalize();

		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;

		List<PositionedSymbol> normalizedSymbols = sign.getPlainSymbols();
		for (int index = 0; index < normalizedSymbols.size(); index++) {
			minX = normalizedSymbols.get(index).getX() < minX ? normalizedSymbols.get(index).getX() : minX;
			maxX = (normalizedSymbols.get(index).getX() + normalizedSymbols.get(index).getWidth()) > maxX
					? (normalizedSymbols.get(index).getX() + normalizedSymbols.get(index).getWidth())
					: maxX;
		}

		int tolerance = 2;
		assertTrue("maxX: " + maxX + ", minX: " + minX, Math.abs(maxX + minX) < tolerance);
	}

	private List<PositionedSymbol> copySymbols(List<PositionedSymbol> posSymbols) {
		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>(posSymbols.size());

		for (PositionedSymbol positionedSymbol : posSymbols) {

			PositionedSymbol newSymbol = new PositionedSymbol(positionedSymbol.getSymbol(), positionedSymbol.getX(),
					positionedSymbol.getY(), positionedSymbol.getZ());

			result.add(newSymbol);
		}
		return result;
	}

	private SimpleSign createDummySign() {
		return createDummySign(0, 0);
	}

	private SimpleSign createDummySign(int minX, int minY) {
		SimpleSign sign = new SimpleSign(new SignId(1234, "hallo", SignLocale.DGS, SignSource.DELEGS),
				User.getUnknownUser(), SignLocale.DGS, new Date(0), "");

		sign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol("01-05-008-01-01-01"), minX + 15, minY, 1));
		sign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol("02-05-005-01-01-01"), minX + 35, minY + 40, 2));
		sign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol("01-01-001-01-01-01"), minX, minY + 20, 3));

		return sign;
	}
}
