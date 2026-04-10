package com.navneet.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/todo_app",
            "postgres",
            "your_password" 
        );
    }
}

/*

Node Equivalent of this code

const client = new Client({
  connectionString: "postgres://..."
});




 */