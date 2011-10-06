package br.gov.serpro.inscricao;

import java.util.ArrayList;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.stereotype.Controller;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@Controller
public class Turma {

	@Inject
	private Logger logger;
	
	@Inject
	private ResourceBundle messages;
	
	@Inject
	private InscricaoConfig config;
	
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	@ExceptionHandler
	public void tratarExcecao(TurmaException exception) {
		logger.warn("Ocorreu um erro ao matricular aluno.");
		throw exception;
	}

	public void matricular(Aluno aluno) {
		if (estaMatriculado(aluno) || alunos.size() >= config.getCapTurma()) {
			throw new TurmaException();
		}
		alunos.add(aluno);
		logger.info(messages.getString("cadastro.aluno.sucesso", aluno));
	}

	public boolean estaMatriculado(Aluno aluno) {
		if (alunos.contains(aluno)) {
			return true;
		}
		return false;
	}

}
