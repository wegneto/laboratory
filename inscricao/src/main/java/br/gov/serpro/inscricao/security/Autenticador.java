package br.gov.serpro.inscricao.security;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;

@Alternative
public class Autenticador implements Authenticator {

	@Inject
	private Credenciais credenciais;

	@Override
	public boolean authenticate() {
		return (credenciais.getNome().equals("secretaria") && credenciais.getSenha().equals("123456"));
	}

	@Override
	public void unAuthenticate() {
	}

	@Override
	public User getUser() {
		return new User() {

			@Override
			public void setAttribute(Object key, Object value) {
			}

			@Override
			public String getId() {
				return null;
			}

			@Override
			public Object getAttribute(Object key) {
				return null;
			}
		};
	}

}
