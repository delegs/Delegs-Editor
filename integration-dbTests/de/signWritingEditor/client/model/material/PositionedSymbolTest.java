package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class PositionedSymbolTest {

	private DbConnector connector;

	@Before
	public void setUp() throws IOException {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testConstructors() {
		SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());

		String codeRepresentation = "01-01-001-01-01-01";
		PositionedSymbol s1 = new PositionedSymbol(symbolFactory.createSymbol(codeRepresentation), 0, 0, 0);
		Symbol codeA = s1.getSymbol();
		assertNotNull(codeA);
		assertEquals(codeRepresentation, codeA.toString());
		assertEquals(0, s1.getX());
		assertEquals(0, s1.getY());

		PositionedSymbol s2 = new PositionedSymbol(symbolFactory.createSymbol(codeRepresentation), 10, 55, 1);
		codeA = s2.getSymbol();
		assertNotNull(codeA);
		assertEquals(codeRepresentation, codeA.toString());
		assertEquals(10, s2.getX());
		assertEquals(55, s2.getY());
		assertEquals(1, s2.getZ());

		Symbol codeB = new Symbol(2, 5, 5, 1, 1, 1, 0, 0);
		PositionedSymbol s3 = new PositionedSymbol(codeB, 0, 0, 0);
		assertEquals(codeB, s3.getSymbol());
		assertEquals(0, s3.getX());
		assertEquals(0, s3.getY());

		PositionedSymbol s4 = new PositionedSymbol(codeB, 13, 66, 1);
		assertEquals(codeB, s4.getSymbol());
		assertEquals(13, s4.getX());
		assertEquals(66, s4.getY());
		assertEquals(1, s4.getZ());
	}

	@Test
	public void testGetterSetter() {
		SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());

		String codeRepresentation = "01-01-001-01-01-01";
		PositionedSymbol s = new PositionedSymbol(symbolFactory.createSymbol(codeRepresentation), 0, 0, 0);
		Symbol codeA = s.getSymbol();
		assertNotNull(codeA);
		assertEquals(codeRepresentation, codeA.toString());
		assertEquals(0, s.getX());
		assertEquals(0, s.getY());

		Symbol symbolCode = new Symbol(1, 12, 654, 77, 04, 12, 0, 0);
		s.setSymbol(symbolCode);
		assertEquals(symbolCode, s.getSymbol());

		s.setX(9);
		assertEquals(9, s.getX());

		s.setY(5);
		assertEquals(5, s.getY());
	}

	@Test
	public void testHashCode() {
		SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());

		String codeRepresentation = "01-01-001-01-01-03";
		PositionedSymbol s1 = new PositionedSymbol(symbolFactory.createSymbol(codeRepresentation), 0, 0, 0);
		assertEquals(new PositionedSymbol(symbolFactory.createSymbol(codeRepresentation), 0, 0, 0).hashCode(),
				s1.hashCode());

		PositionedSymbol s2 = new PositionedSymbol(new Symbol(1, 1, 1, 1, 1, 3, 0, 0), 0, 0, 0);
		assertEquals(new PositionedSymbol(new Symbol(1, 1, 1, 1, 1, 3, 0, 0), 0, 0, 0).hashCode(), s2.hashCode());

		assertEquals(s1.hashCode(), s2.hashCode());
	}

	@Test
	public void testEquals() {
		SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());

		String codeRepresentation = "01-01-001-01-01-01";
		PositionedSymbol s1 = new PositionedSymbol(symbolFactory.createSymbol(codeRepresentation), 0, 0, 0);
		assertEquals(new PositionedSymbol(symbolFactory.createSymbol(codeRepresentation), 0, 0, 0), s1);

		PositionedSymbol s2 = new PositionedSymbol(new Symbol(1, 1, 1, 1, 1, 1, 0, 0), 0, 0, 0);
		assertEquals(new PositionedSymbol(new Symbol(1, 1, 1, 1, 1, 1, 0, 0), 0, 0, 0), s2);

		assertEquals(s1, s2);
	}

	@Test
	public void testClone() {
		SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());

		String codeRepresentation = "01-01-001-01-01-03";
		PositionedSymbol s1 = new PositionedSymbol(symbolFactory.createSymbol(codeRepresentation), 0, 0, 0);
		assertEquals(s1.clone().hashCode(), s1.hashCode());

		PositionedSymbol s2 = new PositionedSymbol(new Symbol(1, 1, 1, 1, 1, 3, 0, 0), 0, 0, 0);
		assertEquals(s2.clone().hashCode(), s2.hashCode());

		assertEquals(s1.hashCode(), s2.hashCode());
		assertEquals(s1.clone().hashCode(), s2.clone().hashCode());
	}

}
