package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        Database database = Database.getInstance();
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = new String(Files.readAllBytes(Paths.get("sql/find_max_projects_client.sql")));
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                result.add(new MaxProjectCountClient(name, projectCount));
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}

