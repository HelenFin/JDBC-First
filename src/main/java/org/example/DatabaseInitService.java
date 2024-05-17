package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {
        Database database = Database.getInstance();
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = new String(Files.readAllBytes(Paths.get("sql/init_db.sql")));
            statement.execute(sql);

            System.out.println("Database initialized successfully.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

