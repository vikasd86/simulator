package com.simulator.services.impl;

import org.junit.Assert;
import org.junit.Test;

import com.simulator.services.impl.Direction;
import com.simulator.services.impl.Location;

public class LocationTest {

	@Test
	public void testGetNextLocation() throws Exception {
		Location location = new Location(3, 3, Direction.WEST);

		Location newLocation = location.getNextLocation();
		Assert.assertEquals(newLocation.getxCoordinate(), 2);
		Assert.assertEquals(newLocation.getyCoordinate(), 3);
		Assert.assertEquals(newLocation.getDirection(), Direction.WEST);
	}
}
