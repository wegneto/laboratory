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
		gerador.gerarVolantes(10);
	}

	public static void main(String[] args) {
		new StartMain(args).go();
	}

}
