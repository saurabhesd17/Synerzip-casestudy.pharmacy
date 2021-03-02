package com.saurabh.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.saurabh.entities.Pharmacy;

public class PharmacyRowmapper implements RowMapper<Pharmacy>{

	public Pharmacy mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pharmacy pharmacy = new Pharmacy();
		pharmacy.setId(rs.getInt(1));
		pharmacy.setName(rs.getString(2));
		pharmacy.setLicense(rs.getLong(3));
		pharmacy.setAddress(rs.getString(4));
		pharmacy.setContact(rs.getLong(5));
		return pharmacy;
	}

}
