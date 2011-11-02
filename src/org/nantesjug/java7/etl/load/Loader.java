package org.nantesjug.java7.etl.load;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.nantesjug.java7.etl.FinancialData;

/**
 * The 'L' of ETL : Load.
 * 
 * @author sebastien.prunier
 */
public class Loader {

	public void load(Set<FinancialData> financialData) throws IOException {
		// Write to output file
		FileWriter writer = null;
		try {
			writer = new FileWriter("out.txt");
			for (FinancialData data : financialData) {
				writer.write(data.toString());
				writer.write(System.getProperty("line.separator"));
			}
			writer.flush();
		} finally {
			writer.close();
		}

		// Make backup
		copyFile("out.txt", "backup.txt");
	}

	private void copyFile(String source, String target) throws IOException {

		FileReader in = null;
		FileWriter out = null;

		try {
			in = new FileReader(source);
			out = new FileWriter(target);

			int c;

			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {

				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {

				}
			}
		}
	}
}
