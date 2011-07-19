package com.wilsonguimaraes;

import java.util.ArrayList;
import java.util.TreeSet;

public class Gerador {

	private static final int TOTAL_DEZENAS = 60;

	private static final int DEZENAS_VOLANTE = 6;

	public static void main(String[] args) {
		
		if (args.length > 0) {
			System.out.println("args.length: " + args.length);
		}
		
		ArrayList<TreeSet<Integer>> apostas = new ArrayList<TreeSet<Integer>>();

		apostas.addAll(gerarVolantes(10));
		
		for (TreeSet<Integer> volante : apostas) {
			System.out.println(volante);
		}

	}
	
	private static ArrayList<TreeSet<Integer>> gerarVolantes(int qtdVolantes) {
		
		ArrayList<TreeSet<Integer>> volantesGerados = new ArrayList<TreeSet<Integer>>();

		ArrayList<Integer> dezenasUtilizadas = new ArrayList<Integer>();

		TreeSet<Integer> volante = null;

		for (int i = 0; i < qtdVolantes; i++) {

			volante = new TreeSet<Integer>();

			while (volante.size() < DEZENAS_VOLANTE) {
				Integer dezena = 1 + (int) (Math.random() * TOTAL_DEZENAS);
				if (!dezenasUtilizadas.contains(dezena)) {
					volante.add(dezena);
				}
			}

			if (!verificarVolanteExistente(volantesGerados, volante)) {
				volantesGerados.add(volante);
				dezenasUtilizadas.addAll(volante);
				if (dezenasUtilizadas.size() == TOTAL_DEZENAS) {
					dezenasUtilizadas = new ArrayList<Integer>();
				}
			}

		}

		return volantesGerados;
		
	}

	private static boolean verificarVolanteExistente(ArrayList<TreeSet<Integer>> apostas, TreeSet<Integer> volante) {

		for (TreeSet<Integer> volanteRealizado : apostas) {
			if (volante.equals(volanteRealizado)) {
				return true;
			}
		}

		return false;

	}

}