package com.navneet.todo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    // Constructor Injection
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void printTodos() {
        System.out.println("Service layer...");
        todoRepository.fetchTodos();
    }

    public List<Todo> getTodos() {
        return todoRepository.fetchTodos();
    }

    public void createTodo(String title) {
        System.out.println("Service: creating todo...");
        todoRepository.createTodo(title);
    }

    public void deleteTodo(int id) {
        System.out.println("Service: deleting todo...");
        todoRepository.deleteTodo(id);
    }

    public void updateTodo(int id, String title) {
        System.out.println("Service: updating todo...");
        todoRepository.updateTodo(id, title);
    }
}