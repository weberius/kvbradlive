package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

public class SelectAllBikesAndPositionsDependsOnModtime extends SelectBike {

	public SelectAllBikesAndPositionsDependsOnModtime() throws SQLException,
			NamingException, IOException {

		queryString = "/selectAllBikesAndPositionsDependsOnModtime.sql";
		runSelect();
	}
}
