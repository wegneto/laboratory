package com.wilsonguimaraes.loteria.util;

import static junit.framework.Assert.assertEquals;

import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class DistribuidorTest {
	
	@Inject
	private Distribuidor distribuidor;
	
	@Test
	public void obterQtdJogosComValorMinimo() {
		Map<Integer, Integer> dist =  distribuidor.obterDistribuicao(2);
		assertEquals(1, dist.size());
		Integer qtdJogos = dist.get(6);
		assertEquals((Integer) 1, qtdJogos);
	}
	
	@Test
	public void obterQtdJogosQuandoValor14() {
		Map<Integer, Integer> dist =  distribuidor.obterDistribuicao(14);
		assertEquals(1, dist.size());
		Integer qtdJogos = dist.get(6);
		assertEquals((Integer) 7, qtdJogos);
	}
	
	@Test
	public void obterQtdJogosQuandoValor20() {
		Map<Integer, Integer> dist =  distribuidor.obterDistribuicao(20);
		assertEquals(1, dist.size());
		Integer qtdJogos = dist.get(6);
		assertEquals((Integer) 10, qtdJogos);
	}
	
	@Test
	public void obterQtdJogosQuandoValor32() {
		Map<Integer, Integer> dist =  distribuidor.obterDistribuicao(32);
		assertEquals(2, dist.size());
		Integer qtdJogos6Dezenas = dist.get(6);
		Integer qtdJogos7Dezenas = dist.get(7);
		assertEquals((Integer) 9, qtdJogos6Dezenas);
		assertEquals((Integer) 1, qtdJogos7Dezenas);
	}
	
}
