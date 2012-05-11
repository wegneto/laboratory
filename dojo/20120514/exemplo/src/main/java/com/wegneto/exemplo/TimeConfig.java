package com.wegneto.exemplo;

import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource = "time")
public class TimeConfig {

	private int tamanhoMaximo;

	public int getTamanhoMaximo() {
		return tamanhoMaximo;
	}

}
