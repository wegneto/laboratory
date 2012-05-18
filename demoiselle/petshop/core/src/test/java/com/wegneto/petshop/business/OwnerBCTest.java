package com.wegneto.petshop.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.wegneto.petshop.business.OwnerBC;

public class OwnerBCTest {
	
	@Test
	public void successfulInsertion() {
		OwnerBC ownerBC = new OwnerBC();
		assertTrue(ownerBC.insert("Wilson"));
	}
	
	@Test
	public void failInsertWhenOwnerAlreadyExists() {
		OwnerBC ownerBC = new OwnerBC();
		ownerBC.insert("Wilson");
		assertFalse(ownerBC.insert("Wilson"));
	}

}
