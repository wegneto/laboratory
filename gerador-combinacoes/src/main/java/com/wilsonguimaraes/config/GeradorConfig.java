package com.wilsonguimaraes.config;

import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource = "gerador")
public class GeradorConfig {

	private int totalDezenas = 60;

	private int dezenasVolante = 6;

	private String nome;

	private String diaNascimento;

	private String mesNascimento;

	private String anoNascimento;

	public String getNome() {
		return nome;
	}

	public String getDiaNascimento() {
		return diaNascimento;
	}

	public String getMesNascimento() {
		return mesNascimento;
	}

	public String getAnoNascimento() {
		return anoNascimento;
	}

	public int getDezenasVolante() {
		return dezenasVolante;
	}

	public int getTotalDezenas() {
		return totalDezenas;
	}

}
