package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Connection conn = null;
        File propsFile = new File("src/main/resources/h2database.properties");

        try (FileInputStream fis = new FileInputStream(propsFile.getAbsolutePath())){
            Properties props = new Properties();
            props.load(fis);

            String url = props.getProperty("db_url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}

