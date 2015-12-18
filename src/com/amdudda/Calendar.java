package com.amdudda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

/**
 * Created by amdudda on 12/18/15.
 */
public class Calendar extends JFrame {
    private LocalDate selectedDate;
    private JTable calendarTable;
    private JLabel monthLabel;
    private JPanel calendarRootPanel;
    private JButton exitButton;
    private JButton fwdOneMonthButton;
    private JButton fwdOneYearbutton;
    private JTextField selDateTextField;
    private JButton revOneMonthButton;
    private JButton revOneYearButton;
    private CalendarTableModel calTM;

    Calendar() {
        selectedDate = LocalDate.now();

        setContentPane(calendarRootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400,300);
        setMonthLabel();
        selDateTextField.setText(selectedDate.toString());
        calTM = new CalendarTableModel(selectedDate);
        calendarTable.setModel(calTM);
        for (int i = 0; i < calTM.getColcount(); i++) {
            calendarTable.getColumnModel().getColumn(i).setMaxWidth(50);
        }

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fwdOneMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                advanceOneMonth();
            }
        });
        fwdOneYearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                advanceOneYear();
            }
        });

        revOneMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retreatOneMonth();
            }
        });
        revOneYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retreatOneYear();
            }
        });
        calendarTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int col = calendarTable.getSelectedColumn();
                int row = calendarTable.getSelectedRow();
                try {
                    int dayNum = Integer.parseInt(calendarTable.getValueAt(row, col).toString());
                    selectedDate = LocalDate.of(selectedDate.getYear(), selectedDate.getMonth(), dayNum);
                    selDateTextField.setText(selectedDate.toString());
                } catch (NumberFormatException nfe) {
                    // just do nothing if it can't parse the empty string.
                    return;
                }
            }
        });
    }

    private void advanceOneYear() {
        selectedDate = selectedDate.plusYears(1);
        setMonthLabel();
        calTM.refresh(selectedDate);
    }

    private void advanceOneMonth() {
        selectedDate = selectedDate.plusMonths(1);
        setMonthLabel();
        calTM.refresh(selectedDate);
    }


    private void retreatOneYear() {
        selectedDate = selectedDate.minusYears(1);
        setMonthLabel();
        calTM.refresh(selectedDate);
    }

    private void retreatOneMonth() {
        selectedDate = selectedDate.minusMonths(1);
        setMonthLabel();
        calTM.refresh(selectedDate);
    }

    private void setMonthLabel() {
        monthLabel.setText(selectedDate.getMonth().toString() + " " + selectedDate.getYear());
    }
}
