package com.wegneto.codility.arrays;

public class CyclicRotation {

	public int[] solution(int[] A, int K) {
		if (K == 0 || A.length == 0 || (K % A.length) == 0) {
			return A;
		}

		int increment = K % A.length;
		int[] result = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			int index = i + increment;
			
			if (index >= A.length) {
				index -= A.length;
			}
			
			result[index] = A[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] test = new CyclicRotation().solution(new int[] { 0, 1, 2, 3, 4 }, 15897);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}

}
