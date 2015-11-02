package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class MarkersTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test the number of Countries in file 'nextbike-live.xml'.
	 * 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testForNumberOfCountries() throws JsonParseException,
			JsonMappingException, IOException {

		InputStream inputStream = this.getClass().getResourceAsStream(
				"/nextbike-live.xml");
		XmlMapper mapper = new XmlMapper();

		int actual = mapper.readValue(inputStream, Markers.class).getCountry()
				.size();
		int expected = 48;

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFor20151014() throws JsonParseException,
			JsonMappingException, IOException {

		InputStream inputStream = this.getClass().getResourceAsStream(
				"/nextbike-live-20151014.xml");
		XmlMapper mapper = new XmlMapper();

		int actual = mapper.readValue(inputStream, Markers.class).getCountry()
				.size();
		int expected = 1;

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFor20151019() throws JsonParseException,
			JsonMappingException, IOException {

		InputStream inputStream = this.getClass().getResourceAsStream(
				"/nextbike-live-20151019.xml");
		XmlMapper mapper = new XmlMapper();

		List<Place> placesList = mapper.readValue(inputStream, Markers.class)
				.getCountry().get(0).getCity().get(0).getPlace();
		String actual = "";
		for (Place places : placesList) {
			String bikeNumbers = places.getBike_numbers();
			if (bikeNumbers != null && bikeNumbers.contains("21380")) {
				actual = "21380";
				break;
			}
		}
		String expected = "21380";
		Assert.assertEquals(expected, actual);
	}

}
