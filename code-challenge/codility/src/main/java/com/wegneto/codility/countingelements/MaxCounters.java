package com.wegneto.codility.countingelements;

public class MaxCounters {

	public int[] solution(int N, int[] A) {
		int[] result = new int[N];
		int currentMax = 0, maxCounter = 0;

		for (int k = 0; k < A.length; k++) {
			if (A[k] >= 1 && A[k] <= N) {
				// increase(X)
				if (result[A[k] - 1] < maxCounter) {
					result[A[k] - 1] = maxCounter;
				}

				result[A[k] - 1]++;

				if (result[A[k] - 1] > currentMax) {
					currentMax = result[A[k] - 1];
				}
			} else if (A[k] == (N + 1)) {
				// maxcounter
				maxCounter = currentMax;
			}
		}

		for (int i = 0; i < result.length; i++) {
			if (result[i] < maxCounter) {
				result[i] = maxCounter;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		new MaxCounters().solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 });
		new MaxCounters().solution(5, new int[] { 3, 4, 4, 6, 1, 4, 6 });
	}

}
