package de.illilli.opendata.service.kvbradpositions;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

public class SelectBikeLastInserted extends SelectBike {

	public SelectBikeLastInserted(Integer number) throws SQLException,
			NamingException, IOException {

		queryString = "/selectBikeLastInsertedRecord.sql";
		runSelect(number);
	}
}
