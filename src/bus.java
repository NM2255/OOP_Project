import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class bus {
    public int busId;
    public String busName;
    public String busNumber;
    public String busRoute;
    public String busTiming;

    //constructor for bus class
    public bus(){}

    public bus(String busName, String busNumber, String busRoute, String busTiming){
        this.busId = busId;
        this.busName = busName;
        this.busNumber = busNumber;
        this.busRoute = busRoute;
        this.busTiming = busTiming;
    }

    //method for adding bus
    public void addBus(PreparedStatement psBus, Connection con) throws Exception{
        String in = ("insert into bus(busName,busNumber,busTiming,busRoute)"+
                "values ('" + busName + "','" + busNumber +"','" +busTiming +"','" +busRoute +"')");
        psBus = con.prepareStatement(in);
        psBus.executeUpdate();
    }

    public String getBusName() {
        return busName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public String getBusTiming() {
        return busTiming;
    }

    public void deleteBus(PreparedStatement psBus, Connection con, ResultSet rsBus,String cell) throws Exception {
        String sql = "DELETE FROM bus WHERE id = "+cell;
        psBus = con.prepareStatement(sql);
        psBus.executeUpdate();
    }

    public void editBus(){}

    public void searchBus(){}

    public JTable showSchedule(Connection con) throws Exception {
        /*read user data from database */

        PreparedStatement psBus = null;
        ResultSet rsBus = null;
        String sql = "select * from bus";
        psBus = con.prepareStatement(sql);
        rsBus = psBus.executeQuery();

        JTable table = new JTable(buildTableModel.BuildTableModel(rsBus));

        table.setFillsViewportHeight(true);
        table.setFont(table.getFont().deriveFont(20.0f));
        table.setRowHeight(60);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 20));

        return table;
    }
}