package de.signWritingEditor.server.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class SignBookDB extends MaterialDB {

	private static final Logger LOG = Logger.getLogger(SignBookDB.class);

	public SignBookDB(DbConnector connector) {
		super(connector);
		assert connector != null : "Precondition failed: connector != null";
	}

	public Map<String, String> getAllLocalizedAppDescriptions() {
		Map<String, String> result = new HashMap<String, String>();
		List<List<String>> results = new ArrayList<List<String>>();

		Query query = createQuery("SELECT LANGUAGE, DESCRIPTION FROM localizedappdescriptions");

		results = query.mapRows(new ResultSetFunction<List<String>>() {

			@Override
			public List<String> apply(ResultSet resultSet) throws SQLException {
				String language = resultSet.getString("LANGUAGE");
				String description = resultSet.getString("DESCRIPTION");

				List<String> result = new ArrayList<String>();
				result.add(language);
				result.add(description);

				return result;
			}
		});

		for (List<String> i : results) {
			result.put(i.get(0), i.get(1));
		}

		return result;
	}

	public int getDatabaseVersion() {
		int result = -1;

		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			connection = connector.getConnection();
			statement = connection.prepareStatement("SELECT version FROM databaserevision",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.execute();
			resultSet = statement.getResultSet();
			resultSet.next();

			result = resultSet.getInt(1);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed())
					resultSet.close();
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
		}

		return result;
	}

}
