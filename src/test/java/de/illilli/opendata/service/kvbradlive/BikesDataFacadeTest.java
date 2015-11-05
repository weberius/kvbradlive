package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.Before;

import de.illilli.opendata.service.kvbrradlive.query.SelectForAllBikesAndPositions;

public class BikesDataFacadeTest {

	private static final Logger logger = Logger
			.getLogger(BikesDataFacadeTest.class);

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws IOException, SQLException,
			NamingException {
		ConnectionFactory.setUpConnectionForJndi();
		String json = new BikesDataFacade(new SelectForAllBikesAndPositions())
				.getJson();
		logger.info(json);
	}

}
