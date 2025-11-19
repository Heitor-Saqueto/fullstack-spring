package com.myfullstackproject.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

	//READ (read and return an item by id)
	public Item findById(Long id) {
		//Use orElseThrow to return 404 Not Found in case of the item does not exist.
		return itemRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Item not found with the ID: "+id
						));
	}
	
	//UPDATE (Update an item by id)
	public Item update(Long id, Item updatedItem) {
		//find an item using the method findById.
		Item existingItem = findById(id);
		//Updtade attributs (Not the ID)
		existingItem.setName(updatedItem.getName());
		existingItem.setDescription(updatedItem.getDescription());
		
		//save the updated item 
		return itemRepository.save(existingItem);
	}
	
	//DELETE (delete by id an item)
	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}
}
