package com.simulator.surfaces;

/**
 * This class represents the rectangular table surface.
 * @author Vikas Dewan
 *
 */
public class Table extends Surface {

	private int length;
	private int breadth;

	public Table(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	
	public boolean isValidLocation(int xCoordinate, int yCoordinate) {

		return !((xCoordinate > length || xCoordinate < 0 ||
				yCoordinate > breadth || yCoordinate < 0));
	}

}
