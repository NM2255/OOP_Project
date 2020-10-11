package com.shahiqinc;
// Ignore all this

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        new WelcomeScreen();
    }
}
class RoundedBorder implements Border {

    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}

//Real code starts from here.......

class WelcomeScreen extends JFrame {

//    Get the screen dimensions and then saving it into two variables for height and width.
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screenSize.getWidth();
    private double height = screenSize.getHeight();
    private String uname;
    private String pwd;

//    The Title of the window
    JTextField newTitle = new JTextField("UBIT Travel and Tours");

//    Constructor
    public WelcomeScreen() {

//        Basic settings of the JFrame.
        this.setSize((int)width, (int)height);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle(newTitle.getText());

//        Object initialization for handling data
        JLabel jl = new JLabel();
        JLabel j2 = new JLabel();
        JLabel j3 = new JLabel();
        JLabel j6 = new JLabel();
        JLabel empty = new JLabel();
        JLabel empty2 = new JLabel();
        JLabel empty5 = new JLabel();
        JTextField user_name = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        JButton b1 = new JButton("Log In");

//        Creating a new JPanel for JSplitPane and it's basic settings.
        JPanel controls = new JPanel();
        controls.setSize((int)width, (int)height);
        controls.setBackground(Color.GRAY);
        controls.setVisible(true);

//        Icon and it's placement settings.
        jl.setIcon(new ImageIcon("E:\\Java\\Programs\\E_TICKETING_SYSTEM_FINAL_PROJECT\\img\\logo.png"));
        jl.setBorder(new EmptyBorder((int)(height/4.5),0,0,0));
        controls.add(jl);
        add(controls);

//        Text below the icon.
        j2.setText("UBIT Travels and Tours");
        controls.add(j2);
        j2.setForeground(Color.BLACK);
        j2.setFont (j2.getFont ().deriveFont (40.0f));

//        Creating a new JPanel for JSplitPane and it's basic settings.
        JPanel logo = new JPanel();
        logo.setSize((int)width, (int)height);
        logo.setBackground(Color.WHITE);
        logo.setVisible(true);

//        Empty labels are for adding space between two objects, they fulfill no additional purpose.
        empty.setPreferredSize(new Dimension((int)width,420));
        logo.add(empty);

//        Label for username field.
        j3.setText("Enter your Username:");
        j3.setFont (j3.getFont ().deriveFont (20.0f));
        j3.setBorder(new EmptyBorder(0,0,0,33));
        logo.add(j3);

//        User name field visual settings
        user_name.setFont (user_name.getFont ().deriveFont (20.0f));
        logo.add(user_name);
        empty2.setBorder(new EmptyBorder(10,(int)width,10,(int)width));
        logo.add(empty2);

//        Label for password field.
        j6.setText("Enter your Password:");
        j6.setFont (j6.getFont ().deriveFont (20.0f));
        j6.setBorder(new EmptyBorder(0,0,0,36));
        logo.add(j6);

//        Password field visual settings
        password.setFont (password.getFont ().deriveFont (20.0f));
        logo.add(password);

        empty5.setBorder(new EmptyBorder(10,(int)width,10,(int)width));
        logo.add(empty5);

//        Saving user name and password into two static variables.
        variableCredentials.uname = user_name.getText();
        variableCredentials.pword = password.getPassword();

//        Saving user name and password into two local variables.
        uname = variableCredentials.uname;
        pwd = String.valueOf(variableCredentials.pword);;

//        Adding the button to JPanel and tweaking it's visual settings.
        b1.setPreferredSize(new Dimension((int)width/10,44));
        b1.setBackground(Color.WHITE);
        b1.setFont (b1.getFont ().deriveFont (15.0f));
        b1.setBorder(new RoundedBorder(40));
        logo.add(b1);

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
                registerButtonPressed();
            }
        });

//        Validating the components.
        validate();
    } // Constructor body ends here.

//    Function declaration for the button press.
    public void registerButtonPressed(){

/*       Ahsan your task starts from here. This method will be called after button is pressed.Data is already saved in
*        two variables defined above, look for the "Saving user name and password into two local variables." comment
*        and you will find them.
* */

    }
} // End of the WelcomeScreen Class.
