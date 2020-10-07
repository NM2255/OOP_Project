import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


class admin{
    public int adminId;
    public String adminUsername;
    public String adminPassword;

    public ArrayList<admin> admins = new ArrayList<admin>();

    public admin(int adminId, String adminUsername, String adminPassword){
        this.adminId = adminId;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    public void addAdmin(admin oAdmin){
        admins.add(oAdmin);
    }

    public void searchAdmin(){
        boolean found = admins.contains(adminUsername + adminPassword);
        if(found == true){
            boolean exit = false;
        }
    }


}

class bus {
    public int busId;
    public String busName;
    public int busNumber;


    public bus(int busId,String busName, int busNumber){
        this.busId = busId;
        this.busName = busName;
        this.busNumber = busNumber;
    }

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

class customer {
    public int customerId;
    public String customerName;
    public int customerPhone;
    public String customerAddr;

    public customer(int customerId, String customerName, int customerPhone, String customerAddr){
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddr = customerAddr;
    }

    public void addCustomer(PrintWriter write1){
        write1.print("Customer Id: " + customerId + " Customer Name: " + customerName + " Customer Phone: "+ customerPhone + " Customer Address: " + customerAddr);
    }

    public void deleteCustomer(){

    }

    public void editCustomer(){

    }

    public void searchCustomer(){

    }

}

class booking {
    public int bookingId;
    public String bookingTitle;
    public Date bookingDate;
    public String bookingDesc;

    public void addBooking(){

    }

    public void deleteBooking(){

    }

    public void editBooking(){

    }

    public void searchBooking(){

    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("/home/ammar/Documents/OOP_Project/testbus.txt");
        File file1 = new File("/home/ammar/Documents/OOP_Project/testcust.txt");
        PrintWriter write = new PrintWriter(file);
        PrintWriter write1 = new PrintWriter(file1);

        Scanner ip = new Scanner(System.in);

        int adminId;
        String adminUsername;
        String adminPassword;

        System.out.println("Enter Id");
        adminId = ip.nextInt();

        System.out.println("Enter username");
        adminUsername = ip.next();

        System.out.println("Enter Pass");
        adminPassword = ip.next();

        admin oAdmin = new admin(adminId, adminUsername,adminPassword);

        boolean exit = false;

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
            } else if (selectioninput == 2) {
                int customerId;
                String customerName;
                int customerPhone;
                String customerAddr;

                System.out.println("Enter Customer Id");
                customerId = ip.nextInt();

                System.out.println("Enter Customer Name");
                customerName = ip.next();

                System.out.println("Enter Customer Phone");
                customerPhone = ip.nextInt();

                System.out.println("Enter Customer Address");
                customerAddr = ip.next();

                customer oCust = new customer(customerId, customerName, customerPhone, customerAddr);

                oCust.addCustomer(write1);

                write1.close();
            }

            else if (selectioninput == 0) {
                exit = true;
            }


        }
    }
}
