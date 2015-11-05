package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.kvbrradlive.query.SelectBike;

/**
 * This Facade returns GeoJson LineString for a List of
 *
 */
public class BikesDataFacade implements Facade {

	private List<BikeBo> bikeList;

	public BikesDataFacade(SelectBike selectBike) throws SQLException,
			NamingException, IOException {
		bikeList = selectBike.getBikeBoList();
	}

	public BikesDataFacade(List<BikeBo> bikeList) throws SQLException,
			NamingException, IOException {
		this.bikeList = bikeList;
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new Gson().toJson(bikeList);
	}

}
