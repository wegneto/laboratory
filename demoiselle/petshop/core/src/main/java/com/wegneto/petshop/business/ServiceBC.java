package com.wegneto.petshop.business;

import java.util.ArrayList;
import java.util.List;

import com.wegneto.petshop.domain.Service;

public class ServiceBC {
	
	private List<Service> db = new ArrayList<Service>();

	public void insert(Service service) {
		db.add(service);
	}

	public List<Service> findAll() {
		return db;
	}

}
