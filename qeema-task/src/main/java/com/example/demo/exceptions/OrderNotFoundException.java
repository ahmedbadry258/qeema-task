package com.example.demo.exceptions;

public class OrderNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	public OrderNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	
}
