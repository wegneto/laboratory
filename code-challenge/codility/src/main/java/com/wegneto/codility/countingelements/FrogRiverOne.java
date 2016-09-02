package com.wegneto.codility.countingelements;

public class FrogRiverOne {

	public int solution(int X, int[] A) {
		int[] result = new int[X];
		
		for (int i = 0; i < A.length; i++) {
			if (result[A[i]-1] == 0) {
				result[A[i]-1] = i;
			}
		}
		
		int greatest = -1;
		
		for (int i = 0; i < result.length; i++) {
			if (greatest < result[i]) {
				greatest = result[i];
			}
		}
		
		return greatest;
	}

	public static void main(String[] args) {
		new FrogRiverOne().solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 });
	}

}
