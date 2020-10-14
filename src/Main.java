

import javax.swing.*;
import java.io.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.Scanner;
import java.text.*;

// Admin/Login class
class admin {
    public int adminId;
    public String adminUsername;
    public String adminPassword;


    //constructor for admin class
    public admin(String adminUsername, String adminPassword) {
        this.adminId = adminId;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    //Method for add admins to database
    public void addAdmin() {

    }

    //Method for searching admins from database
    public boolean searchAdmin(PreparedStatement psAdmin, Connection con, ResultSet rsAdmin, String uname, String pwd, WelcomeScreen ws) throws SQLException {
        boolean aa = false;

        // login method search username & password
        psAdmin = con.prepareStatement("select * from admin where adminUsername = ? and adminPassword = ?");

        // compare both values of username and uname or password & pwd
        psAdmin.setString(1, uname);
        psAdmin.setString(2, String.valueOf(pwd));
        rsAdmin = psAdmin.executeQuery();

        // if rs.next() =  true So condition run other wise run else
        try {
            if (rsAdmin.next()) {
                JOptionPane.showMessageDialog(null, "Login Successfull");
                ws.user_name.setText("");
                ws.password.setText("");

                aa=true;

//                    new WelcomeScreen();

                //=================================================\\
                //====>> shahiq broO your working start from there....
                //=====================================================\\

                ws.dispose();
                new userMenu();

            } else {
                JOptionPane.showMessageDialog(null, "Login Failed please try again");
                aa = false;
            }
        }

        catch(Exception e)

        {
            JOptionPane.showMessageDialog(null, e);
        }
        return aa;

    }





}

// class for bus
class bus {
    public int busId;
    public String busName;
    public String busNumber;
    public String busRoute;
    public String busTiming;



    //constructor for bus class
    public bus(){

    }

    public bus(String busName, String busNumber, String busRoute, String busTiming){
        this.busId = busId;
        this.busName = busName;
        this.busNumber = busNumber;
        this.busRoute = busRoute;
        this.busTiming = busTiming;
    }
    //method for adding bus
    public void addBus(PreparedStatement psBus,Connection con) throws Exception{
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

    public void deleteBus(PreparedStatement psBus, Connection con, ResultSet rsBus) throws Exception {
        //deletes Bus from database
        Scanner dl = new Scanner(System.in);
        System.out.println("enter id of pasenger");
        int Id = dl.nextInt();
        String delete = ("Delete from bus where ID=" + Id);
        psBus = con.prepareStatement(delete);
        psBus.executeUpdate();
        System.out.println("record delete successfully");
    }

    public void editBus(){


    }

    public void searchBus(){


    }

    public void showSchedule(PreparedStatement psBus, Connection con,ResultSet rsBus) throws Exception {
        /*read user data from database */

        String sql = "select * from bus";
        psBus = con.prepareStatement(sql);
        rsBus = psBus.executeQuery();

        while (rsBus.next()) {
            System.out.println("id " + rsBus.getInt(1));
            System.out.println("busName " + rsBus.getString(2));
            System.out.println("busNumber " + rsBus.getString(3));
            System.out.println("busTiming "+rsBus.getString(4));
            System.out.println("busRoute "+rsBus.getString(5));

        };


    }
}

//passenger class
class passenger {
    public int passengerId;
    public String passengerfirstName;
    public String passengerlastName;
    public String passengerPhone;
    public String passengerAddr;
    public String passengerNic;

    //constructor for passenger class
    public passenger(){

    }

    public passenger( int passengerId,String passengerfirstName,String passengerlastName, String passengerPhone, String passengerAddr, String passengerNic){
        this.passengerId = passengerId;
        this.passengerfirstName = passengerfirstName;
        this.passengerlastName = passengerlastName;
        this.passengerPhone = passengerPhone;
        this.passengerAddr = passengerAddr;
        this.passengerNic = passengerNic;

    }

    public String getPassengerfirstName() {
        return passengerfirstName;
    }
    public String getPassengerlastName() {
        return passengerlastName;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public String getPassengerAddr() {
        return passengerAddr;
    }

    public String getPassengerNic() {
        return passengerNic;
    }

    //method for adding passengers
    public void addPassenger(PreparedStatement psPsngr, Connection con) throws Exception {
        String in = ("insert into passenger(passengerfirstName,passengerlastName,passengerPhone,passengerAddr,passengerNic)"+
                "values ('" + passengerfirstName + "','" + passengerlastName + "','" + passengerPhone +"','" + passengerAddr +"','" + passengerNic +"')");
        psPsngr = con.prepareStatement(in);
        psPsngr.executeUpdate();
    }

    public void deletePassenger(PreparedStatement psPsngr,Connection con,ResultSet rsPsngr) throws Exception{
        //deletes passenger from database
            Scanner dl=new Scanner(System.in);
            System.out.println("enter id of pasenger");
            int Id=dl.nextInt();
            String delete = ("Delete from passenger where ID="+Id);
            psPsngr=con.prepareStatement(delete);
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
            System.out.println("passengerfirstName " + rsPsngr.getString(2));
            System.out.println("passengerlastName " + rsPsngr.getString(3));
            System.out.println("passengerPhone " + rsPsngr.getString(4));
            System.out.println("passengerAddr " + rsPsngr.getString(5));
            System.out.println("passengerNic " + rsPsngr.getString(6));

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

    public void output(PreparedStatement psRes, Connection con,ResultSet rsRes) throws Exception {
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




public class Main {

    public static void main(String[] args) throws Exception {



        /*declare variables for database conection */
        Connection con = null;
        PreparedStatement psPsngr = null;
        PreparedStatement psRes = null;
        PreparedStatement psAdmin = null;
        PreparedStatement psBus=null;
        ResultSet rsPsngr = null;
        ResultSet rsAdmin = null;
        ResultSet rsBus =null;
        ResultSet rsRes = null;
        /*establishing connertion with data base */
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con = DriverManager.getConnection("jdbc:ucanaccess://e://oopdatabase.accdb");

        //scanner for input
        Scanner ip = new Scanner(System.in);


        /*String adminUsername;
        String adminPassword;

        System.out.println("Enter username");
        adminUsername = ip.next();

        System.out.println("Enter Password");
        adminPassword= ip.next();

        admin oAdmin = new admin(adminUsername, adminPassword);



        boolean exit = false;
        
        //loop for inputs for adding buses and customers
        while (oAdmin.searchAdmin(psAdmin,con,rsAdmin,adminUsername,adminPassword)) {

            System.out.println("**************************************************************************" +
                    "\nPress 1 for Adding bus \nPress 2 to Show bus Schedule " +
                    "\nPress 3 for Adding Passenger \nPress 4 to Show Passengers" +
                    "\nPress 5 to add Reservation \nPress 6 to search bus" +
                    "\nPress 7 to delete pesenger \n Press 8 to delete Reservation " +
                    "\n Press 9 to edit pesenger \nPress 10 to login \nPress 11 to show reservation \nPress 0 to Exit");
            int selectioninput = ip.nextInt();

            //Press 1 for Adding bus
            if (selectioninput == 1) {
                int busId;
                String busName;
                String busNumber;
                String busRoute;
                String busTiming;

                System.out.println("Enter bus Name");
                busName = ip.next();

                System.out.println("Enter bus Number");
                busNumber = ip.next();

                System.out.println("Enter bus Route");
                busRoute = ip.next();

                System.out.println("Enter bus Timing");
                busTiming = ip.next();

                bus oBus = new bus(busName, busNumber, busRoute, busTiming);
                oBus.addBus(psBus,con);

            }

            //Press 2 to Show bus Schedule
            else if (selectioninput == 2){
                bus oBus = new bus();

                oBus.showSchedule(psBus,con,rsBus);
            }

            //Press 3 for Adding Passenger
            else if (selectioninput == 3) {
                int passengerId=0;
                String passengerfirstName;
                String passengerlastName;
                String passengerPhone;
                String passengerAddr;
                String passengerNic;

                System.out.println("Enter Passenger firstName");
                passengerfirstName = ip.next();

                System.out.println("Enter Passenger lastName");
                passengerlastName = ip.next();

                System.out.println("Enter Passenger Nic");
                passengerNic = ip.next();

                System.out.println("Enter Passenger Phone");
                passengerPhone = ip.next();

                System.out.println("Enter Passenger Address");
                passengerAddr = ip.next();

                passenger oPsngr = new passenger(passengerId,passengerfirstName,passengerlastName, passengerPhone, passengerAddr, passengerNic);
                oPsngr.addPassenger(psPsngr, con);
            }

            //Press 4 to Show Passengers
            else if (selectioninput == 4){


                passenger oPsngr = new passenger();

                oPsngr.output(psPsngr,con,rsPsngr);
            }

            //Press 5 to add Reservation
            else if(selectioninput == 5){
                bus oBus = new bus();
                passenger oPsngr = new passenger();
                String departure;
                String destination;
                String departureDate = "";
                String returnDate = "";
                String busName;
                String busNumber;
                String passengerName;
                int passengerPhone;
                String passengerAddr;
                int passengerNic;

                System.out.println("Enter Passenger Name");
                passengerName = ip.next();

                System.out.println("Enter Passenger NIC#");
                passengerNic = ip.nextInt();

                System.out.println("Enter Passenger Phone");
                passengerPhone = ip.nextInt();

                System.out.println("Enter PassengerAddr");
                passengerAddr = ip.next();

                System.out.println("Enter Departure");
                departure = ip.next();

                System.out.println("Enter Destination");
                destination = ip.next();

                System.out.println("Enter Departure Date");
                departureDate = ip.next();

                System.out.println("Enter Return Date");
                returnDate  = ip.next();

                System.out.println("Enter Bus Name");
                busName = ip.next();

                System.out.println("Enter Bus Number");
                busNumber= ip.next();

                reservation res = new reservation(departure,destination,departureDate,returnDate,passengerName, passengerNic,passengerPhone,passengerAddr,busName,busNumber);
                res.addReservation(psRes,con, oPsngr, oBus);
            }


            //Press 6 to search bus
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

                reservation res = new reservation();
                res.deleteReservation(psRes,con);
            }


            //Press 9 to edit pesenger
            else if(selectioninput==9){
                passenger psngr=new passenger();
                psngr.editPassenger(psPsngr,con,rsPsngr);

            }

            else if (selectioninput == 11){
                reservation oRes = new reservation();

                oRes.output(psRes,con,rsRes);
            }



            else if (selectioninput == 0) {
                break;

            }


        }*/

        new WelcomeScreen();
    }
}

