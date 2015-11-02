package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class CountryTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Tests for the existence of the attribute 'country' and the expected value
	 * 'DE'.
	 * 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testGetCountry() throws JsonParseException,
			JsonMappingException, IOException {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/country_DE.xml");
		XmlMapper mapper = new XmlMapper();

		String actual = mapper.readValue(inputStream, Country.class)
				.getCountry();
		String expected = "DE";

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetNumberOfCities() throws JsonParseException,
			JsonMappingException, IOException {

		InputStream inputStream = this.getClass().getResourceAsStream(
				"/country_DE.xml");
		XmlMapper mapper = new XmlMapper();

		int actual = mapper.readValue(inputStream, Country.class).getCity()
				.size();
		int expected = 1;

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testGetNumberOfPlaces() throws JsonParseException,
			JsonMappingException, IOException {

		InputStream inputStream = this.getClass().getResourceAsStream(
				"/country_DE.xml");
		XmlMapper mapper = new XmlMapper();

		int actual = mapper.readValue(inputStream, Country.class).getCity()
				.get(0).getPlace().size();
		int expected = 2;

		Assert.assertEquals(expected, actual);

	}

}
