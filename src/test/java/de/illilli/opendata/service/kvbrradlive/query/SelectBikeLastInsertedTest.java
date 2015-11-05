package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.opendata.service.kvbradlive.BikeBo;
import de.illilli.opendata.service.kvbradlive.ConnectionFactory;
import de.illilli.opendata.service.kvbrradlive.query.SelectBikeLastInserted;
import de.illilli.opendata.service.kvbrradlive.query.SelectFirstBikeRecord;

public class SelectBikeLastInsertedTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException,
			NamingException, IOException {
		// define db-connection
		ConnectionFactory.setUpConnectionForJndi();
		SelectBike oneBike = new SelectFirstBikeRecord();
		List<BikeBo> listOneBike = oneBike.getBikeBoList();
		SelectBike bike = new SelectBikeLastInserted(listOneBike.get(0)
				.getNumber());
		List<BikeBo> listLastBike = bike.getBikeBoList();
		System.out.println(listLastBike.get(0).toString());
	}

}
