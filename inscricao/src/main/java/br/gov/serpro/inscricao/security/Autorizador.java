package br.gov.serpro.inscricao.security;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.security.SecurityContext;

@Alternative
public class Autorizador implements Authorizer {

	private static final long serialVersionUID = 1L;
	
	public boolean hasRole(String role) {
		return true;
	}

	public boolean hasPermission(String resource, String operation) {
		return true;
	}

}
