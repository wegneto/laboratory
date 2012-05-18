package com.wegneto.petshop.business;

import java.util.ArrayList;
import java.util.List;

public class OwnerBC {
	
	private List<String> owners = new ArrayList<String>();

	public boolean insert(String owner) {
		if (findByName(owner)) {
			return false;
		} else {
			owners.add(owner);
			return true;
		}
	}

	private boolean findByName(String owner) {
		return owners.contains(owner);
	}

}
