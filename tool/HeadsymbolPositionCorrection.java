import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.SymbolToHeadSymbolConverter;

public class HeadsymbolPositionCorrection {

	public static void main(String[] args) throws IOException {
		System.out.println("Starting Headsymbol position corretion");
		ConfigurationService configurationService = new ConfigurationService();
		DbConnector connector = new DbConnector(configurationService);
		UserDb userDB = new UserDb(connector);
		SymbolDB symbolDB = new SymbolDB(connector);
		SymbolFactory symbolFactory = new SymbolFactory(symbolDB.getAllSymbols());
		SignDB signDB = new SignDB(connector, userDB, symbolFactory, configurationService);
		SymbolToHeadSymbolConverter converter = new SymbolToHeadSymbolConverter(new PositionedSymbolFactory());

		for (SignLocale locale : SignLocale.values()) {
			updateSignsForLocale(connector, signDB, locale, converter);
		}
		System.out.println("Done.");
	}

	private static void updateSignsForLocale(DbConnector connector, SignDB signDB, SignLocale locale,
			SymbolToHeadSymbolConverter converter) {
		System.out.println("Current locale : " + locale);

		Map<String, List<SignItem>> allSignsForLocale = loadSignItems(signDB, locale);
		int nextTenPercentPoint = 0;
		List<List<SignItem>> signs = new ArrayList<List<SignItem>>(allSignsForLocale.values());
		for (int i = 0, j = 0; i < signs.size(); i++) {
			// Prozentanzeige
			if (i > nextTenPercentPoint) {
				System.out.println(j * 10 + " Percent finished of " + locale);
				j++;
				nextTenPercentPoint = (int) (j * 0.1 * allSignsForLocale.size());
			}
			for (SignItem signItem : signs.get(i)) {

				SimpleSign sign = signDB.getSign(signItem.getSignId());
				convertSignToDomainModel(sign, converter);

				if (correctYPositionForHeadSymbols(sign)) {
					signItem.setLocalSign(sign);
					try {
						updateSign(connector, sign);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	protected static final String SIGN_TABLE_NAME = "signs";
	private static final String POSITIONED_SYMBOLS_TABLE_NAME = "positionedsymbols";

	private static void updateSign(DbConnector connector, SimpleSign sign) throws SQLException {
		assert connector != null : "Precondition failed: connector != null";
		assert sign != null : "sign != null";

		PreparedStatement deleteOldSymbolsStatement = null;
		PreparedStatement insertNewSymbolsStatement = null;
		Connection connection = null;
		try {
			connection = connector.getConnection();
			connection.setAutoCommit(false);

			deleteOldSymbolsStatement = connection.prepareStatement("DELETE FROM " + POSITIONED_SYMBOLS_TABLE_NAME
					+ " WHERE signidupper = ? AND signword = ? AND language = ? AND source = ?;");
			deleteOldSymbolsStatement.setLong(1, sign.getSignId().getUpperIdPart());
			deleteOldSymbolsStatement.setString(2, sign.getSignId().getLowerIdPart());
			deleteOldSymbolsStatement.setString(3, sign.getSignLocale().name());
			deleteOldSymbolsStatement.setString(4, sign.getSignId().getSignSource().name());
			deleteOldSymbolsStatement.execute();

			for (PositionedSymbol symbol : sign.getPlainSymbols()) {
				insertNewSymbolsStatement = connection.prepareStatement("INSERT INTO " + POSITIONED_SYMBOLS_TABLE_NAME
						+ "(signidupper, signword, symbolid, language, source, x, y, z) VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
				insertNewSymbolsStatement.setLong(1, sign.getSignId().getUpperIdPart());
				insertNewSymbolsStatement.setString(2, sign.getSignId().getLowerIdPart());
				insertNewSymbolsStatement.setString(3, symbol.getSymbol().toString());
				insertNewSymbolsStatement.setString(4, sign.getSignLocale().name());
				insertNewSymbolsStatement.setString(5, sign.getSignId().getSignSource().name());
				insertNewSymbolsStatement.setInt(6, symbol.getX());
				insertNewSymbolsStatement.setInt(7, symbol.getY());
				insertNewSymbolsStatement.setInt(8, symbol.getZ());
				insertNewSymbolsStatement.execute();
			}
			connection.commit();
		} catch (Exception e) {
			System.out.println("ERROR: Failed to update sign with id: " + sign.getSignId());
			e.printStackTrace();
		} finally {
			deleteOldSymbolsStatement.close();
			insertNewSymbolsStatement.close();
			connection.close();
		}
	}

	private static Map<String, List<SignItem>> loadSignItems(SignDB signDB, SignLocale locale) {
		Map<String, List<SignItem>> allSignsForLocale = new HashMap<String, List<SignItem>>();
		List<String> allSignWordsForLocale = signDB.getAllSignWordsForLocale(locale);
		int wordsLoadedFromDBPerChunk = 12000;

		for (int i = 0; i < allSignWordsForLocale.size(); i += wordsLoadedFromDBPerChunk) {
			if (allSignWordsForLocale.size() - i >= wordsLoadedFromDBPerChunk) {
				allSignsForLocale.putAll(
						signDB.findSigns(locale, allSignWordsForLocale.subList(i, i + wordsLoadedFromDBPerChunk)));
			} else {
				allSignsForLocale.putAll(
						signDB.findSigns(locale, allSignWordsForLocale.subList(i, allSignWordsForLocale.size())));
			}
		}
		return allSignsForLocale;
	}

	private static boolean correctYPositionForHeadSymbols(SimpleSign convertedSign) {
		boolean hasCorrected = false;
		List<HeadSymbol> disarrangedHeadSymbols = convertedSign.getDisarrangedHeadSymbols();
		if (!disarrangedHeadSymbols.isEmpty()) {
			int minY = Integer.MAX_VALUE;
			int maxY = Integer.MIN_VALUE;

			for (HeadSymbol headSymbol : disarrangedHeadSymbols) {
				minY = Math.min(headSymbol.getY() + headSymbol.getUpperExtension(), minY);
				maxY = Math.max(headSymbol.getY() + headSymbol.getUpperExtension(), maxY);
			}

			if (minY >= 25 && maxY <= 35 && maxY - minY <= 5) {
				for (HeadSymbol headSymbol : disarrangedHeadSymbols) {
					headSymbol.setY(30 - headSymbol.getUpperExtension());
				}
				hasCorrected = true;
			}
		}
		return hasCorrected;
	}

	private static void convertSignToDomainModel(SimpleSign signToBeConverted, SymbolToHeadSymbolConverter converter) {
		List<HeadSymbol> newDisarrangedHeadSymbols = new ArrayList<HeadSymbol>(
				signToBeConverted.getDisarrangedHeadSymbols());

		// Remove old disarrangedHeadSymbols
		for (HeadSymbol headSymbol : newDisarrangedHeadSymbols) {
			signToBeConverted.removeDisarrangedHeadSymbol(headSymbol);
		}

		List<PositionedSymbol> otherSignSymbols = new ArrayList<PositionedSymbol>(signToBeConverted.getOtherSymbols());

		// Remove symbols that can be converted to HeadSymbols
		for (PositionedSymbol positionedSymbol : converter.getConvertableSymbols(otherSignSymbols)) {
			signToBeConverted.removeSymbol(positionedSymbol);
		}

		// Add converted HeadSymbols
		newDisarrangedHeadSymbols.addAll(converter.convertToHeadSymbols(otherSignSymbols));

		for (HeadSymbol headSymbol : newDisarrangedHeadSymbols) {
			signToBeConverted.addDisarrangedHeadSymbol(headSymbol);
		}
	}
}
