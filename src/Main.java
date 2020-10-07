import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

class bus {
    public int busId;
    public String busName;
    public int busNumber;

    public void addBus(){

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

    public void addCustomer(){

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
        File file = new File("/home/ammar/Documents/OOP_Project");
        FileWriter write = new FileWriter(file);

        System.out.println("Press 1 for Adding bus \nPress 2 for Adding customer \nPress 0 to Exit");
        Scanner ip = new Scanner(System.in);
        
    }
}
