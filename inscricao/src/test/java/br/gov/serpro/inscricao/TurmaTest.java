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

	@Test(expected = TurmaException.class)
	public void falhaAoTentarMatricularAlunoDuplicado() {
		turma.matricular(new Aluno("Aluno 1"));
		turma.matricular(new Aluno("Aluno 1"));
	}

	@Test(expected = TurmaException.class)
	public void falhaAoTentarMatricularAlunoNaTurmaCheia() {
		for (int i = 1; i <= 5; i++) {
			turma.matricular(new Aluno("Aluno " + i));
		}

		turma.matricular(new Aluno("Aluno 6"));
	}

}
