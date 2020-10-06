package com.shahiqinc;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        new WelcomeScreen();
    }
}

class WelcomeScreen extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screenSize.getWidth();
    private double height = screenSize.getHeight();
    JTextField newTitle = new JTextField("UBIT Travel and Tours");

    public WelcomeScreen() {
        this.setSize((int)width, (int)height);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle(newTitle.getText());

        JLabel jl = new JLabel();
        JLabel j2 = new JLabel();
        JLabel j3 = new JLabel();
        JLabel j4 = new JLabel();
        JLabel j5 = new JLabel();
        JButton b1 = new JButton("Create New Account");
        JButton b2 = new JButton("User Account");
        JButton b3 = new JButton("Admin Account");

        JPanel controls = new JPanel();
        controls.setSize((int)width, (int)height);
        controls.setBackground(Color.GRAY);
        controls.setVisible(true);

        jl.setIcon(new ImageIcon("E:\\Java\\Programs\\E_TICKETING_SYSTEM_FINAL_PROJECT\\img\\logo.png"));
        controls.add(jl);
        add(controls);
        j2.setText("UBIT Travels and Tours");
        controls.add(j2);
//        j2.setHorizontalAlignment(JLabel.CENTER);
        j2.setForeground(Color.BLACK);
        j2.setFont (j2.getFont ().deriveFont (40.0f));

        JPanel logo = new JPanel();
        logo.setSize((int)width, (int)height);
        logo.setBackground(Color.WHITE);
        logo.setVisible(true);

        j4.setIcon(new ImageIcon("E:\\Java\\Programs\\E_TICKETING_SYSTEM_FINAL_PROJECT\\img\\user.png"));
        j4.setPreferredSize(new Dimension((int)width/3, 160));
//        j4.setBorder(new EmptyBorder(300,100,100,0));
        j4.setHorizontalAlignment(JLabel.CENTER);
        j4.setVerticalAlignment(JLabel.CENTER);
        logo.add(j4);
        add(logo);
        j3.setText("Register");
//        j3.setBorder(new EmptyBorder(500,100,100,0));
        j3.setPreferredSize(new Dimension((int)width/2,70));
        j3.setHorizontalAlignment(JLabel.CENTER);
        j3.setFont (j3.getFont ().deriveFont (40.0f));
        logo.add(j3);
        b1.setPreferredSize(new Dimension((int)width/3,44));
        b1.setBackground(Color.WHITE);
        b1.setFont (b1.getFont ().deriveFont (15.0f));
        logo.add(b1);

        j5.setText("Log In");
//        j5.setBorder(new EmptyBorder(500,100,100,0));
        j5.setPreferredSize(new Dimension((int)width/2,70));
        j5.setHorizontalAlignment(JLabel.CENTER);
        j5.setFont (j5.getFont ().deriveFont (40.0f));
        logo.add(j5);

        b2.setPreferredSize(new Dimension((int)width/3,44));
        b2.setBackground(Color.WHITE);
        b2.setFont (b2.getFont ().deriveFont (15.0f));
        logo.add(b2);

        b3.setPreferredSize(new Dimension((int)width/3,44));
        b3.setBackground(Color.WHITE);
        b3.setFont (b3.getFont ().deriveFont (15.0f));
        logo.add(b3);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setSize((int)width, (int)height);
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation((int)width/3);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(controls);
        splitPane.setRightComponent(logo);

        this.add(splitPane);
        validate();

    }
}
