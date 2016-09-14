package com.wegneto.codility.prefixsum;

public class PassingCars {

	public int solution(int[] A) {
		int count0 = 0;
		long sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				count0++;
			} else {
				sum += count0;
			}
		}
		
		if (sum > 1000000000) {
			return -1;
		} else {
			return (int) sum;
		}
		
	}
	
}
