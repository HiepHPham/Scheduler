package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

/**
 * TimeZoneConverter functions for converting to and from UTC/local/EST timeZones
 */
public class TimeZoneConverter {

    /**
     *
     * @return User's time zone, alternate from Lambda
     */
    public static String getTimeZone()
    {
        TimeZone systemTimeZone = TimeZone.getDefault();

        return systemTimeZone.getID();
    }

    /**
     *
     * @param time time to be converted
     * @return time in local time zone of user
     */
    public static ZonedDateTime convertToLocalTime(LocalDateTime time)
    {
        ZonedDateTime localTime = ZonedDateTime.of(time, ZoneId.of("UTC")).withZoneSameInstant((ZoneId.of(getTimeZone())));

        return localTime;
    }

    /**
     *
     * @param userZone time zone to convert from
     * @param date date to convert
     * @return business datetime start in requested timezone from EST
     */
    public static ZonedDateTime businessHourStart(ZoneId userZone, ZonedDateTime date)
    {
        ZonedDateTime businessStart = ZonedDateTime.of(1,1,1,8,0,0,0,ZoneId.of("US/Eastern"));
        businessStart = businessStart.with(LocalDate.of(date.getYear(),date.getMonth(),date.getDayOfMonth()));
        ZonedDateTime time = businessStart.withZoneSameInstant(userZone);

        return time;
    }

    /**
     *
     * @param userZone time zone to convert from
     * @param date date to convert
     * @return business datetime end in requested timezone from EST
     */
    public static ZonedDateTime businessHourEnd(ZoneId userZone, ZonedDateTime date)
    {
        ZonedDateTime businessEnd = ZonedDateTime.of(1,1,1,22,0,0,0,ZoneId.of("US/Eastern"));
        businessEnd = businessEnd.with(LocalDate.of(date.getYear(),date.getMonth(),date.getDayOfMonth()));
        ZonedDateTime time = businessEnd.withZoneSameInstant(userZone);

        return time;
    }
}
