package com.wilsonguimaraes;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.StartMain;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import com.wilsonguimaraes.config.GeradorConfig;

public class Main {

	@Inject
	private Gerador gerador;
	
	@Inject
	private GeradorConfig config;
	
	@Inject
	private Palpitador palpitador;

	public void start(@Observes ContainerInitialized event) {
		
		System.out.println("#informacoes do jogo");
		System.out.print("nome.concurso ");
		System.out.println(palpitador.getNumerologia(config.getNomeConcurso()));

		System.out.print("data.sorteio ");
		System.out.println(palpitador.getNumerologia(config.getDataSorteio()));

		System.out.print("hora.sorteio ");
		System.out.println(palpitador.getNumerologia(config.getHoraSorteio()));

		System.out.print("local.sorteio ");
		System.out.println(palpitador.getNumerologia(config.getLocalSorteio()));

		System.out.print("numero.concurso ");
		System.out.println(palpitador.getNumerologia(config.getNumeroConcurso()));

		System.out.print("valor.acumulado ");
		System.out.println(palpitador.getNumerologia(config.getValorAcumulado()));

		System.out.print("estimativa.premio ");
		System.out.println(palpitador.getNumerologia(config.getEstimativaPremio()));
		
		System.out.println("#dados apostador ");
		System.out.print("nome.apostador ");
		System.out.println(palpitador.getNumerologia(config.getNomeApostador()));

		System.out.print("data.nascimento ");
		System.out.println(palpitador.getNumerologia(config.getDataNascimento()));

		System.out.println("#dados aposta");
		System.out.print("data.aposta ");
		System.out.println(palpitador.getNumerologia(config.getDataAposta()));

		System.out.print("dia.semana.aposta ");
		System.out.println(palpitador.getNumerologia(config.getDiaSemanaAposta()));
		
		gerador.gerarVolantes(10);
	}

	public static void main(String[] args) {
		new StartMain(args).go();
	}

}
