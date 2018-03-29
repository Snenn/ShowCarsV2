package com.showCars.dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws URISyntaxException, SQLException {

        return DriverManager.getConnection(
                "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net:3306/heroku_555437bd0a94962?reconnect=true",
                "bdee5f193ec11c", "ac321792");
    }


}
