package com.showCars.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL_DB =
            "";

    public static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_555437bd0a94962?reconnect=true"));

        String username = "bdee5f193ec11c";
        String password = "ac321792";

        return DriverManager.getConnection(
                String.valueOf(dbUri),
                username, password);
    }


}
