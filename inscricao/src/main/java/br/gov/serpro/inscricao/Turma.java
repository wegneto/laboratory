package br.gov.serpro.inscricao;

import java.util.ArrayList;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.util.ResourceBundle;

public class Turma {

	@Inject
	private Logger logger;
	
	@Inject
	private ResourceBundle messages;
	
	private ArrayList<String> alunos = new ArrayList<String>();

	public void matricular(String aluno) {
		if (estaMatriculado(aluno) || alunos.size() >= 5) {
			throw new RuntimeException();
		}
		alunos.add(aluno);
		logger.info(messages.getString("cadastro.aluno.sucesso", aluno));
	}

	public boolean estaMatriculado(String aluno) {
		if (alunos.contains(aluno)) {
			return true;
		}
		return false;
	}

}