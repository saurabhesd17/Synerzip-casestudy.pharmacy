package com.saurabh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.saurabh.entities.Doctor;
import com.saurabh.rowmapper.DoctorRowmapper;
import com.saurabh.services.DoctorServices;

public class DoctorDao implements DoctorServices {
	private JdbcTemplate jdbcTemplate;

	/**
	 * @return number of rows affected after successfully creating new row.
	 */
	public int create(Doctor doctor) {
		String query = "insert into doctor(id, first_name, last_name) values(?,?,?)";
		int count = this.jdbcTemplate.update(query, doctor.getId(), doctor.getFirstName(), doctor.getLastName());
		return count;
	}
	
	/**
	 * @return number of rows affected
	 * deletes the doctor from table by getting doctor id
	 */
	public int delete(int id) {
		String query = "delete from doctor where id=?";
		int count = this.jdbcTemplate.update(query, id);
		return count;
	}

	/**
	 * @param name
	 * @return list of doctors
	 * below methods accepts one parameter as name
	 * and searches for either first name or last name and returns list of matching result
	 */
	public List<Doctor> search(String name) {
		String query = "select * from doctor where first_name like '%"+name+"%' or last_name like '%"+name+"%'";
		List<Doctor> doctor = jdbcTemplate.query(query, new DoctorRowmapper());
		return doctor;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
