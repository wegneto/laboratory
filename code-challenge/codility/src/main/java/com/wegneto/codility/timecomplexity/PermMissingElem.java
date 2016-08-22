package com.wegneto.codility.timecomplexity;

public class PermMissingElem {

	public int solution(final int[] arr) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		final long N = arr.length + 1;
		final long gaussSum = (N * (N + 1)) / 2;

		return (int)(gaussSum - sum);
	}

	public static void main(String[] args) {
		new PermMissingElem().solution(new int[] { });
	}

}
