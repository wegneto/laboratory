package br.gov.serpro.inscricao.security;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Credenciais {

	private String nome;

	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
