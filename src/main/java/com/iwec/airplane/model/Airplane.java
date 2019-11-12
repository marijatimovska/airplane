package com.iwec.airplane.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airplane {

	private Integer id;

	@NonNull
	private String manufacturer;

	@NonNull
	private String model;

	private int totalSeats;

	private double totalCapacity;

	public Airplane(@NonNull String manufacturer, @NonNull String model, int totalSeats, double totalCapacity) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.totalSeats = totalSeats;
		this.totalCapacity = totalCapacity;
	}

}
