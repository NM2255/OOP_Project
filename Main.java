package com.company;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        con=DriverManager.getConnection("jdbc:ucanaccess://e://oopdatabase.accdb");

        String sql="select * from admin";
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            System.out.print("id"+rs.getInt(1)+"/n");
            System.out.print("name"+rs.getString(2)+"/n");
            System.out.print("pasword"+rs.getInt(3)+"/n");


        }
    }
}
