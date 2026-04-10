package com.navneet.todo;

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
}