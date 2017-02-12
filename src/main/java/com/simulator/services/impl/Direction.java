package com.simulator.services.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * This represents the Direction and provides functionality to change & set direction.
 * @author Vikas Dewan
 *
 */
public enum Direction {

	NORTH(1), EAST(2), SOUTH(3), WEST(4);

	private int index;

	private Direction(int index) {
		this.index = index;
	}

	public final static Map<Integer, Direction> directionIndexMap = new HashMap<Integer, Direction>();

	static {
		for (Direction directionEnum : Direction.values()) {
			directionIndexMap.put(directionEnum.index, directionEnum);
		}
	}

	/**
	 * This method returns the specific direction enum for a particular index.
	 * @param index : valid values are 1,2,3,4
	 * @return
	 */
	public static Direction getEnum(int index) {
		return directionIndexMap.get(index);
	}

	/**
	 * This method sets direction to left of existing direction.
	 * Example : EAST would be set if existing direction is SOUTH.
	 * @return
	 */
	public Direction left() {
		int newDir = this.index - 1;

		newDir = (newDir == 0) ? 4 : newDir;
		return getEnum(newDir);
	}

	/**
	 * This method sets direction to left of existing direction.
	 * Example : EAST would be set if existing direction is NORTH.
	 * @return
	 */
	public Direction right() {
		int newDir = this.index + 1;

		newDir = (this.index + 1 == 5) ? 1 : newDir;
		return getEnum(newDir);
	}
}
