package com.iwec.airplane.airport;

import java.util.List;
import java.util.stream.Collectors;

import com.iwec.airplane.model.Stats;

public class AirportFilter {

	public List<Stats> filers(List<Stats> original) {
		if (original == null || original.isEmpty()) {
			return null;
		}
		return original.stream().filter(n -> n.getSeats() >= (20 *250 / 100)).filter(n -> n.getCapacity() >= (70 *250 / 100))
				.collect(Collectors.toList());
	}

}
