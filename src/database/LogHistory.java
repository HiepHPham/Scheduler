/**
 * @author Hiep Pham
 */
package database;

import java.time.ZonedDateTime;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Develops a log history text file of all users, users' login success/failure, and time
 */
public class LogHistory {
    private static final String FILE = "login_activity.txt";
    public LogHistory() {}

    /**
     * Creates FileWriter, BufferedWriter, and PrintWriter to append to log file
     * @param username username to append to the log file
     * @param logInSuccess success/failure to append to log file
     *
     * Catches error in case Writers time out
     */
    public static void log (String username, boolean logInSuccess)
    {

        try (FileWriter filewriter = new FileWriter(FILE, true);
             BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
             PrintWriter printwriter = new PrintWriter(bufferedwriter))
        {
            printwriter.println(username + (logInSuccess ? " Success " : " Failure ") + ZonedDateTime.now());
        }
        catch (IOException e)
        {
            System.out.println("Log History Error: " + e.getMessage());
        }
    }

}
