package com.saurabh.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.saurabh.entities.Medicine;
import com.saurabh.entities.Order;

public class OrderRowmapper implements RowMapper<Order>{

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setId(rs.getInt(1));
		
		Medicine medicine = new  Medicine();
		medicine.setId(rs.getInt(2));
		order.setMedicine(medicine);
		
		order.setQuantity(rs.getInt(3));
		order.setOrderStatus(rs.getString(4));
		return order;
	}
	
}
