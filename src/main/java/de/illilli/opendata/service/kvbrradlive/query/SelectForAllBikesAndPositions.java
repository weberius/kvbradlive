package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

public class SelectForAllBikesAndPositions extends SelectBike {

	public SelectForAllBikesAndPositions() throws SQLException,
			NamingException, IOException {

		queryString = "/selectForAllBikesAndPositions.sql";
		runSelect();
	}
}
