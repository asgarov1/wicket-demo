package com.asgarov.wicket.demo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatterBuilder;

public class HelloWorld extends WebPage {
    public HelloWorld() {
        add(new Label("hello", String.format("Hello World from J | %s | %s", getCurrentDate(), getCurrentTime())));
    }

    private static String getCurrentDate() {
        return LocalDate.now().format(new DateTimeFormatterBuilder().appendPattern("MM/dd").toFormatter());
    }

    private static String getCurrentTime() {
        return LocalTime.now().format(new DateTimeFormatterBuilder().appendPattern("HH:mm:ss").toFormatter());
    }
}
