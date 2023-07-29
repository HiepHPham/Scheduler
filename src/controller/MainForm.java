package controller;

import Model.*;
import database.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import util.IDConverter;
import util.TimeZoneConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.TimeZone;

/**
 * Main Form for all functions of Program, navigated through tabs
 * LAMBDA #1 -- purpose is to simplify creating monthly and weekly lists from the allAppointments list
 * LAMBDA #2 -- purpose is to quickly gather System's Time Zone and assign it to interface TimeZone's
 */
public class MainForm {

    /**
     * Appointments tab
     */
    //All Appointments tab
    @FXML
    private Tab AppointmentAllAppointmentstab;

    @FXML
    public TableView<Appointment> AppointmentAllAppointmentstable;
    @FXML
    private TableColumn<Appointment,Integer> AppointmentAllAppointmentsAppointmentIDcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentAllAppointmentsContactcol;
    @FXML
    private TableColumn<Appointment,Integer> AppointmentAllAppointmentsCustomerIDcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentAllAppointmentsDescriptioncol;
    @FXML
    private TableColumn<Appointment, ZonedDateTime> AppointmentAllAppointmentsEndcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentAllAppointmentsLocationcol;
    @FXML
    private TableColumn<Appointment,ZonedDateTime> AppointmentAllAppointmentsStartcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentAllAppointmentsTitlecol;
    @FXML
    private TableColumn<Appointment,String> AppointmentAllAppointmentsTypecol;
    @FXML
    private TableColumn<Appointment,Integer> AppointmentAllAppointmentsUserIDcol;

    //Monthly Appointments tab
    @FXML
    private Tab AppointmentMonthlyAppointmentstab;

    @FXML
    public TableView<Appointment> AppointmentMonthlyAppointmentstable;
    @FXML
    private TableColumn<Appointment,Integer> AppointmentMonthlyAppointmentsAppointmentIDcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentMonthlyAppointmentsContactcol;
    @FXML
    private TableColumn<Appointment,Integer> AppointmentMonthlyAppointmentsCustomerIDcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentMonthlyAppointmentsDescriptioncol;
    @FXML
    private TableColumn<Appointment,ZonedDateTime> AppointmentMonthlyAppointmentsEndcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentMonthlyAppointmentsLocationcol;
    @FXML
    private TableColumn<Appointment,ZonedDateTime> AppointmentMonthlyAppointmentsStartcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentMonthlyAppointmentsTitlecol;
    @FXML
    private TableColumn<Appointment,String> AppointmentMonthlyAppointmentsTypecol;
    @FXML
    private TableColumn<Appointment,Integer> AppointmentMonthlyAppointmentsUserIDcol;

    //Weekly Appointments tab
    @FXML
    private Tab AppointmentWeeklyAppointmentstab;

    public TableView<Appointment> AppointmentWeeklyAppointmentstable;
    @FXML
    private TableColumn<Appointment,Integer> AppointmentWeeklyAppointmentsAppointmentIDcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentWeeklyAppointmentsContactcol;
    @FXML
    private TableColumn<Appointment,Integer> AppointmentWeeklyAppointmentsCustomerIDcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentWeeklyAppointmentsDescriptioncol;
    @FXML
    private TableColumn<Appointment,ZonedDateTime> AppointmentWeeklyAppointmentsEndcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentWeeklyAppointmentsLocationcol;
    @FXML
    private TableColumn<Appointment,ZonedDateTime> AppointmentWeeklyAppointmentsStartcol;
    @FXML
    private TableColumn<Appointment,String> AppointmentWeeklyAppointmentsTitlecol;
    @FXML
    private TableColumn<Appointment,String> AppointmentWeeklyAppointmentsTypecol;
    @FXML
    private TableColumn<Appointment,Integer> AppointmentWeeklyAppointmentsUserIDcol;


    //CRUD Appointment
    @FXML
    private TextField AppointmentIDtxt;
    @FXML
    private TextField AppointmentTitletxt;
    @FXML
    private TextField AppointmentDescriptiontxt;
    @FXML
    private TextField AppointmentLocationtxt;
    @FXML
    private ComboBox<String> AppointmentContactpicker;
    @FXML
    private TextField AppointmentTypetxt;
    @FXML
    private DatePicker AppointmentDatepicker;
    @FXML
    private ComboBox<String> AppointmentStartTimepicker;
    @FXML
    private ComboBox<String> AppointmentEndTimepicker;
    @FXML
    private TextField AppointmentCustomerIDtxt;
    @FXML
    private TextField AppointmentUserIDtxt;
    @FXML
    private Button AppointmentResetFieldsbutton;
    @FXML
    private Button AppointmentAddAppointmentbutton;

    @FXML
    private Button AppointmentUpdateAppointmentbutton;
    @FXML
    private Button AppointmentDeleteAppointmentbutton;


    /**
     * Customers tab
     */
    //Customer table
    @FXML
    public TableView<Customer> CustomerCustomerstable;
    @FXML
    private TableColumn<Customer,Integer> CustomerCustomerIDcol;
    @FXML
    private TableColumn<Customer,String> CustomerCustomerNamecol;
    @FXML
    private TableColumn<Customer,String> CustomerCustomerAddresscol;
    @FXML
    private TableColumn<Customer,String> CustomerCustomerPhonecol;
    @FXML
    public TableColumn<Customer,String> CustomerCustomerCountrycol;
    @FXML
    private TableColumn<Customer,Integer> CustomerCustomerDivisionIDcol;
    @FXML
    private TableColumn<Customer,String> CustomerCustomerPostalCodecol;


    //CRUD Customer
    @FXML
    private TextField CustomerCustomerIDtxt;
    @FXML
    private TextField CustomerCustomerNametxt;
    @FXML
    private TextField CustomerCustomerPhonetxt;
    @FXML
    private TextField CustomerCustomerAddresstxt;
    @FXML
    private ComboBox<String> CustomerCustomerCountrypicker;
    @FXML
    private ComboBox<String> CustomerCustomerDivisionpicker;
    @FXML
    private TextField CustomerCustomerPostalCodetxt;
    @FXML
    private Button CustomerResetFieldsbutton;
    @FXML
    private Button CustomerAddCustomerbutton;

    @FXML
    private Button CustomerUpdateCustomerbutton;
    @FXML
    private Button CustomerDeleteCustomerbutton;


    /**
     * Reports tab
     */
    //Total Customer Appointments by Type/Month tab
    //Appointment Type Count table
    @FXML
    public TableView<AppointmentTypeCount> ReportAppointmentTypetable;
    @FXML
    private TableColumn<AppointmentTypeCount,String> ReportAppointmentTypecol;
    @FXML
    private TableColumn<AppointmentTypeCount,Integer> ReportAppointmentTypeCountcol;

    //Appointment Month Count table
    @FXML
    public TableView<AppointmentMonthCount> ReportAppointmentMonthtable;
    @FXML
    private TableColumn<AppointmentMonthCount,Month> ReportAppointmentMonthcol;
    @FXML
    private TableColumn<AppointmentMonthCount,Integer> ReportAppointmentMonthCountcol;


    //Appointment Schedule Per Contact tab
    @FXML
    private ComboBox<String> ReportContactpicker;

    //Appointment Schedule Per Contact table
    @FXML
    public TableView<Appointment> ReportContacttable;
    @FXML
    private TableColumn<Appointment,Integer> ReportAppointmentIDcol;
    @FXML
    private TableColumn<Appointment,String> ReportAppointmentTitlecol;
    @FXML
    public TableColumn<Appointment, String> ReportAppointmentTypePerContactcol;
    @FXML
    private TableColumn<Appointment,String> ReportAppointmentDescriptioncol;
    @FXML
    private TableColumn<Appointment,ZonedDateTime> ReportAppointmentStartcol;
    @FXML
    private TableColumn<Appointment,ZonedDateTime> ReportAppointmentEndcol;
    @FXML
    private TableColumn<Appointment,Integer> ReportAppointmentCustomerIDcol;


    //Total Customers Per Division tab
    //Total Customers Per Division table
    @FXML
    public TableView<CustomersPerDivisionCount> ReportDivisiontable;
    @FXML
    private TableColumn<CustomersPerDivisionCount,String> ReportDivisioncol;
    @FXML
    private TableColumn<CustomersPerDivisionCount,Integer> ReportDivisionCustomerCountcol;


    /**
     * Static variables for each tab
     * Lists for Appointment + Customer + Reports Data
     *
     */
    //Customers table
    ObservableList<Customer> allCustomers = FXCollections.observableArrayList();


    //Appointments table
    static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
    FilteredList<Appointment> monthlyAppointments;
    FilteredList<Appointment> weeklyAppointments;


    //Reports Appointment Type/Month tables
    ObservableList<String> appointmentType = FXCollections.observableArrayList();
    ObservableList<String> appointmentTypeWithDuplicates = FXCollections.observableArrayList();
    ObservableList<Month> appointmentMonth = FXCollections.observableArrayList();
    ObservableList<Month> appointmentMonthWithDuplicates = FXCollections.observableArrayList();

    //Reports Appointments per Contact table
    ObservableList<Appointment> appointmentPerContact = FXCollections.observableArrayList();
    ObservableList<String> allContacts = FXCollections.observableArrayList();

    //Reports Customer Count per Division table
    ObservableList<String> divisions = FXCollections.observableArrayList();
    ObservableList<String> divisionsWithDuplicates = FXCollections.observableArrayList();


    /**
     * Variables for computation
     */
    ObservableList<Integer> allUserIDs = FXCollections.observableArrayList();

    ObservableList<String> allCountries = FXCollections.observableArrayList();

    ObservableList<String> USDivisions = FXCollections.observableArrayList();
    ObservableList<String> CanadaDivisions = FXCollections.observableArrayList();
    ObservableList<String> UKDivisions= FXCollections.observableArrayList();

    ObservableList<String> timeList = FXCollections.observableArrayList();

    Connection connection = JDBC.connection;


    /**
     * Initializes and populates ALL tables in every tab.
     * Designed to be able to rerun, acts as a refresh on all data
     *
     *
     * LAMBDA #1 -- purpose is to simplify creating monthly and weekly lists from the allAppointments list
     * LAMBDA #2 -- purpose is to quickly gather System's Time Zone and assign it to interface TimeZone's
     *
     */
    public void initialize() {


        /**
         * Populating allCustomers list from Database
         */
        try {
            String sqlquery =   "SELECT * " +
                                "FROM CLIENT_SCHEDULE.CUSTOMERS";

            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
            preparedstatement.execute();
            ResultSet customerResultSet = preparedstatement.getResultSet();


            allCustomers.clear();
            divisionsWithDuplicates.clear();
            divisions.clear();
            while(customerResultSet.next())
            {
                Customer tempCustomer = new Customer(customerResultSet.getInt("Customer_ID"),
                        customerResultSet.getString("Customer_Name"),
                        customerResultSet.getString("Address"),
                        customerResultSet.getString("Postal_Code"),
                        customerResultSet.getString("Phone"),
                        customerResultSet.getString("Create_Date"),
                        customerResultSet.getString("Created_By"),
                        customerResultSet.getString("Last_Update"),
                        customerResultSet.getString("Last_Updated_By"),
                        customerResultSet.getInt("Division_ID"),
                        IDConverter.convertDivisionToString(customerResultSet.getInt("Division_ID")),
                        IDConverter.convertDivisionToCountryString(customerResultSet.getInt("Division_ID")));

                allCustomers.add(tempCustomer);


                /**
                 * Report Customers Per Division
                 * Gathers division names and its counts
                 */
                divisionsWithDuplicates.add(tempCustomer.getDivision());
                if(!divisions.contains(tempCustomer.getDivision()))
                {
                    divisions.add(tempCustomer.getDivision());
                }
            }

        }
        catch(SQLException exception)
        {
            DisplayAlert.ErrorMessage("SQL Exception Error: " + exception.getErrorCode());
        }


        /**
        * Populating allContacts list from database
        */
        try {
            String sqlquery =   "SELECT * " +
                                "FROM CLIENT_SCHEDULE.CONTACTS";

            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
            preparedstatement.execute();
            ResultSet contactResultSet = preparedstatement.getResultSet();

            allContacts.clear();
            while(contactResultSet.next())
            {
                allContacts.add(contactResultSet.getString("Contact_Name"));
            }


            AppointmentContactpicker.setItems(allContacts);
            ReportContactpicker.setItems(allContacts);

        }
        catch(SQLException exception)
        {
            DisplayAlert.ErrorMessage("SQL Exception Error: " + exception.getErrorCode());
        }


        /**
         * Populating allUserIDs list from database
         */
        try {
            String sqlquery =   "SELECT * " +
                    "FROM CLIENT_SCHEDULE.USERS";

            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
            preparedstatement.execute();
            ResultSet userResultSet = preparedstatement.getResultSet();

            allUserIDs.clear();
            while(userResultSet.next())
            {
                allUserIDs.add(userResultSet.getInt("USER_ID"));
            }
        }
        catch(SQLException exception)
        {
            DisplayAlert.ErrorMessage("SQL Exception Error: " + exception.getErrorCode());
        }

        /**
         * Populate allCountries from database
         */
        try {
            String sqlquery =   "SELECT * FROM " +
                                "CLIENT_SCHEDULE.COUNTRIES";
            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
            preparedstatement.execute();
            ResultSet countriesResultset = preparedstatement.getResultSet();

            allCountries.clear();
            while(countriesResultset.next())
            {
                if(!allCountries.contains(countriesResultset.getString("Country")))
                {
                    allCountries.add(countriesResultset.getString("Country"));
                }

                CustomerCustomerCountrypicker.setItems(allCountries);
            }
        }
        catch(SQLException exception)
        {
            DisplayAlert.ErrorMessage("Countries SQL Exception Error: " + exception.getErrorCode());
        }



        /**
         * Populate allDivisions, USDivisions, UKDivisions, and CanadaDivisions from database
         */
        try {
            String sqlquery =   "SELECT * FROM " +
                    "CLIENT_SCHEDULE.FIRST_LEVEL_DIVISIONS";
            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
            preparedstatement.execute();
            ResultSet divisionsResultset = preparedstatement.getResultSet();

            USDivisions.clear();
            UKDivisions.clear();
            CanadaDivisions.clear();
            while(divisionsResultset.next())
            {
                //US
                if(divisionsResultset.getInt("Country_ID") == 1)
                {
                    USDivisions.add(divisionsResultset.getString("Division"));
                }
                //UK
                else if(divisionsResultset.getInt("Country_ID") == 2)
                {
                    UKDivisions.add(divisionsResultset.getString("Division"));
                }
                //Canada
                else if(divisionsResultset.getInt("Country_ID") == 3)
                {
                    CanadaDivisions.add(divisionsResultset.getString("Division"));
                }
            }
        }
        catch(SQLException exception)
        {
            DisplayAlert.ErrorMessage("Division SQL Exception Error: " + exception.getErrorCode());
        }

        /**
         * Populates allAppointments from database
         */
        try {
            String sqlquery = "SELECT * " +
                    "FROM CLIENT_SCHEDULE.APPOINTMENTS";

            PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
            preparedstatement.execute();
            ResultSet appointmentResultSet = preparedstatement.getResultSet();


            DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


            allAppointments.clear();
            appointmentType.clear();
            appointmentTypeWithDuplicates.clear();
            appointmentMonth.clear();
            appointmentMonthWithDuplicates.clear();
            while(appointmentResultSet.next())
            {
                /**
                 * UTC and Local Time Zone setup
                 */
                LocalDateTime UTCStart = LocalDateTime.parse(appointmentResultSet.getString("Start"),
                        datetimeformatter);
                LocalDateTime UTCEnd = LocalDateTime.parse(appointmentResultSet.getString("End"),
                        datetimeformatter);

                ZonedDateTime zonedStart = TimeZoneConverter.convertToLocalTime(UTCStart);
                ZonedDateTime zonedEnd = TimeZoneConverter.convertToLocalTime(UTCEnd);

                String formattedZonedStart = zonedStart.format(datetimeformatter);
                String formattedZonedEnd = zonedEnd.format(datetimeformatter);

                /**
                 * Create Appointment Object
                 */
                Appointment tempAppointment = new Appointment(appointmentResultSet.getInt("Appointment_ID"),
                        appointmentResultSet.getString("Title"),
                        appointmentResultSet.getString("Description"),
                        appointmentResultSet.getString("Location"),
                        appointmentResultSet.getString("Type"),
                        UTCStart,
                        UTCEnd,
                        appointmentResultSet.getString("Create_Date"),
                        appointmentResultSet.getString("Created_By"),
                        appointmentResultSet.getString("Last_Update"),
                        appointmentResultSet.getString("last_updated_by"),
                        appointmentResultSet.getInt("Customer_ID"),
                        appointmentResultSet.getInt("User_ID"),
                        appointmentResultSet.getInt("Contact_ID"),
                        zonedStart,
                        zonedEnd,
                        formattedZonedStart,
                        formattedZonedEnd,
                        IDConverter.convertCustomerToString(appointmentResultSet.getInt("Customer_ID")),
                        IDConverter.convertUserToString(appointmentResultSet.getInt("User_ID")),
                        IDConverter.converContactToString(appointmentResultSet.getInt("Contact_ID")));

                allAppointments.add(tempAppointment);


                /**
                 * Monthly and Weekly appointment add
                 * LAMBDA #1 -- purpose is to simplify creating monthly and weekly lists from the allAppointments list
                 * using parameters to determine within month or within week
                 */
                monthlyAppointments = new FilteredList<>(allAppointments, appt -> (
                        appt.getStartDateTimeZoned().isBefore(ZonedDateTime.now().plusMonths(1)) &&
                                appt.getStartDateTimeZoned().isAfter(ZonedDateTime.now()
                        )));
                weeklyAppointments = new FilteredList<>(allAppointments, appt -> (
                        appt.getStartDateTimeZoned().isBefore(ZonedDateTime.now().plusWeeks(1)) &&
                                appt.getStartDateTimeZoned().isAfter(ZonedDateTime.now()
                                )));

                /*
                //Commented out in favor of use of Lambda
                if(tempAppointment.getStartDateTimeZoned().isBefore(ZonedDateTime.now().plusMonths(1)) &&
                        tempAppointment.getStartDateTimeZoned().isAfter(ZonedDateTime.now()))
                {
                    monthlyAppointments.add(tempAppointment);

                    if(tempAppointment.getStartDateTimeZoned().isBefore(ZonedDateTime.now().plusWeeks(1)))
                    {
                        weeklyAppointments.add(tempAppointment);
                    }
                }
                */


                /**
                 * Populates AppointmentType and appointmentMonth with and without duplicates
                 * determines count for Report table
                 */
                //Report Appointment Type/Month
                appointmentTypeWithDuplicates.add(tempAppointment.getType());
                appointmentMonthWithDuplicates.add(tempAppointment.getStart().getMonth());

                if(!appointmentType.contains(tempAppointment.getType()))
                {
                    appointmentType.add(tempAppointment.getType());
                }
                if(!appointmentMonth.contains(tempAppointment.getStart().getMonth()))
                {
                    appointmentMonth.add(tempAppointment.getStart().getMonth());
                }
            }
        }
        catch(SQLException exception)
        {
            DisplayAlert.ErrorMessage("SELECT APPOINTMENTS SQL Exception Error: " + exception.getErrorCode());
        }



        /**
        * Populates Appointment table in App
        */
        AppointmentAllAppointmentstable.setItems(allAppointments);
        AppointmentAllAppointmentsAppointmentIDcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        AppointmentAllAppointmentsTitlecol.setCellValueFactory(new PropertyValueFactory<>("title"));
        AppointmentAllAppointmentsDescriptioncol.setCellValueFactory(new PropertyValueFactory<>("description"));
        AppointmentAllAppointmentsLocationcol.setCellValueFactory(new PropertyValueFactory<>("location"));
        AppointmentAllAppointmentsContactcol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        AppointmentAllAppointmentsTypecol.setCellValueFactory(new PropertyValueFactory<>("type"));
        AppointmentAllAppointmentsStartcol.setCellValueFactory(new PropertyValueFactory<>("formattedStartDateTimeZoned"));
        AppointmentAllAppointmentsEndcol.setCellValueFactory(new PropertyValueFactory<>("formattedEndDateTimeZoned"));
        AppointmentAllAppointmentsCustomerIDcol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        AppointmentAllAppointmentsUserIDcol.setCellValueFactory(new PropertyValueFactory<>("user_id"));


        AppointmentMonthlyAppointmentstable.setItems(monthlyAppointments);
        AppointmentMonthlyAppointmentsAppointmentIDcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        AppointmentMonthlyAppointmentsTitlecol.setCellValueFactory(new PropertyValueFactory<>("title"));
        AppointmentMonthlyAppointmentsDescriptioncol.setCellValueFactory(new PropertyValueFactory<>("description"));
        AppointmentMonthlyAppointmentsLocationcol.setCellValueFactory(new PropertyValueFactory<>("location"));
        AppointmentMonthlyAppointmentsContactcol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        AppointmentMonthlyAppointmentsTypecol.setCellValueFactory(new PropertyValueFactory<>("type"));
        AppointmentMonthlyAppointmentsStartcol.setCellValueFactory(new PropertyValueFactory<>("formattedStartDateTimeZoned"));
        AppointmentMonthlyAppointmentsEndcol.setCellValueFactory(new PropertyValueFactory<>("formattedEndDateTimeZoned"));
        AppointmentMonthlyAppointmentsCustomerIDcol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        AppointmentMonthlyAppointmentsUserIDcol.setCellValueFactory(new PropertyValueFactory<>("user_id"));


        AppointmentWeeklyAppointmentstable.setItems(weeklyAppointments);
        AppointmentWeeklyAppointmentsAppointmentIDcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        AppointmentWeeklyAppointmentsTitlecol.setCellValueFactory(new PropertyValueFactory<>("title"));
        AppointmentWeeklyAppointmentsDescriptioncol.setCellValueFactory(new PropertyValueFactory<>("description"));
        AppointmentWeeklyAppointmentsLocationcol.setCellValueFactory(new PropertyValueFactory<>("location"));
        AppointmentWeeklyAppointmentsContactcol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        AppointmentWeeklyAppointmentsTypecol.setCellValueFactory(new PropertyValueFactory<>("type"));
        AppointmentWeeklyAppointmentsStartcol.setCellValueFactory(new PropertyValueFactory<>("formattedStartDateTimeZoned"));
        AppointmentWeeklyAppointmentsEndcol.setCellValueFactory(new PropertyValueFactory<>("formattedEndDateTimeZoned"));
        AppointmentWeeklyAppointmentsCustomerIDcol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        AppointmentWeeklyAppointmentsUserIDcol.setCellValueFactory(new PropertyValueFactory<>("user_id"));

        System.out.println("Appointments added to all Appointment tables");


        /**
         * Populates Customers table in App
         */
        CustomerCustomerstable.setItems(allCustomers);

        CustomerCustomerIDcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        CustomerCustomerNamecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        CustomerCustomerAddresscol.setCellValueFactory(new PropertyValueFactory<>("address"));
        CustomerCustomerPhonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        CustomerCustomerCountrycol.setCellValueFactory(new PropertyValueFactory<>("country"));
        CustomerCustomerDivisionIDcol.setCellValueFactory(new PropertyValueFactory<>("division_id"));
        CustomerCustomerPostalCodecol.setCellValueFactory(new PropertyValueFactory<>("postal_code"));

        System.out.println("Customers added to Customers table");


        /**
         * Populates Report Appointment Types in App
         */

        //Gathering data
        AppointmentTypeCount.appointmentTypeCounts.clear();
        for(String type : appointmentType)
        {
            int total = Collections.frequency(appointmentTypeWithDuplicates, type);
            AppointmentTypeCount.appointmentTypeCounts.add(new AppointmentTypeCount(type, total));
        }

        //Populating table
        ReportAppointmentTypetable.setItems(AppointmentTypeCount.appointmentTypeCounts);
        ReportAppointmentTypecol.setCellValueFactory(new PropertyValueFactory<>("type"));
        ReportAppointmentTypeCountcol.setCellValueFactory(new PropertyValueFactory<>("count"));

        //Sort table
        ReportAppointmentTypeCountcol.setSortType(TableColumn.SortType.DESCENDING);
        ReportAppointmentTypetable.getSortOrder().add(ReportAppointmentTypeCountcol);
        ReportAppointmentTypetable.sort();

        System.out.println("Appointment Types have been added to Reports table");


        /**
         * Populates Report Appointment Months in App
         */

        //Gathering data
        AppointmentMonthCount.appointmentMonthCounts.clear();
        for(Month month : appointmentMonth)
        {
            int total = Collections.frequency(appointmentMonthWithDuplicates, month);
            AppointmentMonthCount.appointmentMonthCounts.add(new AppointmentMonthCount(month, total));
        }

        //Populating table
        ReportAppointmentMonthtable.setItems(AppointmentMonthCount.appointmentMonthCounts);
        ReportAppointmentMonthcol.setCellValueFactory(new PropertyValueFactory<>("Month"));
        ReportAppointmentMonthCountcol.setCellValueFactory(new PropertyValueFactory<>("count"));

        //Sort table
        ReportAppointmentMonthCountcol.setSortType(TableColumn.SortType.DESCENDING);
        ReportAppointmentMonthtable.getSortOrder().add(ReportAppointmentMonthCountcol);
        ReportAppointmentMonthtable.sort();

        System.out.println("Appointment Months have been added to Reports table");

        /**
         * Populates Report Customers Per Division in App
         */

        //Generate data
        CustomersPerDivisionCount.customersPerDivisionCounts.clear();
        for(String division : divisions)
        {
            int total = Collections.frequency(divisionsWithDuplicates, division);
            CustomersPerDivisionCount.customersPerDivisionCounts.add(new CustomersPerDivisionCount(division, total));
        }

        //Populate table
        ReportDivisiontable.setItems(CustomersPerDivisionCount.customersPerDivisionCounts);
        ReportDivisioncol.setCellValueFactory(new PropertyValueFactory<>("division"));
        ReportDivisionCustomerCountcol.setCellValueFactory(new PropertyValueFactory<>("count"));

        //Sort table
        ReportDivisionCustomerCountcol.setSortType(TableColumn.SortType.DESCENDING);
        ReportDivisiontable.getSortOrder().add(ReportDivisionCustomerCountcol);
        ReportDivisiontable.sort();

        System.out.println("Customers Per Division have been added to Reports table");


        /**
         * Set Start/End Time Combo Boxes
         */

        /**
         * Lambda #2 -- purpose is to quickly gather System's Time Zone and assign it to interface TimeZone's
         * TimeZone method and returns it as a String.
         *
         * Utilized in creating ZonedDateTime variables of Business Hour constraints
         */
        Model.TimeZone currentTimeZone = () -> {
            TimeZone systemTimeZone = TimeZone.getDefault();
            return systemTimeZone.getID();
        };

        ZonedDateTime businessHourStartZoned = TimeZoneConverter.businessHourStart(ZoneId.of(currentTimeZone.timeZoneName()), ZonedDateTime.now());
        ZonedDateTime businessHourEndZoned = TimeZoneConverter.businessHourEnd(ZoneId.of(currentTimeZone.timeZoneName()), ZonedDateTime.now());

        DateTimeFormatter formatToTime = DateTimeFormatter.ISO_LOCAL_TIME;

        String businessHourEndTime = businessHourEndZoned.format(formatToTime);

        ZonedDateTime tempTime = businessHourStartZoned;

        timeList.clear();
        boolean timeFlag = true;
        while(timeFlag)
        {
            timeList.add(tempTime.format(formatToTime));

            tempTime = tempTime.plusMinutes(15);

            if(tempTime.format(formatToTime).equals(businessHourEndTime))
            {
                timeFlag = false;
            }
        }
        AppointmentStartTimepicker.setItems(timeList);
        AppointmentEndTimepicker.setItems(timeList);


        /**
         * Disables Update/Delete Customer buttons by default
         */
        AppointmentUpdateAppointmentbutton.setDisable(true);
        AppointmentDeleteAppointmentbutton.setDisable(true);
        CustomerUpdateCustomerbutton.setDisable(true);
        CustomerDeleteCustomerbutton.setDisable(true);

        CustomerCustomerDivisionpicker.setDisable(true);
    }

    /**
     * Resets all Appointment Fields after selection from ANY Appointment table
     * Enables Add/Reset appointment button (since all fields are cleared) in preparation for potential new appointment
     * Disables Update/Delete buttons since resetting also acts as deselection
     */
    public void AppointmentResetFields() {
        AppointmentAllAppointmentstable.getSelectionModel().clearSelection();
        AppointmentMonthlyAppointmentstable.getSelectionModel().clearSelection();
        AppointmentWeeklyAppointmentstable.getSelectionModel().clearSelection();


        AppointmentIDtxt.clear();
        AppointmentTitletxt.clear();
        AppointmentDescriptiontxt.clear();
        AppointmentLocationtxt.clear();
        AppointmentContactpicker.setValue(null);
        AppointmentTypetxt.clear();
        AppointmentDatepicker.setValue(null);
        AppointmentStartTimepicker.setValue(null);
        AppointmentEndTimepicker.setValue(null);
        AppointmentCustomerIDtxt.clear();
        AppointmentUserIDtxt.clear();


        AppointmentResetFieldsbutton.setDisable(false);
        AppointmentAddAppointmentbutton.setDisable(false);
        AppointmentUpdateAppointmentbutton.setDisable(true);
        AppointmentDeleteAppointmentbutton.setDisable(true);
    }

    /**
     * Acts as a selection, populating all information in text fields on selection of an appointment
     * Enables Update/Delete button in preparation for data management, since this acts as an appointment selection
     */
    public void PopulateAppointmentInformation() {
        Appointment selectedAppointment = null;
        if(AppointmentAllAppointmentstab.isSelected())
            selectedAppointment = AppointmentAllAppointmentstable.getSelectionModel().getSelectedItem();
        if(AppointmentMonthlyAppointmentstab.isSelected())
            selectedAppointment = AppointmentMonthlyAppointmentstable.getSelectionModel().getSelectedItem();
        if(AppointmentWeeklyAppointmentstab.isSelected())
            selectedAppointment = AppointmentWeeklyAppointmentstable.getSelectionModel().getSelectedItem();


        if(selectedAppointment != null)
        {
            AppointmentIDtxt.setText(String.valueOf(selectedAppointment.getId()));
            AppointmentTitletxt.setText(selectedAppointment.getTitle());
            AppointmentDescriptiontxt.setText(selectedAppointment.getDescription());
            AppointmentLocationtxt.setText(selectedAppointment.getLocation());
            AppointmentContactpicker.setValue(selectedAppointment.getContact());
            AppointmentTypetxt.setText(selectedAppointment.getType());
            AppointmentDatepicker.setValue(selectedAppointment.getStart().toLocalDate());
            AppointmentStartTimepicker.setValue(selectedAppointment.getStartDateTimeZoned().toLocalTime().toString());
            AppointmentEndTimepicker.setValue(selectedAppointment.getEndDateTimeZoned().toLocalTime().toString());
            AppointmentCustomerIDtxt.setText(String.valueOf(selectedAppointment.getCustomer_id()));
            AppointmentUserIDtxt.setText(String.valueOf(selectedAppointment.getUser_id()));
        }

        AppointmentUpdateAppointmentbutton.setDisable(false);
        AppointmentDeleteAppointmentbutton.setDisable(false);
    }

    /**
     * Adds appointment based on fields
     * Does time zone checking
     * If London, end date is incremented by one if time is past midnight
     */
    public void AppointmentAddAppointment() {
        if ( AppointmentTitletxt.getText().equals("") || AppointmentDescriptiontxt.getText().equals("") ||
                AppointmentLocationtxt.getText().equals("") || AppointmentContactpicker.getValue() == null ||
                AppointmentTypetxt.getText().equals("") || AppointmentDatepicker.getValue() == null ||
                AppointmentStartTimepicker.getValue() == null || AppointmentEndTimepicker.getValue() == null ||
                AppointmentCustomerIDtxt.getText().equals("") || AppointmentUserIDtxt.getText().equals(""))
        {
            DisplayAlert.ErrorMessage("Not all fields were filled." +
                                        "\nAppointment not added to database.");
            return;
        }
        else
        {
            String tempAppointmentTitletxt = AppointmentTitletxt.getText();


            String tempAppointmentDescriptiontxt = AppointmentDescriptiontxt.getText();


            String tempAppointmentLocationtxt = AppointmentLocationtxt.getText();


            String tempAppointmentContactpicker = AppointmentContactpicker.getValue();


            String tempAppointmentTypetxt = AppointmentTypetxt.getText();


            String tempAppointmentStartTimepicker = AppointmentStartTimepicker.getSelectionModel().getSelectedItem();
            String tempAppointmentEndTimepicker = AppointmentEndTimepicker.getSelectionModel().getSelectedItem();
            
            if(tempAppointmentStartTimepicker.equals("") || tempAppointmentEndTimepicker.equals(""))
            {
                DisplayAlert.ErrorMessage("Time can not be blank.\nAppointment not added to database.");
            }
            LocalTime timeStartZoned = LocalTime.parse(tempAppointmentStartTimepicker);
            LocalTime timeEndZoned = LocalTime.parse(tempAppointmentEndTimepicker);

            ZonedDateTime AppointmentStartTimeZoned = ZonedDateTime.of(AppointmentDatepicker.getValue(),timeStartZoned, ZoneId.of(TimeZoneConverter.getTimeZone()));
            ZonedDateTime AppointmentEndTimeZoned = ZonedDateTime.of(AppointmentDatepicker.getValue(),timeEndZoned, ZoneId.of(TimeZoneConverter.getTimeZone()));

            boolean startAfterMidnight = false;
            boolean endAfterMidnight = false;
            if(TimeZoneConverter.getTimeZone().equals("Europe/London"))
            {
                if(AppointmentStartTimeZoned.getHour() == 0 ||
                        AppointmentStartTimeZoned.getHour() == 1 ||
                        AppointmentStartTimeZoned.getHour() == 2 ||
                        AppointmentStartTimeZoned.getHour() == 3)
                {
                    startAfterMidnight = true;
                }
                if(AppointmentEndTimeZoned.getHour() == 0 ||
                        AppointmentEndTimeZoned.getHour() == 1 ||
                        AppointmentEndTimeZoned.getHour() == 2 ||
                        AppointmentEndTimeZoned.getHour() == 3)
                {
                    endAfterMidnight = true;
                }

                if(!startAfterMidnight && endAfterMidnight)
                {
                    AppointmentEndTimeZoned = AppointmentEndTimeZoned.plusDays(1);
                }
            }

            ZonedDateTime UTCStart = AppointmentStartTimeZoned.withZoneSameInstant(ZoneId.of("UTC"));
            ZonedDateTime UTCEnd = AppointmentEndTimeZoned.withZoneSameInstant(ZoneId.of("UTC"));

            LocalDateTime localStart = UTCStart.toLocalDateTime();
            LocalDateTime localEnd = UTCEnd.toLocalDateTime();

            //End time after start time checker
            if(localEnd.isBefore(localStart) || localEnd.isEqual(localStart))
            {
                DisplayAlert.ErrorMessage("End time must be after start time.\nAppointment not added to database.");
                return;
            }

            //If times are both after midnight, means user is in London. This changes business day to be day prior.
            ZonedDateTime startLocal;
            if(startAfterMidnight && endAfterMidnight)
            {
                startLocal = TimeZoneConverter.businessHourStart(ZoneId.of(TimeZoneConverter.getTimeZone()), AppointmentStartTimeZoned.minusDays(1));
            }
            else
            {
                startLocal = TimeZoneConverter.businessHourStart(ZoneId.of(TimeZoneConverter.getTimeZone()), AppointmentStartTimeZoned);
            }
            ZonedDateTime endLocal = TimeZoneConverter.businessHourEnd(ZoneId.of(TimeZoneConverter.getTimeZone()), AppointmentEndTimeZoned);

            //If times are outside business hours ***NOTE*** Should never be checked anyway since time combo box is populated with only within business hour times.
            if(AppointmentStartTimeZoned.toLocalDateTime().isBefore(startLocal.toLocalDateTime()) ||
                    AppointmentStartTimeZoned.toLocalDateTime().isAfter(endLocal.toLocalDateTime()) ||
                    AppointmentEndTimeZoned.toLocalDateTime().isBefore(startLocal.toLocalDateTime()) ||
                    AppointmentEndTimeZoned.toLocalDateTime().isAfter(endLocal.toLocalDateTime()))
            {
                DisplayAlert.ErrorMessage("Appointment times must be set within business hours. Your current business hours are: " +
                                            localStart + " to " + localEnd);
                return;
            }


            int tempAppointmentCustomerIDtxt;
            boolean customerIDflag = false;
            try {
                for (Customer customer : allCustomers) {
                    if (customer.getId() == Integer.parseInt(AppointmentCustomerIDtxt.getText())) {
                        customerIDflag = true;
                    }
                }
                if (customerIDflag) {
                    tempAppointmentCustomerIDtxt = Integer.parseInt(AppointmentCustomerIDtxt.getText());
                } else {
                    DisplayAlert.ErrorMessage("No matching Customer ID.\nAppointment not added to database.");
                    return;
                }
            }
            catch (Exception exception)
            {
                DisplayAlert.ErrorMessage("Customer ID must be an integer.\nAppointment not added to database.");
                return;
            }


            int tempAppointmentUserIDtxt;
            boolean userIDflag = false;
            try {
                for (int id : allUserIDs) {
                    if (id == Integer.parseInt(AppointmentUserIDtxt.getText())) {
                        userIDflag = true;
                    }
                }
                if (userIDflag) {
                    tempAppointmentUserIDtxt = Integer.parseInt(AppointmentUserIDtxt.getText());
                } else {
                    DisplayAlert.ErrorMessage("No matching User ID.\nAppointment not added to database.");
                    return;
                }
            }
            catch (Exception exception)
            {
                DisplayAlert.ErrorMessage("User ID must be an integer.\nAppointment not added to database.");
                return;
            }

            System.out.println("No entry errors, proceeding with Customer overlap check");

            for (Appointment appointment : allAppointments)
            {
                if(appointment.getCustomer_id() == Integer.parseInt(AppointmentCustomerIDtxt.getText()))
                {

                    LocalDate tempAppointmentDateStart = appointment.getStart().toLocalDate();
                    LocalDate tempAppointmentDateEnd = appointment.getEnd().toLocalDate();
                    LocalTime tempAppointmentTimeStart = appointment.getStart().toLocalTime();
                    LocalTime tempAppointmentTimeEnd = appointment.getEnd().toLocalTime();
                    
                    ZonedDateTime tempAppointmentDateStartZoned = ZonedDateTime.of(tempAppointmentDateStart,tempAppointmentTimeStart, ZoneId.of("UTC"));
                    ZonedDateTime tempAppointmentDateEndZoned = ZonedDateTime.of(tempAppointmentDateEnd,tempAppointmentTimeEnd, ZoneId.of("UTC"));

                    if
                            //If appointment time equals existing appointment times
                            (tempAppointmentDateStartZoned.equals(UTCStart) || tempAppointmentDateEndZoned.equals(UTCEnd) ||
                            //If appointment Start is after existing appointment start AND before existing appointment ends
                            (UTCStart.isAfter(tempAppointmentDateStartZoned) && UTCStart.isBefore(tempAppointmentDateEndZoned)) ||
                            //If appointment End is after existing appointment start AND before existing appointment ends
                            (UTCEnd.isAfter(tempAppointmentDateStartZoned) && UTCEnd.isBefore(tempAppointmentDateEndZoned)) ||
                            //If appointment Start is before existing appointment start AND appointment End is after existing appointment ends
                            (UTCStart.isBefore(tempAppointmentDateStartZoned) && UTCEnd.isAfter(tempAppointmentDateEndZoned)))
                    {
                        DisplayAlert.ErrorMessage("Appointment overlaps with an existing appointment.\nAppointment not added to database.");
                        return;
                    }
                }
            }
            DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));
            String currentTime = datetimeformatter.format(Instant.now());
            try {
                String sqlquery = "INSERT INTO CLIENT_SCHEDULE.APPOINTMENTS " +
                        "(Title,Description,Location,Type,Start,End,Created_By,Last_Updated_by,Customer_ID,User_ID,Contact_ID,Create_Date,Last_Update) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
                preparedstatement.setString(1, tempAppointmentTitletxt);
                preparedstatement.setString(2, tempAppointmentDescriptiontxt);
                preparedstatement.setString(3, tempAppointmentLocationtxt);
                preparedstatement.setString(4, tempAppointmentTypetxt);
                preparedstatement.setObject(5, localStart);
                preparedstatement.setObject(6, localEnd);
                preparedstatement.setString(7, User.UserName);
                preparedstatement.setString(8, User.UserName);
                preparedstatement.setInt(9, tempAppointmentCustomerIDtxt);
                preparedstatement.setInt(10, tempAppointmentUserIDtxt);
                preparedstatement.setInt(11, IDConverter.converContactToID(tempAppointmentContactpicker));
                preparedstatement.setString(12, currentTime);
                preparedstatement.setString(13, currentTime);

                preparedstatement.execute();
            }
            catch(SQLException exception)
            {
                DisplayAlert.ErrorMessage("Add Appointment SQL Exception Error: " + exception.getErrorCode());
            }


            initialize();
        }
    }

    /**
     * Updates appointment based on fields
     * Does time zone checking
     * If London, end date is incremented by one if time is past midnight
     */
    public void AppointmentUpdateAppointment(){
        if ( AppointmentTitletxt.getText().equals("") || AppointmentDescriptiontxt.getText().equals("") ||
                AppointmentLocationtxt.getText().equals("") || AppointmentContactpicker.getValue() == null ||
                AppointmentTypetxt.getText().equals("") || AppointmentDatepicker.getValue() == null ||
                AppointmentStartTimepicker.getValue() == null || AppointmentEndTimepicker.getValue() == null ||
                AppointmentCustomerIDtxt.getText().equals("") || AppointmentUserIDtxt.getText().equals(""))
        {
            DisplayAlert.ErrorMessage("Not all fields were filled." +
                    "\nAppointment not updated to database.");
            return;
        }
        else {
            int tempAppointmentId = Integer.parseInt(AppointmentIDtxt.getText());


            String tempAppointmentTitletxt = AppointmentTitletxt.getText();


            String tempAppointmentDescriptiontxt = AppointmentDescriptiontxt.getText();


            String tempAppointmentLocationtxt = AppointmentLocationtxt.getText();


            String tempAppointmentContactpicker = AppointmentContactpicker.getValue();


            String tempAppointmentTypetxt = AppointmentTypetxt.getText();


            String tempAppointmentStartTimepicker = AppointmentStartTimepicker.getSelectionModel().getSelectedItem();
            String tempAppointmentEndTimepicker = AppointmentEndTimepicker.getSelectionModel().getSelectedItem();

            if (tempAppointmentStartTimepicker.equals("") || tempAppointmentEndTimepicker.equals("")) {
                DisplayAlert.ErrorMessage("Time can not be blank.\nAppointment not updated to database.");
            }
            LocalTime timeStartZoned = LocalTime.parse(tempAppointmentStartTimepicker);
            LocalTime timeEndZoned = LocalTime.parse(tempAppointmentEndTimepicker);

            ZonedDateTime AppointmentStartTimeZoned = ZonedDateTime.of(AppointmentDatepicker.getValue(), timeStartZoned, ZoneId.of(TimeZoneConverter.getTimeZone()));
            ZonedDateTime AppointmentEndTimeZoned = ZonedDateTime.of(AppointmentDatepicker.getValue(), timeEndZoned, ZoneId.of(TimeZoneConverter.getTimeZone()));

            boolean startAfterMidnight = false;
            boolean endAfterMidnight = false;
            if (TimeZoneConverter.getTimeZone().equals("Europe/London")) {
                if (AppointmentStartTimeZoned.getHour() == 0 ||
                        AppointmentStartTimeZoned.getHour() == 1 ||
                        AppointmentStartTimeZoned.getHour() == 2 ||
                        AppointmentStartTimeZoned.getHour() == 3) {
                    startAfterMidnight = true;
                }
                if (AppointmentEndTimeZoned.getHour() == 0 ||
                        AppointmentEndTimeZoned.getHour() == 1 ||
                        AppointmentEndTimeZoned.getHour() == 2 ||
                        AppointmentEndTimeZoned.getHour() == 3) {
                    endAfterMidnight = true;
                }

                if (!startAfterMidnight && endAfterMidnight) {
                    AppointmentEndTimeZoned = AppointmentEndTimeZoned.plusDays(1);
                }
            }

            ZonedDateTime UTCStart = AppointmentStartTimeZoned.withZoneSameInstant(ZoneId.of("UTC"));
            ZonedDateTime UTCEnd = AppointmentEndTimeZoned.withZoneSameInstant(ZoneId.of("UTC"));

            LocalDateTime localStart = UTCStart.toLocalDateTime();
            LocalDateTime localEnd = UTCEnd.toLocalDateTime();

            //End time after start time checker
            if (localEnd.isBefore(localStart) || localEnd.isEqual(localStart)) {
                DisplayAlert.ErrorMessage("End time must be after start time.\nAppointment not updated to database.");
                return;
            }

            //If times are both after midnight, means user is in London. This changes business day to be day prior.
            ZonedDateTime startLocal;
            if (startAfterMidnight && endAfterMidnight) {
                startLocal = TimeZoneConverter.businessHourStart(ZoneId.of(TimeZoneConverter.getTimeZone()), AppointmentStartTimeZoned.minusDays(1));
            } else {
                startLocal = TimeZoneConverter.businessHourStart(ZoneId.of(TimeZoneConverter.getTimeZone()), AppointmentStartTimeZoned);
            }
            ZonedDateTime endLocal = TimeZoneConverter.businessHourEnd(ZoneId.of(TimeZoneConverter.getTimeZone()), AppointmentEndTimeZoned);

            //If times are outside business hours ***NOTE*** Should never be checked anyway since time combo box is populated with only within business hour times.
            if (AppointmentStartTimeZoned.toLocalDateTime().isBefore(startLocal.toLocalDateTime()) ||
                    AppointmentStartTimeZoned.toLocalDateTime().isAfter(endLocal.toLocalDateTime()) ||
                    AppointmentEndTimeZoned.toLocalDateTime().isBefore(startLocal.toLocalDateTime()) ||
                    AppointmentEndTimeZoned.toLocalDateTime().isAfter(endLocal.toLocalDateTime())) {
                DisplayAlert.ErrorMessage("Appointment times must be set within business hours. Your current business hours are: " +
                        localStart + " to " + localEnd);
                return;
            }


            int tempAppointmentCustomerIDtxt;
            boolean customerIDflag = false;
            try {
                for (Customer customer : allCustomers) {
                    if (customer.getId() == Integer.parseInt(AppointmentCustomerIDtxt.getText())) {
                        customerIDflag = true;
                    }
                }
                if (customerIDflag) {
                    tempAppointmentCustomerIDtxt = Integer.parseInt(AppointmentCustomerIDtxt.getText());
                } else {
                    DisplayAlert.ErrorMessage("No matching Customer ID.\nAppointment not updated to database.");
                    return;
                }
            } catch (Exception exception) {
                DisplayAlert.ErrorMessage("Customer ID must be an integer.\nAppointment not updated to database.");
                return;
            }


            int tempAppointmentUserIDtxt;
            boolean userIDflag = false;
            try {
                for (int id : allUserIDs) {
                    if (id == Integer.parseInt(AppointmentUserIDtxt.getText())) {
                        userIDflag = true;
                    }
                }
                if (userIDflag) {
                    tempAppointmentUserIDtxt = Integer.parseInt(AppointmentUserIDtxt.getText());
                } else {
                    DisplayAlert.ErrorMessage("No matching User ID.\nAppointment not updated to database.");
                    return;
                }
            } catch (Exception exception) {
                DisplayAlert.ErrorMessage("User ID must be an integer.\nAppointment not updated to database.");
                return;
            }

            System.out.println("No entry errors, proceeding with Customer overlap check");

            for (Appointment appointment : allAppointments) {
                if (appointment.getCustomer_id() == Integer.parseInt(AppointmentCustomerIDtxt.getText()) && appointment.getId() != tempAppointmentId)  {
                    LocalDate tempAppointmentDateStart = appointment.getStart().toLocalDate();
                    LocalDate tempAppointmentDateEnd = appointment.getEnd().toLocalDate();
                    LocalTime tempAppointmentTimeStart = appointment.getStart().toLocalTime();
                    LocalTime tempAppointmentTimeEnd = appointment.getEnd().toLocalTime();

                    ZonedDateTime tempAppointmentDateStartZoned = ZonedDateTime.of(tempAppointmentDateStart, tempAppointmentTimeStart, ZoneId.of("UTC"));
                    ZonedDateTime tempAppointmentDateEndZoned = ZonedDateTime.of(tempAppointmentDateEnd, tempAppointmentTimeEnd, ZoneId.of("UTC"));

                    if
                        //If appointment time equals existing appointment times
                    (tempAppointmentDateStartZoned.equals(UTCStart) || tempAppointmentDateEndZoned.equals(UTCEnd) ||
                            //If appointment Start is after existing appointment start AND before existing appointment ends
                            (UTCStart.isAfter(tempAppointmentDateStartZoned) && UTCStart.isBefore(tempAppointmentDateEndZoned)) ||
                            //If appointment End is after existing appointment start AND before existing appointment ends
                            (UTCEnd.isAfter(tempAppointmentDateStartZoned) && UTCEnd.isBefore(tempAppointmentDateEndZoned)) ||
                            //If appointment Start is before existing appointment start AND appointment End is after existing appointment ends
                            (UTCStart.isBefore(tempAppointmentDateStartZoned) && UTCEnd.isAfter(tempAppointmentDateEndZoned))) {
                        DisplayAlert.ErrorMessage("Appointment overlaps with an existing appointment.\nAppointment not updated to database.");
                        return;
                    }
                }
            }

            DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));
            String currentTime = datetimeformatter.format(Instant.now());
            try {
                String sqlquery =   "UPDATE CLIENT_SCHEDULE.APPOINTMENTS " +
                                    "SET Title = ?, Description = ?, Location = ?, Type = ? , Start = ?, End = ?, " +
                                    "Last_Updated_by = ?, Customer_ID = ?, User_ID = ?, Contact_ID = ?, Last_Update = ? " +
                                    "WHERE APPOINTMENT_ID = ?";
                PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
                preparedstatement.setString(1, tempAppointmentTitletxt);
                preparedstatement.setString(2, tempAppointmentDescriptiontxt);
                preparedstatement.setString(3, tempAppointmentLocationtxt);
                preparedstatement.setString(4, tempAppointmentTypetxt);
                preparedstatement.setObject(5, localStart);
                preparedstatement.setObject(6, localEnd);
                preparedstatement.setString(7, User.UserName);
                preparedstatement.setInt(8, tempAppointmentCustomerIDtxt);
                preparedstatement.setInt(9, tempAppointmentUserIDtxt);
                preparedstatement.setInt(10, IDConverter.converContactToID(tempAppointmentContactpicker));
                preparedstatement.setString(11, currentTime);
                preparedstatement.setInt(12, Integer.parseInt(AppointmentIDtxt.getText()));

                preparedstatement.execute();
            }
            catch(SQLException exception)
            {
                DisplayAlert.ErrorMessage("Update Appointment SQLException Error: " + exception.getErrorCode());
            }


            initialize();
        }
    }

    /**
     * Deletes Appointment based on confirmation from user
     */
    public void AppointmentDeleteAppointment() {
        try {
            var confirmDelete = new Alert(Alert.AlertType.CONFIRMATION,"",ButtonType.YES, ButtonType.NO);
            confirmDelete.setTitle("Confirm Deletion");
            confirmDelete.setContentText("Are you sure you want to delete this appointment?");
            confirmDelete.showAndWait();
            if(confirmDelete.getResult() == ButtonType.YES) {
                String sqlquery = "DELETE FROM CLIENT_SCHEDULE.APPOINTMENTS " +
                        "WHERE APPOINTMENT_ID = ?";

                PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
                preparedstatement.setInt(1, Integer.parseInt(AppointmentIDtxt.getText()));
                preparedstatement.execute();

                DisplayAlert.InfoMessage("Appointment ID " + AppointmentIDtxt.getText() + " with type \"" +
                        AppointmentTypetxt.getText() + "\" has been deleted.");
            }
            else
            {
                return;
            }
        }
        catch (SQLException exception)
        {
            DisplayAlert.ErrorMessage("Delete Appointment SQL Exception error: " + exception.getErrorCode());
        }
        initialize();
    }

    /**
     * Resets all Customer Fields after selection from Customer table
     * Enables Add/Reset Customer button (since all fields are cleared) in preparation for potential new appointment
     * Disables Update/Delete Customer buttons since resetting also acts as deselection
     */
    public void CustomerResetFields() {
        CustomerCustomerstable.getSelectionModel().clearSelection();


        CustomerCustomerIDtxt.clear();
        CustomerCustomerNametxt.clear();
        CustomerCustomerPhonetxt.clear();
        CustomerCustomerAddresstxt.clear();
        CustomerCustomerCountrypicker.setValue(null);
        CustomerCustomerDivisionpicker.setValue(null);
        CustomerCustomerPostalCodetxt.clear();


        CustomerCustomerIDtxt.setDisable(true);
        CustomerCustomerDivisionpicker.setDisable(true);

        CustomerAddCustomerbutton.setDisable(false);
        CustomerUpdateCustomerbutton.setDisable(true);
        CustomerDeleteCustomerbutton.setDisable(true);
        CustomerResetFieldsbutton.setDisable(false);
    }

    /**
     * Acts as a selection, populating all information in text fields on selection of a customer
     * Enables Update/Delete button in preparation for data management, since this acts as a customer selection
     */
    public void PopulateCustomerInformation() {
        Customer selectedCustomer = CustomerCustomerstable.getSelectionModel().getSelectedItem();

        if(selectedCustomer != null) {
            CustomerCustomerIDtxt.setText(String.valueOf(selectedCustomer.getId()));
            CustomerCustomerNametxt.setText(selectedCustomer.getName());
            CustomerCustomerPhonetxt.setText(selectedCustomer.getPhone());
            CustomerCustomerAddresstxt.setText(selectedCustomer.getAddress());
            CustomerCustomerCountrypicker.setValue(selectedCustomer.getCountry());
            CustomerCustomerDivisionpicker.setValue(selectedCustomer.getDivision());
            CustomerCustomerPostalCodetxt.setText(selectedCustomer.getPostal_code());
        }

        CustomerUpdateCustomerbutton.setDisable(false);
        CustomerDeleteCustomerbutton.setDisable(false);
    }

    /**
     * Adds customer based on fields
     */
    public void CustomerAddCustomer() {
        if ( CustomerCustomerNametxt.getText().equals("") || CustomerCustomerPhonetxt.getText().equals("") ||
                CustomerCustomerAddresstxt.getText().equals("") || CustomerCustomerCountrypicker.getValue() == null ||
                CustomerCustomerDivisionpicker.getValue() == null || CustomerCustomerPostalCodetxt.getText().equals(""))
        {
            DisplayAlert.ErrorMessage("Not all fields were filled." +
                    "\nCustomer not added to database.");
            return;
        }
        else {
            String tempCustomerCustomerNametxt = CustomerCustomerNametxt.getText();
            String tempCustomerCustomerPhonetxt = CustomerCustomerPhonetxt.getText();
            String tempCustomerCustomerAddresstxt = CustomerCustomerAddresstxt.getText();
            String tempCustomerCustomerDivisionpicker = CustomerCustomerDivisionpicker.getValue();
            String tempCustomerCustomerPostalCodetxt = CustomerCustomerPostalCodetxt.getText();

            DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));
            String currentTime = datetimeformatter.format(Instant.now());
            try{
                String sqlquery = "INSERT INTO CLIENT_SCHEDULE.CUSTOMERS " +
                        "(CUSTOMER_NAME,ADDRESS,POSTAL_CODE,PHONE,CREATED_BY,LAST_UPDATED_BY,DIVISION_ID,CREATE_DATE,LAST_UPDATE) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
                preparedstatement.setString(1, tempCustomerCustomerNametxt);
                preparedstatement.setString(2, tempCustomerCustomerAddresstxt);
                preparedstatement.setString(3, tempCustomerCustomerPostalCodetxt);
                preparedstatement.setString(4, tempCustomerCustomerPhonetxt);
                preparedstatement.setString(5, User.UserName);
                preparedstatement.setString(6, User.UserName);
                preparedstatement.setInt(7, IDConverter.convertDivisionToID(tempCustomerCustomerDivisionpicker));
                preparedstatement.setString(8, currentTime);
                preparedstatement.setString(9, currentTime);

                preparedstatement.execute();
            }
            catch(SQLException exception)
            {
                DisplayAlert.ErrorMessage("Add Customer SQL Exception error: " + exception.getErrorCode());
            }

            initialize();
        }
    }

    /**
     * Updates customer based on fields
     */
    public void CustomerUpdateCustomer() {
        if ( CustomerCustomerNametxt.getText().equals("") || CustomerCustomerPhonetxt.getText().equals("") ||
                CustomerCustomerAddresstxt.getText().equals("") || CustomerCustomerCountrypicker.getValue() == null ||
                CustomerCustomerDivisionpicker.getValue() == null || CustomerCustomerPostalCodetxt.getText().equals(""))
        {
            DisplayAlert.ErrorMessage("Not all fields were filled." +
                    "\nCustomer not updated to database.");
            return;
        }
        else
        {
            int tempCustomerCustomerIDtxt = Integer.parseInt(CustomerCustomerIDtxt.getText());
            String tempCustomerCustomerNametxt = CustomerCustomerNametxt.getText();
            String tempCustomerCustomerPhonetxt = CustomerCustomerPhonetxt.getText();
            String tempCustomerCustomerAddresstxt = CustomerCustomerAddresstxt.getText();
            String tempCustomerCustomerDivisionpicker = CustomerCustomerDivisionpicker.getValue();
            String tempCustomerCustomerPostalCodetxt = CustomerCustomerPostalCodetxt.getText();

            DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));
            String currentTime = datetimeformatter.format(Instant.now());
            try {
                String sqlquery =   "UPDATE CLIENT_SCHEDULE.CUSTOMERS " +
                                    "SET CUSTOMER_NAME = ?, ADDRESS = ?, POSTAL_CODE = ?, PHONE = ? , " +
                                    "LAST_UPDATE = ?, LAST_UPDATED_BY = ?, DIVISION_ID = ? " +
                                    "WHERE CUSTOMER_ID = ?";

                PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
                preparedstatement.setString(1, tempCustomerCustomerNametxt);
                preparedstatement.setString(2, tempCustomerCustomerAddresstxt);
                preparedstatement.setString(3, tempCustomerCustomerPostalCodetxt);
                preparedstatement.setString(4, tempCustomerCustomerPhonetxt);
                preparedstatement.setString(5, currentTime);
                preparedstatement.setString(6, User.UserName);
                preparedstatement.setInt(7, IDConverter.convertDivisionToID(tempCustomerCustomerDivisionpicker));
                preparedstatement.setInt(8, tempCustomerCustomerIDtxt);

                preparedstatement.execute();
            } catch (SQLException exception) {
                DisplayAlert.ErrorMessage("Update Customer SQL Exception error: " + exception.getErrorCode());
            }

            initialize();
        }
    }

    /**
     * Deletes customer based on fields
     * Verifies user is willing to delete all customer-related appointments, then the customer itself
     */
    public void CustomerDeleteCustomer() {
        try {
            var confirmDelete = new Alert(Alert.AlertType.CONFIRMATION,"",ButtonType.YES, ButtonType.NO);
            confirmDelete.setTitle("Confirm Deletion");
            confirmDelete.setContentText("All customer's related appointments will also be deleted. Are you sure you want to delete this customer?");
            confirmDelete.showAndWait();
            if(confirmDelete.getResult() == ButtonType.YES) {
                String sqlquery =   "DELETE FROM CLIENT_SCHEDULE.APPOINTMENTS " +
                                    "WHERE CUSTOMER_ID = ?";

                PreparedStatement preparedstatement = connection.prepareStatement(sqlquery);
                preparedstatement.setInt(1, Integer.parseInt(CustomerCustomerIDtxt.getText()));

                preparedstatement.execute();

                sqlquery =  "DELETE FROM CLIENT_SCHEDULE.CUSTOMERS " +
                            "WHERE CUSTOMER_ID = ?";

                preparedstatement = connection.prepareStatement(sqlquery);
                preparedstatement.setInt(1, Integer.parseInt(CustomerCustomerIDtxt.getText()));

                preparedstatement.execute();

                DisplayAlert.InfoMessage("Customer ID " + CustomerCustomerIDtxt.getText() + " and customer's related appointments have been deleted.");
            }
            else
            {
                return;
            }
        }
        catch (SQLException exception)
        {
            DisplayAlert.ErrorMessage("Delete Customer SQL Exception error: " + exception.getErrorCode());
        }
        initialize();
    }

    /**
     * Method runs when Country is picked when adding/updating Customer's country box
     * Changes viewable list of division based on country
     */
    public void CustomerFilterDivisionpicker() {
        CustomerCustomerDivisionpicker.setValue(null);

        if(CustomerCustomerCountrypicker.getSelectionModel().getSelectedItem() != null)
        {
            String country = CustomerCustomerCountrypicker.getSelectionModel().getSelectedItem();
            if (IDConverter.convertCountryToID(country) == 1) {
                CustomerCustomerDivisionpicker.setItems(USDivisions);
            } else if (IDConverter.convertCountryToID(country) == 2) {
                CustomerCustomerDivisionpicker.setItems(UKDivisions);
            } else if (IDConverter.convertCountryToID(country) == 3) {
                CustomerCustomerDivisionpicker.setItems(CanadaDivisions);
            }
        }


        CustomerCustomerDivisionpicker.setDisable(false);
    }

    /**
     * Method runs when Contact is selected from Reports
     * Populates all appointments that have the matching contact.
     */
    public void ReportContact(){
        /**
         * Adding items to Report Appointments per Contact List
         */
        appointmentPerContact.clear();

        String contact = ReportContactpicker.getSelectionModel().getSelectedItem();
        System.out.println(contact + " selected.");


        for(Appointment appointment : allAppointments)
        {
            if(appointment.getContact().equals(contact))
            {
                appointmentPerContact.add(appointment);
            }
        }

        ReportContacttable.setItems(appointmentPerContact);
        ReportAppointmentIDcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        ReportAppointmentTitlecol.setCellValueFactory(new PropertyValueFactory<>("title"));
        ReportAppointmentDescriptioncol.setCellValueFactory(new PropertyValueFactory<>("description"));
        ReportAppointmentTypePerContactcol.setCellValueFactory(new PropertyValueFactory<>("type"));
        ReportAppointmentStartcol.setCellValueFactory(new PropertyValueFactory<>("formattedStartDateTimeZoned"));
        ReportAppointmentEndcol.setCellValueFactory(new PropertyValueFactory<>("formattedEndDateTimeZoned"));
        ReportAppointmentCustomerIDcol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
    }


}
