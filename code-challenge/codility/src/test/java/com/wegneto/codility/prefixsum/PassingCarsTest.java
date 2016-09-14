package com.wegneto.codility.prefixsum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PassingCarsTest {

	@Test
	public void simpleTest() {
		PassingCars pc = new PassingCars();
		int result = pc.solution(new int[] { 0, 1, 0, 1, 1 });
		assertEquals(5, result);
	}

	@Test
	public void simpleAlternate() {
		PassingCars pc = new PassingCars();
		int result = pc.solution(new int[] { 0, 1, 0, 1, 0, 1, 0, 1 });
		assertEquals(10, result);
	}

	@Test
	public void test() {
		PassingCars pc = new PassingCars();
		int result = pc.solution(new int[] { 0, 0, 0, 0, 1, 1, 1, 1 });
		assertEquals(16, result);
	}

}
