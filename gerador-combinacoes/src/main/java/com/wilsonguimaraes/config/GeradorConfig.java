package com.wilsonguimaraes.config;

import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource = "gerador")
public class GeradorConfig {

	private int totalDezenas = 60;

	private int dezenasVolante = 6;

	private String nomeCompleto;

	private String mesNascimento;

	private String diaNascimento;

	private String anoNascimento;

	private String diaAposta;

	private String mesAposta;

	private String diaSemanaAposta;

	public int getTotalDezenas() {
		return totalDezenas;
	}

	public int getDezenasVolante() {
		return dezenasVolante;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
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

	public String getDiaAposta() {
		return diaAposta;
	}

	public String getMesAposta() {
		return mesAposta;
	}

	public String getDiaSemanaAposta() {
		return diaSemanaAposta;
	}

}
