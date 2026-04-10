package com.navneet.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

    public void fetchTodos() {
        try (Connection conn = DBConfig.getConnection()) {

            String query = "SELECT * FROM todos";
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Todo: " + rs.getString("title"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}