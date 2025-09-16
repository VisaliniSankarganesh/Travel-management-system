package abc;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class buses extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    static JComboBox<String> comboBox;
    static JComboBox<String> comboBox_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    buses frame = new buses();
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
    public buses() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(00, 00, 1361, 737);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 230, 140));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("From");
        lblNewLabel.setBounds(121, 105, 151, 47);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("To");
        lblNewLabel_1.setBounds(121, 181, 151, 47);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Date");
        lblNewLabel_1_1.setBounds(121, 268, 151, 47);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_1);

        comboBox = new JComboBox<>();
        comboBox.setBounds(335, 121, 144, 22);
        contentPane.add(comboBox);

        comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(335, 197, 144, 22);
        contentPane.add(comboBox_1);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(335, 281, 140, 20);
        contentPane.add(dateChooser);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 430, 852, 89);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setColumnHeaderView(table);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, ""},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
            },
            new String[] {
                "bus_id", "from", "to", "departure_time", "arrival_time", "price", "ratings", "ac/non-ac"
            }
        ));

        JButton btnNewButton = new JButton("SEARCH");
        btnNewButton.setBounds(225, 347, 151, 35);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchBuses();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnNewButton);
        
        JButton selectseat = new JButton("Select Seats");
        selectseat.setBounds(750, 347, 182, 29);
        selectseat.setFont(new Font("Tahoma", Font.BOLD, 20));
        selectseat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			 Class.forName("com.mysql.cj.jdbc.Driver");
 	                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
 	                String sql = "select * from bus_details where from1='"+comboBox.getSelectedItem()+"' and to1='"+comboBox_1.getSelectedItem()+"'";
 	                PreparedStatement pst = con.prepareStatement(sql);
 	               // pst.setString(1, (String)comboBox.getSelectedItem());
 	                //pst.setString(2, (String)comboBox_1.getSelectedItem());
 	                ResultSet rs = pst.executeQuery();
 	                 if(rs.next()) {
 	                	new seat().setVisible(true);
 	           		    SwingUtilities.windowForComponent(selectseat).dispose();
 	                }
 	                 else {
 	                	JOptionPane.showMessageDialog(null, "No Bus");
 	                 }
 	                
        		}
        		catch(Exception t) {
        			t.printStackTrace();
        		}
        		//new seat().setVisible(true);
        		//SwingUtilities.windowForComponent(selectseat).dispose();
        	}
        });
        contentPane.add(selectseat);
        
        lblNewLabel_2 = new JLabel("BUS BOOKING");
        lblNewLabel_2.setForeground(new Color(128, 0, 0));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Pristina", Font.BOLD, 36));
        lblNewLabel_2.setBounds(282, 0, 677, 87);
        contentPane.add(lblNewLabel_2);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(220, 20, 60));
        separator.setForeground(new Color(139, 0, 0));
        separator.setBounds(10, 74, 1273, 2);
        contentPane.add(separator);
        
        JButton btnNewButton_1 = new JButton("BACK");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try{
					sample sf1 = new sample();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setBounds(54, 578, 140, 35);
        contentPane.add(btnNewButton_1);

        // Populate combo boxes with values from the database
        populateComboBoxes();
    }

    private void populateComboBoxes() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
            statement = connection.createStatement();

            // Execute query to get distinct 'from' values
            resultSet = statement.executeQuery("SELECT DISTINCT `from1` FROM bus_details");
            while (resultSet.next()) {
                comboBox.addItem(resultSet.getString("from1"));
            }

            // Close the first resultSet and execute query to get distinct 'to' values
            resultSet.close();
            resultSet = statement.executeQuery("SELECT DISTINCT `to1` FROM bus_details");
            while (resultSet.next()) {
                comboBox_1.addItem(resultSet.getString("to1"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void searchBuses() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
            statement = connection.createStatement();

            // Get selected values from combo boxes
            String from = comboBox.getSelectedItem().toString();
            String to = comboBox_1.getSelectedItem().toString();

            // Execute query to get bus details based on 'from' and 'to' values
            String query = "SELECT * FROM bus_details WHERE `from1` = '" + from + "' AND `to1` = '" + to + "'";
            resultSet = statement.executeQuery(query);

            // Clear existing rows in the table model
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            // Populate the table with the result set
            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getString("bus_id"),
                    resultSet.getString("from1"),
                    resultSet.getString("to1"),
                    resultSet.getString("departure_time"),
                    resultSet.getString("arrival_time"),
                    resultSet.getString("price"),
                    resultSet.getString("ratings"),
                    resultSet.getString("ac/non-ac")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}