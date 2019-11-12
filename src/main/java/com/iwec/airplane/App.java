package com.iwec.airplane;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iwec.airplane.airport.AirportFilter;
import com.iwec.airplane.file.menager.CSVReader;
import com.iwec.airplane.file.menager.FWReader;
import com.iwec.airplane.file.menager.FileMenager;
import com.iwec.airplane.model.Airplane;
import com.iwec.airplane.model.Stats;
import com.iwec.csv.menager.CSVMenager;

@Component
public class App {
	public static final String SOURCE = "stats.txt";
	public static final String SOURCEB = "airplanes.txt";

	public void run(){
		AirportFilter ac = new AirportFilter();

		// Readind FW file
		FileMenager<Stats> readerFW = new FWReader();
		List<Stats> list = readerFW.read(SOURCE);

		// Reading CSV file
		FileMenager<Airplane> readerCSV = new CSVReader();
		List<Airplane> listCSV = readerCSV.read(SOURCEB);
		

		// Filtering airplane stats
		List<Stats> result = ac.filers(list);

		// Determinate which airplanes can fly
		List<Airplane> canFly = listCSV.stream().filter((Airplane h) -> {
			return result.stream().anyMatch(s -> s.getId() == h.getId());
		}).collect(Collectors.toList());

		//CSVParserJson ps = new CSVParserJson();
		//List<String> lp = ps.convertToString(canFly);
		//readerFW.write("proba.csv", lp);
		
		CSVMenager test = new CSVMenager();
		File file = new File("working.csv");
		test.csvMenager(canFly, file);
	}

}
/*
 * OTHER TEST EXAMPLES ▼▼▼▼▼▼▼▼▼▼
 * 
 * Print ids. List<Integer> ids =
 * listCSV.stream().map(Airplane::getId).collect(Collectors.toList());
 * 
 * This uses the Collections.disjoint() method, which returns true when two
 * collections have no elements in common. boolean anyMatch =
 * !Collections.disjoint(new HashSet<>(listCSV), result);
 * 
 * canFly.stream().forEach(n -> System.out.println(n));
 * 
 * String chString = canFly.stream().map(n ->
 * n.toString()).collect(Collectors.joining(","));
 * 
 * List<String> strings = canFly.stream().map(n ->
 * n.toString()).collect(Collectors.toList()); strings.stream().forEach(n ->
 * System.out.println(n));
 * 
 * List<String> test =
 * canFly.stream().map(n->n.getManufacturer()).collect(Collectors.toList());
 * 
 * 	/*for (AirplaneStats airplane : list) {
 *	for (Airplane airplane2 : listCSV) {
 *				
 *			}
 *	}
 */

