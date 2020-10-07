import java.io.*;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

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
	// write your code here
        File file = new File("/home/ammar/Documents/OOP_Project/testbus.txt");
        File file1 = new File("/home/ammar/Documents/OOP_Project/testcust.txt");
        PrintWriter write = new PrintWriter(file);
        PrintWriter write1 = new PrintWriter(file1);

        boolean exit = false;
        while (exit == false) {

            System.out.println("Press 1 for Adding bus \nPress 2 for Adding customer \nPress 0 to Exit");
            Scanner ip = new Scanner(System.in);
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
