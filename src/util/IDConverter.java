package util;

import Model.DisplayAlert;
import database.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * IdConverter methods for quick translation between ID's and Strings
 */
public class IDConverter {

    /**
     * static connection variable for access throughout program
     */
    static Connection connection = JDBC.connection;

    /**
     *
     * @param id id to be converted
     * @return Division String from id
     */
    public static String convertDivisionToString(int id)
    {
        try {
            String sqlquery =    "SELECT * " +
                            "FROM CLIENT_SCHEDULE.FIRST_LEVEL_DIVISIONS " +
                            "WHERE DIVISION_ID = ?";

            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
            preparedstatement.setString(1,String.valueOf(id));

            preparedstatement.execute();
            ResultSet resultset = preparedstatement.getResultSet();

            resultset.next();

            return resultset.getString("Division");
        } catch (SQLException exception) {
            DisplayAlert.ErrorMessage("SQL Database Error: " + exception.getErrorCode());
        }
        return "";
    }

    /**
     *
     * @param name name to be converted
     * @return Division id from name
     */
    public static int convertDivisionToID(String name)
    {
        try {
            String sqlquery =    "SELECT * " +
                    "FROM CLIENT_SCHEDULE.FIRST_LEVEL_DIVISIONS " +
                    "WHERE DIVISION = ?";

            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
            preparedstatement.setString(1,name);

            preparedstatement.execute();
            ResultSet resultset = preparedstatement.getResultSet();

            resultset.next();

            return resultset.getInt("Division_ID");
        } catch (SQLException exception) {
            DisplayAlert.ErrorMessage("SQL Database Error: " + exception.getErrorCode());
        }
        return 0;
    }

    /**
     *
     * @param id id to be converted
     * @return Country String from id
     */
    public static String convertDivisionToCountryString(int id)
    {
        try {
            String sqlquery =    "SELECT * " +
                    "FROM CLIENT_SCHEDULE.FIRST_LEVEL_DIVISIONS " +
                    "WHERE DIVISION_ID = ?";

            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);

            preparedstatement.setString(1,String.valueOf(id));

            preparedstatement.execute();
            ResultSet resultset = preparedstatement.getResultSet();

            resultset.next();
            int countryID = resultset.getInt("Country_ID");

            sqlquery =   "SELECT * " +
                    "FROM CLIENT_SCHEDULE.COUNTRIES " +
                    "WHERE COUNTRY_ID = ?";
            preparedstatement = connection.prepareStatement(sqlquery);

            preparedstatement.setString(1,String.valueOf(countryID));

            preparedstatement.execute();
            resultset = preparedstatement.getResultSet();

            resultset.next();

            return resultset.getString("Country");
        } catch (SQLException exception) {
            DisplayAlert.ErrorMessage("SQL Database Error: " + exception.getErrorCode());
        }
        return "";
    }

    /**
     *
     * @param id id to be converted
     * @return Customer String from id
     */
    public static String convertCustomerToString(int id)
    {
        try {
            String sqlquery =    "SELECT * " +
                            "FROM CLIENT_SCHEDULE.CUSTOMERS " +
                            "WHERE CUSTOMER_ID = ?";
            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);

            preparedstatement.setString(1,String.valueOf(id));

            preparedstatement.execute();
            ResultSet resultset = preparedstatement.getResultSet();

            resultset.next();

            return resultset.getString("CUSTOMER_NAME");
        } catch (SQLException exception) {
            DisplayAlert.ErrorMessage("SQL Database Error: " + exception.getErrorCode());
        }
        return "";
    }

    /**
     *
     * @param id id to be converted
     * @return User String from id
     */
    public static String convertUserToString(int id)
    {
        try {
            String sqlquery =    "SELECT * " +
                    "FROM CLIENT_SCHEDULE.USERS " +
                    "WHERE USER_ID = ?";
            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);

            preparedstatement.setString(1,String.valueOf(id));

            preparedstatement.execute();
            ResultSet resultset = preparedstatement.getResultSet();

            resultset.next();

            return resultset.getString("USER_NAME");
        } catch (SQLException exception) {
            DisplayAlert.ErrorMessage("SQL Database Error: " + exception.getErrorCode());
        }
        return "";
    }

    /**
     *
     * @param id id to be converted
     * @return Contact String from id
     */
    public static String converContactToString(int id)
    {
        try {
            String sqlquery =    "SELECT * " +
                    "FROM CLIENT_SCHEDULE.CONTACTS " +
                    "WHERE CONTACT_ID = ?";
            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);

            preparedstatement.setString(1,String.valueOf(id));


            preparedstatement.execute();
            ResultSet resultset = preparedstatement.getResultSet();

            resultset.next();

            return resultset.getString("CONTACT_NAME");
        } catch (SQLException exception) {
            DisplayAlert.ErrorMessage("SQL Database Error: " + exception.getErrorCode());
        }
        return "";
    }

    /**
     *
     * @param name name to be converted
     * @return Contact id from name
     */
    public static int converContactToID(String name)
    {
        try {
            String sqlquery =    "SELECT * " +
                    "FROM CLIENT_SCHEDULE.CONTACTS " +
                    "WHERE CONTACT_NAME = ?";
            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);

            preparedstatement.setString(1,name);


            preparedstatement.execute();
            ResultSet resultset = preparedstatement.getResultSet();

            resultset.next();

            return resultset.getInt("CONTACT_ID");
        } catch (SQLException exception) {
            DisplayAlert.ErrorMessage("SQL Database Error: " + exception.getErrorCode());
        }
        return 0;
    }

    /**
     *
     * @param name name to be converted
     * @return Country id from name
     */
    public static int convertCountryToID(String name)
    {
        try {
            String sqlquery =    "SELECT * " +
                    "FROM CLIENT_SCHEDULE.COUNTRIES " +
                    "WHERE COUNTRY = ?";
            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);

            preparedstatement.setString(1,name);


            preparedstatement.execute();
            ResultSet resultset = preparedstatement.getResultSet();

            resultset.next();

            return resultset.getInt("COUNTRY_ID");
        } catch (SQLException exception) {
            DisplayAlert.ErrorMessage("SQL Database Error: " + exception.getErrorCode());
        }
        return 0;
    }
}
