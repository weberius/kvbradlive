package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.NamingException;

/**
 * Diese Abfrage gegen die Datenbank
 */
public class SelectAllBikesAndPositionsDependsOnModtime extends SelectBike {

	public SelectAllBikesAndPositionsDependsOnModtime(Timestamp modtime)
			throws SQLException, NamingException, IOException {

		queryString = "/selectAllBikesAndPositionsDependsOnModtime.sql";
		runSelect(modtime);
	}
}
