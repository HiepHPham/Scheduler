package Model;

/**
 * interface for User's current time zone
 * used for Lambda application
 */
public interface TimeZone {
    /**
     *
     * @return returns String of the Time Zone Name from lambda function
     */
    String timeZoneName();
}
