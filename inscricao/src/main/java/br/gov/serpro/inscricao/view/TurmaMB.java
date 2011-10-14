package br.gov.serpro.inscricao.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.serpro.inscricao.business.TurmaBC;
import br.gov.serpro.inscricao.entity.Aluno;

@ViewController
public class TurmaMB {

	@Inject
	private TurmaBC bc;

	private String nomeAluno;

	@Inject
	private FacesContext facesContext;

	public List<Aluno> getAlunosMatriculados() {
		return bc.obterAlunosMatriculados();
	}

	public void matricular() {
		bc.matricular(new Aluno(getNomeAluno()));
		facesContext.addMessage("sucesso", new FacesMessage("Cadastro realizado com sucesso"));
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

}
