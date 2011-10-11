package br.gov.serpro.inscricao.business;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.security.RequiredPermission;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.gov.serpro.inscricao.config.InscricaoConfig;
import br.gov.serpro.inscricao.entity.Aluno;
import br.gov.serpro.inscricao.exception.TurmaException;

@BusinessController
public class TurmaBC {

	@Inject
	private Logger logger;

	@Inject
	private ResourceBundle bundle;

	@Inject
	private InscricaoConfig config;

	@Inject
	private AlunoBC alunoBC;

	@ExceptionHandler
	public void tratar(TurmaException e) {
		logger.warn(bundle.getString("matricula.erro"));
		throw e;
	}

	@Transactional
	@RequiredPermission(resource = "turma", operation = "matricular")
	public void matricular(Aluno aluno) {
		if (estaMatriculado(aluno) || obterAlunosMatriculados().size() == config.getCapacidadeTurma()) {
			throw new TurmaException();
		}

		alunoBC.insert(aluno);
		logger.info(bundle.getString("matricula.sucesso", aluno.getNome()));
	}

	@RequiredPermission(resource = "turma", operation = "consultar")
	public boolean estaMatriculado(Aluno aluno) {
		return obterAlunosMatriculados().contains(aluno);
	}

	private List<Aluno> obterAlunosMatriculados() {
		return alunoBC.findAll();
	}

	@Startup
	public void iniciar() {
		logger.info("O sistema de inscrições está no ar.");
	}
	
}
