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
		Aluno aluno = new Aluno("Aluno 1", 123);
		
		turma.matricular(aluno);
		
		Assert.assertTrue(turma.estaMatriculado(aluno));
	}
	
	@Test
	public void falhaAoTentarMatricularAlunoDuplicado() {
		
		turma.matricular(new Aluno("Aluno 1", 123));
		
		try {
			turma.matricular(new Aluno("Aluno 1", 123));
			Assert.fail();
		} catch (TurmaException e) {
		}
		
	}
	
	@Test
	public void falhaAoTentarMatricularAlunoNaTurmaCheia() {
		turma.matricular(new Aluno("Aluno 1", 123));
		turma.matricular(new Aluno("Aluno 2", 124));
		turma.matricular(new Aluno("Aluno 3", 125));
		turma.matricular(new Aluno("Aluno 4", 126));
		turma.matricular(new Aluno("Aluno 5", 127));
		
		try {
			turma.matricular(new Aluno("Aluno 6", 128));
			Assert.fail();
		} catch (TurmaException e) {
		}
		
	}

}
