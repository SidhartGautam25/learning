package com.navneet.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

    public List<Todo> fetchTodos() {
        List<Todo> todos = new ArrayList<>();

        try (Connection conn = DBConfig.getConnection()) {

            String query = "SELECT * FROM todos";
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Todo todo = new Todo(
                        rs.getInt("id"),
                        rs.getString("title"));
                todos.add(todo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return todos;
    }

    public void createTodo(String title) {
        try (Connection conn = DBConfig.getConnection()) {

            String query = "INSERT INTO todos (title) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, title);
            stmt.executeUpdate();

            System.out.println("Todo inserted: " + title);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTodo(int id) {
        try (Connection conn = DBConfig.getConnection()) {

            String query = "DELETE FROM todos WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            System.out.println("Deleted rows: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTodo(int id, String title) {
        try (Connection conn = DBConfig.getConnection()) {

            String query = "UPDATE todos SET title = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, title);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();

            System.out.println("Updated rows: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}