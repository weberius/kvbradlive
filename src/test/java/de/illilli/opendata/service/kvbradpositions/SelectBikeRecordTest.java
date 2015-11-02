package de.illilli.opendata.service.kvbradpositions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.Before;

import de.illilli.opendata.service.kvbradlive.BikeBo;
import de.illilli.opendata.service.kvbradlive.ConnectionFactory;

public class SelectBikeRecordTest {

	private static final Logger logger = Logger
			.getLogger(SelectBikeRecordTest.class);

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException,
			NamingException, IOException {
		// define db-connection
		ConnectionFactory.setUpConnectionForJndi();
		// select first record
		SelectBike selectFirstRecord = new SelectFirstBikeRecord();
		BikeBo firstBike = selectFirstRecord.getBikeBoList().get(0);
		logger.info(firstBike);

		SelectBike selectRecord = new SelectBikeRecord(firstBike.getNumber());
		List<BikeBo> bikeBoList = selectRecord.getBikeBoList();
		for (BikeBo bikeBo : bikeBoList) {
			logger.info(bikeBo);
		}
	}

}
