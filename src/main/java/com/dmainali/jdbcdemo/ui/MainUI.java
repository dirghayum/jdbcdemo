package com.dmainali.jdbcdemo.ui;

import javax.swing.*;

public class MainUI{
    public static void main(String[] args) {
        JFrame  frame = new JFrame("App");
        frame.setVisible(true);

        JTextField t1 = new JTextField();
        t1.setSize(100,1);
        t1.setVisible(true);
        frame.add(t1);
        frame.setSize(500,500);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
