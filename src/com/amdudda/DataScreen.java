package com.amdudda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Created by amdudda on 12/18/15.
 */
public class DataScreen extends JFrame {
    private JTextField dateSelectedTextField;
    private JPanel dataScreenRootPanel;
    private JButton selectDateButton;
    private JButton exitButton;

    DataScreen() {
        setContentPane(dataScreenRootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        dateSelectedTextField.setText(LocalDate.now().toString());
        pack();
        selectDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate sel_date = LocalDate.parse(dateSelectedTextField.getText());
                Calendar c = new Calendar(sel_date,dateSelectedTextField);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
