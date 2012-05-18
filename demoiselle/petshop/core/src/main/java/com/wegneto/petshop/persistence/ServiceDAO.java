package com.wegneto.petshop.persistence;

import com.wegneto.petshop.domain.Service;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class ServiceDAO extends JPACrud<Service, Long> {

	private static final long serialVersionUID = -815036008009139131L;

}
