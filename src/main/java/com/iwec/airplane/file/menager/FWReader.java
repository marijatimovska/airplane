package com.iwec.airplane.file.menager;

import com.iwec.airplane.model.Stats;

public class FWReader extends FileMenagerImpl<Stats> {

	@Override
	public Stats createInstance(String line) {

		if (line == null || line.isEmpty()) {
			return null;
		}

		Stats st = new Stats();

		st.setId(Integer.parseInt(line.substring(0, 2).trim()));
		st.setSeats(Integer.parseInt(line.substring(3, 6).trim()));
		st.setCapacity(Double.parseDouble(line.substring(6, 11)));

		return st;

	}


}
