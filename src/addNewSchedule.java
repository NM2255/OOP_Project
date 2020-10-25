import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

public class addNewSchedule {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static double width = screenSize.getWidth();
    private static double height = screenSize.getHeight();
    static JTextField busName = new JTextField("Bus Name",20);
    static JTextField busNumber = new JTextField("Bus Number",20);
    static JTextField busRoute = new JTextField("Route",20);
    static JTextField busTiming = new JTextField("Timing",20);
    static JLabel empty = new JLabel(" ");

    public static JPanel addNewSchedule() throws Exception {
        JButton back = new JButton("Back");
        JPanel options = new JPanel();
        Color blue = new Color(0,86,122);
        Color yellow = new Color(255, 202, 68);
        Color white = new Color(133, 174, 191);
        options.setBackground(blue);
        options.setVisible(true);

        JButton addBooking = new JButton("Add Bus");

        options.setLayout(new MigLayout("align center center","align center center","[]4%[]"));

        busName.setFont (busName.getFont ().deriveFont (25.0f));
        busName.setBorder(BorderFactory.createEmptyBorder());
        busName.setBackground(white);
        busName.setHorizontalAlignment(JTextField.CENTER);
        busName.setForeground(Color.WHITE);
        options.add(busName,"wrap, width 20%!");

        busNumber.setFont (busNumber.getFont ().deriveFont (25.0f));
        busNumber.setBorder(BorderFactory.createEmptyBorder());
        busNumber.setBackground(white);
        busNumber.setForeground(Color.WHITE);
        busNumber.setHorizontalAlignment(JTextField.CENTER);
        options.add(busNumber,"wrap, width 20%!");


        busRoute.setFont (busRoute.getFont ().deriveFont (25.0f));
        busRoute.setBorder(BorderFactory.createEmptyBorder());
        busRoute.setBackground(white);
        busRoute.setForeground(Color.WHITE);
        busRoute.setHorizontalAlignment(JTextField.CENTER);
        options.add(busRoute,"wrap, width 20%!");

        busTiming.setFont (busTiming.getFont ().deriveFont (25.0f));
        busTiming.setBorder(BorderFactory.createEmptyBorder());
        busTiming.setBackground(white);
        busTiming.setForeground(Color.WHITE);
        busTiming.setHorizontalAlignment(JTextField.CENTER);
        options.add(busTiming,"wrap, width 20%!");

        empty.setBorder(BorderFactory.createMatteBorder(2,0,0,0,Color.WHITE));
        options.add(empty,"wrap, width 20%!");

        addBooking.setFont(addBooking.getFont().deriveFont(15.0f));
        addBooking.setBackground(yellow);
        options.add(addBooking,"width 20%, height 5%");

        options.add(new JLabel(),"wrap");
        options.add(new JLabel(),"wrap");

        back.setFont(back.getFont().deriveFont(15.0f));
        back.setBackground(yellow);
        options.add(back,"width 5%");

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userMenu.getspliPane().setBottomComponent(userMenu.getlogo());
                userMenu.getJ1().setText("WELCOME "+variableCredentials.uname.toUpperCase());
                userMenu.getspliPane().setDividerLocation((int)height/6);
            }
        });

        addBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    addNewScheduleConfirmed();
                } catch (Exception exception) {
                    exception.printStackTrace();
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
        busRoute.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (busRoute.getText().equals("Route")) {
                    busRoute.setText("");
                    busRoute.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (busRoute.getText().isEmpty()) {
                    busRoute.setText("Route");
                    busRoute.setForeground(Color.WHITE);
                }
            }
        });
        busTiming.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (busTiming.getText().equals("Timing")) {
                    busTiming.setText("");
                    busTiming.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (busTiming.getText().isEmpty()) {
                    busTiming.setText("Timing");
                    busTiming.setForeground(Color.WHITE);
                }
            }
        });

        return options;
    }
    public static void addNewScheduleConfirmed() throws Exception {
        if(busName.getText().equals("") || busNumber.getText().equals("") || busRoute.getText().equals("") || busTiming.getText().equals("")){
            JOptionPane.showMessageDialog(userMenu.getf1(), "Please fill all fields!");
        }
        else{
            bus bs = new bus(busName.getText(),busNumber.getText(),busRoute.getText(),busTiming.getText());
            busName.setText("");
            busNumber.setText("");
            busRoute.setText("");
            busTiming.setText("");
            PreparedStatement ps = null;
            Connection con = null;
            con = DriverManager.getConnection("jdbc:ucanaccess://oopdatabase1.accdb");
            bs.addBus(ps,con);
        }
    }
    public static JPanel viewSchedule() throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();
        JPanel options = new JPanel();
        JButton back = new JButton("Back");
        JButton del = new JButton("Delete");
        options.setBackground(new Color(0,86,122));
        options.setVisible(true);

        options.setLayout(new MigLayout("","align center center",""));

        bus res = new bus();
        JTable schedule = res.showSchedule(DriverManager.getConnection("jdbc:ucanaccess://oopdatabase1.accdb"));
        JScrollPane sp = new JScrollPane(schedule);
        options.add(sp,"growx,pushx,wrap,height 80%");

        options.add(new JLabel(" "),"wrap");
        options.add(new JLabel(" "),"wrap");

        back.setFont(back.getFont().deriveFont(15.0f));
        back.setBackground(new Color(255, 202, 68));
        options.add(back,"width 6%,split 2,gapright 3%");

        del.setFont(del.getFont().deriveFont(15.0f));
        del.setBackground(new Color(255, 202, 68));
        options.add(del,"width 6%,wrap");

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userMenu.getspliPane().setBottomComponent(userMenu.getlogo());
                userMenu.getJ1().setText("WELCOME "+variableCredentials.uname.toUpperCase());
                userMenu.getspliPane().setDividerLocation((int)height/6);
            }
        });

        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tblmodel = (DefaultTableModel)schedule.getModel();
                if(schedule.getSelectedRowCount()==1){
                    PreparedStatement ps = null;
                    Connection con = null;
                    ResultSet rs = null;
                    int row = schedule.getSelectedRow();
                    String cell = schedule.getModel().getValueAt(row,0).toString();
                    try {
                        con = DriverManager.getConnection("jdbc:ucanaccess://oopdatabase1.accdb");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        new bus().deleteBus(ps,con,rs,cell);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    tblmodel.removeRow(schedule.getSelectedRow());
                }
                else{
                    JOptionPane.showMessageDialog(userMenu.getf1(), "Please select only one row!");
                }
            }
        });

        return options;
    }
}
