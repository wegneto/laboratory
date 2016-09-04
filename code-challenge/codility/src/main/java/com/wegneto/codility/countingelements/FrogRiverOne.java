package com.wegneto.codility.countingelements;

public class FrogRiverOne {

	public int solution(int X, int[] A) {
		int[] result = new int[X];
		
		for (int i = 0; i < A.length; i++) {
			if (result[A[i]-1] == 0) {
				result[A[i]-1] = i + 1;
			}
		}
		
		int greatest = -1;
		
		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0 && greatest < result[i]) {
				greatest = result[i] - 1;
			} else if (result[i] == 0) {
				greatest = -1;
				break;
			}
		}
		
		return greatest;
	}

	public static void main(String[] args) {
		System.out.println(new FrogRiverOne().solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		System.out.println(new FrogRiverOne().solution(5, new int[] { 3 }));
		System.out.println(new FrogRiverOne().solution(1, new int[] { 1 }));
	}

}
