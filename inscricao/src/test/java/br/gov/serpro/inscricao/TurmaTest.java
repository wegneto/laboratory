package br.gov.serpro.inscricao;

import junit.framework.Assert;

import org.junit.Test;

public class TurmaTest {
	
	@Test
	public void cadastrarComSucesso() {
		Turma turma = new Turma();
		
		String aluno = "Aluno 1";
		
		turma.matricular(aluno);
		
		Assert.assertTrue(turma.estaMatriculado(aluno));
		
	}

}
