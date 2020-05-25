package rme.project.Util;
/**
 * @author Rasmus Wedelheim
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static Connection conn;

    public static Connection getDatabaseConnection()
    {

        if (conn != null) return conn;

        String name, pass, url;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://den1.mysql5.gear.host:3306/motorhomedb";
            name = "motorhomedb";
            pass = "Tw00?vT9X?C9";
            conn = DriverManager.getConnection(url, name, pass);
            System.out.println("Connection created");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return conn;
    }
}
