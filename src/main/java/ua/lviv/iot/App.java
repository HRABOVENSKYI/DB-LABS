package ua.lviv.iot;

import java.sql.*;

public class App {
    private static final String URL = "jdbc:mysql://localhost:3306/hrabovenskyi?allowPublicKeyRetrieval=true&" +
            "createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (Statement stmt = con.createStatement()) {
                try (ResultSet resultSet = stmt.executeQuery("select  * from `call` where detailed_description is null")) {
                    while (resultSet.next()) {
                        System.out.print(resultSet.getString("reporter_phone_number") + " ");
                        System.out.print(resultSet.getString("short_description") + " ");
                        System.out.print(resultSet.getInt("detailed_description") + " ");
                        System.out.print(resultSet.getString("call_address_id") + " ");
                        System.out.print(resultSet.getString("call_time") + "\n");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
