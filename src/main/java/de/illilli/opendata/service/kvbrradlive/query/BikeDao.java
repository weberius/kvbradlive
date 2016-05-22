package de.illilli.opendata.service.kvbrradlive.query;

import de.illilli.opendata.service.kvbradlive.BikeBo;

public class BikeDao {

	BikeBo bikeBo;

	public BikeDao(BikeFromDb bikeFromDb) {
		bikeBo = new BikeBo();
		bikeBo.setNumber(bikeFromDb.number);
		bikeBo.setName(bikeFromDb.name);
		bikeBo.setLat(bikeFromDb.getLat());
		bikeBo.setLng(bikeFromDb.getLng());
		bikeBo.setBike(bikeFromDb.bike);
		bikeBo.setTimestamp(bikeFromDb.modtime);
		bikeBo.setUid(bikeFromDb.uid);
	}

	public BikeBo getBikeBo() {
		return bikeBo;
	}

}
