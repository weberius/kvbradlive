package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.ConnectionFactory;

public abstract class Delete {

	String queryString;
	private int updated = 0;

	void update(Object... params) throws SQLException, NamingException, IOException {

		Connection conn = ConnectionFactory.getConnection();
		InputStream inputStream = this.getClass().getResourceAsStream(queryString);
		String sql = IOUtils.toString(inputStream);

		QueryRunner query = new QueryRunner();
		updated = query.update(conn, sql, params);
		conn.commit();
		conn.close();
	}

	public int getUpdated() {
		return updated;
	}
}
