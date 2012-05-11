package com.wegneto.exemplo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.stereotype.Controller;

import com.wegneto.exemplo.domain.Partida;
import com.wegneto.exemplo.exception.TimeException;

@Controller
public class Torneio {

	@Inject
	private Logger logger;
	
	@Inject
	private TimeConfig config;
	
	private List<String> times = new ArrayList<String>();

	private List<Partida> partidas = new ArrayList<Partida>();
	
	@ExceptionHandler
	public void trataException(TimeException e) {
		logger.error("Ocorreu uma excecao!");
		throw e;
	}

	public void insereTime(String string) {
		logger.info("Inserindo time {}, {}", string, times.size());
		
		if (times.size() == config.getTamanhoMaximo()) {
			throw new TimeException();
		}

		times.add(string);
	}

	public boolean estaCadastrado(String string) {
		return times.contains(string);
	}

	public void inserePartida(Partida partida) {
		partidas.add(partida);
	}

	public List<Partida> obterPartidas() {
		return partidas ;
	}

}
