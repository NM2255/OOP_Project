import javax.swing.*;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class addNewBooking {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static double width = screenSize.getWidth();
    private static double height = screenSize.getHeight();
    static JTextField departure = new JTextField(20);
    static JTextField destination = new JTextField(20);
    static JTextField departureDate = new JTextField(20);
    static JTextField returnDate = new JTextField(20);
    static JTextField passengerName = new JTextField(20);
    static JTextField passengerNameLast = new JTextField(20);
    static JTextField passengerNic = new JTextField(20);
    static JTextField passengerPhone = new JTextField(20);
    static JTextField passengerAddr = new JTextField(20);
    static JTextField busName = new JTextField(20);
    static JTextField busNumber = new JTextField(20);

    public static JSplitPane addNewBookingScreen() throws Exception{
        JPanel options = new JPanel();
        options.setBackground(Color.WHITE);
        options.setVisible(true);

        JLabel j1 = new JLabel("Enter source");
        JLabel j2 = new JLabel("Enter destination");
        JLabel j3 = new JLabel("Enter departure date");
        JLabel j4 = new JLabel("Enter return date");
        JLabel j5 = new JLabel("Enter first name");
        JLabel j11 = new JLabel("Enter last name");
        JLabel j6 = new JLabel("Enter NIC");
        JLabel j7 = new JLabel("Enter phone number");
        JLabel j8 = new JLabel("Enter address");
        JLabel j9 = new JLabel("Enter bus name");
        JLabel j10 = new JLabel("Enter bus number");

        JButton addBooking = new JButton("Add Booking");

        options.setLayout(new MigLayout("","20[]","[]10[]"));

//        User name field visual settings

        j5.setFont (j5.getFont ().deriveFont (20.0f));
        options.add(j5,"al right");

        passengerName.setFont (passengerName.getFont ().deriveFont (20.0f));
        passengerName.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(passengerName,"wrap,width 400!");

        j11.setFont (j11.getFont ().deriveFont (20.0f));
        options.add(j11,"al right");

        passengerNameLast.setFont (passengerNameLast.getFont ().deriveFont (20.0f));
        passengerNameLast.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(passengerNameLast,"wrap,width 400!");

        j6.setFont (j6.getFont ().deriveFont (20.0f));
        options.add(j6,"al right");

        passengerNic.setFont (passengerNic.getFont ().deriveFont (20.0f));
        passengerNic.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(passengerNic,"wrap,width 400!");

        j7.setFont (j7.getFont ().deriveFont (20.0f));
        options.add(j7,"al right");

        passengerPhone.setFont (passengerPhone.getFont ().deriveFont (20.0f));
        passengerPhone.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(passengerPhone,"wrap,width 400!");

        j8.setFont (j8.getFont ().deriveFont (20.0f));
        options.add(j8,"al right");

        passengerAddr.setFont (passengerAddr.getFont ().deriveFont (20.0f));
        passengerAddr.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(passengerAddr,"wrap,width 400!");

        j1.setFont (j1.getFont ().deriveFont (20.0f));
        options.add(j1,"al right");

        departure.setFont (departure.getFont ().deriveFont (20.0f));
        departure.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(departure,"wrap, width 400!");

        j2.setFont (j2.getFont ().deriveFont (20.0f));
        options.add(j2,"al right");

        destination.setFont (destination.getFont ().deriveFont (20.0f));
        destination.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(destination,"wrap, width 400!");

        j3.setFont (j3.getFont ().deriveFont (20.0f));
        options.add(j3,"al right");

        departureDate.setFont (departureDate.getFont ().deriveFont (20.0f));
        departureDate.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(departureDate,"wrap, width 400!");

        j4.setFont (j4.getFont ().deriveFont (20.0f));
        options.add(j4,"al right");

        returnDate.setFont (returnDate.getFont ().deriveFont (20.0f));
        returnDate.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(returnDate,"wrap, width 400!");


        j9.setFont (j9.getFont ().deriveFont (20.0f));
        options.add(j9,"al right");

        busName.setFont (busName.getFont ().deriveFont (20.0f));
        busName.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(busName,"wrap, width 400!");

        j10.setFont (j10.getFont ().deriveFont (20.0f));
        options.add(j10,"al right");

        busNumber.setFont (busNumber.getFont ().deriveFont (20.0f));
        busNumber.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(busNumber,"wrap, width 400!");

        options.add(new JLabel(""));

        addBooking.setFont(addBooking.getFont().deriveFont(15.0f));
        addBooking.setBackground(Color.WHITE);
        addBooking.setBorder(new RoundedBorder(55));
        options.add(addBooking,"width "+(int)width/4+"!, height 50!");

        addBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    addNewBookingConfirmed();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        JPanel schedulePanel = new JPanel();
        schedulePanel.setLayout(new MigLayout());
        schedulePanel.setBackground(Color.WHITE);
        schedulePanel.setVisible(true);

        bus BUS = new bus();
        JTable schedule = BUS.showSchedule(DriverManager.getConnection("jdbc:ucanaccess://e://oopdatabase.accdb"));
        JScrollPane sp = new JScrollPane(schedule);
        schedulePanel.add(sp,"growx,pushx,wrap");

        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation((int)width/2);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(options);
        splitPane.setRightComponent(schedulePanel);

        return splitPane;
    }
    public static void addNewBookingConfirmed() throws SQLException {

        PreparedStatement psRes = null;
        ResultSet rsRes = null;
        Connection con = null;
        con = DriverManager.getConnection("jdbc:ucanaccess://e://oopdatabase.accdb");

        reservation oRes = new reservation(departure.getText(),destination.getText(),departureDate.getText(),
                returnDate.getText(),passengerName.getText(),passengerNameLast.getText(),passengerNic.getText(),
                passengerPhone.getText(),passengerAddr.getText(),busName.getText(),busNumber.getText());

        oRes.addReservation(psRes,con);
    }
}