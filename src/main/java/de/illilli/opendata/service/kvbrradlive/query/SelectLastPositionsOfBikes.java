package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

public class SelectLastPositionsOfBikes extends SelectBike {

	public SelectLastPositionsOfBikes() throws SQLException, NamingException, IOException {
		queryString = "/selectLastPositionsOfBikes.sql";
		runSelect();
	}

}
