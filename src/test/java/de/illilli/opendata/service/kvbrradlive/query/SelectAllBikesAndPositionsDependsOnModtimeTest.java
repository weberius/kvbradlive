package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
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

		long t = System.currentTimeMillis() - ONEDAY;
		Timestamp modtime = new Timestamp(t);
		SelectBike selectBike = new SelectAllBikesAndPositionsDependsOnModtime(
				modtime);
		List<BikeBo> bikeBoList = selectBike.getBikeBoList();
		logger.debug(bikeBoList.size() + "; " + bikeBoList);
	}

}
