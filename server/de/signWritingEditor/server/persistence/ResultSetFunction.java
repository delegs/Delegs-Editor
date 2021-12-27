package de.signWritingEditor.server.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ResultSetFunction<R> {
	public abstract R apply(ResultSet resultSet) throws SQLException;

	public void onError() {
	}
}
