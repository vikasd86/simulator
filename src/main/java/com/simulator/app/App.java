package com.simulator.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.simulator.common.Constants;
import com.simulator.exception.SimulatorException;
import com.simulator.services.SimulationService;
import com.simulator.services.impl.ToySimulator;
import com.simulator.surfaces.Surface;
import com.simulator.surfaces.Table;
import com.simulator.toys.Toy;
import com.simulator.toys.ToyRobot;
import com.simulator.util.ConfigReader;

/**
 * This class is the entry point to simulator application.
 * 
 * @author Vikas Dewan
 *
 */
public class App {

	public static void main(String[] args) {

		ConfigReader config = ConfigReader.getInstance();

		/* Read initial dimension for a table from a configuration file. */
		int tableLength = Integer.parseInt(config.getConfigValue(Constants.TABLE_LENGTH));
		int tableBreadth = Integer.parseInt(config.getConfigValue(Constants.TABLE_BREADTH));

		Toy toy = new ToyRobot();
		Surface surface = new Table(tableLength, tableBreadth);
		SimulationService simulationService = new ToySimulator(toy, surface);

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String fileLocation = null;

		try {
			if (args.length < 1 || args[0] == null) {
				throw new SimulatorException("No input file specified.");
			}

			fileLocation = args[0];

			/* Read input file location from a configuration file. */
			fileReader = new FileReader(fileLocation);
			bufferedReader = new BufferedReader(fileReader);
			String inputCommand;

			while ((inputCommand = bufferedReader.readLine()) != null) {
				simulationService.simulate(inputCommand);
			}

		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Please specify the valid input file location");
		} catch (SimulatorException simulatorException) {
			System.err.println("Error : " + simulatorException.getMessage());
		} catch (Exception e) {
			System.err.println("An exception occured during execution " + e);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ioe) {
					System.err.println("IO Exception has occured " + ioe);
				}
			}
		}
	}
}
