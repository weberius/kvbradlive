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

public class BikeDaoTest {

	private Markers markers;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetBikeBoList() throws JsonParseException,
			JsonMappingException, IOException {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/nextbike-live-14.xml");
		XmlMapper mapper = new XmlMapper();

		markers = mapper.readValue(inputStream, Markers.class);

		BikesFromNextbike dao = new BikesFromNextbike(markers);
		List<BikeBo> bikeBoList = dao.getBikeBoList();
		for (BikeBo bikeBo : bikeBoList) {
			System.out.println(bikeBo.toString());
		}
	}

	@Test
	public void testGetBikeBoList20151019() throws JsonParseException,
			JsonMappingException, IOException {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/nextbike-live-20151019.xml");
		XmlMapper mapper = new XmlMapper();

		markers = mapper.readValue(inputStream, Markers.class);

		BikesFromNextbike dao = new BikesFromNextbike(markers);
		List<BikeBo> bikeBoList = dao.getBikeBoList();
		int actual = 0;
		int expected = 21380;
		for (BikeBo bikeBo : bikeBoList) {
			if (bikeBo.number == 21380) {
				actual = bikeBo.number;
				System.out.println(bikeBo.toString());
				break;
			}
		}

		Assert.assertEquals(expected, actual);
	}

}
