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

    public reservation(String departure, String destination, String departureDate, String returnDate, String passengerFirstname, String passengerLastname, String passengerNic, String passengerPhone, String passengerAddr, String busName, String busNumber){
        this.reservationId = reservationId;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengerFirstname= passengerFirstname;
        this.passengerLastname = passengerLastname;
        this.passengerLastname = passengerNic;
        this.passengerPhone = passengerPhone;
        this.passengerAddr = passengerAddr;
        this.busName = busName;
        this.busNumber = busNumber;

    }




    public void addReservation(PreparedStatement psRes, Connection con) throws SQLException {

        //adds reservation details to database
        String in = ("insert into reservation(departure,destination,departureDate,returnDate,passengerFirstname,passengerLastname,passengerNic,passengerPhone,passengerAddr,busName,busNumber)" +
                "values ('" + departure + "','" + destination + "','" + departureDate + "','" + returnDate + "','" + passengerFirstname+ "','" + passengerLastname+ "','" + passengerNic + "','" + passengerPhone + "','" + passengerAddr + "','" + busName + "','" + busNumber + "')");
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

    public void output(PreparedStatement psRes, Connection con, ResultSet rsRes) throws Exception {
        /*read user data from database */

        String sql = "select * from reservation";
        psRes = con.prepareStatement(sql);
        rsRes = psRes.executeQuery();

        while (rsRes.next()) {
            System.out.println("id " + rsRes.getInt(1));
            System.out.println("destination " + rsRes.getString(2));
            System.out.println("departure " + rsRes.getString(3));
            System.out.println("departureDate " + rsRes.getString(4));
            System.out.println("returnDate " + rsRes.getString(5));
            System.out.println("passengerfisrtName " + rsRes.getString(6));
            System.out.println("passengerlastName " + rsRes.getString(7));
            System.out.println("passengerNic " + rsRes.getString(8));
            System.out.println("passengerPhone " + rsRes.getString(9));
            System.out.println("passengerAddr " + rsRes.getString(10));
            System.out.println("busName " + rsRes.getString(11));
            System.out.println("busNumber " + rsRes.getString(12));

        };


    }
}