package com.wilsonguimaraes.loteria.util;

import java.util.HashMap;
import java.util.Map;

public class Distribuidor {

	public Map<Integer, Integer> obterDistribuicao(Integer valor) {
		Map<Integer, Integer> retorno = new HashMap<Integer, Integer>();

		int qtdJogos = 0;
		
		qtdJogos = calcular(valor, 14);
		if (qtdJogos != 0) {
			retorno.put(7, qtdJogos);
		}
		
		qtdJogos = calcular(valor, 2);
		if (qtdJogos != 0) {
			retorno.put(6, qtdJogos);
		}
		
		System.out.println(valor + " - > " + retorno);

		return retorno;
	}

	private int calcular(int valor, int custoAposta) {
		int qtdJogos = valor / custoAposta;
		return qtdJogos;
	}

}
