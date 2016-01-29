package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.kvbrradlive.query.SelectAllBikesAndPositionsDependsOnModtime;
import de.illilli.opendata.service.kvbrradlive.query.SelectAllBikesAndPositionsNewerThanModtime;
import de.illilli.opendata.service.kvbrradlive.query.SelectForAllBikesAndPositions;
import de.illilli.opendata.service.kvbrradlive.query.SelectForBikeAndPositions;
import de.illilli.opendata.service.kvbrradlive.query.SelectLastPositionsOfBikes;

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
	 * <a href="http://localhost:8080/kvbradlive/service">/kvbradlive/service
	 * </a>
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
	public String getStandorteFahrraeder()
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
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
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new BikesDataFacade(new SelectForAllBikesAndPositions());
		String json = "{\"data\":" + facade.getJson() + "}";
		return json;
	}

	/**
	 * <p>
	 * Dieser Service-Endpunkt gibt alle Fahrräder zurück, deren Position sich
	 * nach dem Zeitstempel (modtime) geändert hat. Fahrraddaten von Fahrrädern
	 * deren Position sich vor dem Zeitstempel geändert haben, werden nicht
	 * geliefert.
	 * </p>
	 * <p>
	 * Bsp.: <a href=
	 * "http://localhost:8080/kvbradlive/service/bikesmap?lastrun=1446786791072"
	 * >/kvbradlive/service/bikesmap?lastrun=&lt;timestamp&gt;</a>
	 * </p>
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
	public String getBikesMap()
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = null;
		if (request.getParameter("lastrun") != null) {
			long lastrun = Long.parseLong(request.getParameter("lastrun"));
			facade = new BikesMapFacade(new SelectAllBikesAndPositionsDependsOnModtime(lastrun));
		} else {
			facade = new BikesMapFacade(new SelectForAllBikesAndPositions());
		}

		return facade.getJson();
	}

	/**
	 * <p>
	 * Dieser Service-Endpunkt gibt alle Fahrräder zurück, deren Position sich
	 * nach dem Zeitstempel (modtime) geändert hat. Fahrraddaten von Fahrrädern
	 * deren Position sich vor dem Zeitstempel geändert haben, werden nicht
	 * geliefert.
	 * </p>
	 * <p>
	 * Beispiel:
	 * <a href="http://localhost:8080/kvbradlive/service/bikesmap/1447043598324"
	 * >/kvbradlive /service/bikesmap/&lt;modtime&gt;</a>
	 * </p>
	 * 
	 * @param modtime
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/bikesmap/{modtime}")
	public String getBikesMap(@PathParam("modtime") long modtime)
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		logger.info("modtime = '" + new Date(modtime).toString() + "'");
		Facade facade = new BikesMapFacade(new SelectAllBikesAndPositionsNewerThanModtime(modtime));
		return facade.getJson();
	}

	/**
	 * <p>
	 * Beispiel: <a href=
	 * "http://localhost:8080/kvbradlive/service/bikeslist/1447043598324" >
	 * /kvbradlive /service/bikeslist/&lt;modtime&gt;</a>
	 * </p>
	 * 
	 * @param modtime
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/bikeslist/{modtime}")
	public String getBikesList(@PathParam("modtime") long modtime)
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		logger.info("modtime = '" + new Date(modtime).toString() + "'");
		Facade facade = new BikesListFacade(new SelectAllBikesAndPositionsNewerThanModtime(modtime));
		return facade.getJson();
	}

	/**
	 * <p>
	 * Beispiel:
	 * <a href= "http://localhost:8080/kvbradlive/service/bike/21002" >
	 * /kvbradlive/service/bike/&lt;number&gt;</a>
	 * </p>
	 * 
	 * @param number
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/bike/{number}")
	public String getBike(@PathParam("number") int number)
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		logger.info("number = '" + number + "'");
		Facade facade = new BikesListFacade(new SelectForBikeAndPositions(number));
		return facade.getJson();
	}

	/**
	 * <p>
	 * Beispiel: <a href=
	 * "http://localhost:8080/kvbradlive/service/allbikeslatestposition/bikeslist"
	 * > /kvbradlive/service/allbikeslatestposition/bikeslist</a>
	 * </p>
	 * 
	 * @param modtime
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/allbikeslatestposition/bikeslist")
	public String getAllbikeslatestposition()
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new BikesListFacade(new SelectLastPositionsOfBikes());
		return facade.getJson();
	}

	/**
	 * <p>
	 * Dieser Service holt die Daten von nextbike-live und schreibt die
	 * aktuellen Positionen der Fahrräder in die Datenbank.
	 * </p>
	 * <p>
	 * Beispiel:
	 * <code>curl -X PUT http://localhost:8080/kvbradlive/service/put</code>
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/put")
	public String putKvbradpositions()
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		int inserted = new InsertBikeFacade().insert();
		String msg = inserted + " bikes inserted";
		logger.info(msg);
		return msg;
	}

}
