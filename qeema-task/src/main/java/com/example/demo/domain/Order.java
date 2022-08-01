package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Entity(name = "orders")
@ToString
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
	            name = "orders_items",
	            joinColumns = {@JoinColumn(name = "order_id",referencedColumnName = "id")},
	            inverseJoinColumns = {@JoinColumn(name = "item_id",referencedColumnName = "id")}
	    )
	private Set<Item> items= new HashSet<>();
	@Column(name = "total_price",nullable = false)
	private double totalPrice;



}
