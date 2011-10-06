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
	public void inserir(Aluno aluno) {
		entityManager.persist(aluno);
	}
	
	public List<Aluno> findAll() {
		Query query = entityManager.createQuery("select this from Aluno this");

		return query.getResultList();
	}
	
	public List<Aluno> findByNome(String nome) {
		String jpql = "select this from Aluno this where this.nome = :nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", nome);

		return query.getResultList();
	}

}
