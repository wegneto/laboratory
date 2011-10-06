package br.gov.serpro.inscricao.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.inscricao.domain.Turma;

@PersistenceController
public class TurmaDAO extends JPACrud<Turma, Integer> {

	private static final long serialVersionUID = 1L;

}
