package com.simulator.services.impl;

/**
 * This class represents the location.
 * @author Vikas Dewan
 *
 */
public class Location {
	private int xCoordinate;
	private int yCoordinate;
	private Direction direction;

	public Location(Location location) {
		super();
		this.xCoordinate = location.getxCoordinate();
		this.yCoordinate = location.getyCoordinate();
		this.direction = location.getDirection();
	}

	public Location(int xCoordinate, int yCoordinate, Direction direction) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.direction = direction;
	}

	/**
	 * This method returns the x coordinate of the location.
	 * @return
	 */
	public int getxCoordinate() {
		return xCoordinate;
	}

	/**
	 * This method returns the y coordinate of the location.
	 * @return
	 */
	public int getyCoordinate() {
		return yCoordinate;
	}

	/**
	 * This method returns the current direction.
	 * @return
	 */
	public Direction getDirection() {
		return direction;
	}
	
	/**
	 * This method sets the new direction.
	 * @param direction
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * This method returns the next available location in a current direction.
	 * @return
	 */
	public Location getNextLocation() {
		Location location = new Location(this);

		switch (this.direction) {
		case NORTH:
			location.yCoordinate += 1;
			break;
		case EAST:
			location.xCoordinate += 1;
			break;
		case SOUTH:
			location.yCoordinate += -1;
			break;
		case WEST:
			location.xCoordinate += -1;
			break;
		}
		return location;
	}
}