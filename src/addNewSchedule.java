import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addNewSchedule {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static double width = screenSize.getWidth();
    private static double height = screenSize.getHeight();
    static JTextField busName = new JTextField(20);
    static JTextField busNumber = new JTextField(20);
    static JTextField busRoute = new JTextField(20);
    static JTextField busTiming = new JTextField(20);

    static String[][] data = {
            { "1", "Gujjar Coach", "4031", "Karachi to Mumbai", "10 A.M." },
            { "2", "Rangar Coach", "4021", "Lahore to Dubai", "10 P.M." }
    };
    static String[] columnNames = { "ID", "Name", "Bus Number", "Route", "Timings" };

    static DefaultTableModel model = new DefaultTableModel(data,columnNames);

    static JTable schedule = new JTable(model);

    public static JSplitPane addNewSchedule() {
        JPanel options = new JPanel();
        options.setBackground(Color.WHITE);
        options.setVisible(true);

        JLabel j1 = new JLabel("Enter name");
        JLabel j2 = new JLabel("Enter number");
        JLabel j3 = new JLabel("Enter route");
        JLabel j4 = new JLabel("Enter timing");
        JButton delete = new JButton("Delete Bus");

        JButton addBooking = new JButton("Add Bus");

        options.setLayout(new MigLayout("","40[]","[]20[]"));

        j1.setFont (j1.getFont ().deriveFont (20.0f));
        options.add(j1,"al right");

        busName.setFont (busName.getFont ().deriveFont (20.0f));
        busName.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(busName,"wrap, width 490!");

        j2.setFont (j2.getFont ().deriveFont (20.0f));
        options.add(j2,"al right");

        busNumber.setFont (busNumber.getFont ().deriveFont (20.0f));
        busNumber.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(busNumber,"wrap, width 490!");

        j3.setFont (j3.getFont ().deriveFont (20.0f));
        options.add(j3,"al right");

        busRoute.setFont (busRoute.getFont ().deriveFont (20.0f));
        busRoute.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(busRoute,"wrap, width 490!");

        j4.setFont (j4.getFont ().deriveFont (20.0f));
        options.add(j4,"al right");

        busTiming.setFont (busTiming.getFont ().deriveFont (20.0f));
        busTiming.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        options.add(busTiming,"wrap, width 490!");

        options.add(new JLabel(""));

        addBooking.setFont(addBooking.getFont().deriveFont(15.0f));
        addBooking.setBackground(Color.WHITE);
        addBooking.setBorder(new RoundedBorder(55));
        options.add(addBooking,"width "+(int)width/8+"!, height 50!");

        addBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewScheduleConfirmed();
            }
        });

        JPanel schedulePanel = new JPanel();
        schedulePanel.setLayout(new MigLayout());
        schedulePanel.setBackground(Color.WHITE);
        schedulePanel.setVisible(true);

        schedule.setFont(schedule.getFont().deriveFont(20.0f));
        schedule.setRowHeight(30);
        schedule.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 20));
        JScrollPane sp = new JScrollPane(schedule);
        schedulePanel.add(sp,"growx,pushx,wrap");

        delete.setFont(delete.getFont().deriveFont(15.0f));
        delete.setBackground(Color.WHITE);
        delete.setBorder(new RoundedBorder(55));
        schedulePanel.add(delete,"width "+(int)width/8+"!, height 50!");

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteSchedule();
            }
        });

        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation((int)width/2);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(options);
        splitPane.setRightComponent(schedulePanel);

        return splitPane;
    }
    public static void addNewScheduleConfirmed(){
        /**
         * Bajwe idhar se tera kaam shuru hota hai. Textfield ki value lene k liye e.g. busName ki value chahiye toh
         * phir likhna busName.getText();. Baqi ek jar file hogi git p usse external jar file add karde jese uCanAccess
         * kari thi.
         **/
        if(busName.getText().equals("") || busNumber.getText().equals("") || busRoute.getText().equals("") || busTiming.getText().equals("")){
            JOptionPane.showMessageDialog(userMenu.getf1(), "Please fill all fields!");
        }
        else{
            String data[] = {busName.getText(),busNumber.getText(),busRoute.getText(),busTiming.getText()};
            DefaultTableModel tblmodel = (DefaultTableModel)schedule.getModel();
            tblmodel.addRow(data);
        }
    }
    public static void deleteSchedule(){
        DefaultTableModel tblmodel = (DefaultTableModel)schedule.getModel();
        if(schedule.getSelectedRowCount()==1){
            int row = schedule.getSelectedRow();
            String cell = schedule.getModel().getValueAt(row,0).toString();
            String sql = "DELETE FROM bus WHERE id = "+cell;
            System.out.println(sql);
            tblmodel.removeRow(schedule.getSelectedRow());
        }
        else{
            JOptionPane.showMessageDialog(userMenu.getf1(), "Please select only one row!");
        }
    }
}
