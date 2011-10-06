package br.gov.serpro.inscricao;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource = "config", prefix = "inscricao")
public class InscricaoConfig {

	@Name("capacidade.turma")
	private int capTurma = 5;

	public int getCapTurma() {
		return capTurma;
	}

	public void setCapTurma(int capTurma) {
		this.capTurma = capTurma;
	}

}
