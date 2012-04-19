package com.wegneto.petshop.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.wegneto.petshop.domain.Animal;

@PersistenceController
public class AnimalDAO extends JPACrud<Animal, Long> {

	private static final long serialVersionUID = -6580746927618794459L;

}
