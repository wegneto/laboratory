package com.wegneto.exemplo;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

import com.wegneto.exemplo.domain.Partida;
import com.wegneto.exemplo.exception.TimeException;

@RunWith(DemoiselleRunner.class)
public class TorneioTest {

	@Inject
	private Torneio torneio;
	
	@Test
	public void cadastraTimeComSucesso() {
		torneio.insereTime("Atlético/GO");
		Assert.assertTrue(torneio.estaCadastrado("Atlético/GO"));
	}

	@Test(expected = TimeException.class)
	public void falhaAoCadastrarMaisTimesQueOLimite() {
		for (int i = 0; i < 4; i++) {
			torneio.insereTime("Time " + i);
		}

		torneio.insereTime("Vitoria/BA");
		Assert.fail("Uma exceção deveria ser lançada!");
	}
	
	@Test
	public void cadastraPartidaComSucesso() {
		Partida partida = new Partida(new Date(), "Time 1", "Time 2");
		torneio.inserePartida(partida);
		Assert.assertEquals(torneio.obterPartidas().size(), 1);
	}
	
}
