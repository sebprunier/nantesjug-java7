package org.nantesjug.java7.etl.transform;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.nantesjug.java7.etl.FinancialData;

/**
 * The 'T' of ETL : Transform.
 * 
 * @author sebastien.prunier
 */
public class Transformer {

	private static Logger logger = Logger
			.getLogger(Transformer.class.getName());

	public Set<FinancialData> transform(
			Map<String, List<BigDecimal>> financialData) {
		logger.info("ETL::Transform");

		// Init result set
		// JAVA 7 : Type Inference for Generics
		Set<FinancialData> dataSet = new HashSet<>();

		// Transform financial data
		for (String code : financialData.keySet()) {
			List<BigDecimal> values = financialData.get(code);
			FinancialData data = new FinancialData(code, values.get(0),
					values.get(2));
			dataSet.add(data);
		}

		return dataSet;
	}

}
