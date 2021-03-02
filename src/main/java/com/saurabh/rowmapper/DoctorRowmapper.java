package com.saurabh.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.saurabh.entities.Doctor;

public class DoctorRowmapper implements RowMapper<Doctor>{

	public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Doctor doctor = new Doctor();
		doctor.setId(rs.getInt(1));
		doctor.setFirstName(rs.getString(2));
		doctor.setLastName(rs.getString(3));
		return doctor;
	}

}
