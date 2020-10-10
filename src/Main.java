
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.Scanner;

// Admin/Login class
class admin{
    public int adminId;
    public String adminUsername;
    public String adminPassword;

    public ArrayList<admin> admins = new ArrayList<admin>();
    //constructor for admin class
    public admin(int adminId, String adminUsername, String adminPassword){
        this.adminId = adminId;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }
    //Method for add admins to database
    public void addAdmin(admin oAdmin){
        admins.add(oAdmin);
    }
    //Method for searching admins from database
    public boolean searchAdmin(){
        boolean exit = true;
        boolean found = admins.contains(adminUsername);
        if(found == true){
            exit = false;
        }

        else{
            exit = true;
        }
        return exit;
    }


}

// class for bus
class bus {
    public int busId;
    public String busName;
    public String busNumber;


    //constructor for bus class
    public bus(String busName, String busNumber){
        this.busId = busId;
        this.busName = busName;
        this.busNumber = busNumber;
    }
    //method for adding bus
    public void addBus(PreparedStatement psBus,Connection con) throws Exception{
        String in = ("insert into bus(busName,busNumber)"+
                "values ('" + busName + "','" + busNumber +"')");
        psBus = con.prepareStatement(in);
        psBus.executeUpdate();
    }

    public void deleteBus(){

    }

    public void editBus(){
        /* write database in user"; */


    }

    public void searchBus(){

    }

    public void output(PreparedStatement psBus, Connection con,ResultSet rsBus) throws Exception {
        /*read user data from database */

        String sql = "select * from bus";
        psBus = con.prepareStatement(sql);
        rsBus = psBus.executeQuery();

        while (rsBus.next()) {
            System.out.println("id " + rsBus.getInt(1));
            System.out.println("busName " + rsBus.getString(2));
            System.out.println("busNumber " + rsBus.getString(3));

        };


    }
}

//passenger class
class passenger {
    public int passengerId;
    public String passengerName;
    public int passengerPhone;
    public String passengerAddr;

    //constructor for passenger class
    public passenger( String passengerName, int passengerPhone, String passengerAddr){
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerPhone = passengerPhone;
        this.passengerAddr = passengerAddr;
    }
    //method for adding passengers
    public void addPassenger(PreparedStatement psPsngr, Connection con) throws Exception {
        String in = ("insert into passenger(passengerName,passengerPhone,passengerAddr)"+
                "values ('" + passengerName + "','" + passengerPhone +"','" + passengerAddr +"')");
        psPsngr = con.prepareStatement(in);
        psPsngr.executeUpdate();
    }

    public void deletePassenger(){
        //deletes passenger from database

    }

    public void editPassenger(){
        //edits passenger from database
        /* write database in user"; */


    }

    public void searchPassenger(){
        //searches passenger from database

    }

    public void output(PreparedStatement psPsngr, Connection con,ResultSet rsPsngr) throws Exception {
        /*read user data from database */

        String sql = "select * from passenger";
        psPsngr = con.prepareStatement(sql);
        rsPsngr = psPsngr.executeQuery();

        while (rsPsngr.next()) {
            System.out.println("id " + rsPsngr.getInt(1));
            System.out.println("passengerName " + rsPsngr.getString(2));
            System.out.println("passengerPhone " + rsPsngr.getInt(3));
            System.out.println("passengerAddr " + rsPsngr.getString(4));

        };


    }

}

//class for reservation
class reservation {
    public int reservationId;
    public String departure;
    public String destination;
    public Date departureDate;
    public Date returnDate;

    //constructor for reservation class
    public reservation(int reservationId, String departure, String destination, Date departureDate, Date returnDate){
        this.reservationId = reservationId;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }


    public void addReservation(){
        //adds reservation details to database

    }

    public void deleteReservation(){
        //delete reservation details from database


    }

    public void editReservation(){
        //edit reservation details
        /* write database in user"; */


    }

    public void searchReservation(){
        //search reservation details from database

    }

}

public class Main {

    public static void main(String[] args) throws Exception {



        /*declare variables for database conection */
        Connection con = null;
        PreparedStatement psPsngr = null;

        ResultSet rsPsngr = null;
        PreparedStatement psBus=null;
        ResultSet rsBus =null;
        /*establishing connertion with data base */
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con = DriverManager.getConnection("jdbc:ucanaccess://e://oopdatabase.accdb");
        //Scanner obj = new Scanner(System.in);



      /*  while (rs.next()) {
            System.out.println("id " + rs.getInt(1));
            System.out.println("Name1 " + rs.getString(2));
            System.out.println("fathername " + rs.getString(3));
            System.out.println("id " + rs.getInt(4));
            System.out.println("ticketno " + rs.getString(5));
        }
*/

        //initializing files


        //Print writer for writing files


        //scanner for input
        Scanner ip = new Scanner(System.in);

        //inputs for logins
        /*int adminId;
        String adminUsername;
        String adminPassword;

        System.out.println("Enter Id");
        adminId = ip.nextInt();

        System.out.println("Enter username");
        adminUsername = ip.next();

        System.out.println("Enter Pass");
        adminPassword = ip.next();

        admin oAdmin = new admin(adminId, adminUsername,adminPassword);

        oAdmin.addAdmin(oAdmin);

        boolean exit = oAdmin.searchAdmin();*/

        boolean exit = false;

        //loop for inputs for adding buses and customers
        while (exit == false) {

            System.out.println("Press 1 for Adding bus \nPress 2 to Show bus  \nPress 3 for Adding Passenger \nPress 4 to Show Passengers \nPress 0 to Exit");
            int selectioninput = ip.nextInt();

            if (selectioninput == 1) {
                int busId;
                String busName;
                String busNumber;



                System.out.println("Enter bus Name");
                busName = ip.next();

                System.out.println("Enter bus Number");
                busNumber = ip.next();

                bus oBus = new bus(busName, busNumber);

                oBus.addBus(psBus,con);




            }

            else if (selectioninput == 2){
                String busName = null;
                String busNumber = null;
                bus oBus = new bus(busName, busNumber);

                oBus.output(psBus,con,rsBus);
            }

            else if (selectioninput == 3) {
                int passengerId;
                String passengerName;
                int passengerPhone;
                String passengerAddr;

                /*System.out.println("Enter Customer Id");


                passengerId = ip.nextInt(); */

                System.out.println("Enter Customer Name");
                passengerName = ip.next();

                System.out.println("Enter Customer Phone");
                passengerPhone = ip.nextInt();

                System.out.println("Enter Customer Address");
                passengerAddr = ip.next();

                passenger oPsngr = new passenger(passengerName, passengerPhone, passengerAddr);

                oPsngr.addPassenger(psPsngr, con);


            }

            else if (selectioninput == 4){
                String passengerName = null;
                int passengerPhone = 0;
                String passengerAddr = null;
                passenger oPsngr = new passenger(passengerName,passengerPhone,passengerAddr);

                oPsngr.output(psPsngr,con,rsPsngr);
            }

            else if (selectioninput == 0) {
                exit = true;
            }


        }
    }
}