package com.wegneto.codility.countingelements;

public class MissingInteger {

	public int solution(int[] arr) {
		boolean[] test = new boolean[arr.length + 1];

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] > 0 && arr[j] < arr.length + 1) {
				test[arr[j] - 1] = true;
			}
		}

		for (int j = 0; j < test.length; j++) {
			if (test[j] == false) {
				return j + 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		new MissingInteger().solution(new int[] { 1, 3, 6, 4, 1, 2 });
		new MissingInteger().solution(new int[] { 1 });
	}

}
