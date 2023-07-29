package Model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Appointment object to store objects for easy access through lists and computation
 */
public class Appointment {

    /**
     * Customer related fields from database
     */
    private int id;
    private String title;
    private String description;
    private String location;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    private String create_date;
    private String created_by;
    private String last_update;
    private String last_updated_by;
    private int customer_id;
    private int user_id;
    private int contact_id;

    /**
     * Time Zoned time derived from database time
     */
    private ZonedDateTime startDateTimeZoned;
    private ZonedDateTime endDateTimeZoned;
    private String formattedStartDateTimeZoned;
    private String formattedEndDateTimeZoned;

    /**
     * ID translated to String fields
     */
    private String customer;
    private String user;
    private String contact;

    /**
     * Constructor for Appointment, loaded from database or added through application
     * @param id appointment id to be set
     * @param title title to be set
     * @param description description to be set
     * @param location location to be set
     * @param type type to be set
     * @param start start to be set
     * @param end end to be set
     * @param create_date create date to be set
     * @param created_by created by to be set
     * @param last_update last update to be set
     * @param last_updated_by last updated by to be set
     * @param customer_id customer id to be set
     * @param user_id user id to be set
     * @param contact_id contact id to be set
     * @param startDateTimeZoned start time based on User's timezone to be set
     * @param endDateTimeZoned end time based on User's timezone to be set
     * @param formattedStartDateTimeZoned String start time based on User's timezone to be set
     * @param formattedEndDateTimeZoned String end time based on User's timezone to be set
     * @param customer customer to be set
     * @param user user to be set
     * @param contact contact to be set
     */
    public Appointment(int id, String title, String description, String location, String type, LocalDateTime start, LocalDateTime end,
                       String create_date, String created_by, String last_update, String last_updated_by,
                       int customer_id, int user_id, int contact_id, ZonedDateTime startDateTimeZoned,
                       ZonedDateTime endDateTimeZoned, String formattedStartDateTimeZoned, String formattedEndDateTimeZoned,
                       String customer, String user, String contact) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
        this.create_date = create_date;
        this.created_by = created_by;
        this.last_update = last_update;
        this.last_updated_by = last_updated_by;
        this.customer_id = customer_id;
        this.user_id = user_id;
        this.contact_id = contact_id;
        this.startDateTimeZoned = startDateTimeZoned;
        this.endDateTimeZoned = endDateTimeZoned;
        this.formattedStartDateTimeZoned = formattedStartDateTimeZoned;
        this.formattedEndDateTimeZoned = formattedEndDateTimeZoned;
        this.customer = customer;
        this.user = user;
        this.contact = contact;
    }

    /**
     *
     * @return returns Appointment ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return returns Appointment Title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return returns Appointment Description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return returns Appointment Location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @return returns Appointment Type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return returns Appointment Start
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     *
     * @return returns Appointment End
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     *
     * @return returns Appointment Customer ID
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     *
     * @return returns Appointment User ID
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     *
     * @return returns Appointment Contact Name
     */
    public String getContact() {
        return contact;
    }

    /**
     *
     * @return returns Appointment End zoned with user's timezone
     */
    public ZonedDateTime getEndDateTimeZoned() {
        return endDateTimeZoned;
    }

    /**
     *
     * @return returns Appointment Start zoned with user's timezone
     */
    public ZonedDateTime getStartDateTimeZoned() {
        return startDateTimeZoned;
    }

    /**
     *
     * @return returns Appointment String start
     */
    public String getFormattedStartDateTimeZoned() {
        return formattedStartDateTimeZoned;
    }

    /**
     *
     * @return returns Appointment String End
     */
    public String getFormattedEndDateTimeZoned() {
        return formattedEndDateTimeZoned;
    }

    /**
     * @return returns Appointment Create date
     */
    public String getCreate_date() {
        return create_date;
    }

    /**
     * @return returns Appointment created by user
     */
    public String getCreated_by() {
        return created_by;
    }

    /**
     * @return returns Appointment Last update date
     */
    public String getLast_update() {
        return last_update;
    }

    /**
     * @return returns Appointment last updated user
     */
    public String getLast_updated_by() {
        return last_updated_by;
    }

    /**
     * @return returns Appointment contact id
     */
    public int getContact_id() {
        return contact_id;
    }

    /**
     * @return returns Appointment customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @return returns Appointment user
     */
    public String getUser() {
        return user;
    }
}
