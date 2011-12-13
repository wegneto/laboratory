package com.wilsonguimaraes;

public class Palpitador {

	public int getNumerologia(String string) {
		int soma = 0;

		for (int i = 0; i < string.length(); i++) {
			String caractere = string.substring(i, i + 1);

			if (caractere.matches("[0-9]")) {
				soma += Integer.valueOf(caractere);
			} else if (caractere.matches("[a-zA-Z]")) {
				soma++;
			}
		}

		if (soma > 9) {
			soma = getNumerologia(Integer.toString(soma));
		}

		return soma;
	}

}
