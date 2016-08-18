package com.wegneto.codility.arrays;

public class CyclicRotation {

	public int[] solution(int[] array, int rotations) {
		if (rotations == 0 || array.length == 0 || (rotations % array.length) == 0) {
			return array;
		}

		int increment = rotations % array.length;
		int[] result = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			int index = i + increment; 
			
			if (index >= array.length) {
				index -= array.length;
			}
			
			result[index] = array[i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		new CyclicRotation().solution(new int[] { 0, 1, 2, 3, 4 }, 3);
	}

}
