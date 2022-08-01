package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Item;
import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.repositories.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Override
	public List<Item> findAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item findItemById(Long id) throws ItemNotFoundException {
		return itemRepository.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("Item Not Found With Id"));
	}

	@Override
	public Item saveItem(Item item) throws Exception {
		item.setProduct(productServiceImpl.findProductById(item.getProduct().getId()));;
		double total =this.calculateTotal(item.getQuantity(), item.getProduct().getPrice());
		System.out.println("Total Item>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		System.out.println("Total Item" + total);
		System.out.println("quantity" + item.getQuantity());
		System.out.println("Product  price" + item.getProduct().getPrice());
		item.setTotal(total);
		return itemRepository.save(item);
	}

	@Override
	public void deleteItemById(Long id) throws ItemNotFoundException {
		itemRepository.delete(this.findItemById(id));
	}

	@Override
	public Item editItem(Long id, Item item) throws Exception {
		Item oldItem=this.findItemById(id);
		oldItem.setProduct(item.getProduct());
		oldItem.setQuantity(item.getQuantity());
		oldItem.setTotal(item.getTotal());
		return this.saveItem(oldItem);
	}
	private double calculateTotal(int quantity, double price) {
		double sum=0;
		return sum= quantity *price;
	}
}
