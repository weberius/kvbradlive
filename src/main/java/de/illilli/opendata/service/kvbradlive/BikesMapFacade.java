package de.illilli.opendata.service.kvbradlive;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.kvbrradlive.query.SelectBike;

public class BikesMapFacade implements Facade {

	private static final Logger logger = Logger.getLogger(BikesMapFacade.class);

	private List<BikeBo> bikeList;
	Map<Integer, List<BikeBo>> bikesMap;
	final static String DATE_FORMAT = "dd.MM.yyyy hh:mm";

	public BikesMapFacade(SelectBike selectBike) {
		this.bikeList = selectBike.getBikeBoList();
		setBikesMap();
	}

	public BikesMapFacade(List<BikeBo> bikeList) {
		this.bikeList = bikeList;
		setBikesMap();
	}

	void setBikesMap() {
		Bikes bikes = new Bikes(this.bikeList);
		bikesMap = bikes.getBikeMap();
		logger.info("number of bikes in bikesMap: " + bikesMap.size());
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new Gson().toJson(bikesMap);
	}

}
