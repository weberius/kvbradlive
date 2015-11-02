package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	/**
	 * <p>
	 * Dieser Service holt die Daten von nextbike-live und schreibt die
	 * aktuellen Positionen der Fahrräder in die Datenbank.
	 * </p>
	 * <p>
	 * Beispiel:
	 * </p>
	 * <a
	 * href="http://localhost:8080/kvbradlive/service">/kvbradlive/service</a>
	 * 
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/")
	public String getStandorteFahrraeder() throws JsonParseException,
			JsonMappingException, IOException, SQLException, NamingException {
		int inserted = new InsertBikeFacade().insert();
		String msg = inserted + " bikes inserted";
		logger.info(msg);
		return msg;
	}

	/**
	 * <p>
	 * This Endpoint starts the periodical Check for Bikes. Default value is 10
	 * minutes. It is possible to change the period by providing interval
	 * Information.
	 * </p>
	 * <p>
	 * Example: <a
	 * href="http://localhost:8080/kvbradlive/service/start">/kvbradlive
	 * /service/start</a>
	 * </p>
	 * 
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/start")
	public String startRecording() {
		RecordingSingleton.getInstance().start();
		return "start";
	}

	/**
	 * This Endpoint stopps the periodical check of bikes
	 * <p>
	 * Example: <a
	 * href="http://localhost:8080/kvbradlive/service/stop">/kvbradlive
	 * /service/stop</a>
	 * </p>
	 * 
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/stop")
	public String stopRecording() {
		RecordingSingleton.getInstance().stop();
		return "stop";
	}

}
