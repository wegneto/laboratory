package com.wegneto.codility.countingelements;

public class PermCheck {

	public int solution(final int[] arr) {
		final int N = arr.length;
		int[] control = new int[N];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > N) {
				return 0;
			}
			control[arr[i]-1]++;
			if (control[arr[i]-1] > 1) {
				return 0;
			}
		}

		return 1;
	}

	public static void main(String[] args) {
		System.out.println(new PermCheck().solution(new int[] { 4, 1, 3, 2 }));
		System.out.println(new PermCheck().solution(new int[] { 4, 1, 3 }));
		System.out.println(new PermCheck().solution(new int[] { 1, 4, 1 }));
		System.out.println(new PermCheck().solution(new int[] { 1, 1, 3 }));
	}

}
