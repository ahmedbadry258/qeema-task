package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;




import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "total")
	private double total;
	
	

	public Item() {
		
	}

	public Item(Long id, Product product, int quantity, double total) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.total = total;
	}
	
}
