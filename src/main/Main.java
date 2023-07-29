/**
 * @author Hiep Pham
 * 04/07/2022
 */

package main;

import database.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{

    /**
     *
     * @param stage Stage to be set
     * @throws Exception if exception is thrown
     * Sets stage and loads Log-In form scene
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/LogInFormFXML.fxml"));
        stage.setTitle("Log-in Form");
        stage.setScene(new Scene(root, 800,600));
        stage.show();
    }

    /**
     *
     * @param args executes the program
     * Opens connection, execute Application, then closes connection
     */
    public static void main(String[] args){
        JDBC.openConnection();
        launch(args);
        JDBC.closeConnection();
    }
}
