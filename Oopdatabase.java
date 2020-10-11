
package oopdatabase;
import java.sql.*;
import java.util.Scanner;

public class Oopdatabase {

    public static void main(String[] args) throws Exception  {
        
        Connection con=null;
        PreparedStatement ps=null;
        Statement stmt =null;
        ResultSet rs=null;

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con = DriverManager.getConnection("jdbc:ucanaccess://oopdatabase.accdb");

        Scanner obj = new Scanner(System.in);
        
        System.out.println("Enter 1 for Admin && Enter 2 for User");
        int input = obj.nextInt();
        
        //===================\\
        //====>> Admin <<<==== 
        //===================\\
        
        if (input == 1){
            
        //====>> read Admin data <<====\\
       
        String sql="select * from admin";
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        
        System.out.println("Enter 1 for Show && Enter 2 for Add && Enter 3 for Delete && Enter 4 for Edit");
        int usinput = obj.nextInt();
        
        if(usinput == 1){
            
        while (rs.next()){
            System.out.print("id : "+rs.getInt(1)+"\t");
            System.out.print("name : "+rs.getString(2)+"\t");
            System.out.print("pasword : "+rs.getString(3)+"\n");
        }
    }
        
        
        // =====>> write admin data <<====\\
        
    else if (usinput == 2){
            
        System.out.println("name: ");
        String name = obj.nextLine();
        System.out.println("password: ");
        int pass = obj.nextInt();
        String add = "insert into user (name1,pass)" + "values ('" + name + "','" + pass + "')";
        ps = con.prepareStatement(add);
        ps.executeUpdate();
    }
        
            
         //====>> For Delete admin data <<====\\
        
    else if(usinput ==3){
            
        int id;
       
        con = DriverManager.getConnection("jdbc:ucanaccess://oopdatabase.accdb");
        ps = con.prepareStatement("Delete from Admin where id = ?");
        System.out.println("Enter id of delete record");
        id = obj.nextInt();
        ps.setInt(1, id);
        int r = ps.executeUpdate();
        if(r == 1){
            System.out.println("record delete successfully");
        }
    }
        
        //=====>> for Edit admin data <<=====\\
        
    else{
        
         int id;
        String name, pasword;
        
        con = DriverManager.getConnection("jdbc:ucanaccess://oopdatabase.accdb");
        ps = con.prepareStatement("update Admin set name = ?, pasword = ? where ID = ?");
        System.out.println("Enter the new name");
        name = obj.next();
        System.out.println("Enter the new pasword");
        pasword = obj.next();
        System.out.println("Enter the id to update the Record");
        id = obj.nextInt();
        ps.setString(1, name);
        ps.setString(2, pasword);
        ps.setInt(3, id); 
        int s = ps.executeUpdate();
        if(s > 0){
            System.out.println("record Update successfully");
        }
    }
         
}
         
        //===================\\
        //====>> USER <<<==== 
        //===================\\
        
    else{
        String sql = "select * from user";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        System.out.println("Enter 1 for show && Enter 2 for add && Enter 3 for Delete && Enter 4 for Edit");
        int userinput = obj.nextInt();
        
        // Read user data
        
    if (userinput == 2){
        while (rs.next()) {
            System.out.println("id"+rs.getInt(1)+"\t");
            System.out.println("Name1"+rs.getString(2)+"\t");
            System.out.println("fathername"+rs.getString(3)+"\t");
            System.out.println("id"+rs.getInt(4)+"\t");
            System.out.println("ticketno"+rs.getString(5)+"\n");
        }
    }
        
            //===>> Write user data <<====\\
                
    else if(userinput == 2){
        System.out.println("name: ");
        String name = obj.next();
        System.out.println(" fathername: ");
        String father = obj.next();
        System.out.println("nic no: ");
        int nic = obj.nextInt();
        System.out.println("name ticketno: ");
        String ticketNo = obj.next();

        String add = "insert into user (name1,fathername,nic,ticketno)" +
        "values ('" + name + "','" + father +"','" + nic + "','" + ticketNo + "')";
        ps = con.prepareStatement(add);
        ps.executeUpdate();
    }
        
        //===>> For Delete user data <<=====
        
    else if(userinput ==3){
            
        int id;
       
        con = DriverManager.getConnection("jdbc:ucanaccess://oopdatabase.accdb");
        ps = con.prepareStatement("Delete from user where id = ?");
        System.out.println("Enter id of delete record");
        id = obj.nextInt();
        ps.setInt(1, id);
        int q = ps.executeUpdate();
        if(q == 1){
            System.out.println("record delete successfully");
        }
    }
                
         //======>> For Edit user data <<=====\\
                
    else{
        
         int id, nic;
        String name, fatherName, tickno;
        
        con = DriverManager.getConnection("jdbc:ucanaccess://oopdatabase.accdb");
        ps = con.prepareStatement("update user set name1 = ?, fathername = ?, nic = ?, ticketno = ? where ID = ?");
        System.out.println("Enter the new name");
        name = obj.next();
        System.out.println("Enter the new Father name");
        fatherName = obj.next();
        System.out.println("Enter a new NIC");
        nic = obj.nextInt();
        System.out.println("Enter a Ticket no");
        tickno = obj.next();
        System.out.println("Enter the id to update the Record");
        id = obj.nextInt();
        ps.setString(1, name);
        ps.setString(2, fatherName);
        ps.setInt(3, nic);
        ps.setString(4, tickno);
        ps.setInt(5, id); 
        int s = ps.executeUpdate();
        if(s > 0){
            System.out.println("record Update successfully");
        }
      }
    }
        
    }
}
