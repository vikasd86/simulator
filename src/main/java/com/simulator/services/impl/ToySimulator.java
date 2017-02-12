package com.simulator.services.impl;

import com.simulator.services.SimulationService;
import com.simulator.surfaces.Surface;
import com.simulator.toys.Toy;

/**
 * This is simulator class that contains the logic to simulate a toy over the surface.
 * @author Vikas Dewan
 *
 */
public class ToySimulator implements SimulationService {

	private Toy toy;
	private Surface surface;
	
	private static final String COMMAND_DELIMITER = " ";
	private static final String COORDINATE_DELIMITER = ",";

	public ToySimulator(Toy toy, Surface surface){
		this.toy = toy;
		this.surface = surface;
	}

	public void simulate(String command) 
	{
		switch (command) {
		case "MOVE":
			moveToy();
			break;
		case "LEFT":
			toy.turnLeft();
			break;
		case "RIGHT":
			toy.turnRight();
			break;
		case "REPORT":
			reportLocation();
			break;
		default:
			checkAndProcessPlace(command);
			break;
		}
	}
	
	private void reportLocation()
	{
		Location currentLocation = toy.getLocation();
		
		if(currentLocation != null)
		{
			System.out.println(currentLocation.getxCoordinate() + "," + currentLocation.getyCoordinate() + "," + currentLocation.getDirection());
		}
		
	}
	
	private void moveToy()
	{
		if(toy.getLocation() == null){
			return;
		}
		Location newLocation = toy.getLocation().getNextLocation();
		if(surface.isValidLocation(newLocation.getxCoordinate(), newLocation.getyCoordinate()))
		{
			toy.move(newLocation);
		}
	}
	
	/**
	 * This method check whether command is a valid PLACE command. If yes then it executes the same.
	 * otherwise it ignores the command.
	 * 
	 * @param command
	 */
	private void checkAndProcessPlace(String command) {

		if (command.startsWith("PLACE")) {
			int xCoordinate;
			int yCoordinate;

			String directionAsString;
			String[] cmdArr = command.split(COMMAND_DELIMITER);
			String[] coordinates = cmdArr[1].split(COORDINATE_DELIMITER);

			try {
				xCoordinate = Integer.parseInt(coordinates[0]);
				yCoordinate = Integer.parseInt(coordinates[1]);
				directionAsString = coordinates[2];
				
				if(surface.isValidLocation(xCoordinate, yCoordinate))
				{
					Location location = new Location(xCoordinate, yCoordinate, Direction.valueOf(directionAsString));
					toy.place(location);
				}

			} catch(Exception e){
				System.err.println("Invalid place command.");
			}
			
		}
	}
}
