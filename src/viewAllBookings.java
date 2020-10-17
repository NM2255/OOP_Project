import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class viewAllBookings {

    viewAllBookings(){}

    public static JPanel viewAllBookingsScreen() throws Exception {
        JPanel options = new JPanel();
        options.setBackground(Color.WHITE);
        options.setVisible(true);

        options.setLayout(new MigLayout());

        updateBookingsTable ubt = new updateBookingsTable();
        JScrollPane sp = new JScrollPane(ubt.getBookings());
        options.add(sp,"growx,pushx,wrap");

        return options;
    }
}
