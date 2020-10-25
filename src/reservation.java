import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class reservation {
    public int reservationId;
    public String departure;
    public String destination;
    public String departureDate;
    public String returnDate;
    String passengerFirstname;
    String passengerLastname;
    String passengerNic;
    String passengerPhone;
    String passengerAddr;
    String busName;
    String busNumber;

    //constructor for reservation class
    public reservation(){

    }

    public reservation(String departure, String destination, String departureDate, String returnDate,  String busName, String busNumber){
        this.reservationId = reservationId;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.busName = busName;
        this.busNumber = busNumber;

    }

    public void addReservation(PreparedStatement psRes ,Connection con,passenger oPsngr) throws SQLException {

        //adds reservation details to database
        String in = ("insert into reservation(departure,destination,departureDate,returnDate,passengerFirstname,passengerLastname,passengerNic,passengerPhone,passengerAddr,busName,busNumber)" +
                "values ('" + departure + "','" + destination + "','" + departureDate + "','" + returnDate + "','" + oPsngr.getPassengerfirstName()+ "','" + oPsngr.getPassengerlastName()+ "','" + oPsngr.getPassengerNic() + "','" + oPsngr.getPassengerPhone() + "','" + oPsngr.getPassengerAddr() + "','" + busName + "','" + busNumber + "')");
        psRes = con.prepareStatement(in,Statement.RETURN_GENERATED_KEYS);
        psRes.executeUpdate();

        ResultSet rs = psRes.getGeneratedKeys();

        int generatedKey = 0;
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Calendar calobj = Calendar.getInstance();

        JPanel table = new JPanel(new MigLayout("align center","4%","4%"));
        JLabel name = new JLabel("STRADA");
        JLabel our_addr = new JLabel("STRADA Inc., Bori Bazar.");
        JLabel ps_id = new JLabel("Passenger ID                : "+generatedKey);
        JLabel ps_name = new JLabel("Passenger Name        : "+oPsngr.getPassengerfirstName()+" "+oPsngr.getPassengerlastName());
        JLabel a_name = new JLabel("Issued by                       : Mr. "+variableCredentials.uname.toUpperCase());
        JLabel f_to = new JLabel("From/To                          : "+departure+" / "+destination);
        JLabel d_iss = new JLabel("Date Issued                   : "+df.format(calobj.getTime()));
        table.add(name,"wrap");
        table.add(our_addr,"wrap");
        table.add(ps_id,"wrap");
        table.add(ps_name,"wrap");
        table.add(a_name,"wrap");
        table.add(f_to,"wrap");
        table.add(d_iss,"wrap");
        JOptionPane.showMessageDialog(null,table);

    }


    public void deleteReservation(PreparedStatement psBus, Connection con, ResultSet rsBus,String cell) throws Exception{
        //delete reservation details from database
        String sql = "DELETE FROM reservation WHERE id = "+cell;
        psBus = con.prepareStatement(sql);
        psBus.executeUpdate();
    }

    public void editReservation(PreparedStatement psRes, Connection con)throws Exception{
        //edit reservation details

    }

    public JTable searchReservation(String cell) throws Exception{
        //search reservation details from database
        PreparedStatement psRes = null;
        ResultSet rsRes;
        Connection con = null;
        con = DriverManager.getConnection("jdbc:ucanaccess://oopdatabase1.accdb");
        String sql = "SELECT * from reservation where id = "+cell;
        psRes = con.prepareStatement(sql);
        rsRes = psRes.executeQuery();

        JTable table = new JTable(buildTableModel.BuildTableModel(rsRes));

        table.setFillsViewportHeight(true);
        table.setFont(table.getFont().deriveFont(20.0f));
        table.setRowHeight(60);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 20));

        return table;
    }

    public JTable showReservation(Connection con) throws Exception {
        /*read user data from database */

        PreparedStatement psRes = null;
        ResultSet rsRes;
        String sql = "select * from reservation";
        psRes = con.prepareStatement(sql);
        rsRes = psRes.executeQuery();

        JTable table = new JTable(buildTableModel.BuildTableModel(rsRes));

        table.setFillsViewportHeight(true);
        table.setFont(table.getFont().deriveFont(20.0f));
        table.setRowHeight(60);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 20));

        return table;
    }

/*    public void showTicket(reservation oRes,passenger oPsngr,bus oBus, String date){

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Calendar calobj = Calendar.getInstance();
//        System.out.println(df.format(calobj.getTime()));

        System.out.println("Strada\nAddress : UBIT\nPassenger Name                          : " + oPsngr.getPassengerfirstName() + " " + oPsngr.getPassengerlastName() +
                "\nPassenger ID                          : " + *//*oPsngr.getId()*//* "ship" +
                "\nIssued by                          : Sales department of strada" +
                "\nD.Date                          : " + oBus.getBusTiming() +
                "\nFrom/To                          : " + oRes.departure + " / " + oRes.destination +
                "\nDate issued                          : " + df.format(calobj.getTime()));
    }*/
}