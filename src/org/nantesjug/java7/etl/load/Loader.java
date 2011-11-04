package org.nantesjug.java7.etl.load;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.logging.Logger;

import org.nantesjug.java7.etl.FinancialData;

/**
 * The 'L' of ETL : Load.
 * 
 * @author sebastien.prunier
 */
public class Loader {

	private static Logger logger = Logger.getLogger(Loader.class.getName());

	public void load(Set<FinancialData> financialData) throws IOException {
		logger.info("ETL::Load");

		// Write to output file
		// JAVA 7 : try-with-resource
		try (FileWriter writer = new FileWriter("out.txt")) {
			for (FinancialData data : financialData) {
				writer.write(data.toString());
				writer.write(System.getProperty("line.separator"));
			}
			writer.flush();
		}

		// Make backup
		// JAVA 7 : NIO.2 - File copy
		FileSystem fs = FileSystems.getDefault();
		Files.copy(fs.getPath("out.txt"), fs.getPath("backup.txt"),
				StandardCopyOption.REPLACE_EXISTING);
	}

}
