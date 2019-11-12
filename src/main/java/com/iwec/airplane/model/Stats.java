package com.iwec.airplane.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stats {

	private Integer id;

	private int seats;

	private double capacity;

}
