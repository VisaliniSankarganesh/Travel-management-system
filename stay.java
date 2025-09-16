package abc;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

public class stay extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField_1;
    private JDateChooser dateChooser;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    stay frame = new stay();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public stay() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1332, 751);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("BACK");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try{
					sample sf1 = new sample();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(65, 594, 89, 23);
        contentPane.add(btnNewButton);
        
        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"a.m", "p.m"}));
        comboBox_3.setBounds(380, 273, 75, 22);
        contentPane.add(comboBox_3);

        JLabel lblNewLabel = new JLabel("Location");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(51, 62, 103, 44);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("hours");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(51, 131, 123, 25);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("check-in-date");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(51, 196, 187, 25);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("check-in-time");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_3.setBounds(51, 268, 157, 25);
        contentPane.add(lblNewLabel_3);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"AVR", "Junction", "Omalur", "New Bus Stand", "Old Bus Stand", "4 roads", "5 roads", "Gugai"}));
        comboBox.setBounds(224, 73, 123, 22);
        contentPane.add(comboBox);

        JComboBox<String> comboBox_1 = new JComboBox<>();
        comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        comboBox_1.setBounds(224, 132, 123, 22);
        contentPane.add(comboBox_1);

        JComboBox<String> comboBox_2 = new JComboBox<>();
        comboBox_2.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
        comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        comboBox_2.setBounds(218, 269, 123, 22);
        contentPane.add(comboBox_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 375, 500, 80);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"id", "Location", "rooms_available", "room_type", "persons_per_room", "name", "rs_per_hour"
        	}
        ));

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String f = (String) comboBox.getSelectedItem();
                System.out.println(f);
                String ft = (String) comboBox_1.getSelectedItem();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
                    String sql = "SELECT * FROM stay_details WHERE location = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, f);
                    ResultSet rs = pst.executeQuery();
                    DefaultTableModel dt = (DefaultTableModel) table.getModel();
                    dt.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {rs.getString("id"), rs.getString("location"), rs.getString("rooms_available"), rs.getString("room_type"), rs.getString("persons_per_room"), rs.getString("name")};
                        dt.addRow(o);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error occurred while searching.");
                    ex.printStackTrace();
                }
            }
        });
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnSearch.setBounds(119, 326, 157, 23);
        contentPane.add(btnSearch);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(569, 153, 548, 482);
        contentPane.add(textArea);

        JLabel lblNewLabel_4 = new JLabel("Enter the room_id");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_4.setBounds(25, 504, 183, 31);
        contentPane.add(lblNewLabel_4);

        textField_1 = new JTextField();
        textField_1.setBounds(272, 513, 115, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(224, 201, 123, 20);
        contentPane.add(dateChooser);

        JButton btnNewButton_1 = new JButton("BOOK");
        btnNewButton_1.addActionListener(new ActionListener() {
            private int totalAmount;

			public void actionPerformed(ActionEvent e) {
                String f = textField_1.getText();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
                    String sql = "SELECT * FROM stay_details WHERE id = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, f);
                    ResultSet rs = pst.executeQuery();
                    textArea.append("\tBOOKING DETAILS");

                    while (rs.next()) {
                        String o = rs.getString("id");
                        String h = rs.getString("location");
                        String i = rs.getString("rooms_available");
                        String p = rs.getString("room_type");
                        String oi = rs.getString("persons_per_room");
                        int rs_per_hour = rs.getInt("rs_per_hour");

                        int hours = Integer.parseInt((String) comboBox_1.getSelectedItem());
                        totalAmount = hours * rs_per_hour;
                        textArea.append("\n\n");
                        textArea.append("\tid\t" + o + "\n");
                        textArea.append("\t-------------------------------\n");
                        textArea.append("\tlocation\t" + h + "\n");
                        textArea.append("\t-------------------------------\n");
                        textArea.append("\trooms_available\t" + i + "\n");
                        textArea.append("\t-------------------------------\n");
                        textArea.append("\troom_type\t" + p + "\n");
                        textArea.append("\t-------------------------------\n");
                        textArea.append("\tpersons_per_room\t" + oi + "\n");
                        textArea.append("\n\n\n" +
                            "\t\tPlace:\t" + (String) comboBox.getSelectedItem() + "\n" +
                            "\t----------------------------------------------------------------------------------------------\n" +
                            "\t\tHours:\t" + (String) comboBox_1.getSelectedItem() + "\n" +
                            "\t------------------------------------------------------------------------------------------------\n" +
                            "\t\tDate:\t\t" + dateChooser.getDate() + "\n" +
                            "\t-------------------------------------------------------------------------------------------------\n" +
                            "\t\tTime:\t\t" + (String) comboBox_2.getSelectedItem() + "\n" +
                            "\t-------------------------------------------------------------------------------------------------\n" +
                            "\t\tAM/PM:\t\t" + (String) comboBox_3.getSelectedItem() + "\n" +
                            "\t-------------------------------------------------------------------------------------------------\n" +
                            
                            "\t\tTotal Amount:|\t" + totalAmount + "\n" +
                               						
                            "======================================================================\n" +
                            "          CONGRATULATIONS YOUR ROOM HAS BEEN SUCCESSFULLY BOOKED!!\n"
                        );
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error occurred while booking.");
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnNewButton_1.setBounds(569, 35, 157, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("PRINT");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea.print();
                } catch (PrinterException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnNewButton_2.setBounds(830, 35, 157, 23);
        contentPane.add(btnNewButton_2);
        
        JLabel lblNewLabel_5 = new JLabel("New label");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\alen-rojnic-T1Yvmf4oleQ-unsplash.jpg"));
        lblNewLabel_5.setBounds(0, 11, 1283, 678);
        contentPane.add(lblNewLabel_5);
    }
}