package com.simulator.toys;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.simulator.services.impl.Direction;
import com.simulator.services.impl.Location;
import com.simulator.toys.Toy;
import com.simulator.toys.ToyRobot;


public class ToyRobotTest {

	private Toy toy;
	private Location currentLocation;
	
	@Before
	public void setup()
	{
		toy = new ToyRobot();
		currentLocation = new Location(1,1, Direction.NORTH);
		toy.place(currentLocation);
	}
	
	@Test
	public void testPlace()
	{
		Assert.assertEquals(1, toy.getLocation().getxCoordinate());
		Assert.assertEquals(1, toy.getLocation().getyCoordinate());
		Assert.assertEquals(Direction.NORTH, toy.getLocation().getDirection());
		Assert.assertNotEquals(null, toy.getLocation());
	}
	
	@Test
	public void testMove()
	{
		toy.move(toy.getLocation().getNextLocation());
		
		Assert.assertEquals(1, toy.getLocation().getxCoordinate());
		Assert.assertEquals(2, toy.getLocation().getyCoordinate());
		Assert.assertEquals(Direction.NORTH, toy.getLocation().getDirection());
	}
	
	@Test
	public void testLeft()
	{
		toy.turnLeft();
		Assert.assertEquals(1, toy.getLocation().getxCoordinate());
		Assert.assertEquals(1, toy.getLocation().getyCoordinate());
		Assert.assertEquals(Direction.WEST, toy.getLocation().getDirection());
	}
	
	@Test
	public void testRight()
	{
		toy.turnRight();
		Assert.assertEquals(1, toy.getLocation().getxCoordinate());
		Assert.assertEquals(1, toy.getLocation().getyCoordinate());
		Assert.assertEquals(Direction.EAST, toy.getLocation().getDirection());
	}
	
	@Test
	public void testNoMovementWithoutPlaceBeingCalled()
	{
		toy = new ToyRobot();
		Location newLocation = new Location(2,3,Direction.EAST); 
		
		toy.move(newLocation);
		Assert.assertEquals(null, toy.getLocation());
		
		toy.turnLeft();
		Assert.assertEquals(null, toy.getLocation());
		
		toy.turnRight();
		Assert.assertEquals(null, toy.getLocation());
		
		toy.place(newLocation);
		Assert.assertNotEquals(null, toy.getLocation());
	}
}
