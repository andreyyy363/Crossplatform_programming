package com.example.studentapp.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {
    // Шаблон дати
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    // Форматтер дати
    private static final DateTimeFormatter
            DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);


    // Перетворює об'єкт LocalDate в рядок, щоб його можна було відобразити в текстовому полі
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    // Перетворює рядок в форматі дати в об'єкт LocalDate
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    // Перевіряє, чи введений рядок є правильною датою.
    public static boolean validDate(String dateString) {
        // Намагаємось розібрати рядок.
        return DateUtil.parse(dateString) != null;
    }
}