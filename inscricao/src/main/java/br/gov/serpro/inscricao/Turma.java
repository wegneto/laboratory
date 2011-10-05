package br.gov.serpro.inscricao;

import java.util.ArrayList;

import javax.inject.Inject;

import org.slf4j.Logger;

public class Turma {

	@Inject
	private Logger logger;
	
	private ArrayList<String> alunos = new ArrayList<String>();

	public void matricular(String aluno) {
		alunos.add(aluno);
		logger.info("Cadastro realizado com sucesso");
	}

	public boolean estaMatriculado(String aluno) {
		if (alunos.contains(aluno)) {
			return true;
		}
		return false;
	}

}
