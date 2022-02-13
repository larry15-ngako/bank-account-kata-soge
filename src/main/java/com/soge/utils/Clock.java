package com.soge.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    private static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public String todayAsString() {
        LocalDate currentDate = LocalDate.of(2022, 02, 13);
        return currentDate.format(DATE_TIME_FORMATTER);
    }
}
