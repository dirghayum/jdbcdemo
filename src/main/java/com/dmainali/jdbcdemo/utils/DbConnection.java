package com.dmainali.jdbcdemo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    //Creating instance of the Connection class which should be private
    private static Connection con = null;

    //Static block initialization for exceptional handling
    static
    {
        String url = "jdbc:postgresql://localhost:5432/db_name?currentSchema=schema_name";
        String user = "username";
        String pass = "password";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //public static method that returns the instance of the class
    public static Connection getConnection()
    {
        return con;
    }
}
