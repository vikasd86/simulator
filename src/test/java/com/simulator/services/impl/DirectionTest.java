package com.simulator.services.impl;

import org.junit.Assert;
import org.junit.Test;

import com.simulator.services.impl.Direction;

public class DirectionTest {

	@Test
	public void testLeft() throws Exception {
		Direction direction = Direction.EAST;

		direction = direction.left();
		Assert.assertEquals(Direction.NORTH, direction);

		direction = direction.left();
		Assert.assertEquals(Direction.WEST, direction);

	}

	@Test
	public void testRight() {
		Direction direction = Direction.EAST;
		
		direction = direction.right();
		Assert.assertEquals(Direction.SOUTH, direction);

		direction = direction.right();
		Assert.assertEquals(Direction.WEST, direction);

	}
}
