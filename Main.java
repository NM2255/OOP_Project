package com.company;
import java.sql.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {

        /*declare variables for database conection */
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*establishing connertion with data base */
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con = DriverManager.getConnection("jdbc:ucanaccess://e://oopdatabase.accdb");
        Scanner obj = new Scanner(System.in);


        /*read user data from database */




        /*write user data from database */

            /* write database in user";*/
            System.out.println("name: ");
            String name = obj.next();
            System.out.println(" fathername: ");
            String father = obj.next();
            System.out.println("nic no: ");
            int nic = obj.nextInt();
            System.out.println("name ticketno: ");
            String ticketNo = obj.next();

            String in = "insert into user (name1,fathername,nic,ticketno)" +
                    "values ('" + name + "','" + father +"','" + nic + "','" + ticketNo + "')";
            ps = con.prepareStatement(in);
            ps.executeUpdate();


                  /* read database
       String sql="select * from admin";*/
        String sql = "select * from user";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println("id " + rs.getInt(1));
            System.out.println("Name1 " + rs.getString(2));
            System.out.println("fathername " + rs.getString(3));
            System.out.println("id " + rs.getInt(4));
            System.out.println("ticketno " + rs.getString(5));
        }



        /*read admin data from database
        public void readAdmindata(){
            /* read database
            String sql = "select * from admin";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("id " + rs.getInt(1));
                System.out.println("Name1 " + rs.getString(2));
                System.out.println("pass " + rs.getInt(3));
            }

        }
        /*write admin data from database
        public void writeAdmindata() {
            /* write database in admin";
            System.out.println("name: ");
            String name = obj.nextLine();
            System.out.println("password: ");
            int pass = obj.nextInt();
            String in = "insert into user (name1,pass)" + "values ('" + name + "','" + pass + "')";
            ps = con.prepareStatement(in);
            ps.executeUpdate();

        }*/


    }
}
