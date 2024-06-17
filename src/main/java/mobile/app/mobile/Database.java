package mobile.app.mobile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String DB_URL = "jdbc:mysql://database-1.czwi6oo0m60t.us-east-2.rds.amazonaws.com:3306/mobile_phone_db";
    private static final String USER = "admin";
    private static final String PASSWORD = "Behappy123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static ResultSet getMobiles() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT brand, model, price, ram FROM mobiles";
        return statement.executeQuery(query);
    }
}
