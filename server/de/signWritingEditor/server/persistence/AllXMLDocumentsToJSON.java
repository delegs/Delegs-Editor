package de.signWritingEditor.server.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.signWritingEditor.shared.infrastructure.migration.DocumentMetaDaten;
import de.signWritingEditor.shared.infrastructure.migration.Tupel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.User;

public class AllXMLDocumentsToJSON {

	private static final Logger LOG = Logger.getLogger(AllXMLDocumentsToJSON.class);

	private DocumentDb documentDb;
	private DocumentXMLConverter XMLconverter;
	private DocumentJSONConverter JSONconverter;
	private User systemUser;
	private UserDb authorDB;

	public AllXMLDocumentsToJSON(DocumentDb documentDb, DocumentXMLConverter xmlConverter, UserDb userdb,
			DocumentJSONConverter jsonConverter) {

		this.authorDB = userdb;
		this.documentDb = documentDb;
		this.XMLconverter = xmlConverter;
		this.JSONconverter = jsonConverter;

		systemUser = authorDB.getUser("delegs");
	}

	public boolean transformAllDbEntries() {
		boolean hasCorruptDocuments = false;

		try {
			List<Tupel<String, DocumentMetaDaten>> documents = documentDb.getAllDocuments();

			int documentCount = documentDb.getDocumentCount();
			if (documents.size() != documentCount) {
				LOG.warn("The Count of Documents in Db and Documents loaded from DB aren't a match");
				throw new RuntimeException();
			}

			List<Tupel<Document, DocumentMetaDaten>> listOfDocuments = new ArrayList<Tupel<Document, DocumentMetaDaten>>();

			LOG.info("Transforming XML to Documents");
			int percent = 0;

			for (int i = 0; i < documentCount;) {
				Tupel<String, DocumentMetaDaten> document = documents.get(i);
				try {
					listOfDocuments.add(new Tupel<Document, DocumentMetaDaten>(
							XMLconverter.fromXML(document.content, systemUser), document.data));
				} catch (AssertionError e) {
					hasCorruptDocuments = true;
				}
				++i;
				int newPercent = i * 100 / documentCount;
				if (newPercent != percent) {
					percent = newPercent;
					LOG.info(percent + "%");
				}
			}

			// listOfDocuments enthält nicht die korrupten XML-Dokumente,
			// deswegen ist documentCount jetzt ggf. kleiner
			documentCount = listOfDocuments.size();

			LOG.info("Transforming Documents to JSON");
			percent = 0;

			for (int i = 0; i < documentCount;) {
				final Tupel<Document, DocumentMetaDaten> document = listOfDocuments.get(i);
				if (document.content != null)
					documentDb.updateDocument(document.data.getId(), new FileTitle(document.data.getTitle()),
							JSONconverter.toJson(document.content), document.data.getAuthor(),
							document.data.getColor());

				++i;

				int newPercent = i * 100 / documentCount;
				if (newPercent != percent) {
					percent = newPercent;
					LOG.info(percent + "%");
				}
			}
		} catch (Exception e) {
			LOG.error(e);
			throw new RuntimeException(e);
		}

		return hasCorruptDocuments;
	}
}
