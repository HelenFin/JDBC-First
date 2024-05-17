package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseInitService.main(args);  // Ініціалізація БД
        DatabasePopulateService.main(args);  // Наповнення БД

        DatabaseQueryService queryService = new DatabaseQueryService();
        List<MaxProjectCountClient> clients = queryService.findMaxProjectsClient();

        for (MaxProjectCountClient client : clients) {
            System.out.println(client);
        }
    }
}
