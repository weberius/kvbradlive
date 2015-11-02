package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.BeforeClass;

public class InsertBikeFacadeTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		// setup the jndi context and the datasource
		ConnectionFactory.setUpConnectionForJndi();
	}

	public static void main(String[] args) throws SQLException,
			NamingException, IOException {
		ConnectionFactory.setUpConnectionForJndi();
		new InsertBikeFacade().insert();
	}

}
