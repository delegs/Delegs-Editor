package tool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.PositionedHeadPostureSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.User;

public class HeadSymbolPositionCorrectionTest {

	private static final int HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION = 11;

	@Test
	public void correctYPositionForHeadSymbolsGreenWayTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		HeadSymbol head1 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				30, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				30, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				30, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);

		assertNotNull(result);
		assertTrue(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsPositiveOffsetTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		HeadSymbol head1 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				31, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				32, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				35, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);

		assertNotNull(result);
		assertTrue(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsNegativeOffsetTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		HeadSymbol head1 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				29, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				27, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				25, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);

		assertNotNull(result);
		assertTrue(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsNegativeAmdPositiveOffsetTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		HeadSymbol head1 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				29, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				30, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				31, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);

		assertNotNull(result);
		assertTrue(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsNoCorrectionForHighPositiveOffsetsTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		HeadSymbol head1 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				31, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				35, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				36, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 31, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 35, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 36, 1);

		assertNotNull(result);
		assertFalse(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsNoCorrectionForHighNegativeOffsetsTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		HeadSymbol head1 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				24, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				26, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				29, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 24, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 26, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 29, 1);

		assertNotNull(result);
		assertFalse(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsNoCorrectionForHighNegativeAndHighPositiveOffsetsTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		HeadSymbol head1 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				24, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				26, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				40, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 24, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 26, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 40, 1);

		assertNotNull(result);
		assertFalse(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsWithUpperExtensionGreenWayTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		PositionedHeadPostureSymbol headPostureSymbol = (PositionedHeadPostureSymbol) symbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol());
		HeadSymbol head1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				30 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				30, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				30, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				30 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);

		assertNotNull(result);
		assertTrue(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsWithUpperExtensionPositiveOffsetTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		PositionedHeadPostureSymbol headPostureSymbol = (PositionedHeadPostureSymbol) symbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol());
		HeadSymbol head1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				31 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				32, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				35, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				30 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);

		assertNotNull(result);
		assertTrue(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsWithUpperExtensionNegativeAndPositiveOffsetTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		PositionedHeadPostureSymbol headPostureSymbol = (PositionedHeadPostureSymbol) symbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol());
		HeadSymbol head1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				29 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				32, 1);
		PositionedHeadPostureSymbol headPostureSymbol2 = (PositionedHeadPostureSymbol) symbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol());
		HeadSymbol head3 = symbolFactory.createHeadSymbol(headPostureSymbol2, 1,
				31 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				30 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead3 = symbolFactory.createHeadSymbol(headPostureSymbol2, 1,
				30 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);

		assertNotNull(result);
		assertTrue(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsWithUpperExtensionNegativeOffsetTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		PositionedHeadPostureSymbol headPostureSymbol = (PositionedHeadPostureSymbol) symbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol());
		HeadSymbol head1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				29 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				27, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				25, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 30, 1);

		assertNotNull(result);
		assertTrue(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsWithUpperExtensionNoCorrectionForHighPositiveOffsetsTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		PositionedHeadPostureSymbol headPostureSymbol = (PositionedHeadPostureSymbol) symbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol());
		HeadSymbol head1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				31 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				35, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				36, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				31 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 35, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 36, 1);

		assertNotNull(result);
		assertFalse(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsWithUpperExtensionNoCorrectionForHighNegativeOffsetsTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		PositionedHeadPostureSymbol headPostureSymbol = (PositionedHeadPostureSymbol) symbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol());
		HeadSymbol head1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				24 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				26, 1);
		HeadSymbol head3 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				29, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				24 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 26, 1);
		HeadSymbol expectedHead3 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 29, 1);

		assertNotNull(result);
		assertFalse(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	@Test
	public void correctYPositionForHeadSymbolsWithUpperExtensionNoCorrectionForHighNegativeAndHighPositiveOffsetsTest() {
		// prepare
		SimpleSign sign = new SimpleSign(new SignId(0, "word", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(), "comment");
		PositionedSymbolFactory symbolFactory = new PositionedSymbolFactory();
		PositionedHeadPostureSymbol headPostureSymbol = (PositionedHeadPostureSymbol) symbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol());
		HeadSymbol head1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				24 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol head2 = symbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1,
				26, 1);
		PositionedHeadPostureSymbol headPostureSymbol2 = (PositionedHeadPostureSymbol) symbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol());
		HeadSymbol head3 = symbolFactory.createHeadSymbol(headPostureSymbol2, 1,
				40 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		sign.addDisarrangedHeadSymbol(head1);
		sign.addDisarrangedHeadSymbol(head2);
		sign.addDisarrangedHeadSymbol(head3);

		// act
		Boolean result = callCorrectYPositionForHeadSymbos(sign);

		// check
		HeadSymbol expectedHead1 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				24 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);
		HeadSymbol expectedHead2 = symbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 1, 26, 1);
		HeadSymbol expectedHead3 = symbolFactory.createHeadSymbol(headPostureSymbol, 1,
				40 - HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_UPPER_EXTENSION, 1);

		assertNotNull(result);
		assertFalse(result);
		assertEquals(3, sign.getAllSymbols().size());
		assertTrue(sign.getAllSymbols().contains(expectedHead1));
		assertTrue(sign.getAllSymbols().contains(expectedHead2));
		assertTrue(sign.getAllSymbols().contains(expectedHead3));
	}

	private Boolean callCorrectYPositionForHeadSymbos(SimpleSign sign) {
		Class<?> headSymbolPositionCorrectionClass;
		Boolean result = null;
		try {
			headSymbolPositionCorrectionClass = Class.forName("HeadsymbolPositionCorrection");
			Method method = headSymbolPositionCorrectionClass.getDeclaredMethod("correctYPositionForHeadSymbols",
					SimpleSign.class);
			method.setAccessible(true); // if security settings allow this
			result = (Boolean) method.invoke(null, sign); // use null if the
															// method is static
		} catch (ClassNotFoundException | InvocationTargetException | IllegalArgumentException | IllegalAccessException | SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return result;
	}

}
