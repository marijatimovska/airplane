package com.iwec.csv.menager;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import com.iwec.airplane.model.Airplane;

public class CSVMenager {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "id,manufacturer,model,totalSeats,totalCapacity";

	public void csvMenager (List<Airplane> objectList, File fileName) {

		try (PrintWriter out = new PrintWriter(fileName)){

			out.append(FILE_HEADER.toString());
			out.append(NEW_LINE_SEPARATOR);

			for (Airplane i : objectList) {
				out.append(String.valueOf(i.getId()));
				out.append(COMMA_DELIMITER);
				out.append(i.getManufacturer());
				out.append(COMMA_DELIMITER);
				out.append(i.getModel());
				out.append(COMMA_DELIMITER);
				out.append(String.valueOf(i.getTotalSeats()));
				out.append(COMMA_DELIMITER);
				out.append(String.valueOf(i.getTotalCapacity()));
				out.append(NEW_LINE_SEPARATOR);
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		}

	}

}
