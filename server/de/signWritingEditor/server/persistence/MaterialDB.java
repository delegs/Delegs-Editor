package de.signWritingEditor.server.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class MaterialDB {

	private static final Logger LOG = Logger.getLogger(MaterialDB.class);

	protected final DbConnector connector;

	/**
	 * Constructor.
	 * 
	 * @param connector
	 * @require connector != null
	 */
	protected MaterialDB(DbConnector connector) {
		assert connector != null : "connector != null";
		this.connector = connector;
	}

	/**
	 * Delete the entry referenced by the given id from the table with given
	 * table name.
	 * 
	 * @param id The id of the entry to delete.
	 * @param tableName The name of the table where to delete the entry.
	 * @param primaryKeyColumnName Name of the column used to look for the id.
	 * 
	 * @return Statement whether the deletion was successful.
	 * 
	 * @require id != null
	 * @require tableName != null
	 * @require exists(id, tableName, primaryKeyColumnName)
	 * @ensure !exits(id, tableName, primaryKeyColumnName)
	 */
	protected boolean delete(String id, String tableName, String primaryKeyColumnName) {
		assert id != null : "id != null";
		assert tableName != null : "tableName != null";
		assert exists(id, tableName, primaryKeyColumnName) : "exists(id, tableName, primaryKeyColumnName)";

		return createQuery("DELETE FROM " + tableName + " WHERE " + primaryKeyColumnName + " = ?", id).execute();
	}

	/**
	 * Return a list of all ids of the table with given name.
	 * 
	 * @param tableName The name of the table for which to return all ids.
	 * @param primaryKeyColumnName Name of the column used as id.
	 * 
	 * @return List of all ids of a table.
	 * 
	 * @require tableName != null
	 * @require primaryKeyColumnName != null
	 * @ensure result != null
	 */
	protected List<String> getAllIds(String tableName, final String primaryKeyColumnName) {
		assert tableName != null : "tableName != null";
		assert primaryKeyColumnName != null : "primaryKeyColumnName != null";

		Query query = createQuery("SELECT " + primaryKeyColumnName + " FROM " + tableName);
		return query.mapRows(new ResultSetFunction<String>() {
			@Override
			public String apply(ResultSet resultSet) throws SQLException {
				return resultSet.getString(primaryKeyColumnName);
			}
		});
	}

	/**
	 * Returns the total number of entries of the table with given name.
	 * 
	 * @param The name of the table for which to return the number of entries.
	 * 
	 * @return Total number of entries of the table.
	 * 
	 * @require tableName != null
	 * @ensure result >= 0
	 */
	protected int getNumberOfEntries(String tableName) {
		return createQuery("SELECT COUNT(0) FROM " + tableName).getNumberOfMatches();
	}

	/**
	 * Return whether there exists an entry with given id within the table with
	 * given name. The id will be searched within the column with specified by
	 * the primary key column name.
	 * 
	 * @param id The id to look for.
	 * @param table Table in which to look for.
	 * @param primaryKeyColumnName Name of the column used to look for the id.
	 * 
	 * @return Statement whether there exists an entry in the given table with
	 * given id.
	 * 
	 * @require id != null
	 * @require table != null
	 * @require primaryKeyColumnName != null
	 */
	protected boolean exists(String id, String table, String primaryKeyColumnName) {
		assert id != null : "id != null";
		assert table != null : "table != null";
		assert primaryKeyColumnName != null : "primaryKeyColumnName != null";

		Query query = createQuery(
				"SELECT COUNT(" + primaryKeyColumnName + ") FROM " + table + " WHERE " + primaryKeyColumnName + " = ?",
				id);
		return query.getNumberOfMatches() > 0;
	}

	protected Query createQuery(String sql, Object... args) {
		assert sql != null : "sql != null";
		return new Query(sql, args);
	}

	protected class Query {
		private final String query;
		private final Object[] args;

		public Query(String query, Object... args) {
			this.query = query;
			this.args = args;
		}

		private <R> R managedExecute(Connection connection, R errorValue, ResultSetFunction<R> processor) {
			try (PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY)) {
				if (args != null && args.length > 0) {
					int index = 1;
					for (Object arg : args) {
						statement.setObject(index, arg);
						index++;
					}
				}
				statement.execute();
				try (ResultSet resultSet = statement.getResultSet()) {
					return processor.apply(resultSet);
				}
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
				return errorValue;
			}
		}

		/**
		 * This method is meant to be executed within a transaction. Remember to
		 * use try-with-resources to ensure the connection is closed correctly.
		 */
		public boolean execute(Connection connection) {
			return managedExecute(connection, false, new ResultSetFunction<Boolean>() {
				@Override
				public Boolean apply(ResultSet resultSet) throws SQLException {
					return true;
				}
			});
		}

		/**
		 * This method is meant to be executed within a transaction. Remember to
		 * use try-with-resources to ensure the connection is closed correctly.
		 * 
		 * Convenience method for SQL COUNT statements to make client code more
		 * explicit.
		 */
		public int getNumberOfMatches(Connection connection) {
			return managedExecute(connection, 0, new ResultSetFunction<Integer>() {
				@Override
				public Integer apply(ResultSet resultSet) throws SQLException {
					resultSet.next();
					return resultSet.getInt(1);
				}
			});
		}

		private <R> R managedExecute(R errorValue, ResultSetFunction<R> processor) {
			try (Connection connection = connector.getConnection()) {
				return managedExecute(connection, errorValue, processor);
			} catch (SQLException connectionException) {
				LOG.error(connectionException.getMessage(), connectionException);
				return errorValue;
			}
		}

		public boolean execute() {
			return managedExecute(false, new ResultSetFunction<Boolean>() {
				@Override
				public Boolean apply(ResultSet resultSet) throws SQLException {
					return true;
				}
			});
		}

		public String getString() {
			return managedExecute(null, new ResultSetFunction<String>() {
				@Override
				public String apply(ResultSet resultSet) throws SQLException {
					resultSet.next();
					return resultSet.getString(1);
				}
			});
		}

		/**
		 * Convenience method for SQL COUNT statements to make client code more
		 * explicit.
		 */
		public int getNumberOfMatches() {
			return getInt();
		}

		public int getInt() {
			return managedExecute(0, new ResultSetFunction<Integer>() {
				@Override
				public Integer apply(ResultSet resultSet) throws SQLException {
					resultSet.next();
					return resultSet.getInt(1);
				}
			});
		}

		public Boolean getBoolean() {
			return managedExecute(null, new ResultSetFunction<Boolean>() {
				@Override
				public Boolean apply(ResultSet resultSet) throws SQLException {
					resultSet.next();
					return resultSet.getBoolean(1);
				}
			});
		}

		public final <R> List<R> mapRows(final ResultSetFunction<R> function) {
			return managedExecute(Collections.<R>emptyList(), new ResultSetFunction<List<R>>() {
				@Override
				public List<R> apply(ResultSet resultSet) throws SQLException {
					List<R> result = new ArrayList<R>();
					while (resultSet.next()) {
						result.add(function.apply(resultSet));
					}
					return result;
				}
			});
		}

		public final <R> R mapFirstRow(final ResultSetFunction<R> function) {
			return managedExecute(null, new ResultSetFunction<R>() {
				@Override
				public R apply(ResultSet resultSet) throws SQLException {
					boolean next = resultSet.next();
					if (next) {
						return function.apply(resultSet);
					} else {
						function.onError();
						return null;
					}
				}
			});
		}

		public void forEachRow(final ResultSetConsumer consumer) {
			managedExecute(null, new ResultSetFunction<Void>() {
				@Override
				public Void apply(ResultSet resultSet) throws SQLException {
					while (resultSet.next()) {
						consumer.accept(resultSet);
					}
					return null;
				}
			});
		}

		@Override
		public String toString() {
			return "Query [query=" + query + ", args=" + Arrays.toString(args) + "]";
		}
	}
}
