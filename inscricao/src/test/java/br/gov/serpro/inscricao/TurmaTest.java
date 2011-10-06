package br.gov.serpro.inscricao;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class TurmaTest {
	
	@Inject
	private Turma turma;
	
	@Test
	public void matricularAlunoComSucesso() {
		
		String aluno = "Aluno 1";
		
		turma.matricular(aluno);
		
		Assert.assertTrue(turma.estaMatriculado(aluno));
		
	}
	
	@Test
	public void falhaAoTentarMatricularAlunoDuplicado() {
		String aluno = "Aluno 1";
		
		turma.matricular(aluno);
		
		try {
			turma.matricular(aluno);
			Assert.fail();
		} catch (TurmaException e) {
		}
		
	}
	
	@Test
	public void falhaAoTentarMatricularAlunoNaTurmaCheia() {
		turma.matricular("Aluno 1");
		turma.matricular("Aluno 2");
		turma.matricular("Aluno 3");
		turma.matricular("Aluno 4");
		turma.matricular("Aluno 5");
		
		try {
			turma.matricular("Aluno 6");
			Assert.fail();
		} catch (TurmaException e) {
		}
		
	}

}
