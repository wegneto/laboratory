package br.gov.serpro.inscricao;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class AlunoBC extends DelegateCrud<Aluno, Integer, AlunoDAO> {

	private static final long serialVersionUID = 1L;

}
