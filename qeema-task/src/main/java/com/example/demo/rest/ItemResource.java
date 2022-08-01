package com.example.demo.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Item;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.services.ItemServiceImpl;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("api/v1.0.0/items")
public class ItemResource {

	@Autowired
	private ItemServiceImpl itemService;
	@GetMapping("/")
	public ResponseEntity<List<Item>> findAllItems(){
		 log.debug("REST request to get all items ");
		return new ResponseEntity<List<Item>>(itemService.findAllItems(),HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<Item> saveItem(@Valid @RequestBody Item item) throws Exception{
		log.debug("REST request to save item ",item);
		if(item.getId() != null) {
			 throw new BadRequestException("A new Item cannot already have an ID");
		}
		return new ResponseEntity<Item>(itemService.saveItem(item),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Item> findItemById(@PathVariable Long id) {
		log.debug("REST request to get item with id ",id);
		return new ResponseEntity<Item>(itemService.findItemById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable("id") Long id) {
		log.debug("REST request to delete item ", id);
		itemService.deleteItemById(id);
		return new ResponseEntity<String>("This Item Has Been Deleted",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> editItem(@PathVariable("id") Long id,@RequestBody Item item) throws Exception{
		log.debug("REST request to edit item with id ", id);
		return new ResponseEntity<Item>(itemService.editItem(id, item),HttpStatus.OK);
	}
}
