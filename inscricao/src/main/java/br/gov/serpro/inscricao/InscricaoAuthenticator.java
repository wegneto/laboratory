package br.gov.serpro.inscricao;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;

@Alternative
public class InscricaoAuthenticator implements Authenticator {

	private static final long serialVersionUID = 1L;

	@Inject
	private InscricaoCredential credential;

	@Override
	public boolean authenticate() {
		boolean autenticated = false;
		
		if ((credential.getLogin().equals("creuza") && credential.getPassword().equals("amor"))
				&& (credential.getLogin().equals("creuza") && credential.getPassword().equals("amor"))) {
			autenticated = true;
		}

		return autenticated;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unAuthenticate() {
		// TODO Auto-generated method stub

	}

}
