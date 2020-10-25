import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

public class viewAllBookings {

    viewAllBookings(){}

    public static JPanel viewAllBookingsScreen() throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();
        JPanel options = new JPanel();
        JButton back = new JButton("Back");
        JButton del = new JButton("Delete");
        options.setBackground(new Color(0,86,122));
        options.setVisible(true);

        options.setLayout(new MigLayout("","align center center",""));

        reservation res = new reservation();
        JTable schedule = res.showReservation(DriverManager.getConnection("jdbc:ucanaccess://oopdatabase1.accdb"));
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
                        new reservation().deleteReservation(ps,con,rs,cell);
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
    public static JPanel searchReservation() throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();
        JPanel options = new JPanel();
        JLabel line = new JLabel();
        JScrollPane sp = new JScrollPane();
        JLabel srch_lbl = new JLabel("ENTER ID");
        JTextField srch = new JTextField("ID");
        JButton back = new JButton("Back");
        options.setBackground(new Color(0,86,122));
        options.setVisible(true);

        options.setLayout(new MigLayout("align center","align center center",""));

        srch_lbl.setFont(new Font("Sans-serif", Font.PLAIN, 40));
        srch_lbl.setForeground(Color.white);
        options.add(srch_lbl,"wrap,gaptop 5%,gapbottom 2%");

        srch.setFont (srch.getFont ().deriveFont (30.0f));
        srch.setBorder(BorderFactory.createEmptyBorder());
        srch.setBackground(new Color(133, 174, 191));
        srch.setForeground(Color.WHITE);
        srch.setHorizontalAlignment(JTextField.CENTER);
        options.add(srch,"wrap, width 20%!");

        line.setBorder(BorderFactory.createMatteBorder(2,0,0,0,Color.WHITE));
        options.add(line,"wrap,width 90%,gaptop 3%");

        sp.getViewport().setBackground(new Color(0,86,122));
        sp.setBorder(BorderFactory.createEmptyBorder());
        options.add(sp,"wrap,pushx,growx,gaptop 10%,height 11%");

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userMenu.getspliPane().setBottomComponent(userMenu.getlogo());
                userMenu.getJ1().setText("WELCOME "+variableCredentials.uname.toUpperCase());
                userMenu.getspliPane().setDividerLocation((int)height/6);
            }
        });

        srch.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (srch.getText().equals("ID")) {
                    srch.setText("");
                    srch.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (srch.getText().isEmpty()) {
                    srch.setText("ID");
                    srch.setForeground(Color.WHITE);
                }
            }
        });

        srch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservation res = new reservation();
                JTable schedule = null;
                try {
                    schedule = res.searchReservation(srch.getText());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                sp.setViewportView( schedule );
//                options.validate();
            }
        });

        back.setFont(back.getFont().deriveFont(15.0f));
        back.setBackground(new Color(255, 202, 68));
        options.add(back,"width 6%,gaptop 40%");

        return options;
    }
}
