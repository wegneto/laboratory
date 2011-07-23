package com.wilsonguimaraes;

import javax.inject.Inject;

import org.jboss.weld.environment.se.StartMain;
import org.slf4j.Logger;

public class HelloWorld {

	@Inject
	private Logger logger;

	public void say() {
		logger.info("Saying hello on console");
	}
	
	public static void main(String[] args) {
		//new StartMain(args).go();
		System.out.println("teste");
	}
	
}
