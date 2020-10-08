import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
    public int busNumber;


    //constructor for bus class
    public bus(int busId,String busName, int busNumber){
        this.busId = busId;
        this.busName = busName;
        this.busNumber = busNumber;
    }
    //method for adding bus
    public void addBus(PrintWriter write){
        write.print("Bus Id: " + busId + " Bus Name: " + busName + " Bus Number: "+ busNumber);
    }

    public void deleteBus(){

    }

    public void editBus(){

    }

    public void searchBus(){

    }

}

//passenger class
class passenger {
    public int passengerId;
    public String passengerName;
    public int passengerPhone;
    public String passengerAddr;

    //constructor for passenger class
    public passenger(int passengerId, String passengerName, int passengerPhone, String passengerAddr){
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerPhone = passengerPhone;
        this.passengerAddr = passengerAddr;
    }
    //method for adding passengers
    public void addPassenger(PrintWriter write1){
        write1.print("Passenger Id: " + passengerId + " Customer Name: " + passengerName + " Customer Phone: "+ passengerPhone + " Customer Address: " + passengerAddr);
    }

    public void deletePassenger(){
        //deletes passenger from database

    }

    public void editPassenger(){
        //edits passenger from database

    }

    public void searchPassenger(){
        //searches passenger from database

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

    }

    public void searchReservation(){
        //search reservation details from database

    }

}

public class Main {

    public static void main(String[] args) throws IOException {

        //initializing files
        File file = new File("/home/ammar/Documents/OOP_Project/testbus.txt");
        File file1 = new File("/home/ammar/Documents/OOP_Project/testcust.txt");

        //Print writer for writing files
        PrintWriter write = new PrintWriter(file);
        PrintWriter write1 = new PrintWriter(file1);

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

            System.out.println("Press 1 for Adding bus \nPress 2 for Adding customer \nPress 0 to Exit");
            int selectioninput = ip.nextInt();

            if (selectioninput == 1) {
                int busId;
                String busName;
                int busNumber;

                System.out.println("Enter bus Id");
                busId = ip.nextInt();

                System.out.println("Enter bus Name");
                busName = ip.next();

                System.out.println("Enter bus Number");
                busNumber = ip.nextInt();

                bus oBus = new bus(busId, busName, busNumber);

                oBus.addBus(write);

                write.close();
            }

            else if (selectioninput == 2) {
                int passengerId;
                String passengerName;
                int passengerPhone;
                String passengerAddr;

                System.out.println("Enter Customer Id");
                passengerId = ip.nextInt();

                System.out.println("Enter Customer Name");
                passengerName = ip.next();

                System.out.println("Enter Customer Phone");
                passengerPhone = ip.nextInt();

                System.out.println("Enter Customer Address");
                passengerAddr = ip.next();

                passenger oPsngr = new passenger(passengerId, passengerName, passengerPhone, passengerAddr);

                oPsngr.addPassenger(write1);

                write1.close();
            }

            else if (selectioninput == 0) {
                exit = true;
            }


        }
    }
}
