package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.Before;

import de.illilli.opendata.service.kvbradlive.BikeBo;
import de.illilli.opendata.service.kvbradlive.ConnectionFactory;

public class SelectAllBikesAndPositionsDependsOnModtimeTest {

	private static final long ONEDAY = 864000000;

	private static final Logger logger = Logger
			.getLogger(SelectAllBikesAndPositionsDependsOnModtimeTest.class);

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException,
			NamingException, IOException {
		// define db-connection
		ConnectionFactory.setUpConnectionForJndi();

		long modtime = System.currentTimeMillis() - ONEDAY;
		logger.debug(modtime);
		SelectBike selectBike = new SelectAllBikesAndPositionsDependsOnModtime(
				modtime);
		List<BikeBo> bikeBoList = selectBike.getBikeBoList();
		logger.debug(modtime + "; " + bikeBoList.size() + "; " + bikeBoList);
	}

}
