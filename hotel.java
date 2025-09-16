package abc;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import java.awt.Color;

public class hotel extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBox_2;
    private JComboBox<String> comboBox;
    private JComboBox<String> comboBox_3;
    private JTable table;
    private JTextField textField;
    private JTextArea textArea;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    hotel frame = new hotel();
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
    public hotel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1210, 737);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 140, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel place1 = new JLabel("PLACE");
        place1.setBounds(26, 25, 132, 41);
        place1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(place1);

        JLabel lblNewLabel_1 = new JLabel("check-in date");
        lblNewLabel_1.setBounds(16, 115, 185, 41);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("check-out date");
        lblNewLabel_2.setBounds(233, 121, 237, 29);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_2);

        comboBox = new JComboBox<>();
        comboBox.setBounds(43, 283, 51, 22);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"0", "1", "2", "3", "4", "5", "6"}));
        contentPane.add(comboBox);

        JLabel lblNewLabel_3 = new JLabel("Persons");
        lblNewLabel_3.setBounds(16, 236, 223, 22);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_5 = new JLabel("Rooms");
        lblNewLabel_5.setBounds(192, 237, 96, 20);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_5);

        comboBox_2 = new JComboBox<>();
        comboBox_2.setBounds(204, 283, 51, 22);
        comboBox_2.setModel(new DefaultComboBoxModel<>(new String[]{"0", "1", "2", "3", "4", "5", "6"}));
        comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(comboBox_2);

        JButton btnNewButton = new JButton("SEARCH");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String place = (String) comboBox_3.getSelectedItem();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
                    String sql = "SELECT * FROM hotel_details where place= '" + place + "'";
                    PreparedStatement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery();
                    DefaultTableModel dt = (DefaultTableModel) table.getModel();
                    dt.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {rs.getString("name"), rs.getString("number_of_rooms"), rs.getString("ac/non_ac"), rs.getString("room_type"), rs.getString("rating"), rs.getString("place"), rs.getString("room_id"), rs.getString("price")};
                        dt.addRow(o);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error occurred while searching.");
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(89, 351, 185, 31);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnNewButton);
        
         dateChooser = new JDateChooser();
        dateChooser.setBounds(26, 167, 132, 20);
        contentPane.add(dateChooser);
        
         dateChooser_1 = new JDateChooser();
        dateChooser_1.setBounds(262, 167, 136, 20);
        contentPane.add(dateChooser_1);

        JButton btnBook = new JButton("BOOK");
        btnBook.addActionListener(new ActionListener() {
            private Date check_in_date;
			private Date check_out_date;
			private int totalAmount;

			public void actionPerformed(ActionEvent e) {
                String Location = (String) comboBox_3.getSelectedItem();
                 check_in_date = dateChooser.getDate();
                check_out_date = dateChooser_1.getDate();
                String Persons = (String) comboBox.getSelectedItem();
                String rooms = (String) comboBox_2.getSelectedItem();
                String room_id = textField.getText();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
                    String sql = "SELECT * FROM hotel_details where room_id= ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, room_id);
                    ResultSet rs = pst.executeQuery();

                    textArea.setText(""); // Clear previous data
                    textArea.append("\tBOOKING DETAILS");

                    while (rs.next()) {
                        String o = rs.getString(1);
                        String h = rs.getString(2);
                        String i = rs.getString(3);
                        String p = rs.getString(4);
                        String oi = rs.getString(5);
                        String si = rs.getString(6);
                        int price = rs.getInt("price");

                        int numRooms = Integer.parseInt((String) comboBox_2.getSelectedItem());
                        totalAmount = numRooms * price;
                     //   String g=rs.getString(7);
                        textArea.append("\n\n\n");
                        textArea.append("\tName\t" + o + "\n");
                        textArea.append("\t---------------------------------\n");
                        textArea.append("\tNo.of rooms\t " + h + "\n");
                        textArea.append("\t---------------------------------\n");
                        textArea.append("\tAC/NON-AC\t" + i + "\n");
                        textArea.append("\t---------------------------------\n");
                        textArea.append("\tRoom Type\t" + p + "\n");
                        textArea.append("\t---------------------------------\n");
                        textArea.append("\tRating\t" + oi + "\n");
                        textArea.append("\t---------------------------------\n");
                        textArea.append("\tLocation\t" + si + "\n");
                        textArea.append("\t---------------------------------\n");
                        textArea.append("\tPrice per room\t" + price + "\n");
                        textArea.append("\t---------------------------------\n");
                      //  textArea.append("\tPrice\t" + g + "\n");
                        
                        textArea.append("\n\n\n"+
        						
        						"\t\tcheck in date:|\t"+dateChooser.getDate()+"\n"+
        						"\t------------------------------------------------------------------------------------------------\n"+
        						"\t\tcheck in time:|\t"+dateChooser_1.getDate()+"\n"+
        						"\t------------------------------------------------------------------------------------------------\n"+
        						"\t\tNumber of Persons:|\t\t"+(String)comboBox.getSelectedItem()+"\n"+
        						"\t-------------------------------------------------------------------------------------------------\n"+
        						//"\t\tChildren:|\t\t"+(String)comboBox_1.getSelectedItem()+"\n"+
        						//"\t-------------------------------------------------------------------------------------------------\n"+
        						"\t\tRooms:|\t\t"+(String)comboBox_2.getSelectedItem()+"\n"+
        						"\t-------------------------------------------------------------------------------------------------\n"+
        						"\t\tTotal Amount:|\t" + totalAmount + "\n" +
                                "\t------------------------------------------------------------------------------------------------"+"\n\n"+
        						
        						
        						"======================================================================\n"+
        						"\tCONGRATULATIONS YOUR ROOM HAS BEEN SUCESSFULLY BOOKED!!\n"
        						
        						
        						
        						
        						);
                    }

                    // Insert booking details into the booking table
                   /* String insertSql = "INSERT INTO booking (location, check_in_date, check_out_date, adult, children, rooms, room_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement insertPst = con.prepareStatement(insertSql);
                    insertPst.setString(1, Location);
                    insertPst.setString(2, check_in_date);
                    insertPst.setString(3, check_out_date);
                    insertPst.setString(4, adult);
                    insertPst.setString(5, children);
                    insertPst.setString(6, rooms);
                    insertPst.setString(7, room_id);
                    insertPst.executeUpdate();*/

                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnBook.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnBook.setBounds(746, 73, 132, 29);
        contentPane.add(btnBook);

        comboBox_3 = new JComboBox<>();
        comboBox_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        comboBox_3.setModel(new DefaultComboBoxModel<>(new String[]{"Yercaud", "Junction", "AVR", "Kandampatty", "Omalur", "4 roads", "Vincent", "Fairlands", "Gugai", "Seelnayakanpatty"}));
        comboBox_3.setBounds(213, 27, 210, 41);
        contentPane.add(comboBox_3);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 453, 583, 74);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"name", "number_of_rooms", "ac/non_ac", "room_type", "rating", "place", "room_id", "price"
        	}
        ));

        JLabel lblNewLabel = new JLabel("Enter room id");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(722, 11, 185, 31);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(950, 15, 96, 31);
        contentPane.add(textField);
        textField.setColumns(10);

        textArea = new JTextArea();
        textArea.setBounds(629, 139, 509, 473);
        contentPane.add(textArea);
        
        JButton btnNewButton_1 = new JButton("PRINT");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					textArea.print();
				}
				catch(PrinterException e1) {
					e1.printStackTrace();
					
				}
			}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setBounds(925, 73, 121, 27);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("BACK");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try{
					sample sf1 = new sample();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_2.setBounds(162, 610, 96, 23);
        contentPane.add(btnNewButton_2);
    }
}
