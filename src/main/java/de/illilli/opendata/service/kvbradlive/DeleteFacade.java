package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import de.illilli.opendata.service.kvbrradlive.query.DeleteFromBike;

public class DeleteFacade {

	private static final Logger logger = Logger.getLogger(DeleteFacade.class);

	public DeleteFacade() {
		try {
			int updated = new DeleteFromBike().getUpdated();
			logger.info("'" + updated + "' rows deleted");
		} catch (SQLException e) {
			logger.error(e);
		} catch (NamingException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
