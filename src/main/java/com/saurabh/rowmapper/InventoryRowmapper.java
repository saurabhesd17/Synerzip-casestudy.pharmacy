package com.saurabh.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.saurabh.entities.Inventory;
import com.saurabh.entities.Medicine;
import com.saurabh.entities.Pharmacy;

public class InventoryRowmapper implements RowMapper<Inventory>{

	public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
		Inventory inventory = new Inventory();
		inventory.setId(rs.getInt(1));
		
		Medicine medicine = new Medicine();
		medicine.setId(rs.getInt(2));
		inventory.setMedicine(medicine);
		
		Pharmacy pharmacy = new Pharmacy();
		pharmacy.setName(rs.getString(3));
		inventory.setPharmacy(pharmacy);
		
		inventory.setStock(rs.getLong(4));
		return inventory;
	}
	
}
