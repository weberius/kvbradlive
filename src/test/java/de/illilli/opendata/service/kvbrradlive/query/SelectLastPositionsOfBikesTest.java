package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.opendata.service.kvbradlive.BikeBo;
import de.illilli.opendata.service.kvbradlive.ConnectionFactory;

public class SelectLastPositionsOfBikesTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws IOException, SQLException, NamingException {
		// define db-connection
		ConnectionFactory.setUpConnectionForJndi();

		SelectBike select = new SelectLastPositionsOfBikes();
		List<BikeBo> bikeBoList = select.getBikeBoList();

		System.out.println(bikeBoList);
	}

}
