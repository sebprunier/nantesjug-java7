package org.nantesjug.java7.etl;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * This is the Model class used for Transformation.
 * 
 * @author sebastien.prunier
 */
public class FinancialData implements Serializable {

	private static final long serialVersionUID = -1344485181913996732L;

	// e.g "Nasdaq"
	private String code;

	// e.g 2624.63
	private BigDecimal value;

	// e.g -0.68
	private BigDecimal trend;

	public FinancialData(String code, BigDecimal value, BigDecimal trend) {
		super();
		this.code = code;
		this.value = value;
		this.trend = trend;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getTrend() {
		return trend;
	}

	public void setTrend(BigDecimal trend) {
		this.trend = trend;
	}

	@Override
	public String toString() {
		return code + " : " + (value == null ? "N/A" : value.toString())
				+ " | " + (trend == null ? "null" : trend.toString());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 31 * result + (code == null ? 0 : code.hashCode());

		return result;
	}

}
