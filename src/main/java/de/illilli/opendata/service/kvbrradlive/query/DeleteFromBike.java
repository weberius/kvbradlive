package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

public class DeleteFromBike extends Delete {

	public DeleteFromBike() throws SQLException, NamingException, IOException {
		queryString = "/deleteFromBike.sql";
		update(new Object[] {});
	}
}
