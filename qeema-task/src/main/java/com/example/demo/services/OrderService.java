package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Order;
import com.example.demo.exceptions.OrderNotFoundException;


public interface OrderService {

	public List<Order> findAllOrders();
	
	public Order findOrderById(Long id) throws OrderNotFoundException;
	
	public Order saveOrder(Order order,String email) throws Exception;
	
	public void deleteOrderById(Long id) throws OrderNotFoundException;
	
	public Order editOrder(Long id,Order order) throws OrderNotFoundException, Exception;
}
