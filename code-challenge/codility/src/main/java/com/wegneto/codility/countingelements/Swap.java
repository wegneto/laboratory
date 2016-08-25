package com.wegneto.codility.countingelements;

public class Swap {

	public boolean solution(int[] A, int[] B, int m) {
		int sumA = 0;
		int sumB = 0;
		
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
			sumB += B[i];
		}
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int change = B[j] - A[i];
				sumA += change;
				sumB -= change;
				if (sumA == sumB) {
					System.out.println("swap B[j]: " + B[j] + " por A[i]: " + A[i]);
					return true;
				}
				sumA -= change;
				sumB += change;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		new Swap().solution(new int[] { 4, 5 }, new int[] { 5, 6 }, 6);
	}

}
