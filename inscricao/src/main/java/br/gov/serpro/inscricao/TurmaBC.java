package br.gov.serpro.inscricao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@BusinessController
public class TurmaBC {

	@Inject
	private Logger logger;

	@Inject
	private ResourceBundle bundle;

	@Inject
	private InscricaoConfig config;

	@Inject
	private TurmaDAO dao;

	@ExceptionHandler
	public void tratarExcecao(TurmaException exception) {
		logger.warn("Ocorreu um erro ao matricular aluno.");
		throw exception;
	}

	@Transactional
	public void matricular(Aluno aluno) {
		int qtdAlunosMatriculados = dao.findAll().size();

		if (estaMatriculado(aluno) || qtdAlunosMatriculados == config.getLimiteTurma()) {
			throw new TurmaException();
		}

		dao.inserir(aluno);

		logger.info(bundle.getString("matricula.sucesso", aluno.getNome()));
	}

	public boolean estaMatriculado(Aluno aluno) {
		return dao.findByNome(aluno.getNome()).size() > 0;
	}

}
