package br.gov.serpro.inscricao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class TurmaTest {
	
	@Inject
	private TurmaBC turma;
	
	@Inject
	private EntityManager entityManager;
	
	@Before
	public void setUp() {
		final String jpql = "select this from " + Aluno.class.getSimpleName() + " this";
		final Query query = entityManager.createQuery(jpql);

		List<Aluno> lista = query.getResultList();

		entityManager.getTransaction().begin();
		
		for (Aluno aluno : lista) {
			entityManager.remove(aluno);
		}
		
		entityManager.getTransaction().commit();
	}
	
	@Test
	public void matricularAlunoComSucesso() {
		Aluno aluno = new Aluno("Aluno 1");
		turma.matricular(aluno);
		Assert.assertTrue(turma.estaMatriculado(aluno));
	}
	
	@Test
	public void falhaAoTentarMatricularAlunoDuplicado() {
		turma.matricular(new Aluno("Aluno 2"));
		
		try {
			turma.matricular(new Aluno("Aluno 2"));
			Assert.fail();
		} catch (TurmaException e) {
		}
	}
	
	@Test
	public void falhaAoTentarMatricularAlunoNaTurmaCheia() {
		turma.matricular(new Aluno("Aluno 3"));
		turma.matricular(new Aluno("Aluno 4"));
		turma.matricular(new Aluno("Aluno 5"));
		turma.matricular(new Aluno("Aluno 6"));
		turma.matricular(new Aluno("Aluno 7"));
		
		try {
			turma.matricular(new Aluno("Aluno 8"));
			Assert.fail();
		} catch (TurmaException e) {
		}
	}

}
