package org.nantesjug.java7.etl;

import java.util.logging.Logger;

/**
 * ETL entry point
 * 
 * @author sebastien.prunier
 * 
 */
public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		// Check parameters
		if (args.length < 1) {
			logger.severe("Parameter is missing !");
			System.exit(1);
		}

		// Running ETL
		String command = args[0].toLowerCase();
		ETL etl = new ETL();

		// JAVA 7 : Strings in Switch
		switch (command) {
		case "run":
			logger.info("ETL is running");
			etl.run();
			break;
		case "simulate":
			logger.info("ETL is running in simulation mode");
			etl.simulate();
			break;
		default:
			logger.warning("Unknown command : " + command);
		}

		System.exit(0);
	}

}
