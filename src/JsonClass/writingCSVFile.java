package JsonClass;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class writingCSVFile {
	// Delimiter used in CSV file
	static final String COMMA_DELIMITER = ",";

	private static final String NEW_LINE_SEPARATOR = "\n";

	// CSV file header

	private static final String FILE_HEADER = "id,firstName,lastName,gender,age";

	public static void writeCsvFile(String fileName) {

		// Create new students objects

		// Create a new list of student objects

		List students = new ArrayList();


		FileWriter fileWriter = null;

		try {

			fileWriter = new FileWriter(fileName);


			fileWriter.append(FILE_HEADER.toString());

		

			fileWriter.append(NEW_LINE_SEPARATOR);


			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {

			System.out.println("Error in CsvFileWriter !!!");

			e.printStackTrace();

		} finally {

			try {

				fileWriter.flush();

				fileWriter.close();

			} catch (IOException e) {

				System.out
						.println("Error while flushing/closing fileWriter !!!");

				e.printStackTrace();

			}

		}

	}

}
