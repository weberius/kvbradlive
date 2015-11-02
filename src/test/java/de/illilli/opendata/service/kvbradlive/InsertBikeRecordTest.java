package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;

public class InsertBikeRecordTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		// setup the jndi context and the datasource
		ConnectionFactory.setUpConnectionForJndi();
	}

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException,
			NamingException, IOException {

		ConnectionFactory.setUpConnectionForJndi();
		BikeBo bo = new BikeBo();
		bo.name = "BIKE 21640";
		bo.lat = 50.9429485;
		bo.lng = 6.958015;
		bo.number = 21640;
		bo.bike = 1;
		bo.uid = 359446;
		new InsertBikeRecord(bo);
	}

}
