package org.jvesuvius.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.jvesuvius.core.Config;

/**
* Handles database connection and query execution.
*/
public class Database {
    String dbUrl = "jdbc:postgresql://localhost/jvesuvius";
    Config config = new Config();
    HashMap<String, String> dbCredentials = config.getDbCredentials();
    String dbUsername = dbCredentials.get("dbUsername");
    String dbPassword = dbCredentials.get("dbPassword");
    Connection con;
    public Database() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
    * Executes given SQL query and returns the results.
    */
    public ResultSet getResultSet(String query) {
        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
