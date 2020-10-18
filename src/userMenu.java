import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userMenu {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screenSize.getWidth();
    private double height = screenSize.getHeight();
    static JFrame f1 = new JFrame("Welcome, "+variableCredentials.uname+" | UBIT Travels and Tours");
    JLabel j1 = new JLabel("Welcome, "+variableCredentials.uname);
    JPanel logo = new JPanel();
    JSplitPane splitPane = new JSplitPane();
    JPanel controls = new JPanel();
    public static JFrame getf1(){
        return f1;
    }
    userMenu() {
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setSize((int)width, (int)height);
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JLabel empty = new JLabel();
        JButton b1 = new JButton("Add new booking");
        JButton b2 = new JButton("Add new schedule");
        JButton b3 = new JButton("View all bookings");

        controls.setSize((int)width, (int)height);
        controls.setBackground(Color.WHITE);
        controls.setVisible(true);

        f1.add(controls);

        j1.setFont (j1.getFont ().deriveFont (40.0f));
        //j1.setBorder(new EmptyBorder(0,0,0,0));
        j1.setVerticalAlignment(JLabel.CENTER);
        controls.add(j1);

        empty.setPreferredSize(new Dimension((int)width,0));
        controls.add(empty);

        b1.setPreferredSize(new Dimension((int)width/5,44));
        b1.setBackground(Color.WHITE);
        b1.setFont (b1.getFont ().deriveFont (15.0f));
        b1.setBorder(new RoundedBorder(40));
        controls.add(b1);

        b2.setPreferredSize(new Dimension((int)width/5,44));
        b2.setBackground(Color.WHITE);
        b2.setFont (b2.getFont ().deriveFont (15.0f));
        b2.setBorder(new RoundedBorder(40));
        controls.add(b2);

        b3.setPreferredSize(new Dimension((int)width/5,44));
        b3.setBackground(Color.WHITE);
        b3.setFont (b3.getFont ().deriveFont (15.0f));
        b3.setBorder(new RoundedBorder(40));
        controls.add(b3);

        logo.setSize((int)width, (int)height);
        logo.setBackground(Color.PINK);
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

        f1.validate();
    }
    public void addNewBookingButtonPressed() throws Exception{
        f1.remove(logo);
        f1.add(addNewBooking.addNewBookingScreen());
        f1.add(controls);
        splitPane.setTopComponent(controls);
        splitPane.setBottomComponent(addNewBooking.addNewBookingScreen());
        splitPane.setDividerLocation((int)height/6);
        f1.validate();
    }
    public void addNewScheduleButtonPressed() throws Exception{
        f1.remove(logo);
        f1.add(addNewSchedule.addNewSchedule());
        f1.add(controls);
        splitPane.setTopComponent(controls);
        splitPane.setBottomComponent(addNewSchedule.addNewSchedule());
        splitPane.setDividerLocation((int)height/6);
        f1.validate();
    }
    public void viewBookingButtonPressed() throws Exception{
        f1.remove(logo);
        f1.add(addNewSchedule.addNewSchedule());
        f1.add(controls);
        splitPane.setTopComponent(controls);
        splitPane.setBottomComponent(viewAllBookings.viewAllBookingsScreen());
        splitPane.setDividerLocation((int)height/6);
        f1.validate();
    }
}