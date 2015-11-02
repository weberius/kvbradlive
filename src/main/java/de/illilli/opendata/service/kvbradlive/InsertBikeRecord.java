package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import de.illilli.jdbc.ConnectionFactory;

public class InsertBikeRecord {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(InsertBikeRecord.class);

	private int inserts;

	public InsertBikeRecord(BikeBo bo) throws IOException, SQLException,
			NamingException {
		Connection conn = ConnectionFactory.getConnection();
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/insertBikeRecord.sql");
		String sql = IOUtils.toString(inputStream);

		QueryRunner run = new QueryRunner();
		// uid,name,bike,number
		inserts = run.update(conn, sql, bo.uid, bo.name, bo.bike, bo.number,
				bo.lat, bo.lng);

		conn.close();
	}

	public int getInserts() {
		return inserts;
	}

}
