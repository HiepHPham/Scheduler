package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Sets up for connection to database
 *
 * Using mysql-connector-java-8.0.28
 */
public class JDBC {
    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
    private static final String driver = "com.mysql.cj.jdbc.Driver"; // Driver reference
    private static final String userName = "sqlUser"; // Username
    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    private static String password = "Passw0rd!"; // Password
    public static Connection connection;  // Connection Interface

    /**
     * Opens connection using predefined fields for Url, username, and password
     * Catches exception if connection times out
     */
    public static void openConnection()
    {
        try {
            Class.forName(driver); // Locate Driver
            connection = DriverManager.getConnection(jdbcUrl, userName, password); // Reference Connection object
            System.out.println("JDBC Connection successful");
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }

    /**
     * Closes connection
     * Catches exception if connection times out
     */
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("JDBC Connection closed");
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
