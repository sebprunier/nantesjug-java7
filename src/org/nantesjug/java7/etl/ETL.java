package org.nantesjug.java7.etl;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.nantesjug.java7.etl.extract.Extractor;
import org.nantesjug.java7.etl.load.Loader;
import org.nantesjug.java7.etl.transform.Transformer;

/**
 * This is the ETL program !
 * 
 * @author sebastien.prunier
 */
public class ETL {

	private static Logger logger = Logger.getLogger(ETL.class.getName());

	public void run() {
		try {
			// Extract
			Extractor extractor = new Extractor();
			Map<String, List<BigDecimal>> data = extractor.extract();

			// Transform
			Transformer transformer = new Transformer();
			Set<FinancialData> transformedData = transformer.transform(data);

			// Load
			Loader loader = new Loader();
			loader.load(transformedData);

		} catch (RemoteException e) {
			logger.log(Level.SEVERE, "Error while ETL execution", e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error while ETL execution", e);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unknown error !!!", e);
		}
	}

	public void simulate() {
		try {
			// Extract
			Extractor extractor = new Extractor();
			Map<String, List<BigDecimal>> data = extractor.extract();

			// Transform
			Transformer transformer = new Transformer();
			Set<FinancialData> transformedData = transformer.transform(data);

			// Don't Load, just dump !
			for (FinancialData fd : transformedData) {
				logger.info(fd.toString());
			}

		} catch (RemoteException e) {
			logger.log(Level.SEVERE, "Error while ETL execution", e);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unknown error !!!", e);
		}
	}

}
