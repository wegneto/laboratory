package br.gov.serpro.inscricao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.stereotype.Controller;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@Controller
public class Turma {

	@Inject
	private Logger logger;

	@Inject
	private ResourceBundle messages;

	@Inject
	private InscricaoConfig config;

	@Inject
	private EntityManager entityManager;

	@ExceptionHandler
	public void tratarExcecao(TurmaException exception) {
		logger.warn("Ocorreu um erro ao matricular aluno.");
		throw exception;
	}

	public void matricular(Aluno aluno) {
		Query query = entityManager.createQuery("select count(this) from Aluno this");
		Long qtdAlunosMatriculados = (Long) query.getSingleResult();

		if (estaMatriculado(aluno) || qtdAlunosMatriculados >= config.getCapTurma()) {
			throw new TurmaException();
		}

		entityManager.getTransaction().begin();
		entityManager.persist(aluno);
		entityManager.getTransaction().commit();

		logger.info(messages.getString("cadastro.aluno.sucesso", aluno.getNome()));
	}

	public boolean estaMatriculado(Aluno aluno) {
		String jpql = "select this from Aluno this where this.nome = :nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", aluno.getNome());

		return query.getResultList().size() > 0;
	}

}
