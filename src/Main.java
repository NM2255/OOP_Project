// Importing essential packages

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

// Start screen
class WelcomeScreen extends JFrame {

    //    Get the screen dimensions and then saving it into two variables for height and width.
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screenSize.getWidth();
    private double height = screenSize.getHeight();
    private String uname;
    private String pwd;
    JTextField user_name = new JTextField(20);
    JPasswordField password = new JPasswordField(20);
    JLabel empty2 = new JLabel();
    JLabel empty5 = new JLabel();

    //    The Title of the window
    JTextField newTitle = new JTextField("UBIT Travel and Tours");

    public String getUname() {
        return uname;
    }

    public String getPwd() {
        return pwd;
    }

    //    Constructor
    public WelcomeScreen() {

//        Basic settings of the JFrame.
//        this.setSize((int)width, (int)height);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle(newTitle.getText());

//        Object initialization for handling data
        JLabel jl = new JLabel();
        JLabel j2 = new JLabel("UBIT Travels and Tours");
        JLabel j3 = new JLabel("Enter your Username:");
        JLabel j6 = new JLabel("Enter your Password:");
        JButton b1 = new JButton("Log In");

//        Creating a new JPanel for JSplitPane and it's basic settings.
        JPanel controls = new JPanel(new MigLayout());
        controls.setSize((int)width, (int)height);
        controls.setBackground(Color.GRAY);
        controls.setVisible(true);

//        Icon and it's placement settings.
        jl.setIcon(new ImageIcon("logo.png"));
        controls.add(jl,"al center center,wrap,gapy 20%");
        add(controls);

//        Text below the icon.
        controls.add(j2,"al center center");
        j2.setForeground(Color.BLACK);
        j2.setFont (j2.getFont ().deriveFont (40.0f));

//        Creating a new JPanel for JSplitPane and it's basic settings.
        JPanel logo = new JPanel(new MigLayout("align center center","","30"));
        logo.setSize((int)width, (int)height);
        logo.setBackground(Color.WHITE);
        logo.setVisible(true);

//        Label for username field.
        j3.setFont (j3.getFont ().deriveFont (20.0f));
        logo.add(j3,"al right");

//        User name field visual settings
        user_name.setFont (user_name.getFont ().deriveFont (20.0f));
        logo.add(user_name,"wrap,width 30%!");

        logo.add(empty2,"wrap");

//        Label for password field.
        j6.setFont (j6.getFont ().deriveFont (20.0f));
        logo.add(j6,"al right");

//        Password field visual settings
        password.setFont (password.getFont ().deriveFont (20.0f));
        logo.add(password,"wrap,width 30%!");
        logo.add(empty5,"wrap");

        logo.add(new JLabel());

//        Adding the button to JPanel and tweaking it's visual settings.
        b1.setBackground(Color.WHITE);
        b1.setFont (b1.getFont ().deriveFont (15.0f));
        b1.setBorder(new RoundedBorder(40));
        logo.add(b1,"width "+(int)width/8+"!, height 50!");

//        Creating a split pane two incorporate two JPanels in a single JFrame.
        JSplitPane splitPane = new JSplitPane();
        splitPane.setSize((int)width, (int)height);
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation((int)width/3);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(controls);
        splitPane.setRightComponent(logo);

//        Adding the split pane to JFrame.
        this.add(splitPane);

//        Creating a method for when the button is pressed.
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    registerButtonPressed();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

//        Validating the components.
        validate();
    } // Constructor body ends here.

    //    Function declaration for the button press.
    public void registerButtonPressed() throws SQLException {

        if(user_name.getText().trim().equals("")){
            empty2.setText("Enter your username!");
        }
        else{
            empty2.setText("");
        }
        if(password.getPassword().length == 0){
            empty5.setText("Enter your password!");
        }
        else{
            empty5.setText("");
        }
        if(!user_name.getText().trim().equals("")&&(password.getPassword().length != 0)){

//        Saving user name and password into two static variables.
            variableCredentials.uname = user_name.getText();
            variableCredentials.pword = password.getPassword();

//        Saving user name and password into two local variables.
            uname = variableCredentials.uname;
            pwd = String.valueOf(variableCredentials.pword);

            Connection con = null;
            PreparedStatement psAdmin = null;
            ResultSet rsAdmin = null;
            con = DriverManager.getConnection("jdbc:ucanaccess://e://oopdatabase.accdb");

            admin oAdmin = new admin(uname,pwd);
            oAdmin.searchAdmin(psAdmin,con,rsAdmin,uname,pwd);
            if(oAdmin.searchAdmin(psAdmin,con,rsAdmin,uname,pwd)){
                this.dispose();
                new userMenu();
            }
            else{
                JOptionPane.showMessageDialog(this, "Better luck next time bsdk!");
            }
        }
    }
} // End of the WelcomeScreen Class.
public class Main {

    public static void main(String[] args) {

        new WelcomeScreen();
	// write your code here
    }
}
