/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseLocator {

    private static DataBaseLocator instance = new DataBaseLocator();

    public static DataBaseLocator getInsLocator() {
        return instance;
    }

    private DataBaseLocator() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ifood", "root", "");
        return conn;
    }
}
