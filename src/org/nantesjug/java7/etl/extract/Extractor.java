package org.nantesjug.java7.etl.extract;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
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

	public Map<String, List<BigDecimal>> extract() throws FinancialException {
		logger.info("ETL::Extract");

		// Get connection parameters
		String url = System.getProperty("etl.url", "localhost");
		String user = System.getProperty("etl.user", "");
		String password = System.getProperty("etl.password", "");

		// Get financial data
		MyFinancialConnection conn = null;
		try {
			conn = new MyFinancialConnection(url, user, password);
			return conn.getFinancialData();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (IOException e) {
					// Do nothing, just trace ...
					logger.severe("Error while closing MyFinancialConnection ...");
				}
			}
		}

	}
}
