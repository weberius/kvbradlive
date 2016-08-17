package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.AskFor;

public class AskForNextBikeLifeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMarkers() throws JsonParseException, JsonMappingException, IOException {
		InputStream inputStream = this.getClass().getResourceAsStream("/nextbike-live-20160817.xml");
		Markers markers = new AskForNextBikeLife(inputStream).getData();
		int actual = markers.country.size();
		int expected = 1;
		Assert.assertEquals(expected, actual);
	}

	/**
	 * This method allows to check the AskForNextBikeLife.
	 * 
	 * @param args
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		AskFor<Markers> askFor = new AskForNextBikeLife();
		Markers markers = askFor.getData();
		System.out.println(markers);
	}

}
