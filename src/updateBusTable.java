import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class updateBusTable {

    updateBusTable(){}

    public JTable getBusSchedule() throws SQLException {
        String[][] data = {};
        String[] columnNames = { "ID","Name", "Bus Number", "Route", "Timings" };

        DefaultTableModel model = new DefaultTableModel(data,columnNames);
        JTable schedule = new JTable(model);

        //connection
        Connection con=null;
        PreparedStatement psBus=null;
        ResultSet rsBus=null;
        con = DriverManager.getConnection("jdbc:ucanaccess://e://oopdatabase.accdb");
        String in = "select * from bus";

        try {
            psBus = con.prepareStatement(in);
            rsBus = psBus.executeQuery();
            schedule.setModel(DbUtils.resultSetToTableModel(rsBus));
        }
        catch (Exception e){

        }
        finally {
            try{
                rsBus.close();
                psBus.close();
            }
            catch (Exception e){

            }
        }
        schedule.setFont(schedule.getFont().deriveFont(20.0f));
        schedule.setRowHeight(30);
        schedule.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 20));
        return schedule;
    }
}
