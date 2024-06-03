package com.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.TodoItem;
import com.todo.repository.TodoRepo;
import com.todo.services.ItemService;

@RestController
@RequestMapping("/items")
public class TodoController {

	@Autowired
	private ItemService itemService;
	
	
	//handler to get all todo item
	
	@GetMapping("/todoitems")
	public List<TodoItem> findAll(){
		
		
		return itemService.findAll();
	}
	
	// to insert item in todo
	
	@PostMapping("/create")
	public TodoItem createItem(@RequestBody TodoItem todoItem) {
		
		return itemService.save(todoItem);
	}
	
	// handler to get item by id
	
	@GetMapping("/{id}")
	public Optional<TodoItem> getItemById(@PathVariable long id) {
		
		return itemService.findById(id);
	}
	
	// handler to delete item
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable long id) {
		
		itemService.deleteById(id);
	}
	
	// handler to update todo item
	@PutMapping("update/{id}")
	public TodoItem updateItem(@PathVariable long id, @RequestBody TodoItem item) {
		Optional<TodoItem> existingItem = itemService.findById(id);
		if(existingItem.isPresent()) {
			TodoItem updatedItem = existingItem.get();
			updatedItem.setDescription(item.getDescription());
			updatedItem.setCompleted(item.isCompleted());
			return itemService.save(updatedItem);
		}
		return null;
	}
	
}
