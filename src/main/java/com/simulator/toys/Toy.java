package com.simulator.toys;

import com.simulator.services.impl.Location;

/**
 * This is an abstract class that declares the methods required for the toy movement. 
 * 
 * @author Vikas Dewan
 *
 */
public abstract class Toy {

	/**
	 * This method moves the toy to the specified location.
	 * @param location : location where toy has to be moved.
	 */
	public abstract void move(Location location);

	/**
	 * This method turns the toy to left.
	 */
	public abstract void turnLeft();

	/**
	 * This method turns the toy to right.
	 */
	public abstract void turnRight();

	/**
	 * This method will initialize the toy with the specified location.
	 * @param location
	 */
	public abstract void place(Location location);

	/**
	 * This method returns the current location of the toy.
	 * @return
	 */
	public abstract Location getLocation();
}
