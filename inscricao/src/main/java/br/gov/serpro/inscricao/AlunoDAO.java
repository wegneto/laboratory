package br.gov.serpro.inscricao;

import java.util.List;

import javax.persistence.Query;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class AlunoDAO extends JPACrud<Aluno, Integer> {

	private static final long serialVersionUID = 1L;

	public List<Aluno> findByTurma(Turma turma) {
		String jpql = "select this from Aluno this where this.turma.id = :id";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("id", turma.getId());

		return query.getResultList();		
	}

	public List<Aluno> findByNomeTurma(String nome, Turma turma) {
		String jpql = "select this from Aluno this where this.nome = :nome and this.turma.id = :idTurma";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("nome", nome);
		query.setParameter("idTurma", turma.getId());

		return query.getResultList();
	}

}
