package com.saurabh.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.saurabh.entities.Pharmacy;
import com.saurabh.rowmapper.PharmacyRowmapper;
import com.saurabh.services.PharmacyServices;

public class PharmacyDao implements PharmacyServices {
	private JdbcTemplate jdbcTemplate;

	/**
	 * @return number of rows affected after inserting new row in pharmacy column
	 */
	public int create(Pharmacy pharmacy) {
		String query = "insert into pharmacy(id, name, license, address, contact) values(?,?,?,?,?)";
		int count = this.jdbcTemplate.update(query, pharmacy.getId(), pharmacy.getName(), pharmacy.getLicense(),
				pharmacy.getAddress(), pharmacy.getContact());
		return count;
	}

	/**
	 * @return number of rows affected
	 * deletes the pharmacy from pharmacy table by getting id of pharmacy
	 */
	public int delete(int id) {
		String query = "delete from pharmacy where id=?";
		int count = this.jdbcTemplate.update(query, id);
		return count;
	}

	/**
	 * @return pharmacy
	 * below method returns the information of Pharmacy from pharmacy table
	 * it accepts id of pharmacy and stores the info on pharmacy object
	 */
	public Pharmacy information(int id) {
		String query = "select * from pharmacy where id=?";
		RowMapper<Pharmacy> rowMapper = new PharmacyRowmapper();
		Pharmacy pharmacy = this.jdbcTemplate.queryForObject(query, rowMapper, id);
		return pharmacy;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
