package com.example.demo.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Entity(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Product Name Must Be Not Blank")
	@NotNull(message = "Product Name is required.")
	@NotEmpty(message = "Product Name Must Be Not Empty")
	@Column(name = "names")
	private String name;
	
	@NotNull
	@Min(value = 1, message = "Product Price should be Greater than Zero ")
	@Column(name = "price")
	private double price;
	
	@NotEmpty(message = "Discription Must Be Not Empty")
	@Column(name = "discription")
	private String discription;
	
	public Product() {
		super();
	}
	public Product(Long id,
			@NotBlank(message = "Product Name Must Be Not Blank") @NotNull(message = "Product Name is required.") @NotEmpty(message = "Product Name Must Be Not Empty") String name,
			@NotNull @Min(value = 1, message = "Product Price should be Greater than Zero ") double price,
			@NotEmpty(message = "Discription Must Be Not Empty") String discription) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.discription = discription;
	}
	
	
	
	
	
}
