package de.illilli.opendata.service.kvbradpositions;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.opendata.service.kvbradlive.BikeBo;

public class SelectBikeRecord extends SelectBike {

	BikeBo bikeBo;

	public SelectBikeRecord(Integer number) throws SQLException,
			NamingException, IOException {

		queryString = "/selectBikeRecord.sql";
		runSelect(number);
	}
}
