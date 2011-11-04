package org.nantesjug.java7.etl.transform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.nantesjug.java7.etl.FinancialData;

public class TransformerTest {

	@Test
	public void testTransform() {
		Transformer transformer = new Transformer();

		// Empty dataset
		Set<FinancialData> data = transformer
				.transform(new HashMap<String, List<BigDecimal>>());
		assertNotNull(data);
		assertEquals(0, data.size());

		// Dataset with values
		// JAVA 7 : Type Inference for Generics
		Map<String, List<BigDecimal>> rowData = new HashMap<>();
		List<BigDecimal> values = new ArrayList<>();
		// JAVA 7 : Underscores in numeric literals
		values.add(new BigDecimal(11_801.64));
		values.add(new BigDecimal(143.68));
		values.add(new BigDecimal(1.23));
		rowData.put("DOW", values);

		data = transformer.transform(rowData);
		assertNotNull(data);
		assertEquals(1, data.size());
	}

	@Test(expected = NullPointerException.class)
	public void testTransformWithNullInput() {
		Transformer transformer = new Transformer();

		transformer.transform(null);
	}

}
