package com.saurabh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.saurabh.entities.Inventory;
import com.saurabh.rowmapper.InventoryRowmapper;
import com.saurabh.services.InventoryService;

public class InventoryDao implements InventoryService {
	private JdbcTemplate jdbcTemplate;

	/**
	 *@return number of rows affected after adding medicine in inventory
	 */
	public int create(Inventory inventory) {
		String query = "insert into inventory(id,medicine_id,pharmacy_name,stock) values(?,?,?,?)";
		int count = this.jdbcTemplate.update(query, inventory.getId(), inventory.getMedicine().getId(),
				inventory.getPharmacy().getName(), inventory.getStock());
		return count;
	}

	/**
	 * @return list of all medicines in the inventory
	 */
	public List<Inventory> medicineList() {
		String query = "select * from inventory";
		List<Inventory> medicine = this.jdbcTemplate.query(query, new InventoryRowmapper());
		return medicine;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
