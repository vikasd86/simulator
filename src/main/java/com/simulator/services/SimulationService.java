package com.simulator.services;

/**
 * This interface exposes the functionality for simulation.
 * @author Vikas Dewan
 *
 */
public interface SimulationService {
	
	/**
	 * This method executes the command to simulate the toy over the surface.
	 * @param command
	 */
	void simulate(String command);
}
