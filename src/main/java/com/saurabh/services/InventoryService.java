package com.saurabh.services;

import java.util.List;

import com.saurabh.entities.Inventory;

public interface InventoryService {
	public int create(Inventory inventory);
	public List<Inventory> medicineList();
}
