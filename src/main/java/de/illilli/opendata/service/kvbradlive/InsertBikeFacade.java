package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.kvbradpositions.SelectBike;
import de.illilli.opendata.service.kvbradpositions.SelectBikeLastInserted;

/**
 * Diese Facade sammelt Informationen, um sie danach in die Datenbank zu
 * schreiben:
 * <ol>
 * <li>Ask For Next Bike Life Data</li>
 * <li>Get the Bikes from Data</li>
 * <li>Insert Bikes to DB</li>
 * </ol>
 */
public class InsertBikeFacade {

	private static final Logger logger = Logger
			.getLogger(InsertBikeFacade.class);

	public InsertBikeFacade() throws JsonParseException, JsonMappingException,
			IOException, SQLException, NamingException {
	}

	public int insert() throws JsonParseException, JsonMappingException,
			IOException, SQLException, NamingException {

		// just for reporting
		int countInsertedBikes = 0;
		int countBikes = 0;
		// 1. AskForNextBikeLife
		logger.info("1. AskForNextBikeLife");
		Markers markers = new AskForNextBikeLife().getMarkers();
		// 2. Get the Bikes
		logger.info("2. Get the Bikes");
		List<BikeBo> bikeBoList = new BikesFromNextbike(markers)
				.getBikeBoList();
		// 3. Insert Bikes to DB
		logger.info("3. Insert Bikes to DB");
		long before = System.currentTimeMillis();
		for (BikeBo bo : bikeBoList) {
			// check for existing bike before inserting
			SelectBike selectBike = new SelectBikeLastInserted(bo.getNumber());
			boolean insertBike = false;

			if (selectBike.getBikeBoList().isEmpty()) {
				// there is no bike with this number; insert
				insertBike = true;
				StringBuilder sb = new StringBuilder();
				sb.append("add '");
				sb.append(bo.getNumber() + " ");
				sb.append("' ");
				sb.append("[");
				sb.append(bo.getLat());
				sb.append(",");
				sb.append(bo.getLng());
				sb.append("]");
				sb.append("; insertBike=‘" + insertBike + "‘");
				if (insertBike) {
					logger.debug(sb);
				}

			} else {
				boolean isSameLat = selectBike.getBikeBoList().get(0).getLat() == bo
						.getLat();
				boolean isSameLng = selectBike.getBikeBoList().get(0).getLng() == bo
						.getLng();
				// if the position is different to the previous insert; else
				// don't!
				insertBike = !isSameLat || !isSameLng;

				StringBuilder sb = new StringBuilder();
				sb.append("add '");
				sb.append(bo.getNumber() + " ");
				sb.append("' ");
				sb.append("[");
				sb.append(selectBike.getBikeBoList().get(0).getLat());
				sb.append(",");
				sb.append(selectBike.getBikeBoList().get(0).getLng());
				sb.append("],[");
				sb.append(bo.getLat());
				sb.append(",");
				sb.append(bo.getLng());
				sb.append("]");
				sb.append("; insertBike=‘" + insertBike + "‘");
				if (insertBike) {
					logger.debug(sb);
				}
			}

			if (insertBike) {
				countInsertedBikes += new InsertBikeRecord(bo).getInserts();
			}
			countBikes++;
		}
		long after = System.currentTimeMillis();
		long duration = (after - before) / 1000;
		String msg = "'" + countInsertedBikes + "' bikes from '" + countBikes
				+ "' inserted in " + duration + " sec";
		logger.info(msg);

		return countInsertedBikes;
	}
}
