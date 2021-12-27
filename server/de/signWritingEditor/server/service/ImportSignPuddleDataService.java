package de.signWritingEditor.server.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jdom.JDOMException;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.ResultSetFunction;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class ImportSignPuddleDataService {
	private static final String SIGN_PUDDLE_EXPORT_URL = "http://www.signbank.org/SignPuddle2.0/data/spml/";

	private static final Logger LOG = Logger.getLogger(ImportSignPuddleDataService.class);

	public static void importData() {
		DbConnector connector = null;
		try {
			Date startDate = new Date();
			LOG.info("Starting SignPuddle import");

			ConfigurationService configurationService = new ConfigurationService();
			connector = new DbConnector(configurationService);
			UserDb authorDb = new UserDb(connector);
			SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
			SignDbExtended signDb = new SignDbExtended(connector, authorDb, symbolFactory, configurationService);
			SignImageCache signImageCache = new SignImageFileSystemCache(configurationService);

			Map<SignLocale, URL> signPuddleDictionaries = new HashMap<SignLocale, URL>();
			signPuddleDictionaries.put(SignLocale.ASL, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn4.spml"));
			signPuddleDictionaries.put(SignLocale.BSL, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn59.spml"));
			signPuddleDictionaries.put(SignLocale.DGS, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn53.spml"));
			signPuddleDictionaries.put(SignLocale.LIBRAS, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn46.spml"));
			signPuddleDictionaries.put(SignLocale.LSE, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn55.spml"));
			signPuddleDictionaries.put(SignLocale.LSFB, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn43.spml"));
			signPuddleDictionaries.put(SignLocale.LSF, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn58.spml"));
			signPuddleDictionaries.put(SignLocale.LSM, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn31.spml"));
			signPuddleDictionaries.put(SignLocale.LSQ, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn47.spml"));
			signPuddleDictionaries.put(SignLocale.PJM, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn19.spml"));
			signPuddleDictionaries.put(SignLocale.SZJ, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn74.spml"));
			signPuddleDictionaries.put(SignLocale.TSE, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn104.spml"));
			signPuddleDictionaries.put(SignLocale.DSGS, new URL(SIGN_PUDDLE_EXPORT_URL + "sgn48.spml"));

			for (Entry<SignLocale, URL> signPuddleDictionary : signPuddleDictionaries.entrySet()) {
				SignLocale signLocale = signPuddleDictionary.getKey();
				URL importUrl = signPuddleDictionary.getValue();
				try {
					LOG.info("Trying to import data for " + signLocale + " from signpuddle at " + importUrl);
					SignPuddleRepairStrategy repairStrategy;
					if (signLocale == SignLocale.DSGS) {
						repairStrategy = new RepairSwissWords();
					} else {
						repairStrategy = KeepEveryWordUnchanged.INSTANCE;
					}
					List<DictionaryEntry> importFromURL = importFromURL(importUrl, signLocale, symbolFactory,
							repairStrategy);
					updateDatabaseForSignLocale(signLocale, importFromURL, signDb, signImageCache);
				} catch (Exception e) {
					LOG.error("Could not import new signs for " + signLocale + " from signpuddle", e);
				}
			}

			long timeInSeconds = (new Date().getTime() - startDate.getTime()) / 1000;
			LOG.info("Import took " + timeInSeconds + " seconds.");
		} catch (Exception e) {
			LOG.error("Import failed", e);
		}
	}

	private static List<DictionaryEntry> importFromURL(URL url, SignLocale language, SymbolFactory symbolFactory,
			SignPuddleRepairStrategy repairStrategy) throws IOException, MalformedURLException, JDOMException {
		Date startDate = new Date();

		String puddleXmlString = IOUtils.toString(url.openConnection().getInputStream(), "UTF8");

		List<DictionaryEntry> result = new SignPuddleXmlParser(symbolFactory).parsePuddleXml(puddleXmlString, language,
				repairStrategy);

		long timeinSeconds = (new Date().getTime() - startDate.getTime()) / 1000;
		LOG.info(result.size() + " signs from " + url.toString() + " (" + language.name() + ") read in " + timeinSeconds
				+ " seconds.");

		return result;
	}

	private static void updateDatabaseForSignLocale(SignLocale signLocale, List<DictionaryEntry> allEntries,
			SignDbExtended signDb, SignImageCache signImageCache) throws Exception {
		assert signLocale != null : "Precondition failed: signLocale != null";
		assert allEntries != null : "Precondition failed: allEntries != null";
		assert signDb != null : "Precondition failed: signDb != null";

		Date startDate = new Date();

		removeModifiedOrDeletedSigns(signLocale, allEntries, signDb, signImageCache);
		insertNewOrModifiedSigns(signLocale, allEntries, signDb, signImageCache);

		long timeInSeconds = (new Date().getTime() - startDate.getTime()) / 1000;
		LOG.info("Locale " + signLocale.name() + " updated in " + timeInSeconds + " seconds.");
	}

	private static void removeModifiedOrDeletedSigns(SignLocale signLocale, List<DictionaryEntry> allEntries,
			SignDbExtended signDb, SignImageCache signImageCache) throws Exception {
		assert signLocale != null : "Precondition failed: signLocale != null";
		assert allEntries != null : "Precondition failed: allEntries != null";
		assert signDb != null : "Precondition failed: signDB != null";
		assert signImageCache != null : "Precondition failed: signImageCache != null";

		int modifiedSignCount = 0;
		int deletedSignCount = 0;

		// Map from upperIds in SignPuddle to ModificationDates
		Map<Long, Long> upperIdToModificationDateMapSignPuddle = ImportSignPuddleDataService
				.getUpperIdToModificationDateMap(allEntries);

		// Map from upperIds in DataBase to ModificationDates
		Map<Long, Long> upperIdsToModificationDatesInDatabase = signDb.getAllModificationDates(signLocale);

		// Delete signs that have been modified
		for (Long upperIdSignPuddle : upperIdToModificationDateMapSignPuddle.keySet()) {
			if (upperIdsToModificationDatesInDatabase.containsKey(upperIdSignPuddle)) {
				long modificationDateSignPuddle = upperIdToModificationDateMapSignPuddle.get(upperIdSignPuddle);
				long modificationDateDatabase = upperIdsToModificationDatesInDatabase.get(upperIdSignPuddle);
				if (modificationDateSignPuddle != modificationDateDatabase) {
					// delete all with upperId from DB
					List<SignId> signIdsToDelete = signDb.getSignIdsForUpperId(signLocale, upperIdSignPuddle);
					for (SignId signId : signIdsToDelete) {
						signDb.deleteSign(signId);

						if (signImageCache.containsSignImagesFor(signId)) {
							signImageCache.removeSignImagesFor(signId);
						}

						modifiedSignCount++;
					}
				}
			}
		}

		// Delete signs that have been removed from SignPuddle
		for (Long upperIdInDatabase : upperIdsToModificationDatesInDatabase.keySet()) {
			if (!upperIdToModificationDateMapSignPuddle.containsKey(upperIdInDatabase)) {
				// delete all with upperId from db
				List<SignId> signIdsToDelete = signDb.getSignIdsForUpperId(signLocale, upperIdInDatabase);
				for (SignId signId : signIdsToDelete) {
					signDb.deleteSign(signId);

					if (signImageCache.containsSignImagesFor(signId)) {
						signImageCache.removeSignImagesFor(signId);
					}

					deletedSignCount++;
				}
			}
		}

		LOG.info("Deleted signs for " + signLocale.name() + ": " + deletedSignCount);
		LOG.info("Modified signs for " + signLocale.name() + ": " + modifiedSignCount);
	}

	private static void insertNewOrModifiedSigns(SignLocale signLocale, List<DictionaryEntry> allEntriesFromSignPuddle,
			SignDbExtended signDb, SignImageCache signImageCache) throws Exception {
		int newSignsCount = 0;
		Map<Long, Long> allUpperIdsToModificationDates = signDb.getAllModificationDates(signLocale);

		List<DictionaryEntry> filteredList = SignPuddleEntryFilter.filter(allEntriesFromSignPuddle,
				SignPuddleEntryFilter.Filters.SIGNS_WITH_DELEGS_ORIGIN, true);

		for (DictionaryEntry dictionaryEntry : filteredList) {
			SimpleSign sign = dictionaryEntry.getSign();
			SignId signId = sign.getSignId();
			Long upperIdPart = Long.valueOf(signId.getUpperIdPart());

			if (!allUpperIdsToModificationDates.containsKey(upperIdPart)) {
				if (!signDb.existsItem(signId)) {
					signDb.saveSign(dictionaryEntry.getWord(), sign);

					if (signImageCache.containsSignImagesFor(signId)) {
						signImageCache.removeSignImagesFor(signId);
					}

					newSignsCount++;
				} else {
					// E.g. happens if SignPuddle-entry contains the same text
					// term twice
					LOG.debug("Saving sign failed, duplicate entry: " + signId + " for sign locale: "
							+ signLocale.name());
				}
			}
		}

		LOG.info("New or modified signs for " + signLocale.name() + ": " + newSignsCount);
	}

	private static Map<Long, Long> getUpperIdToModificationDateMap(List<DictionaryEntry> dictionaryEntries) {
		Map<Long, Long> result = new HashMap<Long, Long>();

		for (DictionaryEntry dictionaryEntry : dictionaryEntries) {
			SimpleSign sign = dictionaryEntry.getSign();
			Long upperId = sign.getSignId().getUpperIdPart();

			if (!result.containsKey(upperId)) {
				result.put(upperId, sign.getModificationDate().getTime());
			}
		}

		return result;
	}

	private static class SignDbExtended extends SignDB {

		public SignDbExtended(DbConnector connector, UserDb authorDB, SymbolFactory symbolFactory,
				ConfigurationService configurationService) {
			super(connector, authorDB, symbolFactory, configurationService);
		}

		public Map<Long, Long> getAllModificationDates(SignLocale signLocale) {
			assert signLocale != null : "Precondition failed: signLocale != null";

			Map<Long, Long> result = new HashMap<Long, Long>();

			Query query = createQuery("SELECT idupper, mdtSignPuddle FROM " + SignDB.SIGN_TABLE_NAME
					+ " WHERE language = ? AND source = ?", signLocale.name(), SignSource.IMPORTED.name());

			List<List<Long>> resultsInSets = new ArrayList<List<Long>>();

			resultsInSets = query.mapRows(new ResultSetFunction<List<Long>>() {

				@Override
				public List<Long> apply(ResultSet resultSet) throws SQLException {
					List<Long> result = new ArrayList<Long>();

					result.add(resultSet.getLong("idupper"));
					result.add(resultSet.getLong("mdtSignPuddle"));

					return result;
				}
			});

			for (List<Long> i : resultsInSets) {
				result.put(i.get(0), i.get(1));
			}

			return result;
		}

		public List<SignId> getSignIdsForUpperId(final SignLocale signLocale, Long upperId) {
			assert signLocale != null : "Precondition failed: signLocale != null";
			assert upperId != null : "Precondition failed: upperId != null";

			Query query = createQuery(
					"SELECT idupper, word FROM " + SignDB.SIGN_TABLE_NAME
							+ " WHERE language = ? AND idupper = ? AND source = ?",
					signLocale.name(), upperId, SignSource.IMPORTED.name());

			return query.mapRows(new ResultSetFunction<SignId>() {

				@Override
				public SignId apply(ResultSet resultSet) throws SQLException {
					long idUpper = resultSet.getLong("idupper");
					String word = resultSet.getString("word");
					return new SignId(idUpper, word, signLocale, SignSource.IMPORTED);
				}

			});

		}

		public static void main(String[] args) throws IOException {
			if (System.getProperty("user.dir").endsWith("war")) {
				importData();
			} else {
				System.err.println("Run import only in war directory! Check the run configuration!");
			}
		}
	}
}
