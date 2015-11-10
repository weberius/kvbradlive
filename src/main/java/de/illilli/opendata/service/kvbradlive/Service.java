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

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.kvbrradlive.query.SelectForAllBikesAndPositions;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	/**
	 * <p>
	 * Dieser Service holt die Daten der Räder aus der Datenbank und gibt sie
	 * als Liste zurück.
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new BikesDataFacade(new SelectForAllBikesAndPositions());
		return facade.getJson();
	}

	/**
	 * liefert alle Datensätze der Fahrräder für eine datatable zurück.
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/datatable")
	public String getStandorteFahrraederForDataTable()
			throws JsonParseException, JsonMappingException, IOException,
			SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new BikesDataFacade(new SelectForAllBikesAndPositions());
		String json = "{\"data\":" + facade.getJson() + "}";
		return json;
	}

	/**
	 * Die Bikesmap liefert alle Fahrräder in der Map zurück; key ist die
	 * bike-number, value ist die Liste der Punkte, die dem Bike zuordnenbar
	 * sind.
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/bikesmap")
	public String getBikesMap() throws JsonParseException,
			JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new BikesMapFacade(new SelectForAllBikesAndPositions());
		return facade.getJson();
	}

	/**
	 * <p>
	 * Dieser Service holt die Daten von nextbike-live und schreibt die
	 * aktuellen Positionen der Fahrräder in die Datenbank.
	 * </p>
	 * <p>
	 * Beispiel:
	 * </p>
	 * <a href="http://localhost:8080/kvbradlive/service/insert">/kvbradlive/
	 * service/insert</a>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/insert")
	public String insertFahrraeder() throws JsonParseException,
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
	// @GET
	// @Produces({ MediaType.APPLICATION_JSON })
	// @Path("/start")
	@Deprecated
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
	// @GET
	// @Produces({ MediaType.APPLICATION_JSON })
	// @Path("/stop")
	@Deprecated
	public String stopRecording() {
		RecordingSingleton.getInstance().stop();
		return "stop";
	}

}
