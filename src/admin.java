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