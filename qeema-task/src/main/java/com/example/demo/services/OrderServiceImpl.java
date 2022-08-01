package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Item;
import com.example.demo.domain.Order;
import com.example.demo.domain.User;
import com.example.demo.exceptions.OrderNotFoundException;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private ItemServiceImpl itemServiceImpl;
	
	@Override
	public List<Order> findAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order findOrderById(Long id) throws OrderNotFoundException {
		return orderRepository.findById(id).orElseThrow(()-> new OrderNotFoundException("No Order Found With Id : "+id));
		 
	}

	
	@Override
	public Order saveOrder(Order order,String email) throws Exception {
		//find user who created the order
		User user=userRepository.findByEmail(email);
		order.setUser(user);
		Set<Item> setItems=order.getItems();
		for (Item item : setItems) {
			item.setProduct(
					productServiceImpl.findProductById(item.getProduct().getId())
					);
			itemServiceImpl.saveItem(item);
		}
		
		order.setTotalPrice(this.calculateTotalPriceOrder(order.getItems()));
		
		order.setCreatedDate(LocalDateTime.now());
		System.out.println(order.toString());
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrderById(Long id) throws OrderNotFoundException {
		orderRepository.deleteById(id);
		
	}

	


	@Override
	public Order editOrder(Long id, Order order) throws Exception {
		Order oldOrder=this.findOrderById(id);
		oldOrder.setItems(order.getItems());
		//oldOrder.setUsername(order.getUsername());
		return this.saveOrder(oldOrder,order.getUser().getEmail());
		
	}
	
	private double calculateTotalPriceOrder(Set<Item> items) {
		double sum=0;
		//items.forEach(item -> sum= sum+ item.getTotal());
		for (Item item : items) {
			sum+= item.getTotal();
		}
		return sum;
	}

}
