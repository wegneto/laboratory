package com.wegneto.codility.prefixsum;

public class PassingCars {

	public int solution(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] < A[j]) {
					count++;
				}
			}
		}
		
		return count;
	}
	
}
