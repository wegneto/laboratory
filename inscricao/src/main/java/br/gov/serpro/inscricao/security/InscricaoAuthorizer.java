package br.gov.serpro.inscricao.security;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.security.SecurityContext;

@Alternative
public class InscricaoAuthorizer implements Authorizer {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SecurityContext securityContext;

	@Override
	public boolean hasPermission(String arg0, String arg1) {
		boolean hasPermission = false;
		
		if (securityContext.getUser().getId().equals("creuza")) {
			hasPermission = true;
		}
		
		return hasPermission;
	}

	@Override
	public boolean hasRole(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
