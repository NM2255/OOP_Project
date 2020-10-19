import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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




    public void addReservation(PreparedStatement psRes, Connection con,passenger oPsngr) throws SQLException {

        //adds reservation details to database
        String in = ("insert into reservation(departure,destination,departureDate,returnDate,passengerFirstname,passengerLastname,passengerNic,passengerPhone,passengerAddr,busName,busNumber)" +
                "values ('" + departure + "','" + destination + "','" + departureDate + "','" + returnDate + "','" + oPsngr.getPassengerfirstName()+ "','" + oPsngr.getPassengerlastName()+ "','" + oPsngr.getPassengerNic() + "','" + oPsngr.getPassengerPhone() + "','" + oPsngr.getPassengerAddr() + "','" + busName + "','" + busNumber + "')");
        psRes = con.prepareStatement(in);
        psRes.executeUpdate();
    }


    public void deleteReservation(PreparedStatement psRes, Connection con)throws Exception{
        //delete reservation details from database
        Scanner dl=new Scanner(System.in);
        System.out.println("enter id of pasenger reservation");
        int Id=dl.nextInt();
        String dlete = ("Delete from reservation where ID="+Id);
        psRes=con.prepareStatement(dlete);
        psRes.executeUpdate();
        System.out.println("record delete successfully");


    }

    public void editReservation(PreparedStatement psRes, Connection con)throws Exception{
        //edit reservation details

    }




    public void searchReservation()throws Exception{
        //search reservation details from database

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
}