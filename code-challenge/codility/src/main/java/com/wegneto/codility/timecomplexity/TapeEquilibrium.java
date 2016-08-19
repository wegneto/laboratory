package com.wegneto.codility.timecomplexity;

public class TapeEquilibrium {

	public int solution(int[] arr) {
		int sum = 0;
		int[] leftValues = new int[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++) {
			sum += arr[i];
			leftValues[i] = sum;
		}

		int[] rightValues = new int[arr.length - 1];
		sum = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			sum += arr[i];
			rightValues[i - 1] = sum;
		}

		sum = Math.abs(leftValues[0] - rightValues[0]);
		for (int i = 1; i < arr.length - 1; i++) {
			int aux = Math.abs(leftValues[i] - rightValues[i]);
			if (aux < sum) {
				sum = aux;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		new TapeEquilibrium().solution(new int[] { -2000, 2000 });
	}

}