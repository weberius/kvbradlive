package de.illilli.opendata.service.kvbradlive;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Diese Klasse gruppiert alle Bikes in einer Map anhand der Bike-Number. Der
 * value ist eine Liste aus Bike-Positionen. Dabei kommt keine Bike-Position
 * doppelt vor.
 *
 */
public class Bikes {

	private Map<Integer, List<BikeBo>> bikeMap;

	public Bikes(List<BikeBo> bikeList) {

		bikeMap = new Hashtable<Integer, List<BikeBo>>();
		String keyBefore = "";
		Integer numberBefore = 0;
		Integer counter = 1;
		List<BikeBo> bikeBoList = new ArrayList<BikeBo>();

		for (BikeBo bikeBo : bikeList) {

			Integer bikeNumber = bikeBo.number;
			String bikeKey = bikeBo.number + ";" + bikeBo.lng + ";"
					+ bikeBo.lat;
			boolean addToMap = false;

			if (numberBefore.equals(bikeNumber)) {
				// gleiches Bike, anderer Standort
				if (!keyBefore.equals(bikeKey)) {
					bikeBoList.add(bikeBo);
					keyBefore = bikeKey;
					addToMap = true;
				} else {
					if (counter == bikeList.size()) {
						addToMap = true;
					}
				}
			} else {
				// put
				bikeMap.put(bikeNumber, bikeBoList);
				// new Bike
				bikeBoList = new ArrayList<BikeBo>();
				bikeBoList.add(bikeBo);
				keyBefore = bikeKey;
				numberBefore = bikeNumber;
			}
			if (addToMap) {
				bikeMap.put(bikeNumber, bikeBoList);
			}
			counter++;
		}
	}

	public Map<Integer, List<BikeBo>> getBikeMap() {
		return bikeMap;
	}

}
