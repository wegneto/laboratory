package com.wegneto.codility.countingelements;

public class MissingInteger {

	public int solution(int[] arr) {
		int minSoFar = 1;
		int i = 0;
		
		while (i < arr.length) {
			if (arr[i] == minSoFar) {
				minSoFar++;
				i = 0;
			}
			i++;
		}
		
		System.out.println(minSoFar);
		
		return minSoFar;
	}

	public static void main(String[] args) {
		new MissingInteger().solution(new int[] { 1, 3, 6, 4, 1, 2 });
	}

}
