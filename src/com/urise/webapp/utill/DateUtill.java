package com.urise.webapp.utill;

import java.time.LocalDate;
import java.time.Month;

public class DateUtill {
    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }
}
