package br.gov.serpro.inscricao;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class AlunoBC extends DelegateCrud<Aluno, Integer, AlunoDAO> {

	private static final long serialVersionUID = 1L;

	public List<Aluno> findByTurma(Turma turma) {
		return getDelegate().findByTurma(turma);
	}

	public List<Aluno> findByNomeTurma(String nome, Turma turma) {
		return getDelegate().findByNomeTurma(nome, turma);
	}

}
