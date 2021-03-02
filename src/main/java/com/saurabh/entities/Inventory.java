package com.saurabh.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Inventory {
	private int id;
	@Autowired
	@Qualifier("medicine5")
	private Medicine medicine;
	@Autowired
	@Qualifier("pharmacy1")
	private Pharmacy pharmacy;
	private long stock;

	public int getId() {
		return id;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public long getStock() {
		return stock;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", medicine=" + medicine.getId() + ", pharmacy=" + pharmacy.getName()
				+ ", stock=" + stock + "]";
	}

}
