package br.gov.serpro.inscricao;

import java.util.ArrayList;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.util.ResourceBundle;

public class Turma {

	@Inject
	private Logger logger;
	
	@Inject
	private ResourceBundle bundle;
	
	private ArrayList<String> alunos = new ArrayList<String>();

	public void matricular(String aluno) {
		alunos.add(aluno);
		logger.info(bundle.getString("cadastro.aluno.sucesso", aluno));
	}

	public boolean estaMatriculado(String aluno) {
		if (alunos.contains(aluno)) {
			return true;
		}
		return false;
	}

}
