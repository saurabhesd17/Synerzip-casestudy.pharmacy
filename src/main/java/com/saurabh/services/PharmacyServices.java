package com.saurabh.services;

import com.saurabh.entities.Pharmacy;

public interface PharmacyServices {
	public int create(Pharmacy pharmacy);
	public int delete(int id);
	public Pharmacy information(int id);
}
