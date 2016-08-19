package com.wegneto.codility.timecomplexity;

public class FrogJmp {

	public int solution(int X, int Y, int D) {
		return (int) Math.ceil((double) (Y - X) / D);
	}

	public static void main(String[] args) {
		new FrogJmp().solution(5, 105, 3);
	}

}
