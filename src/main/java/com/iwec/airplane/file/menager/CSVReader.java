package com.iwec.airplane.file.menager;

import com.iwec.airplane.model.Airplane;

public class CSVReader extends FileMenagerImpl<Airplane> {

	@Override
	public Airplane createInstance(String line) {

		if (line == null || line.isEmpty()) {
			return null;
		}

		String[] tokens = line.split(",");

		if (tokens.length != 5) {
			return null;
		}

		return new Airplane(Integer.parseInt(tokens[0].trim()), tokens[1].trim(), tokens[2].trim(),
				Integer.parseInt(tokens[3].trim()), Double.parseDouble(tokens[4].trim()));
	}


}
