package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.opendata.service.kvbradlive.BikeBo;

public class SelectForBikeAndLastPosition extends SelectBike {

	BikeBo bikeBo;

	public SelectForBikeAndLastPosition(Integer number) throws SQLException,
			NamingException, IOException {

		queryString = "/selectForBikeAndLastPosition.sql";
		runSelect(number);
	}
}
