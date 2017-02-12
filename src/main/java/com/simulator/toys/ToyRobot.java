package com.simulator.toys;

import com.simulator.services.impl.Location;

/**
 * This class implements the toy movement methods. 
 * @author Vikas Dewan
 *
 */
public class ToyRobot extends Toy {

	private Location location;

	public Location getLocation() {
		return location;
	}

	public void move(Location location) {
		if (this.location != null) {
			this.location = location;
		}
	}

	public void turnLeft() {
		if (this.location != null) {
			this.location.setDirection(this.location.getDirection().left());
		}
	}

	public void turnRight() {
		if (this.location != null) {
			this.location.setDirection(this.location.getDirection().right());
		}
	}

	public void place(Location location) {
		this.location = location;
	}
}
