package com.saurabh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import com.saurabh.entities.Medicine;
import com.saurabh.rowmapper.MedicineRowmapper;
import com.saurabh.services.MedicineServices;

public class MedicineDao implements MedicineServices {
	private JdbcTemplate jdbcTemplate;

	/**
	 * @return number of rows affected after inserting new medicine
	 */
	public int create(Medicine medicine) {
		String query = "insert into medicine(id, name, brand, pharmacy_id) values(?,?,?,?)";
		int count = this.jdbcTemplate.update(query, medicine.getId(), medicine.getName(), medicine.getBrand(),
				medicine.getPharmacy().getId());
		return count;
	}

	/**
	 * @return number of rows affected
	 * below method deletes the medicine from table by getting id
	 */
	public int delete(int id) {
		String query = "delete from medicine where id=?";
		int count = this.jdbcTemplate.update(query, id);
		return count;
	}

	/**
	 * @return list of medicines
	 * searches medicine by name
	 */
	public List<Medicine> searchByName(String name) {
		String query = "select * from medicine where name like '%"+name+"%' ";
		List<Medicine> medicine = this.jdbcTemplate.query(query, new MedicineRowmapper());
		return medicine;
	}

	/**
	 * @return list of medicines
	 * searches medicine by brand
	 */
	public List<Medicine> searchByBrand(String name) {
		String query = "select * from medicine where brand like '%"+name+"%' ";
		List<Medicine> medicine = this.jdbcTemplate.query(query, new MedicineRowmapper());
		return medicine;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
