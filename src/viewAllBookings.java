import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.sql.DriverManager;

public class viewAllBookings {

    viewAllBookings(){}

    public static JPanel viewAllBookingsScreen() throws Exception {
        JPanel options = new JPanel();
        options.setBackground(Color.WHITE);
        options.setVisible(true);

        options.setLayout(new MigLayout());

        reservation res = new reservation();
        JTable schedule = res.showReservation(DriverManager.getConnection("jdbc:ucanaccess://e://oopdatabase.accdb"));
        JScrollPane sp = new JScrollPane(schedule);
        options.add(sp,"growx,pushx,wrap");

        return options;
    }
}
