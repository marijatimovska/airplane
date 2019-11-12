package com.iwec.airplane.airport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iwec.airplane.model.Stats;

@ExtendWith(MockitoExtension.class)
public class AirportCalcTest {

	@Spy
	private List<Stats> spyList = new ArrayList<>();
	
	@Spy
	private List<Stats> mockList = new ArrayList<>();

	@InjectMocks
	private AirportFilter calc;

	@BeforeEach
	public void setUp() {
		calc = new AirportFilter();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testWhenListHasMoreElements() {

		spyList.add(new Stats(1, 250, 27000));
		spyList.add(new Stats(2, 260, 29000));
		spyList.add(new Stats(3, 90, 10000));
		spyList.add(new Stats(4, 70, 11000));

		Mockito.verify(spyList).add(new Stats(1, 250, 27000));
		Mockito.verify(spyList).add(new Stats(2, 260, 29000));
		Mockito.verify(spyList).add(new Stats(3, 90, 10000));
		Mockito.verify(spyList).add(new Stats(4, 70, 11000));
		
		mockList.add(new Stats(1, 250, 27000));
		mockList.add(new Stats(2, 260, 29000));
		Mockito.verify(mockList).add(new Stats(1, 250, 27000));
		Mockito.verify(mockList).add(new Stats(2, 260, 29000));

		List<Stats> result = calc.filers(spyList);
	
		assertIterableEquals(mockList, result);
		assertEquals(new Stats(1, 250, 27000), result.get(0));
		assertEquals(new Stats(2, 260, 29000), result.get(1));
	}

	@Test
	public void testWhenListHasElements() {

		spyList.add(new Stats(1, 250, 27000));
		spyList.add(new Stats(2, 90, 10000));
		spyList.add(new Stats(3, 70, 11000));

		Mockito.verify(spyList).add(new Stats(1, 250, 27000));
		Mockito.verify(spyList).add(new Stats(2, 90, 10000));
		Mockito.verify(spyList).add(new Stats(3, 70, 11000));

		List<Stats> result = calc.filers(spyList);

		assertEquals(new Stats(1, 250, 27000), result.get(0));
	}

	@Test
	public void testWhenListIsEmpty() {
		when(spyList.isEmpty()).thenReturn(true);
		List<Stats> result = calc.filers(spyList);
		assertEquals(null, result);
	}

	@Test
	public void testWhenListIsNull() {
		List<Stats> result = calc.filers(null);
		assertNull(result);
	}

}
/*
 * Mockito.when(mockedList.size()).thenReturn(3);
 * Mockito.when(mockedList.get(0)).thenReturn(new AirplaneStats(1, 250, 27000));
 * Mockito.when(mockedList.get(1)).thenReturn(new AirplaneStats(1, 90, 10000));
 * Mockito.when(mockedList.get(2)).thenReturn(new AirplaneStats(1, 70, 11000));
 */
