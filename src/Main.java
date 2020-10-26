// Importing essential packages

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

// Start screen
class WelcomeScreen extends JFrame {

    //    Get the screen dimensions and then saving it into two variables for height and width.
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screenSize.getWidth();
    private double height = screenSize.getHeight();
    private String uname;
    private String pwd;
    JTextField user_name = new JTextField("Name",20);
    JPasswordField password = new JPasswordField("Password",20);
    JLabel empty2 = new JLabel();
    JLabel empty5 = new JLabel();

    //    The Title of the window
    JTextField newTitle = new JTextField("WELCOME TO STRADA");

    public String getUname() {
        return uname;
    }

    public String getPwd() {
        return pwd;
    }

    //    Constructor
    public WelcomeScreen() {

//        Basic settings of the JFrame.
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle(newTitle.getText());

//        Object initialization for handling data
        JLabel j2 = new JLabel("WELCOME TO STRADA");
        JLabel j1 = new JLabel("Log In");
        JButton b1 = new JButton("Log In");

//        Creating a new JPanel for JSplitPane and it's basic settings.
        JPanel controls = new JPanelGradient(new MigLayout("align center center"));
        controls.setSize((int)width, (int)height);
        controls.setVisible(true);

//        Text below the icon.
        controls.add(j2);
        Color blue = new Color(0, 86, 122);
        j2.setForeground(blue);
        j2.setFont(new Font("SansSerif", Font.PLAIN, 55));

//        Creating a new JPanel for JSplitPane and it's basic settings.
        JPanel logo = new JPanel(new MigLayout("align center center","","30"));
        logo.setBackground(blue);
        logo.setSize((int)width, (int)height);
        logo.setVisible(true);

        j1.setFont(new Font("SansSerif", Font.PLAIN, 50));
        j1.setHorizontalAlignment(JTextField.CENTER);
        j1.setForeground(Color.WHITE);
        logo.add(j1,"wrap,width 30%!,gapbottom 7%!");

//        User name field visual settings
        user_name.setFont(new Font("SansSerif", Font.PLAIN, 25));
        user_name.setHorizontalAlignment(JTextField.CENTER);
        user_name.setBorder(BorderFactory.createEmptyBorder());
        user_name.setBackground(new Color(133, 174, 191));
        logo.add(user_name,"wrap,width 30%!");

        user_name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (user_name.getText().equals("Name")) {
                    user_name.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (user_name.getText().isEmpty()) {
                    user_name.setText("Name");
                }
            }
        });

        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
//                System.out.println(String.valueOf(password.getPassword()));
                if (String.valueOf(password.getPassword()).equals("Password")) {
                    password.setText("");
                    password.setEchoChar('\u25CF');
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (password.getPassword().length == 0) {
                    password.setText("Password");
                    password.setEchoChar((char)0);
                }
            }
        });

        logo.add(empty2,"wrap");

//        Password field visual settings
        password.setFont(new Font("SansSerif", Font.PLAIN, 25));
        password.setHorizontalAlignment(JTextField.CENTER);
        password.setEchoChar((char)0);
        password.setBorder(BorderFactory.createEmptyBorder());
        password.setBackground(new Color(133, 174, 191));
        logo.add(password,"wrap,width 30%!");
        logo.add(empty5,"wrap");

//        Adding the button to JPanel and tweaking it's visual settings.
        b1.setBackground(new Color(255, 202, 68));
        b1.setFont(new Font("SansSerif", Font.PLAIN, 20));
        b1.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        logo.add(b1,"width 30%!");

//        Creating a split pane two incorporate two JPanels in a single JFrame.
        JSplitPane splitPane = new JSplitPane();
        splitPane.setSize((int)width, (int)height);
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation((int)width/10);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
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
            con = DriverManager.getConnection("jdbc:ucanaccess://oopdatabase1.accdb");

            admin oAdmin = new admin(uname,pwd);
            oAdmin.searchAdmin(psAdmin,con,rsAdmin,uname,pwd);
            if(oAdmin.searchAdmin(psAdmin,con,rsAdmin,uname,pwd)){
                this.dispose();
                new userMenu();
            }
            else{
                JOptionPane.showMessageDialog(this, "Try again!");
            }
        }
    }
} // End of the WelcomeScreen Class.

class JPanelGradient extends JPanel{
    public JPanelGradient(LayoutManager s) {
        this.setLayout(s);
    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        Color color1 = new Color(255,202, 68);
        Color color2 = new Color(255,255,255);
        GradientPaint gp = new GradientPaint(0,height,color1,width,height,color2);
        g2d.setPaint(gp);
        g2d.fillRect(0,0,width,height);
    }
}
public class Main {

    public static void main(String[] args) {

        new WelcomeScreen();
	// write your code here
    }
}

