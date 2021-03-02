package com.saurabh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.saurabh.entities.Order;
import com.saurabh.rowmapper.OrderRowmapper;
import com.saurabh.services.OrderServices;

public class OrderDao implements OrderServices {
	private JdbcTemplate jdbcTemplate;

	/**
	 * @return number of rows affected
	 * by default order status will be PENDING
	 * you have to manually complete the order
	 * you can go to option 3->3 to complete the order
	 * specify the id of order in Test file option 3->3
	 */
	public int makeOrder(Order order) {
		String query = "insert into orders(id, medicine_id, quantity, status) values(?,?,?,?)";
		int count = this.jdbcTemplate.update(query, order.getId(), order.getMedicine().getId(), order.getQuantity(),
				order.getOrderStatus());
		return count;
	}

	/**
	 * @return list of all pending orders
	 */
	public List<Order> pendingOrders() {
		String query = "select * from orders where status like '%pending%'";
		List<Order> order = jdbcTemplate.query(query, new OrderRowmapper());
		return order;
	}

	/**
	 * @param status
	 * sets the status as COMPLETE in order table
	 * accepts id of order
	 */
	public int completeOrder(int id) {
		String query = "update orders set status = 'COMPLETE' where id ="+id+" ";
		int count = jdbcTemplate.update(query);
		return count;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



}
