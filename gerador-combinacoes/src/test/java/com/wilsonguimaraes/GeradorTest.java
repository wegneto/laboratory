package com.wilsonguimaraes;

import java.util.TreeSet;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class GeradorTest {
	
	@Inject
	private Gerador gerador;
	
	@Test
	public void retornaNumeroDezenasIguaisQuandoSequenciasSaoIguais() {
		TreeSet<Integer> seq1 = new TreeSet<Integer>();
		TreeSet<Integer> seq2 = new TreeSet<Integer>();
		
		for (int i = 1; i < 7; i++) {
			seq1.add(i);
			seq2.add(i);
		}
		
		Assert.assertEquals(6, gerador.getQtdDezenasIguais(seq1, seq2));
	}
	
	@Test
	public void retornaNumeroDezenasIguaisQuandoSequenciasSaoDiferentes() {
		TreeSet<Integer> seq1 = new TreeSet<Integer>();
		TreeSet<Integer> seq2 = new TreeSet<Integer>();
		
		for (int i = 1; i < 7; i++) {
			seq1.add(i);
			seq2.add(i + 1);
		}
		
		Assert.assertEquals(5, gerador.getQtdDezenasIguais(seq1, seq2));
	}
	
	@Test
	public void retornaNumeroDezenasIguaisQuandoSequenciasPossueTamanhosDiferentes() {
		TreeSet<Integer> seq1 = new TreeSet<Integer>();
		TreeSet<Integer> seq2 = new TreeSet<Integer>();
		
		for (int i = 1; i < 7; i++) {
			seq1.add(i);
		}
		
		for (int i = 1; i < 10; i++) {
			seq2.add(i);
		}
		
		Assert.assertEquals(6, gerador.getQtdDezenasIguais(seq1, seq2));
	}

}
