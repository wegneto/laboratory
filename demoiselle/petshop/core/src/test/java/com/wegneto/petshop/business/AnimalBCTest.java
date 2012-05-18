package com.wegneto.petshop.business;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

import com.wegneto.petshop.domain.Animal;

@RunWith(DemoiselleRunner.class)
public class AnimalBCTest {

	@Inject
	private AnimalBC animalBC;
	
	@Test
	public void successfulInsertion() {
		animalBC.insert(new Animal("Laila"));
		assertEquals(1, animalBC.findAll().size());
	}

}
