package de.signWritingEditor.server.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.Pair;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.FingerAlphabet;
import de.signWritingEditor.shared.model.domainValue.PersistenceLocation;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.DatabasePositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedFingerAlphabetSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.RevisionedWordToSignsDictionaryEntries;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.WordToSignsDictionaryEntry;
import de.signWritingEditor.shared.service.SymbolCategoryAnalyzer;

public class SignDB extends MaterialDB {

	protected static final String DELETEDSIGNS_TABLE_NAME = "deletedsigns";
	private static final String SIGNREVISION_TABLE_NAME = "signrevision";
	protected static final String SIGN_TABLE_NAME = "signs";
	private static final String POSITIONED_SYMBOLS_TABLE_NAME = "positionedsymbols";
	private static final String POSITIONED_SYMBOLS_HISTORY_TABLE_NAME = "positionedsymbolshistory";
	private static final String SIGN_HISTORY_TABLE_NAME = "signshistory";

	private final UserDb authorDB;
	private final SymbolFactory symbolFactory;

	private static final Logger LOG = Logger.getLogger(SignDB.class);

	/**
	 * 
	 * @param conPool
	 * @param authorDB
	 * @param symbolFactory
	 */
	public SignDB(DbConnector connector, UserDb authorDB, SymbolFactory symbolFactory,
			ConfigurationService configurationService) {
		super(connector);
		this.authorDB = authorDB;
		this.symbolFactory = symbolFactory;
	}

	public boolean existsItem(SignId signId) {
		assert signId != null : "signId != null";

		Query query = createQuery(
				"SELECT COUNT(idupper) FROM " + SIGN_TABLE_NAME
						+ "  WHERE  word = ? AND idupper = ? AND language = ? AND source = ?",
				signId.getLowerIdPart(), signId.getUpperIdPart(), signId.getSignLocale().name(),
				signId.getSignSource().name());

		return query.getNumberOfMatches() > 0;
	}

	public void saveSign(String word, SimpleSign sign) throws Exception {
		assert word != null : "Precondition failed: word != null";
		assert !word.isEmpty() : "Precondition failed: !word.isEmpty()";
		assert sign != null : "Precondition failed: sign != null";

		if (sign.getSignId().getSignSource().equals(SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS)) {

			boolean isAlreadyHistoricised = false;
			Query isAlreadyHistoricisedQuery = createQuery(
					"SELECT COUNT(revision) FROM " + SIGN_HISTORY_TABLE_NAME
							+ " WHERE idupper = ? AND word = ? AND language = ? AND source = ? AND revision = ?",
					sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(),
					sign.getSignId().getSignLocale().name(), SignSource.IMPORTED.name(), sign.getRevision());

			isAlreadyHistoricised = isAlreadyHistoricisedQuery.getNumberOfMatches() > 0;

			if (!isAlreadyHistoricised) {
				SignId importedSignId = new SignId(sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(),
						sign.getSignId().getSignLocale(), SignSource.IMPORTED);
				historiciseSign(importedSignId);
			}
		}

		long signRevisionIncremented = incrementRevision();
		sign.setModificationDate(
				sign.getSignId().getSignSource().equals(SignSource.IMPORTED) ? sign.getModificationDate()
						: new java.util.Date());

		createQuery("INSERT INTO " + SIGN_TABLE_NAME
				+ "(idupper, word, owner, language, width, mdtSignPuddle, revision, source, comment)  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)",
				sign.getSignId().getUpperIdPart(), word, sign.getAuthor().getUsername(), sign.getSignLocale().name(),
				sign.getWidth(), sign.getModificationDate().getTime(), signRevisionIncremented,
				sign.getSignId().getSignSource().name(), sign.getComment()).execute();

		// Remove positioned symbols entry from table of positioned symbols
		// to prevent duplicated entries when replacing an imported sign
		// twice (2nd time
		// after deleting the first replacement)
		createQuery(
				"DELETE FROM " + POSITIONED_SYMBOLS_TABLE_NAME
						+ " WHERE signidupper = ? AND signword = ? AND language = ? AND source = ?",
				sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(), sign.getSignLocale().name(),
				sign.getSignId().getSignSource().name()).execute();

		for (PositionedSymbol symbol : sign.getPlainSymbols()) {
			createQuery("INSERT INTO " + POSITIONED_SYMBOLS_TABLE_NAME
					+ "(signidupper, signword, symbolid, language, source, x, y, z) VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
					sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(), symbol.getSymbol().toString(),
					sign.getSignLocale().name(), sign.getSignId().getSignSource().name(), symbol.getX(), symbol.getY(),
					symbol.getZ()).execute();
		}

		// Remove entry from table of deleted signs, if sign was deleted
		// before
		if (isSignDeleted(sign)) {
			createQuery(
					"DELETE FROM " + DELETEDSIGNS_TABLE_NAME
							+ " WHERE signupperid = ? AND word = ? AND language = ? AND source = ?",
					sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(), sign.getSignLocale().name(),
					sign.getSignId().getSignSource().name()).execute();
		}

		sign.setPersistenceLocation(PersistenceLocation.GLOBAL_DICTIONARY);
	}

	public void updateSign(SimpleSign sign) {
		assert sign != null : "sign != null";

		historiciseSign(sign.getSignId());

		long signRevisionIncremented = this.incrementRevision();
		sign.setModificationDate(new java.util.Date());
		createQuery("UPDATE " + SIGN_TABLE_NAME
				+ " SET owner = ?, language = ?, width = ?, mdtSignPuddle = ?, revision = ?, comment = ? WHERE idupper = ? AND word = ? AND source = ?",
				sign.getAuthor().getUsername(), sign.getSignLocale().name(), sign.getWidth(),
				sign.getModificationDate().getTime(), signRevisionIncremented, sign.getComment(),
				sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(),
				sign.getSignId().getSignSource().name()).execute();

		createQuery(
				"DELETE FROM " + POSITIONED_SYMBOLS_TABLE_NAME
						+ " WHERE signidupper = ? AND signword = ? AND language = ? AND source = ?",
				sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(), sign.getSignLocale().name(),
				sign.getSignId().getSignSource().name()).execute();

		for (PositionedSymbol symbol : sign.getPlainSymbols()) {
			createQuery("INSERT INTO " + POSITIONED_SYMBOLS_TABLE_NAME
					+ "(signidupper, signword, symbolid, language, source, x, y, z) VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
					sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(), symbol.getSymbol().toString(),
					sign.getSignLocale().name(), sign.getSignId().getSignSource().name(), symbol.getX(), symbol.getY(),
					symbol.getZ()).execute();
		}

		sign.setPersistenceLocation(PersistenceLocation.GLOBAL_DICTIONARY);
	}

	public long getModificationDate(SignId signId) {
		long modificationDate = Long.parseLong(createQuery(
				"SELECT mdtSignPuddle FROM " + SIGN_TABLE_NAME
						+ " WHERE word = ? AND idupper = ? AND language = ? AND source = ?",
				signId.getLowerIdPart(), signId.getUpperIdPart(), signId.getSignLocale().name(),
				signId.getSignSource().name()).getString());
		return modificationDate;
	}

	public long getCurrentRevision() {
		return (long) createQuery("SELECT MAX(revision) FROM " + SIGNREVISION_TABLE_NAME).getInt();
	}

	public long incrementRevision() {
		long currentRevision = getCurrentRevision();
		long result = currentRevision + 1;

		createQuery("UPDATE " + SIGNREVISION_TABLE_NAME + " SET revision = ? WHERE revision = ?", result,
				currentRevision).execute();

		return result;
	}

	public void deleteSign(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";
		assert existsItem(signId) : "Precondition failed: existsItem(signId)";

		String id = "" + signId.getUpperIdPart();

		createQuery(
				"DELETE FROM " + POSITIONED_SYMBOLS_TABLE_NAME
						+ " WHERE signidupper = ? AND signword = ? AND language = ? AND source = ?",
				id, signId.getLowerIdPart(), signId.getSignLocale().name(), signId.getSignSource().name()).execute();

		createQuery(
				"DELETE FROM " + SIGN_TABLE_NAME + " WHERE idupper = ? AND word = ? AND language = ? AND source = ?",
				id, signId.getLowerIdPart(), signId.getSignLocale().name(), signId.getSignSource().name()).execute();

		long incrementedRevision = incrementRevision();
		createQuery(
				"INSERT INTO " + DELETEDSIGNS_TABLE_NAME
						+ "(signupperid, word, language, revision, source) VALUES(?,?, ?, ?, ?)",
				id, signId.getLowerIdPart(), signId.getSignLocale().name(), incrementedRevision,
				signId.getSignSource().name()).execute();
	}

	public void addSignToDeletedSignsTable(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";
		assert existsItem(signId) : "Precondition failed: existsItem(signId)";

		// If the sign to delete is an overwritten sign we have to delete the
		// imported entry from the signhistory tabel so that the signhistory is
		// ok
		if (SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS.equals(signId.getSignSource())) {
			SignId importedSignId = new SignId(signId.getUpperIdPart(), signId.getLowerIdPart(), signId.getSignLocale(),
					SignSource.IMPORTED);
			if (existsItem(importedSignId)) {

				int revision = -1;
				revision = createQuery(
						"SELECT revision FROM " + SIGN_TABLE_NAME
								+ " WHERE idupper = ? AND word = ? AND language = ? AND source = ?",
						importedSignId.getUpperIdPart(), importedSignId.getLowerIdPart(),
						importedSignId.getSignLocale().name(), importedSignId.getSignSource().name()).getInt();

				createQuery(
						"INSERT INTO " + DELETEDSIGNS_TABLE_NAME
								+ "(signupperid, word, language, revision, source) VALUES(?,?, ?, ?, ?)",
						importedSignId.getUpperIdPart(), importedSignId.getLowerIdPart(),
						importedSignId.getSignLocale().name(), revision, importedSignId.getSignSource().name())
								.execute();
			}
		}

		String id = "" + signId.getUpperIdPart();
		long incrementedRevision = incrementRevision();
		createQuery(
				"INSERT INTO " + DELETEDSIGNS_TABLE_NAME
						+ "(signupperid, word, language, revision, source) VALUES(?,?, ?, ?, ?)",
				id, signId.getLowerIdPart(), signId.getSignLocale().name(), incrementedRevision,
				signId.getSignSource().name()).execute();
	}

	public void removeSignFromDeletedSignsTable(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";
		assert isSignDeleted(signId) : "Precondition failed: isSignDeleted(signId)";

		String id = "" + signId.getUpperIdPart();
		createQuery(
				"DELETE FROM " + DELETEDSIGNS_TABLE_NAME
						+ " WHERE signupperid = ? AND word = ? AND language = ? AND source = ?",
				id, signId.getLowerIdPart(), signId.getSignLocale().name(), signId.getSignSource().name()).execute();
	}

	public boolean isSignDeleted(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";

		boolean result = false;
		Query query = createQuery(
				"SELECT count(signupperid) FROM " + DELETEDSIGNS_TABLE_NAME
						+ " WHERE signupperId=? AND word=? AND language=? AND source=?",
				signId.getUpperIdPart(), signId.getLowerIdPart(), signId.getSignLocale().name(),
				signId.getSignSource().name());

		return query.getNumberOfMatches() > 0;
	}

	/**
	 * Delete the given sign from the database
	 * 
	 * @param sign The sign to delete
	 * @require sign != null
	 * @require existsItem(sign.getMeaning())
	 */
	public void deleteSign(SimpleSign sign) {
		assert sign != null : "sign != null";
		assert existsItem(sign.getSignId()) : "existsItem(sign.getSignId()) ";

		deleteSign(sign.getSignId());
	}

	public List<SignItem> findSigns(String word, SignLocale signLocale) {
		assert word != null : "word != null";

		final Query signQuery = createQuery("SELECT idupper, word, width, language, revision, source FROM "
				+ SIGN_TABLE_NAME
				+ " AS s WHERE s.language = ? AND LOWER(s.word) collate utf8_bin = ? AND (idupper, LOWER(word), language, source) NOT IN (SELECT d.signupperid, LOWER(d.word), d.language, d.source FROM "
				+ DELETEDSIGNS_TABLE_NAME + "  AS d ) ORDER BY s.idupper", signLocale.name(), word.toLowerCase());

		List<SignItem> unhidden = signQuery.mapRows(new ResultSetFunction<SignItem>() {
			@Override
			public SignItem apply(ResultSet resultSet) throws SQLException {
				return parseSignItemQueryResultItem(resultSet);
			}
		});
		return hideOverwrittenSignPuddleSigns(unhidden);
	}

	@Deprecated
	public List<String> getAllSignWordsForLocale(SignLocale locale) {

		return createQuery("SELECT signword FROM " + POSITIONED_SYMBOLS_TABLE_NAME + " WHERE language LIKE ?",
				locale.name()).mapRows(new ResultSetFunction<String>() {

					@Override
					public String apply(ResultSet resultSet) throws SQLException {
						return resultSet.getString("signword");
					}
				});

	}

	/**
	 * Only to be used from Tool denormalizePositionedSymbols
	 */
	@Deprecated
	public List<DatabasePositionedSymbol> denormalize() {

		List<DatabasePositionedSymbol> result = new ArrayList<DatabasePositionedSymbol>();
		result = createQuery("SELECT p.*, s.width FROM " + POSITIONED_SYMBOLS_TABLE_NAME
				+ " AS p INNER JOIN symbols AS s ON s.id = p.symbolid ORDER BY signword, signidupper, language, source, x DESC")
						.mapRows(new ResultSetFunction<DatabasePositionedSymbol>() {

							@Override
							public DatabasePositionedSymbol apply(ResultSet resultSet) throws SQLException {
								return new DatabasePositionedSymbol(
										Integer.parseInt(resultSet.getString("signidupper")),
										resultSet.getString("symbolid"), Integer.parseInt(resultSet.getString("x")),
										Integer.parseInt(resultSet.getString("y")),
										Integer.parseInt(resultSet.getString("z")), resultSet.getString("signword"),
										resultSet.getString("language"), resultSet.getString("source"),
										Integer.parseInt(resultSet.getString("width")));
							}
						});

		float counter = 0;

		System.out.println("Selected all " + result.size() + " symbols at " + new java.util.Date().toString()
				+ ". Now updating...");

		List<DatabasePositionedSymbol> lastDPSs = new ArrayList<DatabasePositionedSymbol>();
		for (DatabasePositionedSymbol databasePositionedSymbol : result) {
			if (lastDPSs.size() == 0) {
				lastDPSs.add(databasePositionedSymbol);
			} else {
				if (databasePositionedSymbol.equals(lastDPSs.get(0))) {
					lastDPSs.add(databasePositionedSymbol);
				} else {
					int averageX = (lastDPSs.get(0).x + lastDPSs.get(0).width) / 2;
					createQuery("UPDATE " + POSITIONED_SYMBOLS_TABLE_NAME
							+ " SET x = x - ? WHERE signidupper = ? AND signword = ? AND language = ? AND source = ?",
							averageX, lastDPSs.get(0).signidupper, lastDPSs.get(0).signword, lastDPSs.get(0).language,
							lastDPSs.get(0).source).execute();
					lastDPSs.clear();
					lastDPSs.add(databasePositionedSymbol);
				}
			}
			counter++;
			if (counter % 100 == 0) {
				System.out.println(
						"completed " + counter + " / " + result.size() + " at " + (new java.util.Date()).toString());
				if (counter / result.size() > 0.9)
					System.out.println(">90%");
				else if (counter / result.size() > 0.8)
					System.out.println(">80%");
				else if (counter / result.size() > 0.7)
					System.out.println(">70%");
				else if (counter / result.size() > 0.6)
					System.out.println(">60%");
				else if (counter / result.size() > 0.5)
					System.out.println(">50%");
				else if (counter / result.size() > 0.4)
					System.out.println(">40%");
				else if (counter / result.size() > 0.3)
					System.out.println(">30%");
				else if (counter / result.size() > 0.2)
					System.out.println(">20%");
				else if (counter / result.size() > 0.1)
					System.out.println(">10%");
				else if (counter / result.size() > 0.05)
					System.out.println(">5%");
				else if (counter / result.size() > 0.01)
					System.out.println(">1%");
			}
		}

		int averageX = lastDPSs.get(0).x / 2;
		createQuery(
				"UPDATE " + POSITIONED_SYMBOLS_TABLE_NAME
						+ " SET x = x - ? WHERE signidupper = ? AND signword = ? AND language = ? AND source = ?",
				averageX, lastDPSs.get(0).signidupper, lastDPSs.get(0).signword, lastDPSs.get(0).language,
				lastDPSs.get(0).source).execute();
		lastDPSs.clear();
		System.out.println("Done");

		return result;
	}

	public List<String> findSignWordsWithPrefix(String prefix, Integer count, SignLocale signLocale) {
		assert prefix != null : "prefix != null";
		assert count != null : "count != null";

		return createQuery("SELECT word FROM " + SIGN_TABLE_NAME
				+ " AS s WHERE s.language = ? AND LOWER(s.word) LIKE CONCAT(?,'%') AND (idupper, LOWER(word), language, source) NOT IN (SELECT d.signupperid, LOWER(d.word), d.language, d.source FROM "
				+ DELETEDSIGNS_TABLE_NAME + "  AS d ) GROUP BY s.word LIMIT ?", signLocale.name(), prefix.toLowerCase(),
				count).mapRows(new ResultSetFunction<String>() {

					@Override
					public String apply(ResultSet resultSet) throws SQLException {
						return resultSet.getString("word");
					}
				});

	}

	public RevisionedWordToSignsDictionaryEntries findEntries(final SignLocale signLocale) {
		assert signLocale != null : "Precondition failed: signLocale != null";

		RevisionedWordToSignsDictionaryEntries result = new RevisionedWordToSignsDictionaryEntries();

		// Make sure to get revision before fetches
		result.setRevision(getCurrentRevision());

		int allSignIdsCount = 0;
		final Map<String, List<SignId>> wordsToSignIds = new HashMap<String, List<SignId>>();

		createQuery("SELECT idupper, word, source FROM " + SIGN_TABLE_NAME + " WHERE language = ?", signLocale.name())
				.forEachRow(new ResultSetConsumer() {

					@Override
					public void accept(ResultSet resultSet) throws SQLException {
						int signUpperIdPart = resultSet.getInt("idupper");
						String meaning = resultSet.getString("word");
						SignSource source = SignSource.valueOf(resultSet.getString("source"));
						SignId signId = new SignId(signUpperIdPart, meaning, signLocale, source);

						List<SignId> signIds = wordsToSignIds.get(meaning);
						if (signIds == null) {
							signIds = new ArrayList<SignId>();
							wordsToSignIds.put(meaning, signIds);
						}
						signIds.add(signId);
					}
				});

		for (String meaning : wordsToSignIds.keySet()) {
			List<SignId> signIds = wordsToSignIds.get(meaning);

			result.addDictionaryEntry(new WordToSignsDictionaryEntry(meaning, signIds));
			allSignIdsCount += signIds.size();
		}

		assert result != null : "Postcondition failed: result != null";
		assert countItemsWithLocale(
				signLocale) == allSignIdsCount : "Postcondition failed: countItemsWithLocale(signLocale) == result.size()";

		return result;
	}

	public RevisionedWordToSignsDictionaryEntries getEntriesSinceRevision(long revision, final SignLocale signLocale) {
		assert revision >= 0 : "Precondition failed: revision >= 0";
		assert signLocale != null : "Precondition failed: signLocale != null";

		RevisionedWordToSignsDictionaryEntries result = new RevisionedWordToSignsDictionaryEntries();

		// Make sure to get revision before fetches
		result.setRevision(getCurrentRevision());

		final Map<String, List<SignId>> wordsToSignIds = new HashMap<String, List<SignId>>();

		Query signQuery = createQuery("SELECT idupper as signupperid, word, language, source FROM " + SIGN_TABLE_NAME
				+ " WHERE language = ? AND revision > ? ORDER BY signs.idupper", signLocale.name(), revision);

		signQuery.forEachRow(new ResultSetConsumer() {
			@Override
			public void accept(ResultSet resultSet) throws SQLException {
				String meaning = resultSet.getString("word");
				SignId signId = new SignId(resultSet.getLong("signupperid"), meaning,
						SignLocale.valueOf(resultSet.getString("language")),
						SignSource.valueOf(resultSet.getString("source")));

				List<SignId> signIds = wordsToSignIds.get(meaning);
				if (signIds == null) {
					signIds = new ArrayList<SignId>();
					wordsToSignIds.put(meaning, signIds);
				}
				signIds.add(signId);
			}
		});

		for (String meaning : wordsToSignIds.keySet()) {
			List<SignId> signIds = wordsToSignIds.get(meaning);
			result.addDictionaryEntry(new WordToSignsDictionaryEntry(meaning, signIds));
		}
		return result;
	}

	public RevisionedWordToSignsDictionaryEntries getDeletedEntriesSinceRevision(long revision,
			final SignLocale signLocale) {
		assert revision >= 0 : "Precondition failed: revision >= 0";
		assert signLocale != null : "Precondition failed: signLocale != null";
		final RevisionedWordToSignsDictionaryEntries result = new RevisionedWordToSignsDictionaryEntries();

		// Make sure to get revision before fetches
		result.setRevision(getCurrentRevision());

		Query signQuery = createQuery(
				"SELECT signupperid, word, language, source FROM " + DELETEDSIGNS_TABLE_NAME
						+ " WHERE language = ? AND revision > ? ORDER BY deletedsigns.signupperid",
				signLocale.name(), revision);

		final Map<String, List<SignId>> wordsToSignIds = new HashMap<String, List<SignId>>();

		signQuery.forEachRow(new ResultSetConsumer() {
			@Override
			public void accept(ResultSet resultSet) throws SQLException {
				String meaning = resultSet.getString("word");
				SignId signId = new SignId(resultSet.getLong("signupperid"), meaning,
						SignLocale.valueOf(resultSet.getString("language")),
						SignSource.valueOf(resultSet.getString("source")));

				List<SignId> signIds = wordsToSignIds.get(meaning);
				if (signIds == null) {
					signIds = new ArrayList<SignId>();
					wordsToSignIds.put(meaning, signIds);
				}
				signIds.add(signId);
			}
		});

		for (String meaning : wordsToSignIds.keySet()) {
			List<SignId> signIds = wordsToSignIds.get(meaning);
			result.addDictionaryEntry(new WordToSignsDictionaryEntry(meaning, signIds));
		}

		return result;
	}

	public void loadSignItemWidth(Set<SignItem> signItems, final SignLocale signLocale) {
		assert signItems != null : "Precondition failed: signItems != null";
		assert !signItems.isEmpty() : "Precondition failed: !signItems.isEmpty()";
		assert signLocale != null : "Precondition failed: signLocale != null";

		final Map<SignId, SignItem> signItemMap = new HashMap<SignId, SignItem>();
		for (SignItem signItem : signItems) {
			signItemMap.put(signItem.getSignId(), signItem);
			if (signItem.getLocalSign() != null) {
				signItem.getLocalSign().setPersistenceLocation(PersistenceLocation.GLOBAL_DICTIONARY);
			}
		}

		StringBuilder queryBuilder = new StringBuilder("SELECT idupper, word, source, width FROM " + SIGN_TABLE_NAME
				+ " WHERE language = ? AND CONCAT(idupper,'&&',word,'&&',source) collate utf8_bin IN (?");
		for (int index = 1; index < signItemMap.size(); index++) {
			queryBuilder.append(", ?");
		}
		queryBuilder.append(")");

		List<Object> queryParameters = new ArrayList<Object>();
		queryParameters.add(signLocale.name());
		for (SignId signId : signItemMap.keySet()) {
			String signIdCombined = signId.getUpperIdPart() + "&&" + signId.getLowerIdPart() + "&&"
					+ signId.getSignSource().name();
			queryParameters.add(signIdCombined);
		}

		Query signQuery = createQuery(queryBuilder.toString(), queryParameters.toArray());

		signQuery.forEachRow(new ResultSetConsumer() {
			@Override
			public void accept(ResultSet resultSet) throws SQLException {
				int signUpperIdPart = resultSet.getInt("idupper");
				String meaning = resultSet.getString("word");
				int width = resultSet.getInt("width");
				SignSource source = SignSource.valueOf(resultSet.getString("source"));
				SignId signId = new SignId(signUpperIdPart, meaning, signLocale, source);
				signItemMap.get(signId).setSignWidth(width);
			}
		});
	}

	private List<SignItem> hideOverwrittenSignPuddleSigns(List<SignItem> signList) {
		assert signList != null : "Precondition failed: signList != null";

		List<SignItem> result = new ArrayList<SignItem>();

		for (SignItem signItem : signList) {
			if (signItem.getLocalSign() != null) {
				signItem.getLocalSign().setPersistenceLocation(PersistenceLocation.GLOBAL_DICTIONARY);
			}
			if (signItem.getSignId().getSignSource().equals(SignSource.IMPORTED)) {
				SignId overwrittenSignId = new SignId(signItem.getSignId().getUpperIdPart(),
						signItem.getSignId().getLowerIdPart(), signItem.getSignId().getSignLocale(),
						SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS);
				SignItem overwrittenSignItem = new SignItem(overwrittenSignId, signItem.getSignWidth());

				// If imported sign is not overwritten by another sign add it
				if (!signList.contains(overwrittenSignItem)) {
					result.add(signItem);
				}
			} else {
				result.add(signItem);
			}
		}

		return result;
	}

	public SimpleSign getSign(final SignId signId) {
		assert existsItem(signId) : "Precondition failed: existsItem(signId)";

		final Query signQuery = createQuery(
				"SELECT * FROM " + SIGN_TABLE_NAME + " WHERE source = ? AND idupper = ? AND  word collate utf8_bin = ?",
				signId.getSignSource().name(), (int) signId.getUpperIdPart(), signId.getLowerIdPart());

		return signQuery.mapFirstRow(new ResultSetFunction<SimpleSign>() {
			@Override
			public SimpleSign apply(ResultSet resultSet) throws SQLException {
				SimpleSign result = parseSignQueryResultToSign(resultSet);
				result.setPersistenceLocation(PersistenceLocation.GLOBAL_DICTIONARY);

				assert result != null : "Postcondition failed: result != null";
				assert result.getSignId().equals(signId) : "Postcondition failed: result.getSignId().equals(signId)";
				return result;
			}

			@Override
			public void onError() {
				LOG.error("[GREPME] ResultSet closed: " + signQuery);
			}
		});
	}

	public boolean isSignDeleted(SimpleSign sign) {
		return 0 < createQuery(
				"SELECT COUNT(signupperid) FROM " + DELETEDSIGNS_TABLE_NAME
						+ " WHERE signupperid = ? AND word = ? AND language = ? AND source = ?",
				sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(), sign.getSignLocale().name(),
				sign.getSignId().getSignSource().name()).getNumberOfMatches();
	}

	public long getNewSignUpperId(SignLocale locale) {

		return (long) createQuery("SELECT MAX(idupper) AS upperID FROM " + SIGN_TABLE_NAME + " WHERE language = ?",
				locale.name()).getInt() + 1;
	}

	@Deprecated
	public void purgeTableSigns() {

		createQuery("DELETE FROM " + POSITIONED_SYMBOLS_TABLE_NAME).execute();

		createQuery("DELETE FROM " + SIGN_TABLE_NAME).execute();

	}

	protected int countItemsWithLocale(SignLocale signLocale) {
		assert signLocale != null : "Precondition failed: signLocale != null";

		return createQuery("SELECT count(*) FROM " + SIGN_TABLE_NAME + " WHERE language = ?", signLocale.name())
				.getNumberOfMatches();
	}

	private void historiciseSign(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";
		assert existsItem(signId) : "Precondition failed: existsItem(signId)";

		createQuery("INSERT INTO " + SIGN_HISTORY_TABLE_NAME
				+ " (idupper, word, owner, language, topic, details, width, mdtSignPuddle, revision, source, comment) "
				+ "SELECT s.idupper, s.word, s.owner, s.language, s.topic, s.details, s.width, s.mdtSignPuddle, s.revision, s.source, s.comment "
				+ "FROM " + SIGN_TABLE_NAME + " s WHERE source = ? AND idupper = ? AND  word collate utf8_bin = ?",
				signId.getSignSource().name(), signId.getUpperIdPart(), signId.getLowerIdPart()).execute();

		createQuery("INSERT INTO " + POSITIONED_SYMBOLS_HISTORY_TABLE_NAME
				+ " (signidupper, symbolid, x, y, z, signword, language, source, revision)  "
				+ "SELECT p.signidupper, p.symbolid, p.x, p.y, p.z, p.signword, p.language, p.source, s.revision FROM "
				+ POSITIONED_SYMBOLS_TABLE_NAME + " p " + "INNER JOIN " + SIGN_TABLE_NAME
				+ " s ON s.idupper = p.signidupper AND s.source = p.source AND s.word = p.signword AND p.language = s.language "
				+ "WHERE p.source = ? AND p.signidupper = ? AND  p.language = ? AND p.signword collate utf8_bin = ?",
				signId.getSignSource().name(), signId.getUpperIdPart(), signId.getSignLocale().name(),
				signId.getLowerIdPart()).execute();

	}

	private SignId parseSignIdQueryResultItem(Map<String, String> signIdQueryResultItem) {
		assert signIdQueryResultItem != null : "Precondition failed: signIdQueryResultItem != null";
		assert signIdQueryResultItem
				.containsKey("signupperid") : "Precondition failed: signIdQueryResultItem.containsKey(\"signupperid\")";
		assert signIdQueryResultItem
				.containsKey("word") : "Precondition failed: signIdQueryResultItem.containsKey(\"word\")";
		assert signIdQueryResultItem
				.containsKey("language") : "Precondition failed: signIdQueryResultItem.containsKey(\"language\")";

		String languageName = signIdQueryResultItem.get("language");
		SignLocale signLocale = SignLocale.valueOf(languageName);

		int signUpperIdPart = Integer.parseInt(signIdQueryResultItem.get("signupperid"));
		String meaning = signIdQueryResultItem.get("word");
		SignSource source = SignSource.valueOf(signIdQueryResultItem.get("source"));

		SignId signId = new SignId(signUpperIdPart, meaning, signLocale, source);

		return signId;
	}

	private SignItem parseSignItemQueryResultItem(ResultSet resultSet) throws SQLException {
		assert resultSet != null : "Precondition failed: signQueryResultItem != null";

		assert !resultSet.getString("word")
				.isEmpty() : "Precondition failed: Database should not contain empty ('') word. !resultSet.get('word').isEmpty()";

		String languageName = resultSet.getString("language");
		SignLocale signLocale = SignLocale.valueOf(languageName);

		int signUpperIdPart = resultSet.getInt("idupper");
		String meaning = resultSet.getString("word");
		int width = resultSet.getInt("width");
		SignSource source = SignSource.valueOf(resultSet.getString("source"));

		SignItem signItem = new SignItem(new SignId(signUpperIdPart, meaning, signLocale, source), width);
		signItem.setRevision(resultSet.getLong("revision"));

		return signItem;
	}

	private SimpleSign parseSignQueryResultToSign(ResultSet signQueryResultItem) throws SQLException {
		assert signQueryResultItem != null : "Precondition failed: signQueryResultItem != null";

		final SimpleSign sign;
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

		sign = new SimpleSign(new SignId(signUpperId, word, language, source), authorDB.getUser(author), language,
				modificationDate, comment);
		sign.setRevision(revision);

		Query symbolsQuery = createQuery("SELECT * FROM " + POSITIONED_SYMBOLS_TABLE_NAME
				+ " ps, symbols s WHERE ? = ps.signidupper AND ? = ps.signword AND ? = ps.language AND ? = ps.source AND s.id = ps.symbolid",
				signUpperId, word, language.name(), source.name());

		symbolsQuery.forEachRow(new ResultSetConsumer() {
			@Override
			public void accept(ResultSet resultSet) throws SQLException {
				int x = resultSet.getInt("x");
				int y = resultSet.getInt("y");
				int z = resultSet.getInt("z");

				int category = resultSet.getInt("category");
				int group = resultSet.getInt("sgroup");
				int symbol = resultSet.getInt("symbol");
				int variation = resultSet.getInt("variation");
				int fill = resultSet.getInt("fill");
				int rotation = resultSet.getInt("rotation");

				Symbol iswaSymbol = symbolFactory.createSymbol(category, group, symbol, variation, fill, rotation);
				PositionedSymbol positionedSymbol;
				if (SymbolCategoryAnalyzer.isFingerAlphabetSymbol(iswaSymbol)) {
					positionedSymbol = new PositionedFingerAlphabetSymbol(
							FingerAlphabet.getFingerAlphabetSymbolFor(iswaSymbol), x, y, z);
					sign.addSymbol(positionedSymbol);
				} else {
					positionedSymbol = new PositionedSymbol(iswaSymbol, x, y, z);
					sign.addSymbol(positionedSymbol);
				}
			}
		});
		return sign;
	}

	public Map<String, List<SignItem>> findSigns(List<Pair<String, SignLocale>> wordsWithSignLocale) {
		Map<String, List<SignItem>> result = new HashMap<>();
		for (Pair<String, SignLocale> wordWithLocale : wordsWithSignLocale) {
			if (result.containsKey(wordWithLocale.getA())) {
				// Necessary for signs with same name but different locales (for
				// example: "name" in dgs, "name" in asl, "name" in bsl).
				result.get(wordWithLocale.getA()).addAll(findSigns(wordWithLocale.getA(), wordWithLocale.getB()));
			} else {
				result.put(wordWithLocale.getA(), findSigns(wordWithLocale.getA(), wordWithLocale.getB()));
			}
		}
		return result;
	}

	public Map<String, List<SignItem>> findSigns(SignLocale locale, List<String> wordList) {
		assert wordList != null : "wordList != null";

		final Map<String, List<SignItem>> result = new HashMap<String, List<SignItem>>();

		List<String> arguments = new ArrayList<String>();
		arguments.add(locale.name());
		for (String word : wordList) {
			arguments.add(word.toLowerCase());
		}

		String parameter = new String(new char[wordList.size()]).replace("\0", ",?").substring(1);
		Query signQuery = createQuery("SELECT idupper, word, width, language, revision, source " + //
				"FROM " + SIGN_TABLE_NAME + " AS s " + //
				"WHERE " + //
				"	s.language = ?" + //
				"	AND LOWER(s.word) collate utf8_bin in (" + parameter + ")" + //
				"	AND (idupper, LOWER(word), language, source) " + //
				"	NOT IN " + //
				"		(SELECT " + //
				"			d.signupperid, LOWER(d.word), d.language, d.source " + //
				"			FROM " + //
				"			" + DELETEDSIGNS_TABLE_NAME + " AS d ) " + //
				"ORDER BY LOWER(s.word), s.idupper", arguments.toArray());

		signQuery.forEachRow(new ResultSetConsumer() {
			@Override
			public void accept(ResultSet resultSet) throws SQLException {
				SignItem signItem = parseSignItemQueryResultItem(resultSet);

				String word = resultSet.getString("word").toLowerCase();

				List<SignItem> signList = result.get(word);
				if (signList == null) {
					signList = new ArrayList<SignItem>();
					result.put(word, signList);
				}
				signList.add(signItem);
			}
		});

		for (Map.Entry<String, List<SignItem>> entry : result.entrySet()) {
			List<SignItem> list = entry.getValue();
			List<SignItem> hideOverwrittenSignPuddleSigns = hideOverwrittenSignPuddleSigns(list);
			result.put(entry.getKey(), hideOverwrittenSignPuddleSigns);
		}
		return result;
	}

	public SignSource findLatestSource(long upperIdPart, String lowerIdPart, SignLocale signLocale) {
		Query latestSourceQuery = createQuery(
				"SELECT source FROM " + SIGN_TABLE_NAME
						+ " WHERE word = ? AND idupper = ? AND language = ? ORDER BY mdtSignPuddle DESC",
				lowerIdPart, upperIdPart, signLocale.name());
		String sourceString = latestSourceQuery.getString();
		SignSource latestSource = SignSource.valueOf(sourceString);
		return latestSource;
	}

	public List<String> getAllSymbolIdsForSignItem(SignId signId) {

		return createQuery(
				"SELECT symbolid FROM " + POSITIONED_SYMBOLS_TABLE_NAME + " WHERE signidupper = ? AND signword = ?",
				signId.getUpperIdPart(), signId.getLowerIdPart()).mapRows(new ResultSetFunction<String>() {

					@Override
					public String apply(ResultSet resultSet) throws SQLException {
						return resultSet.getString("symbolid");
					}
				});

	}
}
