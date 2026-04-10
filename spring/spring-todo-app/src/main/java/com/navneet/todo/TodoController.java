package com.navneet.todo;

public class TodoController {

    private final TodoService todoService;

    // Constructor Injection
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    public void getTodos() {
        System.out.println("Controller layer...");
        todoService.printTodos();
    }
}