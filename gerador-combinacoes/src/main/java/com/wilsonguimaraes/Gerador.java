package com.wilsonguimaraes;

import java.util.ArrayList;
import java.util.TreeSet;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.StartMain;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import com.wilsonguimaraes.config.GeradorConfig;

public class Gerador {
	
	@Inject
	private GeradorConfig config;
	
	private ArrayList<TreeSet<Integer>> volantesGerados = new ArrayList<TreeSet<Integer>>();

	public void start(@Observes ContainerInitialized event) {
		gerarVolantes(10);
	}

	public static void main(String[] args) {
		new StartMain(args).go();
	}
	
	private void gerarVolantes(int qtdVolantes) {
		ArrayList<Integer> dezenasUtilizadas = new ArrayList<Integer>();

		for (int i = 0; i < qtdVolantes; i++) {

			TreeSet<Integer> volante = new TreeSet<Integer>();

			while (volante.size() < config.getDezenasVolante()) {
				Integer dezena = 1 + (int) (Math.random() * config.getTotalDezenas());
				if (!dezenasUtilizadas.contains(dezena)) {
					volante.add(dezena);
				}
			}

			if (!verificarVolanteExistente(volante)) {
				volantesGerados.add(volante);
				dezenasUtilizadas.addAll(volante);
				if (dezenasUtilizadas.size() == config.getTotalDezenas()) {
					dezenasUtilizadas = new ArrayList<Integer>();
				}
			}

		}

		imprimirVolantes();
	}
	
	private void imprimirVolantes() {
		for (TreeSet<Integer> volante : volantesGerados) {
			System.out.println(volante);
		}
	}

	private boolean verificarVolanteExistente(TreeSet<Integer> volante) {
		for (TreeSet<Integer> volanteRealizado : volantesGerados) {
			if (volante.equals(volanteRealizado)) {
				return true;
			}
		}

		return false;
	}

}