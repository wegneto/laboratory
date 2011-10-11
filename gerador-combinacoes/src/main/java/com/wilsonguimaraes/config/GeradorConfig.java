package com.wilsonguimaraes.config;

import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource = "gerador")
public class GeradorConfig {

	private int totalDezenas = 60;

	private int dezenasVolante = 6;

	private String nomeConcurso;

	private String dataSorteio;

	private String horaSorteio;

	private String localSorteio;

	private String numeroConcurso;

	private String valorAcumulado;

	private String estimativaPremio;

	// dados apostador
	private String nomeApostador;

	private String dataNascimento;

	// dados aposta
	private String dataAposta;

	private String diaSemanaAposta;

	public int getTotalDezenas() {
		return totalDezenas;
	}

	public int getDezenasVolante() {
		return dezenasVolante;
	}

	public String getNomeConcurso() {
		return nomeConcurso;
	}

	public String getDataSorteio() {
		return dataSorteio;
	}

	public String getHoraSorteio() {
		return horaSorteio;
	}

	public String getLocalSorteio() {
		return localSorteio;
	}

	public String getNumeroConcurso() {
		return numeroConcurso;
	}

	public String getValorAcumulado() {
		return valorAcumulado;
	}

	public String getEstimativaPremio() {
		return estimativaPremio;
	}

	public String getNomeApostador() {
		return nomeApostador;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getDataAposta() {
		return dataAposta;
	}

	public String getDiaSemanaAposta() {
		return diaSemanaAposta;
	}

}
