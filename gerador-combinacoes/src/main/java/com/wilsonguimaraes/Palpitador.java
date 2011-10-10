package com.wilsonguimaraes;

import javax.enterprise.event.Observes;

import org.jboss.weld.environment.se.StartMain;
import org.jboss.weld.environment.se.events.ContainerInitialized;

public class Palpitador {
	
	private int calcular(String valor) {
		int soma = 0;

		for (int i = 0; i < valor.length(); i++) {
			soma += Integer.parseInt(valor.substring(i, i + 1));
		}

		if (soma > 9) {
			soma = calcular(Integer.toString(soma));
		}
		
		return soma;
	}

	public int getNumerologia(String string) {
		int total = 0;
		
		for (int i = 0; i < string.length(); i++) {
			String caractere = string.substring(i, i + 1);
			
			if (caractere.matches("[0-9]")) {
				total += Integer.valueOf(caractere);
			} else if (caractere.matches("[a-zA-Z]")) {
				total++;
			}
		}
		
		return calcular(Integer.toString(total));
	}

	public void start(@Observes ContainerInitialized event) {
	}

	public static void main(String[] args) {
		new StartMain(args).go();
	}

}
