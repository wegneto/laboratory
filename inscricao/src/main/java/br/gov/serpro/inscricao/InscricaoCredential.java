package br.gov.serpro.inscricao;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InscricaoCredential {

	private String login;

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
