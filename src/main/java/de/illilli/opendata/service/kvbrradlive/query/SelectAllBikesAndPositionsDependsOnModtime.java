package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.NamingException;

/**
 * Mit dieser Abfrage werden alle Fahrraddaten abgefragt, von Fahrrädern, deren
 * Position sich nach dem Zeitstempel geändert hat. Es werden alle
 * Fahrradpositionen zurückgegeben unabhängig davon, ob sie vor oder nach dem
 * übergebenen Zeitstempel in die Datenbank geschrieben werden.
 */
public class SelectAllBikesAndPositionsDependsOnModtime extends SelectBike {

	/**
	 * 
	 * @param time
	 *            Zeitstempel in Form eines long zur Einrschränkung der
	 *            Rückgabe.
	 * @throws SQLException
	 * @throws NamingException
	 * @throws IOException
	 */
	public SelectAllBikesAndPositionsDependsOnModtime(long time)
			throws SQLException, NamingException, IOException {

		queryString = "/selectAllBikesAndPositionsDependsOnModtime.sql";
		Timestamp modtime = new Timestamp(time);
		runSelect(modtime);
	}
}
