package br.gov.serpro.inscricao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class TurmaTest {
	
	@Test
	public void cadastrarComSucesso() {
		Turma turma = new Turma();
		
		String aluno = "Aluno 1";
		
		turma.matricular(aluno);
		
		Assert.assertTrue(turma.estaMatriculado(aluno));
		
	}

}
