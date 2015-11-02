package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class PlaceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void readPlace35409Test() throws JsonParseException,
			JsonMappingException, IOException {

		InputStream inputStream = this.getClass().getResourceAsStream(
				"/place_35409.xml");
		XmlMapper mapper = new XmlMapper();
		Place actual = mapper.readValue(inputStream, Place.class);

		Place expected = new Place();
		expected.bike_numbers = "21640,21371,21336,21507";
		expected.bikes = "4";
		expected.lat = 50.9429485;
		expected.lng = 6.958015;
		expected.name = "Hauptbahnhof";
		expected.number = 4826;
		expected.spot = 1;
		expected.terminal_type = "free";
		expected.uid = 35409;
		Assert.assertEquals(expected, actual);
	}

}
