package de.illilli.opendata.service.kvbradlive;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BikesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSameBikeTwoDifferentPositions() {
		List<BikeBo> bikeList = new ArrayList<BikeBo>();
		// first bike
		BikeBo bike = new BikeBo();
		bike.number = 1;
		bike.lat = 0.0;
		bike.lng = 0.1;
		bikeList.add(bike);

		// next bike
		bike = new BikeBo();
		bike.number = 1;
		bike.lat = 0.1;
		bike.lng = 0.1;
		bikeList.add(bike);

		Bikes bikes = new Bikes(bikeList);

		int expected = 2;
		int actual = bikes.getBikeMap().get(1).size();
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testSameBikeOnePosition() {
		List<BikeBo> bikeList = new ArrayList<BikeBo>();
		// first bike
		BikeBo bike = new BikeBo();
		bike.number = 1;
		bike.lat = 0.0;
		bike.lng = 0.1;
		bikeList.add(bike);

		// next bike
		bike = new BikeBo();
		bike.number = 1;
		bike.lat = 0.0;
		bike.lng = 0.1;
		bikeList.add(bike);

		Bikes bikes = new Bikes(bikeList);

		for (Integer key : bikes.getBikeMap().keySet()) {
			List<BikeBo> bikeBoList = bikes.getBikeMap().get(key);
			for (BikeBo bikeBo : bikeBoList) {
				System.out.println(bikeBo.toString());
			}
		}

		int expected = 1;
		int actual = bikes.getBikeMap().get(1).size();
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testDifferentBikesOnePosition() {
		List<BikeBo> bikeList = new ArrayList<BikeBo>();
		// first bike
		BikeBo bike = new BikeBo();
		bike.number = 1;
		bike.lat = 0.0;
		bike.lng = 0.1;
		bikeList.add(bike);

		// next bike
		bike = new BikeBo();
		bike.number = 2;
		bike.lat = 0.0;
		bike.lng = 0.1;
		bikeList.add(bike);

		// next bike
		bike = new BikeBo();
		bike.number = 3;
		bike.lat = 0.0;
		bike.lng = 0.1;
		bikeList.add(bike);

		Bikes bikes = new Bikes(bikeList);

		int expected = 3;
		int actual = bikes.getBikeMap().size();
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testDifferentBikesDifferentPositions() {
		List<BikeBo> bikeList = new ArrayList<BikeBo>();
		// first bike
		BikeBo bike = new BikeBo();
		bike.number = 1;
		bike.lat = 0.0;
		bike.lng = 0.1;
		bikeList.add(bike);

		// next bike
		bike = new BikeBo();
		bike.number = 1;
		bike.lat = 0.1;
		bike.lng = 0.1;
		bikeList.add(bike);

		// next bike
		bike = new BikeBo();
		bike.number = 2;
		bike.lat = 0.0;
		bike.lng = 0.1;
		bikeList.add(bike);

		// next bike
		bike = new BikeBo();
		bike.number = 2;
		bike.lat = 0.1;
		bike.lng = 0.1;
		bikeList.add(bike);

		Bikes bikes = new Bikes(bikeList);

		int expected = 2;
		int actual = bikes.getBikeMap().size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDifferentBikesDifferentAndSamePositions() {
		List<BikeBo> bikeList = new ArrayList<BikeBo>();
		// first bike
		BikeBo bike = new BikeBo();
		bike.number = 1;
		bike.lat = 0.0;
		bike.lng = 0.1;
		bikeList.add(bike);

		// same bike; different position
		bike = new BikeBo();
		bike.number = 1;
		bike.lat = 0.1;
		bike.lng = 0.1;
		bikeList.add(bike);

		// same bike; same position
		bike = new BikeBo();
		bike.number = 1;
		bike.lat = 0.1;
		bike.lng = 0.1;
		bikeList.add(bike);

		// next bike
		bike = new BikeBo();
		bike.number = 2;
		bike.lat = 0.0;
		bike.lng = 0.1;
		bikeList.add(bike);

		// same bike; different position
		bike = new BikeBo();
		bike.number = 2;
		bike.lat = 0.1;
		bike.lng = 0.1;
		bikeList.add(bike);

		// same bike; different position
		bike = new BikeBo();
		bike.number = 2;
		bike.lat = 0.1;
		bike.lng = 0.2;
		bikeList.add(bike);

		Bikes bikes = new Bikes(bikeList);

		// first bike
		int expected = 2;
		int actual = bikes.getBikeMap().get(1).size();
		Assert.assertEquals(expected, actual);

		// second bike
		expected = 3;
		actual = bikes.getBikeMap().get(2).size();
		Assert.assertEquals(expected, actual);

	}

}
