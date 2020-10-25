import javax.swing.*;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

public class addNewBooking {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static double width = screenSize.getWidth();
    private static double height = screenSize.getHeight();
    static JTextField departure = new JTextField("From: City",20);
    static JTextField destination = new JTextField("To: City",20);
    static JTextField departureDate = new JTextField("Departure Date",20);
    static JTextField returnDate = new JTextField("Return Date",20);
    static JTextField passengerName = new JTextField("First Name",20);
    static JTextField passengerNameLast = new JTextField("Last Name",20);
    static JTextField passengerNic = new JTextField("NIC#",20);
    static JTextField passengerPhone = new JTextField("Phone",20);
    static JTextField passengerAddr = new JTextField("Address",20);
    static JTextField busName = new JTextField("Bus Name",20);
    static JTextField busNumber = new JTextField("Bus Number",20);
    static JLabel p_info = new JLabel("Passenger Info");
    static JLabel c_info = new JLabel("Contact Info");
    static JLabel b_info = new JLabel("Bus");
    static JLabel t_info = new JLabel("Travel Info");
    static JLabel line = new JLabel();
    static JLabel line1 = new JLabel();
    static JLabel line2 = new JLabel();
    static JLabel line3 = new JLabel();
    static JLabel line4 = new JLabel();
    static JCheckBox o_way = new JCheckBox("Oneway");

    public static JSplitPane addNewBookingScreen() throws Exception{

        JPanel options = new JPanel();
        JPanel options1 = new JPanel();
        JLabel empty = new JLabel(" ");
        JLabel empty1 = new JLabel(" ");
        JLabel empty2 = new JLabel(" ");
        options.setBackground(new Color(0,86,122));
        options.setVisible(true);
        options1.setBackground(new Color(0,86,122));
        options1.setVisible(true);

        Color yellow = new Color(133, 174, 191);

        JButton addBooking = new JButton("Add Reservation");
        JButton back = new JButton("Back");

        options.setLayout(new MigLayout("","align center center","[]4%[]"));
        options1.setLayout(new MigLayout("","align center center","[]4%[]"));

//        User name field visual settings

        p_info.setFont (p_info.getFont ().deriveFont (20.0f));
        p_info.setForeground(Color.WHITE);
        options.add(p_info,"wrap,pushx,align center center,gaptop 7%");

        passengerName.setFont (passengerName.getFont ().deriveFont (20.0f));
        passengerName.setBorder(BorderFactory.createEmptyBorder());
        passengerName.setBackground(yellow);
        passengerName.setForeground(Color.WHITE);
        passengerName.setHorizontalAlignment(JTextField.CENTER);
        options.add(passengerName,"wrap,width 80%!");

        passengerNameLast.setFont (passengerNameLast.getFont ().deriveFont (20.0f));
        passengerNameLast.setBorder(BorderFactory.createEmptyBorder());
        passengerNameLast.setBackground(yellow);
        passengerNameLast.setForeground(Color.WHITE);
        passengerNameLast.setHorizontalAlignment(JTextField.CENTER);
        options.add(passengerNameLast,"wrap,width 80%!");

        passengerNic.setFont (passengerNic.getFont ().deriveFont (20.0f));
        passengerNic.setBorder(BorderFactory.createEmptyBorder());
        passengerNic.setBackground(yellow);
        passengerNic.setForeground(Color.WHITE);
        passengerNic.setHorizontalAlignment(JTextField.CENTER);
        options.add(passengerNic,"wrap,width 80%!");

        line.setBorder(BorderFactory.createMatteBorder(2,0,0,0,Color.WHITE));
        options.add(line,"wrap, width 80%!");

        c_info.setFont (c_info.getFont ().deriveFont (20.0f));
        c_info.setForeground(Color.WHITE);
        options.add(c_info,"wrap,pushx,align center center");

        passengerPhone.setFont (passengerPhone.getFont ().deriveFont (20.0f));
        passengerPhone.setBorder(BorderFactory.createEmptyBorder());
        passengerPhone.setBackground(yellow);
        passengerPhone.setForeground(Color.WHITE);
        passengerPhone.setHorizontalAlignment(JTextField.CENTER);
        options.add(passengerPhone,"wrap,width 80%!");

        passengerAddr.setFont (passengerAddr.getFont ().deriveFont (20.0f));
        passengerAddr.setBorder(BorderFactory.createEmptyBorder());
        passengerAddr.setBackground(yellow);
        passengerAddr.setForeground(Color.WHITE);
        passengerAddr.setHorizontalAlignment(JTextField.CENTER);
        options.add(passengerAddr,"wrap,width 80%!");

        line1.setBorder(BorderFactory.createMatteBorder(2,0,0,0,Color.WHITE));
        options.add(line1,"wrap, width 80%!");

        b_info.setFont (b_info.getFont ().deriveFont (20.0f));
        b_info.setForeground(Color.WHITE);
        options.add(b_info,"wrap,pushx,align center center");

        busName.setFont (busName.getFont ().deriveFont (20.0f));
        busName.setBorder(BorderFactory.createEmptyBorder());
        busName.setBackground(yellow);
        busName.setForeground(Color.WHITE);
        busName.setHorizontalAlignment(JTextField.CENTER);
        options.add(busName,"wrap, width 80%!");

        busNumber.setFont (busNumber.getFont ().deriveFont (20.0f));
        busNumber.setBorder(BorderFactory.createEmptyBorder());
        busNumber.setBackground(yellow);
        busNumber.setForeground(Color.WHITE);
        busNumber.setHorizontalAlignment(JTextField.CENTER);
        options.add(busNumber,"wrap, width 80%!");

        line2.setBorder(BorderFactory.createMatteBorder(2,0,0,0,Color.WHITE));
        options.add(line2,"wrap, width 80%!");

        t_info.setFont (t_info.getFont ().deriveFont (20.0f));
        t_info.setForeground(Color.WHITE);
        options1.add(t_info,"wrap,pushx,align center center,gaptop 7%");

        departure.setFont (departure.getFont ().deriveFont (20.0f));
        departure.setBorder(BorderFactory.createEmptyBorder());
        departure.setBackground(yellow);
        departure.setForeground(Color.WHITE);
        departure.setHorizontalAlignment(JTextField.CENTER);
        options1.add(departure,"wrap, width 80%!");

        destination.setFont (destination.getFont ().deriveFont (20.0f));
        destination.setBorder(BorderFactory.createEmptyBorder());
        destination.setBackground(yellow);
        destination.setForeground(Color.WHITE);
        destination.setHorizontalAlignment(JTextField.CENTER);
        options1.add(destination,"wrap, width 80%!");

        empty.setFont (empty.getFont ().deriveFont (20.0f));
        options1.add(empty,"wrap, width 80%!");

        line3.setBorder(BorderFactory.createMatteBorder(2,0,0,0,Color.WHITE));
        options1.add(line3,"wrap, width 80%!");

        o_way.setBackground(new Color(0,86,122));
        o_way.setForeground(Color.WHITE);

        options1.add(o_way,"span, center, wrap");

        departureDate.setFont (departureDate.getFont ().deriveFont (20.0f));
        departureDate.setBorder(BorderFactory.createEmptyBorder());
        departureDate.setBackground(yellow);
        departureDate.setForeground(Color.WHITE);
        departureDate.setHorizontalAlignment(JTextField.CENTER);
        options1.add(departureDate,"wrap, width 80%!");

        returnDate.setFont (returnDate.getFont ().deriveFont (20.0f));
        returnDate.setBorder(BorderFactory.createEmptyBorder());
        returnDate.setBackground(yellow);
        returnDate.setForeground(Color.WHITE);
        returnDate.setHorizontalAlignment(JTextField.CENTER);
        options1.add(returnDate,"wrap, width 80%!");

        line4.setBorder(BorderFactory.createMatteBorder(2,0,0,0,Color.WHITE));
        options1.add(line4,"wrap, width 80%!");

        empty1.setFont (empty.getFont ().deriveFont (20.0f));
        options1.add(empty1,"wrap, width 80%!");

        addBooking.setFont(addBooking.getFont().deriveFont(15.0f));
        addBooking.setBackground(new Color(255, 202, 68));
        options1.add(addBooking,"wrap, width 80%!");

        empty2.setFont (empty.getFont ().deriveFont (20.0f));
        options1.add(empty2,"wrap, width 80%!");

        back.setFont(back.getFont().deriveFont(15.0f));
        back.setBackground(new Color(255, 202, 68));
        options1.add(back,"wrap, width 20%!,al right,gapright 20%");

        back.setFont(back.getFont().deriveFont(15.0f));
        back.setBackground(new Color(255, 202, 68));
        options1.add(back,"width 20%!,al right,split 2,gapright 20%");

        options.setBorder(BorderFactory.createMatteBorder(0,0,0,4,Color.WHITE));
        options1.setBorder(BorderFactory.createMatteBorder(0,0,0,3,Color.WHITE));

        JSplitPane splitPane1 = new JSplitPane();
        splitPane1.setDividerSize(0);
        splitPane1.setDividerLocation((int)(width/3.2));
        splitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane1.setLeftComponent(options);
        splitPane1.setRightComponent(options1);

        addBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    addNewBookingConfirmed();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userMenu.getspliPane().setBottomComponent(userMenu.getlogo());
                userMenu.getJ1().setText("WELCOME "+variableCredentials.uname.toUpperCase());
                userMenu.getspliPane().setDividerLocation((int)height/6);
            }
        });

        passengerName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passengerName.getText().equals("First Name")) {
                    passengerName.setText("");
                    passengerName.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (passengerName.getText().isEmpty()) {
                    passengerName.setText("First Name");
                    passengerName.setForeground(Color.WHITE);
                }
            }
        });

        passengerNameLast.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passengerNameLast.getText().equals("Last Name")) {
                    passengerNameLast.setText("");
                    passengerNameLast.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (passengerNameLast.getText().isEmpty()) {
                    passengerNameLast.setText("Last Name");
                    passengerNameLast.setForeground(Color.WHITE);
                }
            }
        });

        passengerNic.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passengerNic.getText().equals("NIC#")) {
                    passengerNic.setText("");
                    passengerNic.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (passengerNic.getText().isEmpty()) {
                    passengerNic.setText("NIC#");
                    passengerNic.setForeground(Color.WHITE);
                }
            }
        });

        passengerPhone.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passengerPhone.getText().equals("Phone")) {
                    passengerPhone.setText("");
                    passengerPhone.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (passengerPhone.getText().isEmpty()) {
                    passengerPhone.setText("Phone");
                    passengerPhone.setForeground(Color.WHITE);
                }
            }
        });

        passengerAddr.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passengerAddr.getText().equals("Address")) {
                    passengerAddr.setText("");
                    passengerAddr.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (passengerAddr.getText().isEmpty()) {
                    passengerAddr.setText("Address");
                    passengerAddr.setForeground(Color.WHITE);
                }
            }
        });

        busName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (busName.getText().equals("Bus Name")) {
                    busName.setText("");
                    busName.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (busName.getText().isEmpty()) {
                    busName.setText("Bus Name");
                    busName.setForeground(Color.WHITE);
                }
            }
        });

        busNumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (busNumber.getText().equals("Bus Number")) {
                    busNumber.setText("");
                    busNumber.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (busNumber.getText().isEmpty()) {
                    busNumber.setText("Bus Number");
                    busNumber.setForeground(Color.WHITE);
                }
            }
        });

        departure.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (departure.getText().equals("From: City")) {
                    departure.setText("");
                    departure.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (departure.getText().isEmpty()) {
                    departure.setText("From: City");
                    departure.setForeground(Color.WHITE);
                }
            }
        });

        destination.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (destination.getText().equals("To: City")) {
                    destination.setText("");
                    destination.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (destination.getText().isEmpty()) {
                    destination.setText("To: City");
                    destination.setForeground(Color.WHITE);
                }
            }
        });

        departureDate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (departureDate.getText().equals("Departure Date")) {
                    departureDate.setText("");
                    departureDate.setForeground(Color.BLACK);
                }
            }


            @Override
            public void focusLost(FocusEvent e) {
                if (departureDate.getText().isEmpty()) {
                    departureDate.setText("Departure Date");
                    departureDate.setForeground(Color.WHITE);
                }
            }
        });

        returnDate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (returnDate.getText().equals("Return Date")) {
                    returnDate.setText("");
                    returnDate.setForeground(Color.BLACK);
                }
            }


            @Override
            public void focusLost(FocusEvent e) {
                if (returnDate.getText().isEmpty()) {
                    returnDate.setText("Return Date");
                    returnDate.setForeground(Color.WHITE);
                }
            }
        });

        o_way.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox cb = (JCheckBox) event.getSource();
                if (cb.isSelected()) {
                    returnDate.setEnabled(false);
                } else {
                    returnDate.setEnabled(true);
                }
            }
        });

        JPanel schedulePanel = new JPanel();
        schedulePanel.setLayout(new MigLayout());
        schedulePanel.setBackground(new Color(0,86,122));
        schedulePanel.setVisible(true);

        bus BUS = new bus();
        JTable schedule = BUS.showSchedule(DriverManager.getConnection("jdbc:ucanaccess://oopdatabase1.accdb"));
        JScrollPane sp = new JScrollPane(schedule);
        schedulePanel.add(sp,"growx,pushx,wrap,pushy,growy");

        JSplitPane splitPane = new JSplitPane();
        splitPane.setBackground(new Color(0,86,122));
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation((int)(width/1.6));
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(splitPane1);
        splitPane.setRightComponent(schedulePanel);

        return splitPane;
    }
    public static void addNewBookingConfirmed() throws SQLException, ClassNotFoundException {

        PreparedStatement psRes = null;
        ResultSet rsRes = null;
        Connection con = null;
        con = DriverManager.getConnection("jdbc:ucanaccess://oopdatabase1.accdb");
        passenger oPsngr = new passenger(passengerName.getText(),passengerNameLast.getText(),passengerNic.getText(),passengerPhone.getText(),passengerAddr.getText());

        reservation oRes = new reservation(departure.getText(),destination.getText(),departureDate.getText(),
                returnDate.getText(),busName.getText(),busNumber.getText());

       // reservation oRes = new reservation(departure.getText(),destination.getText(),departureDate.getText(),
             //   returnDate.getText(),passengerName.getText(),passengerNameLast.getText(),passengerNic.getText(),
               // passengerPhone.getText(),passengerAddr.getText(),busName.getText(),busNumber.getText());

        oRes.addReservation(psRes,con,oPsngr);
    }
}
