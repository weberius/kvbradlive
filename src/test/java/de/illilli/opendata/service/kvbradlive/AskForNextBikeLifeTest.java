package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class AskForNextBikeLifeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMarkers() throws JsonParseException,
			JsonMappingException, IOException {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/nextbike-live-20151014.xml");
		Markers markers = new AskForNextBikeLife(inputStream).getMarkers();
		int actual = markers.country.size();
		int expected = 1;
		Assert.assertEquals(expected, actual);
	}

}
