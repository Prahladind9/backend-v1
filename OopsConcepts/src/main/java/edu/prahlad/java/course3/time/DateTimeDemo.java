package edu.prahlad.java.course3.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class DateTimeDemo {
    public static void main( String args[] ) {
        //localDate();
        //localTime();
        //localDateTime();
        //zonedDateTime();
        //period();
        duration();
    }

    private static void duration() {
        Duration duration = Duration.ofDays(1);  // Created a duration of 1 day.
        System.out.println(duration.getSeconds() + " seconds"); // This will return the number of seconds in a day.

        duration = Duration.ofHours(2);  // Created a duration of 2 hours.
        System.out.println(duration.getSeconds() + " seconds"); // This will return the number of seconds in 2 hours.

        duration = Duration.ofMinutes(23);  // Created a duration of 23 minutes.
        System.out.println(duration.getSeconds() + " seconds"); // This will return the number of seconds in 23 minutes.

        duration = Duration.of(1, ChronoUnit.HOURS);
        System.out.println(duration.getSeconds() + " seconds");

        duration = Duration.between(LocalTime.parse("12:14"), LocalTime.parse("13:15"));
        System.out.println("The difference is " + duration.getSeconds() + " Seconds");
    }

    private static void period() {
        Period period = Period.ofDays(5);  // Period of 5 days.
        System.out.println(period.getDays());

        period = Period.ofMonths(3);  // Period of 3 months.
        System.out.println(period.getMonths());

        period = Period.ofYears(2);  // Period of 2 Years
        System.out.println(period.getYears());


        period = Period.of(2, 5, 12); // Period of 2 Years, 5 Months and 12 Days.
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        Period periodDiff = Period.between(LocalDate.parse("2020-05-18"), LocalDate.parse("2017-04-17"));
        System.out.println(periodDiff);

        period = Period.between(LocalDate.parse("2017-04-17"), LocalDate.parse("2020-05-18"));

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        System.out.println("The difference between two dates is " + years + " Years, " + months + " Months and " + days + " Days");

    }

    private static void zonedDateTime() {

        // Fetching the current TimeZone
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        // fetching the ZoneId for Canada/Atlantic
        ZoneId zoneId = ZoneId.of("Canada/Atlantic");
        zonedDateTime =
                ZonedDateTime.of(2020, 10, 15, 23, 45, 59, 1234, zoneId);
        System.out.println(zonedDateTime);

        //Fetching the Zoneid for given Zone.
        zoneId = ZoneId.of("America/Marigot");
        System.out.println("Zone Id " + zoneId);

        //Fetching a Set of all Zoneids
        Set<String> zoneIdList = ZoneId.getAvailableZoneIds();

        /*for (String zone : zoneIdList) {
            System.out.println(zone);
        }*/


        zonedDateTime = ZonedDateTime.now();

        int year = zonedDateTime.getYear();
        System.out.println("Year is: " + year);

        Month month = zonedDateTime.getMonth();
        System.out.println("Month is: " + year);

        int dayOfMonth = zonedDateTime.getDayOfMonth();
        System.out.println("Day Of Month is: " + dayOfMonth);

        DayOfWeek dayOfWeek = zonedDateTime.getDayOfWeek();
        System.out.println("Day of week is: " + dayOfWeek);

        int dayOfYear = zonedDateTime.getDayOfYear();
        System.out.println("Day of year is: " + dayOfYear);

        int hour = zonedDateTime.getHour();
        System.out.println("Hour is: " + hour);

        int minute = zonedDateTime.getMinute();
        System.out.println("Minute is: " + minute);

        int second = zonedDateTime.getSecond();
        System.out.println("Second is: " + second);

        int nano = zonedDateTime.getNano();
        System.out.println("Nano is: " + nano);

        System.out.println("Date after adding Year is: " + zonedDateTime.plusYears(1));

        System.out.println("Date after adding Month is: " + zonedDateTime.plusMonths(1));

        System.out.println("Date after adding days is: " + zonedDateTime.plusDays(15));

        System.out.println("Date after adding hours is: " + zonedDateTime.plusHours(15));

        System.out.println("Date after adding minutes is: " + zonedDateTime.plusMinutes(1));

        System.out.println("Date after adding seconds is: " + zonedDateTime.plusSeconds(15));

        System.out.println("Date after adding nanoseconds is: " + zonedDateTime.plusNanos(15));

        System.out.println("Date after subtracting Year is: " + zonedDateTime.minusYears(1));

        System.out.println("Date after subtractng Month is: " + zonedDateTime.minusMonths(1));

        System.out.println("Date after subtracting days is: " + zonedDateTime.minusDays(15));

        System.out.println("Date after subtracting hours is: " + zonedDateTime.minusHours(15));

        System.out.println("Date after subtracting minutes is: " + zonedDateTime.minusMinutes(1));

        System.out.println("Date after subtracting seconds is: " + zonedDateTime.minusSeconds(15));

        System.out.println("Date after subtracting nanoseconds is: " + zonedDateTime.minusNanos(15));

    }

    private static void localDateTime() {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);

        // of(int year, int month, int dayOfMonth, int hour, int minute)
        date = LocalDateTime.of(2019, 05, 03, 12, 34);
        System.out.println(date);

        // of(int year, int month, int dayOfMonth, int hour, int minute, int second)
        date = LocalDateTime.of(2019, Month.AUGUST, 03, 23, 34);
        System.out.println(date);

        // parse(CharSequence text)
        date = LocalDateTime.parse("2020-06-20T07:54:00");
        System.out.println(date);

        // Adding 4 days to given date and time.
        date = LocalDateTime.parse("2020-05-12T08:30:00").plusDays(4);
        System.out.println(date);

        // Adding 4 months to given date and time.
        date = LocalDateTime.parse("2020-05-12T08:30:00").plus(4, ChronoUnit.MONTHS);
        System.out.println(date);

        // Subtracting 4 months from given date and time.
        date = LocalDateTime.parse("2020-05-12T08:30:00").minusMonths(4);
        System.out.println(date);

    }

    private static void localTime() {
        LocalTime time = LocalTime.now();
        System.out.println(time);

        // of(int hour, int minute)
        time = LocalTime.of(11, 25);
        System.out.println(time);

        // of(int hour, int minute, int second)
        time = LocalTime.of(11, 25, 03);
        System.out.println(time);

        // of(int hour, int minute, int second, int nanoOfSecond)
        time = LocalTime.of(11, 25, 04, 323);
        System.out.println(time);

        // parse(CharSequence text)
        time = LocalTime.parse("08:27");
        System.out.println(time);

        // parse(CharSequence text, DateTimeFormatter formatter)
        time = LocalTime.parse("08:27", DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println(time);


        // Adding 4 seconds to the given time.
        time = LocalTime.parse("12:54:53").plusSeconds(4);
        System.out.println(time);

        // Adding 10 minutes to the given time.
        time = LocalTime.parse("12:54:53").plusMinutes(10);
        System.out.println(time);

        // Adding 2 hours to the given time.
        time = LocalTime.parse("12:54:53").plusHours(2);
        System.out.println(time);

        // Adding 4 minutes to the given time.
        time = LocalTime.parse("12:54:53").plus(4, ChronoUnit.MINUTES);
        System.out.println(time);

        int minute = LocalTime.parse("07:45").getMinute();
        System.out.println(minute);

        boolean isBefore = LocalTime.parse("06:23")
                .isBefore(LocalTime.parse("07:50"));
        System.out.println(isBefore);

        boolean isAfter = LocalTime.parse("06:23")
                .isAfter(LocalTime.parse("07:50"));
        System.out.println(isAfter);
    }

    private static void localDate() {
        // now() method will return the current date.
        LocalDate date = LocalDate.now();
        System.out.println(date);

        // of(int year, int month, int dayOfMonth)
        date = LocalDate.of(2019, 05, 03);
        System.out.println(date);

        // of(int year, Month month, int dayOfMonth)
        date = LocalDate.of(2019, Month.AUGUST, 03);
        System.out.println(date);

        // parse(CharSequence text)
        date = LocalDate.parse("2015-02-12");
        System.out.println(date);

        // parse(CharSequence text, DateTimeFormatter formatter)
        date = LocalDate.parse("12/02/2012", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(date);

        // Adding 4 days to the given date.
        date = LocalDate.parse("2015-02-12").plusDays(4);
        System.out.println(date);

        // Adding 4 months to the given date.
        date = LocalDate.parse("2015-02-12").plus(4, ChronoUnit.MONTHS);
        System.out.println(date);

        DayOfWeek dayOfWeek = LocalDate.parse("2017-04-06").getDayOfWeek();
        System.out.println(dayOfWeek);

        // Using isBefore() to check if the date is before a given date.
        boolean isBefore = LocalDate.parse("2020-03-12")
                .isBefore(LocalDate.parse("2018-06-14"));
        System.out.println(isBefore);

        // Using isAfter() to check if the date is after a given date.
        boolean isAfter = LocalDate.parse("2020-03-12")
                .isAfter(LocalDate.parse("2018-06-14"));
        System.out.println(isAfter);
    }
}
