import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

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
    public void addBus(PreparedStatement psBus, Connection con) throws Exception{
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