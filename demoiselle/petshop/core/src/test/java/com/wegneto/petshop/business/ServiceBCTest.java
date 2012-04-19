package com.wegneto.petshop.business;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.frameworkdemoiselle.util.Beans;

import com.wegneto.petshop.domain.Animal;
import com.wegneto.petshop.domain.Service;

@RunWith(DemoiselleRunner.class)
public class ServiceBCTest {

	@Inject
	private ServiceBC serviceBC;

	@BeforeClass
	public static void prepareDatabase() {
	}

	@Test
	public void successfulInsertion() {
		Service service = new Service();
		service.setDate(new Date());

		AnimalBC animalBC = Beans.getReference(AnimalBC.class);
		Animal animal = new Animal("Laila");
		animalBC.insert(animal);

		service.setAnimal(animal);
		service.setGroomer("Luis");
		service.setType("tosa");
		service.setPrice(10);

		serviceBC.insert(service);
		assertEquals(1, serviceBC.findAll().size());
	}

}
