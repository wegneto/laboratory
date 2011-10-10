package com.wilsonguimaraes;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class PalpitadorTest {

	@Inject
	private Palpitador palpitador;
	
	@Test
	public void testNomeSimples() {
		int qtdCaract = palpitador.getNumerologia("teste");
		Assert.assertEquals(qtdCaract, 5);
	}
	
	@Test
	public void testNomeComEspaco() {
		int qtdCaract = palpitador.getNumerologia("William Shakespeare");
		Assert.assertEquals(qtdCaract, 9);
	}
	
	@Test
	public void testNomeGrande() {
		int qtdCaract = palpitador.getNumerologia("Pedro de Alcantara Joao Carlos Leopoldo Salvador Bibiano Francisco Xavier de Paula Leocadio Miguel Gabriel Rafael Gonzaga");
		Assert.assertEquals(qtdCaract, 6);
	}
	
	@Test
	public void testLetrasENumeros() {
		int qtdCaract = palpitador.getNumerologia("123teste456");
		Assert.assertEquals(qtdCaract, 8);
	}
	
	@Test
	public void testNumeroUm() {
		int qtdCaract = palpitador.getNumerologia("1");
		Assert.assertEquals(qtdCaract, 1);
	}
	
	@Test
	public void testNumeroDois() {
		int qtdCaract = palpitador.getNumerologia("2");
		Assert.assertEquals(qtdCaract, 2);
	}
	
	@Test
	public void testNumeroDez() {
		int qtdCaract = palpitador.getNumerologia("10");
		Assert.assertEquals(qtdCaract, 1);
	}
	
	@Test
	public void testNumeroDezesseis() {
		int qtdCaract = palpitador.getNumerologia("16");
		Assert.assertEquals(qtdCaract, 7);
	}
	
	@Test
	public void testNumeroDezenove() {
		int qtdCaract = palpitador.getNumerologia("19");
		Assert.assertEquals(qtdCaract, 1);
	}
	
	@Test
	public void testNumeroCem() {
		int qtdCaract = palpitador.getNumerologia("100");
		Assert.assertEquals(qtdCaract, 1);
	}
	
	@Test
	public void testCPF() {
		int qtdCaract = palpitador.getNumerologia("12345678901");
		Assert.assertEquals(qtdCaract, 1);
	}
	
	@Test
	public void testCPFFormatado() {
		int qtdCaract = palpitador.getNumerologia("123.456.789-01");
		Assert.assertEquals(qtdCaract, 1);
	}
	
}
