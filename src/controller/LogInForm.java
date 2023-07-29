package controller;


import Model.Appointment;
import Model.DisplayAlert;
import Model.User;
import database.JDBC;
import database.LogHistory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author Pham
 * Login Controller
 *
 * Controller for JavaFX elements
 */
public class LogInForm implements Initializable {

    @FXML
    public Label UserLoginlabel;

    @FXML
    public TextField UserIDtxt;
    @FXML
    public PasswordField Passwordtxt;

    @FXML
    public Button Signinbutton;

    @FXML
    public Label Languagelabel;
    @FXML
    public Label Zonelabel;
    @FXML
    public Label UserIDlabel;
    @FXML
    public Label Passwordlabel;

    String LogInErrorMessage = "Invalid User ID and/or Password, please try again.";
    boolean LogInSuccess = false;

    /**
     *
     * Initializes login form will check zone and change log-in form language to french if system language is french
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //Changes Zone label to match user Time Zone
        Zonelabel.setText("Zone: " + ZoneId.systemDefault());

        String userLanguage = Locale.getDefault().getLanguage();
        Languagelabel.setText(userLanguage);

        //If user's language is french, set all label's text to french
        if(userLanguage.equals("fr"))
        {
            UserLoginlabel.setText("Formulaire de Connexion");

            UserIDlabel.setText("Identifiant d'utilisateur");
            Passwordlabel.setText("Le mot de passe");

            Signinbutton.setText("Soumettre");

            LogInErrorMessage = "ID utilisateur et/ou mot de passe invalide, veuillez réessayer.";
        }
    }

    /**
     *
     * @param actionEvent if User clicks on Submit, function iterates through Users database to verify username
     *                     and password matches a User in the database
     * @throws IOException if IO exception is thrown
     * @throws SQLException if SQL exception is thrown
     */
    public void Login(ActionEvent actionEvent) throws IOException, SQLException
    {
        String UserName = UserIDtxt.getText();
        String Password = Passwordtxt.getText();

        String UserQuery =  "SELECT * " +
                            "FROM CLIENT_SCHEDULE.USERS";
        Connection connection = JDBC.connection;
        PreparedStatement statement = connection.prepareStatement(UserQuery);
        statement.execute();
        ResultSet resultset = statement.getResultSet();

        String UserIDdatabase;
        String Passworddatabase;

        while(resultset.next())
        {
            UserIDdatabase = resultset.getString("User_Name");
            Passworddatabase = resultset.getString("Password");

            if(UserName.equals(UserIDdatabase) && Password.equals(Passworddatabase))
            {
                LogInSuccess = true;
                break;
            }
        }
        LogHistory.log(UserName, LogInSuccess);

        if(LogInSuccess)
        {
            User.UserName = UserName;
            System.out.println("Successfully log-in as " + User.UserName);

            Parent scene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/MainFormFXML.fxml")));
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Scheduler");
            stage.setScene(new Scene(scene,800,600));
            stage.show();
            appointmentCheck();
        }
        else
        {
            DisplayAlert.ErrorMessage(LogInErrorMessage);
        }
    }

    /**
     * Iterates through the static allAppointments List to check whether an Appointment start occurs within the next
     * 15 minutes
     */
    public static void appointmentCheck()
    {
        boolean hasAppointment = false;
        for(Appointment appointment : MainForm.allAppointments) {
            if (appointment.getStartDateTimeZoned().isBefore(ZonedDateTime.now().plusMinutes(15)) &&
                    appointment.getStartDateTimeZoned().isAfter(ZonedDateTime.now())) {
                hasAppointment = true;

                DisplayAlert.InfoMessage("There is an appointment within 15 minutes" +
                        "\nAppointment ID: " + appointment.getId() +
                        "\nStart: " + appointment.getFormattedStartDateTimeZoned() +
                        "\nEnd: " + appointment.getFormattedEndDateTimeZoned());
            }
        }
        if(!hasAppointment)
            DisplayAlert.InfoMessage("There are no appointments within 15 minutes.");
    }
}
