package org.example.services;

import org.example.util.Database;
import org.example.util.SqlFileLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabasePopulateService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabasePopulateService.class);
    public static void main(String[] args) {
        Database database = Database.getInstance();
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = SqlFileLoader.loadSqlFromFile("populate_db.sql");
            statement.execute(sql);

            LOGGER.info("Database populated successfully.");
        } catch (IOException | SQLException e) {
            LOGGER.error("Error executing query in DatabasePopulateService", e);
        }
    }
}

