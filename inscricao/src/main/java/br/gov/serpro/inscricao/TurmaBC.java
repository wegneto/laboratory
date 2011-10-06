package br.gov.serpro.inscricao;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.security.RequiredPermission;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@BusinessController
public class TurmaBC extends DelegateCrud<Turma, Integer, TurmaDAO>{

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;

	@Inject
	private ResourceBundle bundle;

	@Inject
	private InscricaoConfig config;

	@Inject
	private AlunoBC alunoBC;

	@ExceptionHandler
	public void tratarExcecao(TurmaException exception) {
		logger.warn("Ocorreu um erro ao matricular aluno.");
		throw exception;
	}

	@Transactional
	@RequiredPermission(resource="turma", operation="matricular")
	public void matricular(Aluno aluno, Turma turma) {
		int qtdAlunosMatriculados = alunoBC.findByTurma(turma).size();

		if (estaMatriculado(aluno, turma) || qtdAlunosMatriculados == config.getLimiteTurma()) {
			throw new TurmaException();
		}

		alunoBC.insert(aluno);
		if (turma.getId() == null) {
			getDelegate().insert(turma);
		}

		aluno.setTurma(turma);
		alunoBC.update(aluno);

		logger.info(bundle.getString("matricula.sucesso", aluno.getNome()));
	}

	public boolean estaMatriculado(Aluno aluno, Turma turma) {
		return alunoBC.findByNomeTurma(aluno.getNome(), turma).size() > 0;
	}
	
}
