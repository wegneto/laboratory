package com.wegneto.codility.countingelements;

import java.util.Arrays;

public class MaxCounters {

	public int[] solution(int N, int[] A) {
		int[] result = new int[N];
		int maxValue = 0;

		for (int k = 0; k < A.length; k++) {
			if (A[k] >= 1 && A[k] <= N) {
				// increase(X)
				result[A[k]-1]++;
				
				if (result[A[k]-1] > maxValue) {
					maxValue = result[A[k]-1];
				}
				
				
			} else if (A[k] == (N + 1)) {
				// maxcounter
				Arrays.fill(result, maxValue);
			}
			
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			
			System.out.println(" ");
			
		}

		return result;
	}

	public static void main(String[] args) {
		new MaxCounters().solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 });
	}

}
