import org.apache.commons.lang3.ObjectUtils;

import java.io.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.Scanner;
import java.text.*;

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
    public bus(){

    }

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
    public passenger(){

    }

    public passenger( int passengerId,String passengerName, int passengerPhone, String passengerAddr){
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

    public void deletePassenger(PreparedStatement psPsngr,Connection con,ResultSet rsPsngr) throws Exception{
        //deletes passenger from database
            Scanner dl=new Scanner(System.in);
            System.out.println("enter id of pasenger");
            passengerId=dl.nextInt();
            String dlete = ("Delete from passenger where ID="+passengerId);
            psPsngr=con.prepareStatement(dlete);
            psPsngr.executeUpdate();
            System.out.println("record delete successfully");


    }

    public void editPassenger(PreparedStatement psPsngr, Connection con,ResultSet rsPsngr) throws Exception{
        //edits passenger from database
        int id, psngrphone;
        String psngrname, psngradress;

        Scanner dl=new Scanner(System.in);
        System.out.println("Enter the new passengername");
        psngrname = dl.next();
        System.out.println("Enter a phone no");
        psngrphone = dl.nextInt();
        System.out.println("Enter a adress no");
        psngradress = dl.next();
        System.out.println("Enter the id to update the Record");
        id = dl.nextInt();
        String dlete=("update passenger set  passengerName= ?, passengerPhone= ?, passengerAddr = ? where ID = ?");
        psPsngr = con.prepareStatement(dlete);
        psPsngr.setString(1, psngrname);
        psPsngr.setInt(2, psngrphone);
        psPsngr.setString(3, psngradress);
        psPsngr.setInt(4, id);
        psPsngr.executeUpdate();
        System.out.println("record Update successfully");
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
    public String departureDate;
    public String returnDate;

    //constructor for reservation class
    public reservation(String departure, String destination, String departureDate, String returnDate){
        this.reservationId = reservationId;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }




    public void addReservation(PreparedStatement psRes, Connection con,passenger oPsngr, bus oBus) throws SQLException {
        String busNAme = oBus.busName;
        String busNumber = oBus.busNumber;
        String passengerName = oPsngr.passengerName;
        int passengerPhone = oPsngr.passengerPhone;
        String passengerAddr = oPsngr.passengerAddr;
        //adds reservation details to database
        String in = ("insert into reservation(departure,destination,departureDate,returnDate,busName,busNumber,passengerName,passengerPhone,passengerAddr)" +
                "values ('" + departure + "','" + destination + "','" + departureDate + "','" + returnDate + "','" + busNAme + "','" + busNumber + "','" + passengerName + "','" + passengerPhone + "','" + passengerAddr + "')");
        psRes = con.prepareStatement(in);
        psRes.executeUpdate();
    }


        public void deleteReservation(PreparedStatement psRes, Connection con)throws Exception{
        //delete reservation details from database
            Scanner dl=new Scanner(System.in);
            System.out.println("enter id of pasenger reservation");
            reservationId=dl.nextInt();
            String dlete = ("Delete from reservation where ID="+reservationId);
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
}


//class for schedule
class Schedule{

    public int scheduleId;
    public String towhere;
    public String from;

    public void searchSchedule()throws Exception{
        //search reservation details from database

    }
    public void editSchedule()throws Exception{
        //search reservation details from database

    }
    public void dleteScedule()throws Exception{
        //search reservation details from database

    }
    public void addScedule()throws Exception{
        //search reservation details from database

    }



}

public class Main {

    public static void main(String[] args) throws Exception {



        /*declare variables for database conection */
        Connection con = null;
        PreparedStatement psPsngr = null;
        PreparedStatement psRes = null;
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

            System.out.println("Press 1 for Adding bus \nPress 2 to Show bus \nPress 5 to search bus  \nPress 3 for Adding Passenger" +
                                 " \nPress 4 to Show Passengers \nPress 6 to add Reservation" +
                                 " \nPress 7 to deletepesenger \n Press 8 to deletepesengerReservation " +
                                 "\n Press 9 to edit pesenger data \nPress 0 to Exit");
            int selectioninput = ip.nextInt();

            //Press 1 for Adding bus
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

            //Press 2 to Show bus
            else if (selectioninput == 2){
                String busName = null;
                String busNumber = null;
                bus oBus = new bus(busName, busNumber);

                oBus.output(psBus,con,rsBus);
            }

            //Press 3 for Adding Passenger
            else if (selectioninput == 3) {
                int passengerId=0;
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

                passenger oPsngr = new passenger(passengerId,passengerName, passengerPhone, passengerAddr);
                oPsngr.addPassenger(psPsngr, con);
            }

            //Press 4 to Show Passengers
            else if (selectioninput == 4){
                int passengerId=0;
                String passengerName = null;
                int passengerPhone = 0;
                String passengerAddr = null;
                passenger oPsngr = new passenger(passengerId,passengerName,passengerPhone,passengerAddr);

                oPsngr.output(psPsngr,con,rsPsngr);
            }

            //Press 5 to search bus
            else if(selectioninput == 5){
                bus oBus = new bus();
                passenger oPsngr = new passenger();
                String departure;
                String destination;
                String departureDate = "";
                String returnDate = "";
                /*String busName = oBus.getBusName();
                String busNumber = oBus.getBusNumber();
                String passengerName = oPsngr.getPassengerName();
                int passengerPhone = oPsngr.getPassengerPhone();
                String passengerAddr = oPsngr.getPassengerAddr();*/



                System.out.println("Enter Departure");
                departure = ip.next();

                System.out.println("Enter Destination");
                destination = ip.next();

                System.out.println("Enter Departure Date");
                departureDate = ip.next();

                System.out.println("Enter Return Date");
                returnDate  = ip.next();

                reservation res = new reservation(departure,destination,departureDate,returnDate);
                res.addReservation(psRes,con, oPsngr, oBus);
            }


            //Press 6 to add Reservation
            else if (selectioninput == 6) {
                String dest;
            }


            //Press 7 to deletepesenger
            else if(selectioninput==7){
                passenger psngr=new passenger();
                psngr.deletePassenger(psPsngr,con,rsPsngr);

            }

            //Press 8 to deletepesengerReservation
            else if(selectioninput==8){
                String destination=null;
                String departureDate=null;
                String returnDate=null;
                String departure=null;

                reservation res = new reservation(departure,destination,departureDate,returnDate);
                res.deleteReservation(psRes,con);
            }


            //Press 9 to edit pesenger data
            else if(selectioninput==9){
                passenger psngr=new passenger();
                psngr.editPassenger(psPsngr,con,rsPsngr);

            }

            else if (selectioninput == 0) {
                exit = true;
            }


        }
    }
}

