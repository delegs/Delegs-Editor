package de.signWritingEditor.server.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.PersistenceLocation;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class SignHistoryDB extends MaterialDB {

	private static final String SIGN_HISTORY_TABLE_NAME = "signshistory";
	private static final String POSITIONED_SYMBOLS_HISTORY_TABLE_NAME = "positionedsymbolshistory";
	private static final Logger LOG = Logger.getLogger(SignHistoryDB.class);
	private final UserDb userDB;
	private final SymbolFactory symbolFactory;

	public SignHistoryDB(DbConnector connector, UserDb userDB, ConfigurationService configurationService,
			SymbolFactory symbolFactory) {
		super(connector);
		this.userDB = userDB;
		this.symbolFactory = symbolFactory;
	}

	public List<SignHistoryItem> getSignHistoryItemsFor(final SignId signId) {
		assert signId != null : "Precondition failed: signId != null";

		Query signHistoryQuery;

		if (signId.getSignSource().equals(SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS)
				|| signId.getSignSource().equals(SignSource.IMPORTED)) {
			signHistoryQuery = createQuery(
					"SELECT revision, source, mdtSignPuddle, comment, owner, idupper, word, language FROM "
							+ SIGN_HISTORY_TABLE_NAME
							+ " WHERE language = ? AND idupper = ? AND word collate utf8_bin = ? AND source IN (?, ?) "
							+ "ORDER BY mdtSignPuddle DESC",
					signId.getSignLocale().name(), signId.getUpperIdPart(), signId.getLowerIdPart(),
					SignSource.IMPORTED.name(), SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS.name());
		} else {
			signHistoryQuery = createQuery(
					"SELECT revision, source, mdtSignPuddle, comment, owner, idupper, word, language FROM "
							+ SIGN_HISTORY_TABLE_NAME
							+ " WHERE language = ? AND idupper = ? AND word collate utf8_bin = ? AND source = ? ORDER BY mdtSignPuddle DESC",
					signId.getSignLocale().name(), signId.getUpperIdPart(), signId.getLowerIdPart(),
					signId.getSignSource().name());
		}

		return signHistoryQuery.mapRows(new ResultSetFunction<SignHistoryItem>() {
			@Override
			public SignHistoryItem apply(ResultSet resultSet) throws SQLException {
				return parseSignHistoryItemFromResultSet(resultSet);
			}
		});
	}

	public void deleteSignHistoryForSign(SignId signId) {
		createQuery(
				"DELETE FROM " + SIGN_HISTORY_TABLE_NAME
						+ " WHERE idupper = ? AND word = ? AND language = ? AND source = ?",
				signId.getUpperIdPart(), signId.getLowerIdPart(), signId.getSignLocale(), signId.getSignSource())
						.execute();

		createQuery(
				"DELETE FROM " + POSITIONED_SYMBOLS_HISTORY_TABLE_NAME
						+ " WHERE signidupper = ? AND signword = ? AND language = ? AND source = ?",
				signId.getUpperIdPart(), signId.getLowerIdPart(), signId.getSignLocale(), signId.getSignSource())
						.execute();
	}

	public boolean existsItem(SignHistoryItem signHistoryItem) {
		assert signHistoryItem != null : "signHistoryItem != null";

		return createQuery(
				"SELECT COUNT(idupper) FROM " + SIGN_HISTORY_TABLE_NAME
						+ "  WHERE  word = ? AND idupper = ? AND language = ? AND source = ? AND revision = ?",
				signHistoryItem.getSignId().getLowerIdPart(), signHistoryItem.getSignId().getUpperIdPart(),
				signHistoryItem.getSignId().getSignLocale().name(), signHistoryItem.getSignId().getSignSource().name(),
				signHistoryItem.getRevision()).getNumberOfMatches() > 0;

	}

	public SimpleSign getSign(final SignHistoryItem signHistoryItem) {
		assert existsItem(signHistoryItem) : "Precondition failed: existsItem(signHistoryItem)";

		final Query signQuery = createQuery("SELECT * FROM " + SIGN_HISTORY_TABLE_NAME
				+ " WHERE source = ? AND idupper = ? AND  word collate utf8_bin = ? 	AND language = ? AND revision = ? ",
				signHistoryItem.getSignId().getSignSource().name(), signHistoryItem.getSignId().getUpperIdPart(),
				signHistoryItem.getSignId().getLowerIdPart(), signHistoryItem.getSignId().getSignLocale().name(),
				signHistoryItem.getRevision());

		return signQuery.mapFirstRow(new ResultSetFunction<SimpleSign>() {
			@Override
			public SimpleSign apply(ResultSet resultSet) throws SQLException {
				SimpleSign result = parseSignQueryResultToSign(resultSet);
				result.setPersistenceLocation(PersistenceLocation.GLOBAL_DICTIONARY);

				assert result != null : "Postcondition failed: result != null";
				assert result.getSignId().equals(signHistoryItem
						.getSignId()) : "Postcondition failed: result.getSignId().equals(signHistoryItem.getSignId())";
				return result;
			}

			@Override
			public void onError() {
				LOG.error("[GREPME] ResultSet closed: " + signQuery);
			}
		});
	}

	private SimpleSign parseSignQueryResultToSign(ResultSet signQueryResultItem) throws SQLException {
		assert signQueryResultItem != null : "Precondition failed: signQueryResultItem != null";

		SimpleSign sign;

		List<PositionedSymbol> signParts;

		String author = signQueryResultItem.getString("owner");
		if (author == null) {
			author = "unknown";
		}
		SignLocale language = SignLocale.valueOf(signQueryResultItem.getString("language"));

		String comment = signQueryResultItem.getString("comment");

		Date modificationDate = new Date(signQueryResultItem.getLong("mdtSignPuddle"));

		int revision = signQueryResultItem.getInt("revision");

		int signUpperId = signQueryResultItem.getInt("idupper");
		String word = signQueryResultItem.getString("word");
		SignSource source = SignSource.valueOf(signQueryResultItem.getString("source"));

		sign = new SimpleSign(new SignId(signUpperId, word, language, source), userDB.getUser(author), language,
				modificationDate, comment);
		sign.setRevision(revision);

		Query symbolsQuery = createQuery("SELECT * FROM " + POSITIONED_SYMBOLS_HISTORY_TABLE_NAME
				+ " ps, symbols s WHERE ? = ps.signidupper AND ? = ps.signword AND ? = ps.language AND ? = ps.source AND s.id = ps.symbolid AND ps.revision = ? ",
				signUpperId, word, language.name(), source.name(), revision);

		signParts = symbolsQuery.mapRows(new ResultSetFunction<PositionedSymbol>() {

			@Override
			public PositionedSymbol apply(ResultSet resultSet) throws SQLException {
				int x = Integer.parseInt(resultSet.getString("x"));
				int y = Integer.parseInt(resultSet.getString("y"));
				int z = Integer.parseInt(resultSet.getString("z"));

				int category = Integer.parseInt(resultSet.getString("category"));
				int group = Integer.parseInt(resultSet.getString("sgroup"));
				int symbol = Integer.parseInt(resultSet.getString("symbol"));
				int variation = Integer.parseInt(resultSet.getString("variation"));
				int fill = Integer.parseInt(resultSet.getString("fill"));
				int rotation = Integer.parseInt(resultSet.getString("rotation"));

				return new PositionedSymbol(
						symbolFactory.createSymbol(category, group, symbol, variation, fill, rotation), x, y, z);
			}
		});

		for (PositionedSymbol i : signParts) {
			sign.addSymbol(i);
		}
		return sign;
	}

	private SignHistoryItem parseSignHistoryItemFromResultSet(ResultSet resultSet) throws SQLException {
		assert resultSet != null : "Precondition failed: resultSet != null";

		int signUpperIdPart = resultSet.getInt("idupper");
		String word = resultSet.getString("word");

		String languageName = resultSet.getString("language");
		SignLocale signLocale = SignLocale.valueOf(languageName);

		Long revision = resultSet.getLong("revision");
		SignSource source = SignSource.valueOf(resultSet.getString("source"));

		Date modificationDate = new Date(resultSet.getLong("mdtSignPuddle"));
		String authorName = resultSet.getString("owner");

		String comment = resultSet.getString("comment");
		if (comment == null) {
			comment = "";
		}

		return new SignHistoryItem(new SignId(signUpperIdPart, word, signLocale, source), authorName, comment,
				modificationDate, revision);
	}
}
