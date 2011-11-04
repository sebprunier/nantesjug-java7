package org.nantesjug.java7.etl.extract;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The 'E' of ETL : Extract.
 * 
 * @author sebastien.prunier
 */
public class Extractor {

	private static Logger logger = Logger.getLogger(Extractor.class.getName());

	public Map<String, List<BigDecimal>> extract() throws FinancialException,
			FinancialException2 {
		logger.info("ETL::Extract");

		// Get connection parameters
		String url = System.getProperty("etl.url", "localhost");
		String user = System.getProperty("etl.user", "");
		String password = System.getProperty("etl.password", "");

		// Get financial data
		// JAVA 7 : try-with-resource and custom AutoCloseable
		try (MyFinancialConnection conn = new MyFinancialConnection(url, user,
				password)) {
			return conn.getFinancialData();
		}

	}
}
