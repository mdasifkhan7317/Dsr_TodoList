package com.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.model.TodoItem;
import com.todo.repository.TodoRepo;

@Service
public class ItemService {

	@Autowired
	private TodoRepo todoRepo;
	
	public List<TodoItem> findAll(){
		
		return todoRepo.findAll();
	}
	
	public Optional<TodoItem> findById(long id) {
		
		return todoRepo.findById(id);
	}
	
	public TodoItem save(TodoItem item) {
		
		
		return todoRepo.save(item);
	}
	
	public void deleteById(long id) {
		
		 todoRepo.deleteById(id);
	}
}
