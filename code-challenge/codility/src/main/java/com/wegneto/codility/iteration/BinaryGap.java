package com.wegneto.codility.iteration;

public class BinaryGap {

	public int solution(int N) {
		String binary = Integer.toBinaryString(N);
		
		int max = 0;
		int aux = 0;
		
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '0') {
				aux++;
			} else if (aux > 0) {
				if (aux > max) {
					max = aux;
				}
				aux = 0;
			}
			
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		new BinaryGap().solution(1047);
	}

}
