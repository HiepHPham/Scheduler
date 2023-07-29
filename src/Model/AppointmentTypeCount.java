package Model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Appointment Type Count class for the two columns in Report
 */
public class AppointmentTypeCount {
    /**
     * type and count variable for simple data management
     * type is type of appointment
     * count is frequency of type
     * list to hold all variables together as an object
     */
    public String type;
    public int count;
    public static ObservableList<AppointmentTypeCount> appointmentTypeCounts = FXCollections.observableArrayList();

    /**
     *
     * @param type Appointment type for column
     * @param count Count of Appointment type for column
     */
    public AppointmentTypeCount(String type, int count) {
        this.type = type;
        this.count = count;
    }

    /**
     * @return returns Appointment Type
     */
    public String getType() {
        return type;
    }

    /**
     * @return returns Appointment type count
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @return returns appointment Type Count list
     */
    public static ObservableList<AppointmentTypeCount> getAppointmentTypeCounts() {
        return appointmentTypeCounts;
    }
}
