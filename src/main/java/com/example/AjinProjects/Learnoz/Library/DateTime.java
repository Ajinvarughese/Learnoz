package com.example.AjinProjects.Learnoz.Library;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    public static String currentDateTime() {
        ZonedDateTime dateTimeInIST = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        return dateTimeInIST.format(formatter);
    }
}
