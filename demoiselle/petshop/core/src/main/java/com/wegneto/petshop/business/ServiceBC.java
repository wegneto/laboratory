package com.wegneto.petshop.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.wegneto.petshop.domain.Service;
import com.wegneto.petshop.persistence.ServiceDAO;

@BusinessController
public class ServiceBC extends DelegateCrud<Service, Long, ServiceDAO> {

	private static final long serialVersionUID = -4127437318419234562L;
	
}
