package com.myfullstackproject.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myfullstackproject.demo.model.Item;
import com.myfullstackproject.demo.repository.ItemRepository;

@Service
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	//Dependency Injection
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	//CREATE  (create and save a new item)
	
	public Item save(Item item) {
		return itemRepository.save(item);
	}
	
	
	//READ (read and return a list with all items)
	public List<Item> findAll(){
		return itemRepository.findAll();
	}

}
