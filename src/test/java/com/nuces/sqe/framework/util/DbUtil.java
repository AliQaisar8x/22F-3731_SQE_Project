package com.nuces.sqe.framework.util;

import com.nuces.sqe.framework.core.ConfigReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbUtil {

    private static final Properties props = ConfigReader.load("db.properties");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password"));
    }

    public static List<String> readProducts() {
        String sql = "SELECT name FROM products";
        List<String> products = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to read products from DB", e);
        }
        return products;
    }
}


