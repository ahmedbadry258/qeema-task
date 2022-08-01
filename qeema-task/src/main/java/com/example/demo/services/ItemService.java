package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Item;

import com.example.demo.exceptions.ItemNotFoundException;


public interface ItemService {
	
	public List<Item> findAllItems();
	
	public Item findItemById(Long id) throws ItemNotFoundException;
	
	public Item saveItem(Item item) throws Exception;
	
	public void deleteItemById(Long id) throws ItemNotFoundException;
	
	public Item editItem(Long id,Item item) throws Exception;
}
