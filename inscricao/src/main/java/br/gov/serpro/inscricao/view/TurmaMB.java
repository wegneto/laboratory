package br.gov.serpro.inscricao.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.serpro.inscricao.business.TurmaBC;
import br.gov.serpro.inscricao.entity.Aluno;

@ViewController
public class TurmaMB {

	@Inject
	private TurmaBC bc;
	
	public List<Aluno> getAlunosMatriculados() {
		return bc.obterAlunosMatriculados();
	}

}
