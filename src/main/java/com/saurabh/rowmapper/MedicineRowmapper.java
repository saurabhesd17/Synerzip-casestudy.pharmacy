package com.saurabh.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.saurabh.entities.Medicine;
import com.saurabh.entities.Pharmacy;

public class MedicineRowmapper implements RowMapper<Medicine>{

	public Medicine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Medicine medicine = new Medicine();
		medicine.setId(rs.getInt(1));
		medicine.setName(rs.getString(2));
		medicine.setBrand(rs.getString(3));
		
		Pharmacy ph = new Pharmacy();
		ph.setId(rs.getInt(4));
		medicine.setPharmacy(ph);
		return medicine;
	}

}
