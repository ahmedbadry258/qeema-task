package com.example.demo.exceptions;

public class ItemNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	public ItemNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	
}
