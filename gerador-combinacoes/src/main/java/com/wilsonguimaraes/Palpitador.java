package com.wilsonguimaraes;

import java.util.regex.Pattern;

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
		String valor = string.replaceAll(" ", "");
		Pattern p = Pattern.compile("\\D");

		if (p.matcher(valor).find()) {
			valor = Integer.toString(valor.length());
		}

		return calcular(valor);
	}

	public void start(@Observes ContainerInitialized event) {
	}

	public static void main(String[] args) {
		new StartMain(args).go();
	}

}
