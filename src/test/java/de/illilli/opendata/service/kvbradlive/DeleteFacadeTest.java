package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

public class DeleteFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public static void main(String[] args) throws IOException, SQLException, NamingException {
		ConnectionFactory.setUpConnectionForJndi();
		new DeleteFacade();
	}

}
