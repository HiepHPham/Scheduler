package Model;

/**
 * User object to hold user log in data during log-in
 */
public class User {
    public static int UserID;
    public static String UserName;
    public static String UserPassword;

    /**
     *
     * @param UserID Global user ID to be set
     * @param UserName Global username to be set
     * @param UserPassword Global password to be set
     */
    public User(int UserID, String UserName, String UserPassword)
    {
        this.UserID = UserID;
        this.UserName = UserName;
        this.UserPassword = UserPassword;
    }

    /**
     *
     * @return returns User ID
     */
    public static int getUserID() {
        return UserID;
    }

    /**
     *
     * @return returns user name
     */
    public static String getUserName() {
        return UserName;
    }

    /**
     *
     * @return returns user password
     */
    public static String getUserPassword() {
        return UserPassword;
    }
}
