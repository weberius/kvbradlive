package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * Just one Bike, but all positions.
 */
public class SelectForBikeAndPositions extends SelectBike {

	public SelectForBikeAndPositions(Integer number) throws SQLException,
			NamingException, IOException {

		queryString = "/selectForBikeAndPositions.sql";
		runSelect(number);
	}
}
