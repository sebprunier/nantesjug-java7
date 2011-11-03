package org.nantesjug.java7.etl.extract;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ExtractorTest {

	@Test
	public void testExtract() {
		try {
			Extractor extractor = new Extractor();
			Map<String, List<BigDecimal>> data = extractor.extract();

			assertNotNull(data);
			assertEquals(5, data.size());

			for (String code : data.keySet()) {
				assertNotNull(data.get(code));
				assertEquals(3, data.get(code).size());
			}
		} catch (FinancialException e) {
			fail();
		}
	}

}
