package com.wegneto.petshop.business;

import org.junit.Assert;
import org.junit.Test;

import com.wegneto.petshop.business.AnimalBC;

public class AnimalBCTest {

	@Test
	public void successfulInsertion() {
		AnimalBC bc = new AnimalBC();
		Assert.assertTrue(bc.insert("cachorro"));
	}

}
