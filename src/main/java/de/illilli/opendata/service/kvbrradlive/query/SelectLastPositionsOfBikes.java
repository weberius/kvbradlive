package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.opendata.service.TopLeftBottomRightFromString;

public class SelectLastPositionsOfBikes extends SelectBike {

	private int srid = 4326;

	public SelectLastPositionsOfBikes() throws SQLException, NamingException, IOException {

		queryString = "/selectLastPositionsOfBikes.sql";

		runSelect();
	}

	public SelectLastPositionsOfBikes(String bbox) throws SQLException, NamingException, IOException {

		queryString = "/selectLastPositionsOfBikesByBoudingBox.sql";

		TopLeftBottomRightFromString tlbr = new TopLeftBottomRightFromString(bbox);
		Object[] params = new Object[] { tlbr.getTopx(), tlbr.getTopy(), tlbr.getBottomx(), tlbr.getBottomy(),
				this.srid };

		runSelect(params);
	}

}
