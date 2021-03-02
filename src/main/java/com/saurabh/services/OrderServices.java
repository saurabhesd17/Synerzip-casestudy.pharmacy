package com.saurabh.services;

import java.util.List;

import com.saurabh.entities.Order;

public interface OrderServices {
	public int makeOrder(Order order);
	public List<Order> pendingOrders();
	public int completeOrder(int id);
}
