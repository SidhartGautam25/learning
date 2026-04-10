package com.navneet.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class TodoController {

    private final TodoService todoService;

    // Constructor Injection
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    @ResponseBody
    public String getTodos() {
        System.out.println("Controller layer...");
        todoService.printTodos();
        return "Todos fetched successfully!";
    }

    @PostMapping("/todos")
    @ResponseBody
    public String createTodo(@RequestParam String title) {
        todoService.createTodo(title);
        return "Todo created!";
    }
}