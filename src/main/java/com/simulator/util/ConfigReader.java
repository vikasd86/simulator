package com.simulator.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import com.simulator.common.Constants;

/**
 * This is a singleton class that reads the static configuration from the configuration file.
 * If configuration file is not present then it initializes the configuration with default values.
 * 
 * @author Vikas Dewan
 *
 */
public class ConfigReader {

	private Logger LOGGER = Logger.getLogger(ConfigReader.class.getName());
	
	private Properties properties = new Properties();
	private Map<String, String> propMap = new HashMap<String, String>();
	private static ConfigReader instance = new ConfigReader();
	
	private final String CONFIG_FILE_NAME = "toy_simulator.properties";

	private ConfigReader() {
		loadConfig();
	}

	/**
	 * This method returns the instance of ConfigReader class.
	 * @return
	 */
	public static ConfigReader getInstance() {
		return instance;
	}

	/**
	 * This method returns the configuration value for a certain property.
	 * @param configName : Name of the parameter
	 * @return : Value of the parameter.
	 */
	public String getConfigValue(String configName) {
		return propMap.get(configName);
	}

	private void loadConfig() {

		InputStream inputStream = null;

		try {
			/* First load the default configuration. */
			populateDefaultConfig();

			inputStream = new FileInputStream(CONFIG_FILE_NAME);

			/*
			 * If configuration file is present then update the configuration
			 * from the same.
			 */
			if (inputStream != null) {
				properties.load(inputStream);
				populateConfig();
			}

		} catch (Exception ex) {
			System.err.println("An error occurred while reading the configuration");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					LOGGER.severe("An error occurred while closing the input stream.");
					LOGGER.severe(e.getMessage());
				}
			}
		}
	}

	private void populateConfig() {
		String propValue = null;

		propValue = properties.getProperty(Constants.TABLE_LENGTH);

		if (propValue != null) {
			/* Check if an integer then override default value. */
			if (isInteger(propValue)) {
				propMap.put(Constants.TABLE_LENGTH, propValue);
			}
		}

		propValue = properties.getProperty(Constants.TABLE_BREADTH);
		if (propValue != null) {
			/* Check if an integer then override default value. */
			if (isInteger(propValue)) {
				propMap.put(Constants.TABLE_BREADTH, propValue);
			}
		}
	}

	private void populateDefaultConfig() {
		propMap.put(Constants.TABLE_LENGTH, "5");
		propMap.put(Constants.TABLE_BREADTH, "5");
	}

	private boolean isInteger(String str) {
		return str.matches("\\d*");
	}
}
