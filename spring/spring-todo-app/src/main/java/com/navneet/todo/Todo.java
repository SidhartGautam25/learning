package com.navneet.todo;

// model class representing a todo item
public class Todo {

    private int id;
    private String title;

    public Todo() {
    }

    public Todo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}