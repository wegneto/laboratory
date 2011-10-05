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
	public void cadastrarComSucesso() {
		
		String aluno = "Aluno 1";
		
		turma.matricular(aluno);
		
		Assert.assertTrue(turma.estaMatriculado(aluno));
		
	}

}
