package com.saurabh.services;

import java.util.List;

import com.saurabh.entities.Medicine;

public interface MedicineServices {
	public int create(Medicine medicine);
	public int delete(int id);
	public List<Medicine> searchByName(String name);
	public List<Medicine> searchByBrand(String name);
}
