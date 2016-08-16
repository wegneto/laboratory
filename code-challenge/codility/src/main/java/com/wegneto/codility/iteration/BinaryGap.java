package com.wegneto.codility.iteration;

public class BinaryGap {

	public int solution(int N) {
		String binary = "";
		while (N >= 1) {
			int resto = (N % 2);
			N = N / 2;
			binary = resto + binary;
		}

		binary = (binary.isEmpty() ? "00" : binary);

		System.out.println(binary);
		int found = 0;
		int aux = 0;
		
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '0') {
				aux++;
			} else if (aux > 0) {
				if (aux > found) {
					found = aux;
				}
				aux = 0;
			}
			
		}
		System.out.println(found);
		
		return found;
	}

	public static void main(String[] args) {
		new BinaryGap().solution(35);
	}

}
