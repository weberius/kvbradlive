package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.NamingException;

/**
 * Diese Klasse fragt die Datenbank nach Fahrradpositionen ab, die aktueller
 * sind, als der übergebene Zeitstempel (modtime).
 */
public class SelectAllBikesAndPositionsNewerThanModtime extends SelectBike {

	public SelectAllBikesAndPositionsNewerThanModtime(long time)
			throws SQLException, NamingException, IOException {

		queryString = "/selectBikesAndPositionsNewerThanModtime.sql";
		Timestamp modtime = new Timestamp(time);
		runSelect(modtime);
	}
}
