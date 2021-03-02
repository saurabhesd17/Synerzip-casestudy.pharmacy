package com.saurabh.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Order {
	private int id;
	private String orderStatus = "PENDING";
	private int quantity;
	@Autowired
	@Qualifier("medicine2")
	private Medicine medicine;

	public int getId() {
		return id;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderStatus=" + orderStatus + ", quantity=" + quantity + ", medicine="
				+ medicine.getId() + "]";
	}

}
