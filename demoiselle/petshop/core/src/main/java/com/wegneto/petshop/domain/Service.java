package com.wegneto.petshop.domain;

import java.util.Date;

public class Service {

	private String type;

	private Date date;

	private String animal;

	private String groomer;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getGroomer() {
		return groomer;
	}

	public void setGroomer(String groomer) {
		this.groomer = groomer;
	}

	private int price;

}
