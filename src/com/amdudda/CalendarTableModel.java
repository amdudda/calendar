package com.amdudda;

import javax.swing.table.AbstractTableModel;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * Created by amdudda on 12/18/15.
 */
public class CalendarTableModel extends AbstractTableModel {
    LinkedList<String> cal;
    int rowcount=0;
    int colcount=0;

    public CalendarTableModel(LocalDate date) {
        this.cal = buildDateList(date);
        setup();
    }

    private void setup(){
        this.rowcount = (int) this.cal.size() / 7;
        this.colcount = 7;
    }

    @Override
    public int getRowCount() {
        return this.rowcount;
    }

    @Override
    public int getColumnCount() {
        return this.colcount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int position = ((rowIndex * 7) + (columnIndex +1)) - 1;
        return cal.get(position);
    }

    @Override
    public String getColumnName(int col) {
        String dayName = "";
        switch (col) {
            case 0: dayName = "SU"; break;
            case 1: dayName = "MO"; break;
            case 2: dayName = "TU"; break;
            case 3: dayName = "WE"; break;
            case 4: dayName = "TH"; break;
            case 5: dayName = "FR"; break;
            case 6: dayName = "SA"; break;
            default: dayName = "??"; break;
        }
        return dayName;
    }

    // getters for row and column counts
    public int getRowcount() {
        return rowcount;
    }

    public int getColcount() {
        return colcount;
    }

    private static LinkedList<String> buildDateList(LocalDate dateToUse) {
        LinkedList<String> listOfDates = new LinkedList<>();
        LocalDate firstofMonth = LocalDate.of(dateToUse.getYear(),dateToUse.getMonthValue(),1);
//        System.out.println(firstofMonth);
        int firstDayOfWeek = firstofMonth.getDayOfWeek().getValue() % 7;
        int lastDayOfMonth = dateToUse.lengthOfMonth();

        // insert strings into empty squares for the first few dates.
        int cur_weekday=0;
        while (cur_weekday != firstDayOfWeek) {
            listOfDates.add("");
            cur_weekday++;
        }

        // then populate the individual dates.
        for (int d = 1; d <= lastDayOfMonth; d++) {
            LocalDate date_to_print = LocalDate.of(dateToUse.getYear(),dateToUse.getMonth(),d);
            // print out a calendar for the month
            listOfDates.add(String.format("%02d",d));
        }

        // and fill out the empty calendar spaces:
        int dt = LocalDate.of(dateToUse.getYear(),dateToUse.getMonth(),lastDayOfMonth).getDayOfWeek().getValue() % 7;
        for (int d = dt; d < 6; d++) {
            listOfDates.add("");
        }

        return listOfDates;
    }

    protected void refresh(LocalDate date) {
        this.cal = buildDateList(date);
        setup();
        fireTableStructureChanged();
    }
}
