package JsonClass;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class writingCSVFile {
	// Delimiter used in CSV file
	static final String COMMA_DELIMITER = ",";
	
	private static final String fileName = "C:\\Users\\Lie\\Dropbox\\2015.2\\Redes Sociais\\trabalho1\\starWarsGhapsData.gdf";

	private static final String NEW_LINE_SEPARATOR = "\n";

	// CSV file header

	private static final String FILE_HEADER = "Origen,Destino";

	public static void writeCsvFile(ArrayList<String> coluna1, ArrayList<String> coluna2,ArrayList<String> palavras) {

		// Create new students objects

		// Create a new list of student objects

		List students = new ArrayList();


		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);
			
			fileWriter.append("nodedef> name,label");
			fileWriter.append(NEW_LINE_SEPARATOR);
			for(String palavra : palavras) {
				fileWriter.append(palavra +","+palavra);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			fileWriter.append("edgedef> node1,node2");
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (int cont=0; cont< coluna1.size(); cont++) {
				fileWriter.append((String)coluna1.get(cont));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append((String)coluna2.get(cont));
				fileWriter.append(NEW_LINE_SEPARATOR);
				
			}
			/*
			fileWriter.append(FILE_HEADER);
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (int cont=0; cont< coluna1.size(); cont++) {
				fileWriter.append((String)coluna1.get(cont));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append((String)coluna2.get(cont));
				fileWriter.append(NEW_LINE_SEPARATOR);
				
			}*/


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
