package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.TodoItem;

public interface TodoRepo extends JpaRepository<TodoItem, Long>{

}
