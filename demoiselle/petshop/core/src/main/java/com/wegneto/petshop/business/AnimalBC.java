package com.wegneto.petshop.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.wegneto.petshop.domain.Animal;
import com.wegneto.petshop.persistence.AnimalDAO;

@BusinessController
public class AnimalBC extends DelegateCrud<Animal, Long, AnimalDAO>{

	private static final long serialVersionUID = -8480170812285890121L;

}
