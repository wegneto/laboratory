package com.wegneto.codility.timecomplexity;

public class TapeEquilibrium {

	public int solution(int[] arr) {
		int lSum = arr[0];
		int rSum = 0;
		
		for (int i = 1; i < arr.length; i++) {
			rSum += arr[i];
		}

		int min = Math.abs(lSum - rSum);
		
		for (int i = 1; i < arr.length - 1; i++) {
			lSum += arr[i];
			rSum -= arr[i];
			
			int diff = Math.abs(lSum - rSum);
			
			if (diff < min) {
				min = diff;
			}
		}

		return min;
	}

	public static void main(String[] args) {
		new TapeEquilibrium().solution(new int[] { -2000, 2000 });
	}

}