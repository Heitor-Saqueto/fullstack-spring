package com.myfullstackproject.demo.controller;

import java.util.List;

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

import com.myfullstackproject.demo.model.Item;
import com.myfullstackproject.demo.service.ItemService;

@RestController
@RequestMapping("/api/v1/items") //This sets the base prefix for all endpoints
public class ItemController {

	private final ItemService itemService;
	
	//Dependency Injection 
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	//Endpoint: POST /api/v1/items (create a new item)
	@PostMapping
	public ResponseEntity<Item> createItem(@RequestBody Item item){
		Item savedItem = itemService.save(item);
		//return status 201 created and saved item
		return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
		
	}
	//Endpoint: GET /api/v1/items (list All items)
	@GetMapping
	public ResponseEntity<List<Item>> getAllItems(){
		List<Item> items = itemService.findAll();
		//Return status 200 ok and list all items
		return ResponseEntity.ok(items);
	}
	
	//New Get by id
	@GetMapping("/{id}")
	public ResponseEntity<Item> findById(@PathVariable Long id){
		Item item = itemService.findById(id);
		return ResponseEntity.ok(item); //It returns 200 OK 
	} 
	
	//Update by id
	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item updatedItem){
		
		Item result = itemService.update(id, updatedItem);
		//returns 200 OK with updated Item
		return ResponseEntity.ok(result);
	}
	//Delete by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		itemService.deleteById(id);
		// return 204 no content.
		return ResponseEntity.noContent().build();
	}
}
