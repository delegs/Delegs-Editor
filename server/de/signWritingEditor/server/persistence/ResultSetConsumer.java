package de.signWritingEditor.server.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetConsumer {
	void accept(ResultSet resultSet) throws SQLException;
}
