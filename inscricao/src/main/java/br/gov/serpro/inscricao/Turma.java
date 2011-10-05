package br.gov.serpro.inscricao;

import java.util.ArrayList;

public class Turma {

	private ArrayList<String> alunos = new ArrayList<String>();

	public void matricular(String aluno) {
		alunos.add(aluno);
	}

	public boolean estaMatriculado(String aluno) {
		if (alunos.contains(aluno)) {
			return true;
		}
		return false;
	}

}
