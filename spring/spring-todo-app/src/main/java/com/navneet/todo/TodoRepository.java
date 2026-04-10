package com.navneet.todo;

import org.springframework.stereotype.Repository;


@Repository
public class TodoRepository {

    public void fetchTodos() {
        System.out.println("Fetching todos from DB...");
    }
}