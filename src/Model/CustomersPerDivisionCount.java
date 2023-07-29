package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * CustomersPerDivisionCount Object to hold the two columns for Report
 */
public class CustomersPerDivisionCount {
    /**
     * division and count variable for simple data management
     * division is division of appointment
     * count is frequency of division
     * list to hold all variables together as an object
     */
    public String division;
    public int count;
    public static ObservableList<CustomersPerDivisionCount> customersPerDivisionCounts = FXCollections.observableArrayList();

    /**
     *
     * @return returns Division for customer count
     */
    public String getDivision() {
        return division;
    }

    /**
     *
     * @return returns Customer count
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @return returns Customer per division count list
     */
    public static ObservableList<CustomersPerDivisionCount> getCustomersPerDivisionCounts() {
        return customersPerDivisionCounts;
    }

    /**
     * Constructor for CustomersPerDivisionCount, automatically populated during initialize query
     * @param division division to be set for column
     * @param count division count to be set for column
     */
    public CustomersPerDivisionCount(String division, int count) {
        this.division = division;
        this.count = count;
    }
}
