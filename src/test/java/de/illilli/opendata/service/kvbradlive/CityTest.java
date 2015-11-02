package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class CityTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCity14Uid() throws JsonParseException,
			JsonMappingException, IOException {

		InputStream inputStream = this.getClass().getResourceAsStream(
				"/city_14.xml");
		XmlMapper mapper = new XmlMapper();

		int actual = mapper.readValue(inputStream, City.class).getUid();
		int expected = 14;

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCity14NumberOfPlaces() throws JsonParseException,
			JsonMappingException, IOException {

		InputStream inputStream = this.getClass().getResourceAsStream(
				"/city_14.xml");
		XmlMapper mapper = new XmlMapper();

		int actual = mapper.readValue(inputStream, City.class).getPlace()
				.size();
		int expected = 2;

		Assert.assertEquals(expected, actual);
	}

}
