package com.wegneto.codility.arrays;

public class OddOccurrencesInArray {

	public int solution(int[] arr) {
		int oe = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(oe + " ^= " + arr[i] + " = " + (oe ^= arr[i]));
			//oe ^= arr[i];
		}

		return oe;
	}

	public static void main(String[] args) {
		System.out.println(new OddOccurrencesInArray().solution(new int[] { 9, 3, 9, 9, 7, 3, 9 }));
	}

}
