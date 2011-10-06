package br.gov.serpro.inscricao.config;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource = "config", prefix = "inscricao")
public class InscricaoConfig {

	@Name("capacidade.turma")
	private int limiteTurma = 5;

	public int getLimiteTurma() {
		return limiteTurma;
	}

	public void setLimiteTurma(int limiteTurma) {
		this.limiteTurma = limiteTurma;
	}

}
