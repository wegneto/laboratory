package com.wegneto.petshop.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Animal implements Serializable {

	private static final long serialVersionUID = -5163278548052260297L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	public Animal() {
	}

	public Animal(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
