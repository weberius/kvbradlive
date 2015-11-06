package de.illilli.opendata.service.kvbrradlive.query;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.ConnectionFactory;
import de.illilli.jdbc.DbUtilsBeanListHandler;
import de.illilli.opendata.service.kvbradlive.BikeBo;

public abstract class SelectBike {

	String queryString;

	private List<BikeBo> bikeBoList = new ArrayList<BikeBo>();

	void runSelect(Object... params) throws SQLException, NamingException,
			IOException {

		Connection conn = ConnectionFactory.getConnection();
		InputStream inputStream = this.getClass().getResourceAsStream(
				queryString);
		String sql = IOUtils.toString(inputStream);

		BeanListHandler<BikeFromDb> beanListHandler = new BeanListHandler<BikeFromDb>(
				BikeFromDb.class);
		DbUtilsBeanListHandler<BikeFromDb> rsh = new DbUtilsBeanListHandler<BikeFromDb>(
				conn, beanListHandler, sql, params);
		List<BikeFromDb> bikeList = rsh.getList();

		for (BikeFromDb bike : bikeList) {
			bikeBoList.add(new BikeDao(bike).getBikeBo());
		}
		conn.close();

	}

	public List<BikeBo> getBikeBoList() {
		return bikeBoList;
	}

}
