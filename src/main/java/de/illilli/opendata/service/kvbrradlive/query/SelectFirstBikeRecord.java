package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.opendata.service.kvbradlive.BikeBo;

public class SelectFirstBikeRecord extends SelectBike {

	BikeBo bikeBo;

	public SelectFirstBikeRecord() throws SQLException, NamingException,
			IOException {

		queryString = "/selectFirstBikeRow.sql";
		runSelect();
	}
}
