package org.nantesjug.java7.etl.extract;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simulates a connection to a remote financial service.
 * 
 * @author sebastien.prunier
 */
public class MyFinancialConnection {

	private Map<String, List<BigDecimal>> financialData;

	private boolean closed;

	public MyFinancialConnection(String url, String user, String password) {
		// TODO connect to a remote financial service
	}

	public Map<String, List<BigDecimal>> getFinancialData()
			throws FinancialException {
		if (financialData == null) {
			financialData = new HashMap<String, List<BigDecimal>>();
			// TODO Execute remote financial service call
			loadMockValues();
		}
		return financialData;
	}

	public void close() throws IOException {
		// TODO release connection to the remote financial service
		closed = true;
	}

	public boolean isClosed() {
		return closed;
	}

	/*
	 * Creates mock values.
	 */
	private void loadMockValues() {
		// Dow
		List<BigDecimal> values = new ArrayList<BigDecimal>();
		values.add(new BigDecimal(11_801.64));
		values.add(new BigDecimal(143.68));
		values.add(new BigDecimal(1.23));

		financialData.put("DOW", values);

		// Nasdaq
		values = new ArrayList<BigDecimal>();
		values.add(new BigDecimal(2_624.63));
		values.add(new BigDecimal(17.67));
		values.add(new BigDecimal(0.68));

		financialData.put("NASDAQ", values);

		// Oil
		values = new ArrayList<BigDecimal>();
		values.add(new BigDecimal(92.739_998));
		values.add(new BigDecimal(0.55));
		values.add(new BigDecimal(0.60));

		financialData.put("OIL", values);

		// Gold
		values = new ArrayList<BigDecimal>();
		values.add(new BigDecimal(1_732.60));
		values.add(new BigDecimal(21.60));
		values.add(new BigDecimal(1.26));

		financialData.put("GOLD", values);

		// CAC 40
		values = new ArrayList<BigDecimal>();
		values.add(new BigDecimal(3_110.59));
		values.add(new BigDecimal(42.26));
		values.add(new BigDecimal(1.38));

		financialData.put("CAC_40", values);
	}
}
