package com.wegneto.petshop.business;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.wegneto.petshop.domain.Service;

public class ServiceBCTest {

	@Test
	public void successfulInsertion() {
		Service service = new Service();
		service.setType("tosa");
		service.setDate(new Date());
		service.setAnimal("Laila");
		service.setPrice(10);
		service.setGroomer("Luis");
		
		ServiceBC serviceBC = new ServiceBC();
		serviceBC.insert(service);
		assertEquals(1, serviceBC.findAll().size());
	}

}
