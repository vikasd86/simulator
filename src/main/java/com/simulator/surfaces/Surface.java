package com.simulator.surfaces;

/**
 * This is an abstract class that declares the methods required for valid movement over the surface.
 * @author Vikas Dewan
 *
 */
public abstract class Surface {
	
	/**
	 * This method checks whether following co-ordinates lies over the surface.
	 * @param xCoordinate
	 * @param yCoordinate
	 * @return
	 */
	public abstract boolean isValidLocation(int xCoordinate, int yCoordinate);
}
