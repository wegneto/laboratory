package br.gov.serpro.inscricao;

import java.util.List;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.frameworkdemoiselle.security.SecurityContext;

@RunWith(DemoiselleRunner.class)
public class TurmaTest {

	@Inject
	private TurmaBC turmaBC;

	@Inject
	private AlunoBC alunoBC;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private InscricaoCredential credential;

	@Before
	public void setUp() {
		
		credential.setLogin("creuza");
		credential.setPassword("amor");
		securityContext.login();
		
		List<Aluno> listaAlunos = alunoBC.findAll();
		for (Aluno aluno : listaAlunos) {
			alunoBC.delete(aluno.getMatricula());
		}
		
		List<Turma> listaTurmas = turmaBC.findAll();
		for (Turma turma : listaTurmas) {
			turmaBC.delete(turma.getId());
		}
	}

	@Test
	public void matricularAlunoComSucesso() {
		Turma turma = new Turma("Turma 1");
		Aluno aluno = new Aluno("Aluno 1");
		turmaBC.matricular(aluno, turma);
		Assert.assertTrue(turmaBC.estaMatriculado(aluno, turma));
	}

	@Test(expected = TurmaException.class)
	public void falhaAoTentarMatricularAlunoDuplicado() {
		Turma turma = new Turma("Turma 1");
		turmaBC.matricular(new Aluno("Aluno 1"), turma);
		turmaBC.matricular(new Aluno("Aluno 1"), turma);
	}

	@Test(expected = TurmaException.class)
	public void falhaAoTentarMatricularAlunoNaTurmaCheia() {
		Turma turma = new Turma("Turma 1");

		for (int i = 1; i <= 5; i++) {
			turmaBC.matricular(new Aluno("Aluno " + i), turma);
		}

		turmaBC.matricular(new Aluno("Aluno 6"), turma);
	}

}
