import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userMenu {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screenSize.getWidth();
    private double height = screenSize.getHeight();
    static JFrame f1 = new JFrame("Welcome "+variableCredentials.uname.toUpperCase()+" | STRADA");
    static JLabel j1 = new JLabel("WELCOME "+variableCredentials.uname.toUpperCase());
    JLabel j2 = new JLabel("CHOOSE AN OPERATION");
    static JPanel logo = new JPanel(new MigLayout("align center center", "align center center","[]4%[]"));
    static JSplitPane splitPane = new JSplitPane();
    static JPanel controls = new JPanelGradient(new MigLayout("align center center"));

    Color Blue = new Color(0,86,122,255);
    Color Orange = new Color(255,202,68,255);
    Color White50 = new Color(133,174,191,255);
    public static JFrame getf1(){
        return f1;
    }
    public static JSplitPane getspliPane(){return splitPane;}
    public static JPanel getlogo(){return logo;}
    public static JLabel getJ1(){return j1;}
    userMenu() {
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setSize((int)width, (int)height);
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JButton b1 = new JButton("Add Reservation");
        JButton b2 = new JButton("Add Bus to the fleet");
        JButton b3 = new JButton("View Reservations");
        JButton b4 = new JButton("Find Reservation");
        JButton b5 = new JButton("View Buses");
        JButton b6 = new JButton("Logout");

        controls.setSize((int)width, (int)height);
        controls.setVisible(true);

        f1.add(controls);

        j1.setFont(new Font("Sans-serif", Font.PLAIN, 40));
        j1.setForeground(Blue);
        controls.add(j1);

        j2.setFont(new Font("Sans-serif", Font.PLAIN, 50));
        j2.setForeground(Color.white);
        logo.add(j2,"wrap");

        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.setBackground(White50);
        b1.setForeground(Color.WHITE);
        b1.setFont (b1.getFont ().deriveFont (15.0f));
        logo.add(b1,"wrap, width 20%, height 5%");

        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.setBackground(White50);
        b2.setForeground(Color.WHITE);
        b2.setFont (b2.getFont ().deriveFont (15.0f));
        logo.add(b2,"wrap, width 20%, height 5%");

        b3.setBorder(BorderFactory.createEmptyBorder());
        b3.setBackground(White50);
        b3.setForeground(Color.WHITE);
        b3.setFont (b3.getFont ().deriveFont (15.0f));
        logo.add(b3,"wrap, width 20%, height 5%");

        b4.setBorder(BorderFactory.createEmptyBorder());
        b4.setBackground(White50);
        b4.setForeground(Color.WHITE);
        b4.setFont (b4.getFont ().deriveFont (15.0f));
        logo.add(b4,"wrap, width 20%, height 5%");

        b5.setBorder(BorderFactory.createEmptyBorder());
        b5.setBackground(White50);
        b5.setForeground(Color.WHITE);
        b5.setFont (b5.getFont ().deriveFont (15.0f));
        logo.add(b5,"wrap, width 20%, height 5%");

        b6.setBorder(BorderFactory.createEmptyBorder());
        b6.setBackground(Orange);
        b6.setForeground(Color.black);
        b6.setFont (b6.getFont ().deriveFont (15.0f));
        logo.add(b6,"wrap, gapy 20, width 20%, height 5%");

        logo.setSize((int)width, (int)height);
        logo.setBackground(Blue);
        logo.setVisible(true);
        f1.add(logo);

        splitPane.setSize((int)width, (int)height);
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation((int)height/6);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(controls);
        splitPane.setBottomComponent(logo);
        f1.add(splitPane);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                try {
                    addNewBookingButtonPressed();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                try {
                    addNewScheduleButtonPressed();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                try {
                    viewBookingButtonPressed();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                try {
                    searchReservation();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                try {
                    viewSchedule();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        f1.validate();
    }
    public void addNewBookingButtonPressed() throws Exception{
        f1.remove(logo);
        f1.add(addNewBooking.addNewBookingScreen());
        j1.setText("CONFIRM BOOKING");
        f1.add(controls);
        splitPane.setTopComponent(controls);
        splitPane.setBottomComponent(addNewBooking.addNewBookingScreen());
        splitPane.setDividerLocation((int)height/6);
        f1.validate();
    }
    public void addNewScheduleButtonPressed() throws Exception{
        f1.remove(logo);
        f1.add(addNewSchedule.addNewSchedule());
        j1.setText("ADD BUS TO FLEET");
        f1.add(controls);
        splitPane.setTopComponent(controls);
        splitPane.setBottomComponent(addNewSchedule.addNewSchedule());
        splitPane.setDividerLocation((int)height/6);
        f1.validate();
    }
    public void viewBookingButtonPressed() throws Exception{
        f1.remove(logo);
        f1.add(viewAllBookings.viewAllBookingsScreen());
        j1.setText("RESERVATIONS");
        f1.add(controls);
        splitPane.setTopComponent(controls);
        splitPane.setBottomComponent(viewAllBookings.viewAllBookingsScreen());
        splitPane.setDividerLocation((int)height/6);
        f1.validate();
    }
    public void searchReservation() throws Exception{
        f1.remove(logo);
        f1.add(viewAllBookings.searchReservation());
        j1.setText("FIND RESERVATIONS");
        f1.add(controls);
        splitPane.setTopComponent(controls);
        splitPane.setBottomComponent(viewAllBookings.searchReservation());
        splitPane.setDividerLocation((int)height/6);
        f1.validate();
    }
    public void viewSchedule() throws Exception{
        f1.remove(logo);
        f1.add(addNewSchedule.viewSchedule());
        j1.setText("BUSES");
        f1.add(controls);
        splitPane.setTopComponent(controls);
        splitPane.setBottomComponent(addNewSchedule.viewSchedule());
        splitPane.setDividerLocation((int)height/6);
        f1.validate();
    }
}
