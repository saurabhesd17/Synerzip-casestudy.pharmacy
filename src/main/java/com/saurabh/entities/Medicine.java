package com.saurabh.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Medicine {
	private int id;
	private String name;
	private String Brand;
	@Autowired
	@Qualifier("pharmacy1")
	private Pharmacy pharmacy;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return Brand;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", Brand=" + Brand + ", pharmacy=" + pharmacy.getId() + "]";
	}

}
