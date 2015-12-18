package com.amdudda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Calendar c_scrn = new Calendar();
    }
/*
    // used in initial proof-of-concept development.

    private static String getBorder() {
        String line = "";
        for (int i = 0; i < 36; i++) {
            line += "=";
        }
        return line + "\n";
    }

    private static String calendarBuilder(LocalDate dtu) {
        String calList = getCalHeader(dtu);
        calList += getCalendarBody(dtu);
        calList += getBorder();
        return calList;
    }

    private static String getCalHeader(LocalDate date) {
        String header = getBorder();
        String month = date.getMonth().toString().toUpperCase();
        int charpad = (36 - month.length())/2;
        for (int i = 0; i < charpad; i++) {
            header += " ";
        }
        header += month + "\n";
        header += getBorder();
        return header ;
    }

    private static String getCalendarBody(LocalDate dateToUse) {
        LocalDate firstofMonth = LocalDate.of(dateToUse.getYear(),dateToUse.getMonthValue(),1);
//        System.out.println(firstofMonth);
        int firstDayOfWeek = firstofMonth.getDayOfWeek().getValue();
        int lastDayOfMonth = dateToUse.lengthOfMonth();
//        System.out.println(firstDayOfWeek);
//        System.out.println(lastDayOfMonth);
//        System.out.printf("%02d\n",firstofMonth.getDayOfMonth());
        String calList = "";

        // print out empty squares for the first few dates.
        int cur_weekday=0;
        while (cur_weekday != firstDayOfWeek) {
            calList += ("|    ");
            cur_weekday++;
        }

        for (int d = 1; d <= lastDayOfMonth; d++) {
            LocalDate date_to_print = LocalDate.of(dateToUse.getYear(),dateToUse.getMonth(),d);
            // print out a calendar for the month
            calList += String.format("| %02d ",d);
            if (date_to_print.getDayOfWeek().getValue() == 6) {
                calList += ("|\n");
            }
        }

        // and fill out the empty calendar spaces:
        int dt = LocalDate.of(dateToUse.getYear(),dateToUse.getMonth(),lastDayOfMonth).getDayOfWeek().getValue() % 7;
        for (int d = dt; d < 6; d++) {
            calList += ("|    ");
        }
        calList += ("|\n");  // last pipe to tidy up the display.

        return calList;
    }

*/

}

