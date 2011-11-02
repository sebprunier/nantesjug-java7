package org.nantesjug.java7.etl.load;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.nantesjug.java7.etl.FinancialData;

public class LoaderTest {

	@Test
	public void testLoad() {
		try {
			// Create data set
			Set<FinancialData> data = new HashSet<FinancialData>();
			data.add(new FinancialData("TEST", new BigDecimal(123.45),
					new BigDecimal(-1.25)));

			// Load
			Loader loader = new Loader();
			loader.load(data);

			// Check
			assertTrue(new File("out.txt").exists());
			assertTrue(new File("backup.txt").exists());

		} catch (IOException e) {
			fail();
		} finally {
			new File("out.txt").delete();
			new File("backup.txt").delete();
		}
	}

	@Test(expected = NullPointerException.class)
	public void testLoadWithNullInput() {
		try {
			Loader loader = new Loader();
			loader.load(null);
		} catch (IOException e) {
			fail();
		} finally {
			new File("out.txt").delete();
		}
	}

}
