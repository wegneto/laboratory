package br.gov.serpro.inscricao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@PersistenceController
public class TurmaDAO {

	@Inject
	private EntityManager entityManager;

	@Transactional
	public void inserir(Turma turma) {
		entityManager.persist(turma);
	}
	
	public List<Aluno> findAll() {
		Query query = entityManager.createQuery("select this from Aluno this");

		return query.getResultList();
	}

}

