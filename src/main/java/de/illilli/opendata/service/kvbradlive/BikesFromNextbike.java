package de.illilli.opendata.service.kvbradlive;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 * Diese Klasse 'durchkämmt' den Datensatz von nextbike und extrahiert alle
 * Fahrrad-Informationen. Diese werden in einer Liste gesammelt und stehen dann
 * zur weiteren Verarbeitung zur Verfügung. Dabei sind zwei Informationen zu
 * unterscheiden:
 * <ul>
 * <li>Informationen von Places; hier können mehrere Fahrräder verzeichnet sein.
 * </li>
 * <li>Informationen von Bikes; hier ist jeweils nur ein Fahrrad verzeichnet.
 * </li>
 * </ul>
 * 
 * @author wolfram
 *
 */
public class BikesFromNextbike {

	private static final Logger logger = Logger.getLogger(BikesFromNextbike.class);

	public static final String delim = ",";

	private List<BikeBo> bikeBoList = new ArrayList<BikeBo>();

	public BikesFromNextbike(Markers markers) {

		List<Country> countryList = markers.country;

		for (Country country : countryList) {

			if (country.city == null) {
				logger.info("no city found for: " + country.toString());
			} else {

				List<City> cityList = country.city;

				for (City city : cityList) {

					List<Place> placeList = city.place;
					for (Place place : placeList) {

						String bike_numbers = place.bike_numbers;
						if (bike_numbers != null && !"0".equals(place.bikes)) {
							StringTokenizer bikesSt = new StringTokenizer(bike_numbers, delim);
							List<Integer> bikeNumberList = new ArrayList<Integer>();

							while (bikesSt.hasMoreElements()) {
								int bikeNumber = Integer.parseInt(bikesSt.nextToken());
								bikeNumberList.add(bikeNumber);
								BikeBo bikeBo = new BikeBo();
								bikeBo.uid = place.uid;
								bikeBo.bike = place.bike;
								bikeBo.name = place.name;
								bikeBo.number = bikeNumber;
								bikeBo.lat = place.lat;
								bikeBo.lng = place.lng;
								bikeBoList.add(bikeBo);
							}
						}
					}
				} // end for City
			} // end else
		} // end for Country
	}

	public List<BikeBo> getBikeBoList() {
		return bikeBoList;
	}

}
