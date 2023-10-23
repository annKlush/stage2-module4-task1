package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    private final String jdbcDriver;
    private final String dbUrl;
    private final String user;
    private final String password;

    public H2ConnectionFactory(Properties properties) {
        jdbcDriver = properties.getProperty("jdbc_driver");
        dbUrl = properties.getProperty("db_url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    @Override
    public Connection createConnection() {
        try {
            Class.forName(jdbcDriver);
            return DriverManager.getConnection(dbUrl, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null; // Handle the error as needed
        }
    }
}

