package com.example.BagShop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {
    private static DBConnectionProvider dbConnectionProvider= new DBConnectionProvider();
    private final String DB_HOST="jdbc:mysql://localhost:3306/bagShop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDateTimeCode=false&serverTimezone=UTC";
    private final String USERNAME="root";
    private final String PASSWORD="rootroot";

    private DBConnectionProvider(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

    }

    public static DBConnectionProvider getInstance(){
        return dbConnectionProvider;
    }

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(DB_HOST, USERNAME, PASSWORD);
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
