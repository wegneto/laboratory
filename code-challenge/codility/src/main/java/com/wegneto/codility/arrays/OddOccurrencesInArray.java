package com.wegneto.codility.arrays;

public class OddOccurrencesInArray {

	public int solution(int[] arr) {
		if (arr.length == 1) {
			return arr[0];
		}

		int oe = 0;

		for (int i = 0; i < arr.length; i++) {
			oe ^= arr[i];
		}

		return oe;
	}

	public static void main(String[] args) {
		System.out.println(new OddOccurrencesInArray().solution(new int[] { 3, 3, 7, 9, 9, 9, 9 }));
	}

}
