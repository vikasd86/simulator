package com.simulator.exception;

/**
 * This class represents the Simulator application exception.
 * @author Vikas Dewan
 *
 */
public class SimulatorException extends RuntimeException{

	private static final long serialVersionUID = 2826729798048558223L;

	public SimulatorException(String message) {
		super(message);
	}
}
