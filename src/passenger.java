import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

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

    public passenger(String passengerfirstName,String passengerlastName,String passengerNic, String passengerPhone, String passengerAddr ){
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

    public void deletePassenger(PreparedStatement psPsngr, Connection con, ResultSet rsPsngr) throws Exception{
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