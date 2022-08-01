package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Order;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.services.OrderServiceImpl;

@RestController
@RequestMapping("api/v1.0.0/orders")
public class OrderResource {

	@Autowired
	private OrderServiceImpl orderServiceImpl;
	@GetMapping("/")
	public ResponseEntity<List<Order>> findAllOrders(){
		return new ResponseEntity<List<Order>>(orderServiceImpl.findAllOrders(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable("id") Long id) throws Exception{
		
		return new ResponseEntity<Order>(orderServiceImpl.findOrderById(id),HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) throws Exception{
		if(order.getId() != null) {
			 throw new BadRequestException("A new Order cannot already have an ID");
		}
		String email= SecurityContextHolder.getContext().getAuthentication().getName();
		return new ResponseEntity<Order>(orderServiceImpl.saveOrder(order,email),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable ("id") Long id) throws Exception{
		orderServiceImpl.deleteOrderById(id);
		return new ResponseEntity<String>("This Product Has Been Deleted",HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Order> editOrder(@PathVariable ("id") Long id, @RequestBody Order order) throws Exception{
		return new ResponseEntity<Order>(orderServiceImpl.editOrder(id,order),HttpStatus.OK);
	}
}
