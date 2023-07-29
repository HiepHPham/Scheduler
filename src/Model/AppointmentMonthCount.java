package Model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.Month;

/**
 * Appointment Month Count class for the two columns in Report
 */
public class AppointmentMonthCount {
    /**
     * month and count variable for simple data management
     * month is month of appointment
     * count is frequency of month
     * list to hold all variables together as an object
     */
    public Month month;
    public int count;
    public static ObservableList<AppointmentMonthCount> appointmentMonthCounts = FXCollections.observableArrayList();

    /**
     *
     * @return returns Appointment month
     */
    public Month getMonth() {
        return month;
    }

    /**
     *
     * @return returns Appointment month count
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @return returns Appointment Month count list
     */
    public static ObservableList<AppointmentMonthCount> getAppointmentMonthCounts() {
        return appointmentMonthCounts;
    }

    /**
     *
     * @param month Appointment month for column
     * @param count Count of Appointment months for column
     */
    public AppointmentMonthCount(Month month, int count) {
        this.month = month;
        this.count = count;
    }
}
