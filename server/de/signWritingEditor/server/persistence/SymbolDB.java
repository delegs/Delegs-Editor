package de.signWritingEditor.server.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolDB extends MaterialDB {

	/**
	 * Constructor.
	 * 
	 * @param connector
	 * @require connector != null
	 */
	public SymbolDB(DbConnector connector) {
		super(connector);
		assert connector != null : "connector != null";
	}

	public List<Map<String, String>> getAllSymbols() {
		Query query = createQuery(
				"SELECT CATEGORY, SGROUP, SYMBOL, VARIATION, FILL, ROTATION, width, height FROM symbols");

		return query.mapRows(new ResultSetFunction<Map<String, String>>() {

			@Override
			public Map<String, String> apply(ResultSet resultSet) throws SQLException {
				Map<String, String> symbolValue = new HashMap<String, String>();

				symbolValue.put("CATEGORY", resultSet.getString("CATEGORY"));
				symbolValue.put("SGROUP", resultSet.getString("SGROUP"));
				symbolValue.put("SYMBOL", resultSet.getString("SYMBOL"));
				symbolValue.put("VARIATION", resultSet.getString("VARIATION"));
				symbolValue.put("FILL", resultSet.getString("FILL"));
				symbolValue.put("ROTATION", resultSet.getString("ROTATION"));
				symbolValue.put("width", resultSet.getString("width"));
				symbolValue.put("height", resultSet.getString("height"));

				return symbolValue;
			}
		});

	}

	/**
	 * @return all base symbols
	 */
	public List<Map<String, String>> getAllBaseSymbols() {
		Query query = createQuery(
				"SELECT DISTINCT CATEGORY, SGROUP, SYMBOL, VARIATION, MIN(FILL) AS FILL, MIN(ROTATION) AS ROTATION FROM symbols "
						+ "GROUP BY CATEGORY, SGROUP, SYMBOL, VARIATION ORDER BY CATEGORY, SGROUP, SYMBOL, VARIATION");

		return query.mapRows(new ResultSetFunction<Map<String, String>>() {

			@Override
			public Map<String, String> apply(ResultSet resultSet) throws SQLException {
				Map<String, String> symbolValue = new HashMap<String, String>();

				symbolValue.put("CATEGORY", resultSet.getString("CATEGORY"));
				symbolValue.put("SGROUP", resultSet.getString("SGROUP"));
				symbolValue.put("SYMBOL", resultSet.getString("SYMBOL"));
				symbolValue.put("VARIATION", resultSet.getString("VARIATION"));
				symbolValue.put("FILL", resultSet.getString("FILL"));
				symbolValue.put("ROTATION", resultSet.getString("ROTATION"));

				return symbolValue;
			}
		});
	}
}
