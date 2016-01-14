package de.illilli.opendata.service.kvbradlive;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.kvbrradlive.query.SelectBike;

public class BikesListFacade implements Facade {

	private List<BikeBo> bikeList;

	public BikesListFacade(SelectBike selectBike) {
		bikeList = selectBike.getBikeBoList();
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new Gson().toJson(bikeList);
	}

}
