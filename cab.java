package abc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import java.awt.Color;

public class cab extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextArea textArea;
	private JDateChooser dateChooser;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cab frame = new cab();
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
	public cab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1254, 709);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					sample sf1 = new sample();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_3).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(49, 567, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_6 = new JLabel("PRICE");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(447, 290, 87, 27);
		contentPane.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(447, 344, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(21, 57, 141, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(21, 124, 87, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(21, 192, 76, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Time");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(21, 249, 76, 36);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Sitka Text", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Junction", "New bus Stand", "Old Bus Stand", "Sona College", "Ammapet", "Shevapet", "Omalur", "Gugai", "Edapaddy"}));
		comboBox.setBounds(193, 64, 196, 33);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Junction", "New Bus Stand", "Old Bus Stand", "Sona College", "Ammapet", "Shevapet", "Omalur", "Gugai", "Edapaddy"}));
		comboBox_1.setBounds(193, 128, 196, 28);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_2.setBounds(193, 247, 65, 42);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"a.m", "p.m"}));
		comboBox_3.setBounds(314, 248, 76, 36);
		contentPane.add(comboBox_3);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			private String f;

			public void actionPerformed(ActionEvent e) {
				
				
			f=(String)comboBox.getSelectedItem();
			System.out.println(f);
			String ft=(String)comboBox_1.getSelectedItem();
			if(f.equals(ft))
			{
				JOptionPane.showMessageDialog(btnNewButton, this, "Enter valid location", 0, null);
			}
			else {
				try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
	                String sql = "SELECT * FROM cab_details where pickup = '"+f+"'";
	                PreparedStatement pst = con.prepareStatement(sql);
	                //pst.setString(1,f);
	                ResultSet rs=pst.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("cab_id"),rs.getString("model"),rs.getString("seats"),rs.getString("pickup"),rs.getString("rating")};
					dt.addRow(o);
					}
					if(f.equals("Junction") && ft.equals("Old Bus Stand")) {
						textField_1.setText("200");
                	}
					else if(f.equals("Junction") && ft.equals("New Bus Stand")) {
						textField_1.setText("250");
					}
				
				    else if(f.equals("Junction") && ft.equals("Gugai")) {
						textField_1.setText("400");
				    }	
				    else if(f.equals("Junction") && ft.equals("Omalur")) {
						textField_1.setText("500");
				    }
				    else if(f.equals("Junction") && ft.equals("Sona College")) {
						textField_1.setText("100");
				    }
				    else if(f.equals("Junction") && ft.equals("Shevapet")) {
						textField_1.setText("450");
				    }
				    else if(f.equals("Junction") && ft.equals("Ammapet")) {
						textField_1.setText("370");
				    }
				    else if(f.equals("Junction") && ft.equals("Edappady")) {
						textField_1.setText("600");
				    }
				    else if(f.equals("Edappady") && ft.equals("New Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Edappady") && ft.equals("Gugai")) {
						textField_1.setText("400");
				    }	
				    else if(f.equals("Edappady") && ft.equals("Omalur")) {
						textField_1.setText("500");
				    }
				    else if(f.equals("Edappady") && ft.equals("Sona College")) {
						textField_1.setText("100");
				    }
				    else if(f.equals("Edappady") && ft.equals("Shevapet")) {
						textField_1.setText("450");
				    }
				    else if(f.equals("Edappady") && ft.equals("Ammapet")) {
						textField_1.setText("370");
				    }
				    else if(f.equals("Edappady") && ft.equals("Junction")) {
						textField_1.setText("600");
				    }
				    else if(f.equals("Edappady") && ft.equals("Old Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Sona College") && ft.equals("New Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Sona College") && ft.equals("Gugai")) {
						textField_1.setText("400");
				    }	
				    else if(f.equals("Sona College") && ft.equals("Omalur")) {
						textField_1.setText("500");
				    }
				    else if(f.equals("Sona College") && ft.equals("Edappady")) {
						textField_1.setText("100");
				    }
				    else if(f.equals("Sona College") && ft.equals("Shevapet")) {
						textField_1.setText("450");
				    }
				    else if(f.equals("Sona College") && ft.equals("Ammapet")) {
						textField_1.setText("370");
				    }
				    else if(f.equals("Sona College") && ft.equals("Junction")) {
						textField_1.setText("600");
				    }
				    else if(f.equals("Sona College") && ft.equals("Old Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Gugai") && ft.equals("New Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Gugai") && ft.equals("Sona College")) {
						textField_1.setText("400");
				    }	
				    else if(f.equals("Gugai") && ft.equals("Omalur")) {
						textField_1.setText("500");
				    }
				    else if(f.equals("Gugai") && ft.equals("Edappady")) {
						textField_1.setText("100");
				    }
				    else if(f.equals("Gugai") && ft.equals("Shevapet")) {
						textField_1.setText("450");
				    }
				    else if(f.equals("Gugai") && ft.equals("Ammapet")) {
						textField_1.setText("370");
				    }
				    else if(f.equals("Gugai") && ft.equals("Junction")) {
						textField_1.setText("600");
				    }
				    else if(f.equals("Gugai") && ft.equals("Old Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Omalur") && ft.equals("New Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Omalur") && ft.equals("Sona College")) {
						textField_1.setText("400");
				    }	
				    else if(f.equals("Omalur") && ft.equals("Gugai")) {
						textField_1.setText("500");
				    }
				    else if(f.equals("Omalur") && ft.equals("Edappady")) {
						textField_1.setText("100");
				    }
				    else if(f.equals("Omalur") && ft.equals("Shevapet")) {
						textField_1.setText("450");
				    }
				    else if(f.equals("Omalur") && ft.equals("Ammapet")) {
						textField_1.setText("370");
				    }
				    else if(f.equals("Omalur") && ft.equals("Junction")) {
						textField_1.setText("600");
				    }
				    else if(f.equals("Omalur") && ft.equals("Old Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Ammapet") && ft.equals("New Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Ammapet") && ft.equals("Sona College")) {
						textField_1.setText("400");
				    }	
				    else if(f.equals("Ammapet") && ft.equals("Gugai")) {
						textField_1.setText("500");
				    }
				    else if(f.equals("Ammapet") && ft.equals("Edappady")) {
						textField_1.setText("100");
				    }
				    else if(f.equals("Ammapet") && ft.equals("Shevapet")) {
						textField_1.setText("450");
				    }
				    else if(f.equals("Ammapet") && ft.equals("Omalur")) {
						textField_1.setText("370");
				    }
				    else if(f.equals("Ammapet") && ft.equals("Junction")) {
						textField_1.setText("600");
				    }
				    else if(f.equals("Ammapet") && ft.equals("Old Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Shevapet") && ft.equals("New Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Shevapet") && ft.equals("Sona College")) {
						textField_1.setText("400");
				    }	
				    else if(f.equals("Shevapet") && ft.equals("Gugau")) {
						textField_1.setText("500");
				    }
				    else if(f.equals("Shevapet") && ft.equals("Edappady")) {
						textField_1.setText("100");
				    }
				    else if(f.equals("Shevapet") && ft.equals("Ammapet")) {
						textField_1.setText("450");
				    }
				    else if(f.equals("Shevapet") && ft.equals("Omalur")) {
						textField_1.setText("370");
				    }
				    else if(f.equals("Shevapet") && ft.equals("Junction")) {
						textField_1.setText("600");
				    }
				    else if(f.equals("Shevapet") && ft.equals("Old Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Old Bus Stand") && ft.equals("New Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("Old Bus Stand") && ft.equals("Sona College")) {
						textField_1.setText("400");
				    }	
				    else if(f.equals("Old Bus Stand") && ft.equals("Gugai")) {
						textField_1.setText("500");
				    }
				    else if(f.equals("Old Bus Stand") && ft.equals("Edappady")) {
						textField_1.setText("100");
				    }
				    else if(f.equals("Old Bus Stand") && ft.equals("Ammapet")) {
						textField_1.setText("450");
				    }
				    else if(f.equals("Old Bus Stand") && ft.equals("Omalur")) {
						textField_1.setText("370");
				    }
				    else if(f.equals("Old Bus Stand") && ft.equals("Junction")) {
						textField_1.setText("600");
				    }
				    else if(f.equals("Old Bus Stand") && ft.equals("Shevapet")) {
						textField_1.setText("250");
					}
				    else if(f.equals("New Bus Stand") && ft.equals("Old Bus Stand")) {
						textField_1.setText("250");
					}
				    else if(f.equals("New Bus Stand") && ft.equals("Sona College")) {
						textField_1.setText("400");
				    }	
				    else if(f.equals("New Bus Stand") && ft.equals("Gugai")) {
						textField_1.setText("500");
				    }
				    else if(f.equals("New Bus Stand") && ft.equals("Edappady")) {
						textField_1.setText("100");
				    }
				    else if(f.equals("New Bus Stand") && ft.equals("Ammapet")) {
						textField_1.setText("450");
				    }
				    else if(f.equals("New Bus Stand") && ft.equals("Omalur")) {
						textField_1.setText("370");
				    }
				    else if(f.equals("New Bus Stand") && ft.equals("Junction")) {
						textField_1.setText("600");
				    }
				    else if(f.equals("New Bus Stand") && ft.equals("Shevapet")) {
						textField_1.setText("250");
					}
				}
				    
					
					
				 catch (Exception ex) {
	                
	                JOptionPane.showMessageDialog(null, "Error occurred while searching.");
	                ex.printStackTrace();
	                 // Disable the Book Ticket button
	            }
				
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(109, 328, 244, 36);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 405, 466, 126);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"cab_id", "model", "seats", "pickup", "rating"
			}
		));
	 dateChooser = new JDateChooser();
		dateChooser.setBounds(193, 192, 141, 20);
		contentPane.add(dateChooser);
		JLabel lblNewLabel_4 = new JLabel("Enter cab id:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(447, 61, 156, 29);
		contentPane.add(lblNewLabel_4);
		
		
		
		 textArea = new JTextArea();
		 textArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
			textArea.setBounds(585, 25, 606, 612);
			contentPane.add(textArea);
			textField = new JTextField();
			textField.setBounds(447, 105, 96, 20);
			contentPane.add(textField);
			textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("BOOK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String f=textField.getText();
				
				try {
				
				       
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
	                String sql = "SELECT * FROM cab_details where cab_id= ?";
	                PreparedStatement pst = con.prepareStatement(sql);
	                pst.setString(1,f);
	                ResultSet rs=pst.executeQuery();
	                textArea.append("\tBOOKING DETAILS");
					
					
					while(rs.next()) {
					
				String o= rs.getString(1);
				String h= rs.getString(2);
				String i= rs.getString(3);
				String p= rs.getString(4);
				String oi= rs.getString(5);
				textArea.append("\n\n");
				textArea.append("\tcabid\t"+o+"\n");
				textArea.append("\t-----------------\n");
				textArea.append("\tmodel\t"+h+"\n");
				textArea.append("\t-----------------\n");
				
				textArea.append("\tseats\t"+i+"\n");
				textArea.append("\t-----------------\n");
				textArea.append("\tpickup place\t"+p+"\n");
				textArea.append("\t-----------------\n");
				
				textArea.append("\trating\t"+oi+"\n");
				textArea.append("\n\n\n"+
						
        						"\t\tPick up place:\t"   +(String)comboBox.getSelectedItem()+"\n"+
        						"\t----------------------------------------------------------------------------------------------\n"+
        						"\t\tDropping place:\t"+(String)comboBox_1.getSelectedItem()+"\n"+
        						"\t------------------------------------------------------------------------------------------------\n"+
        						"\t\tDate:\t\t"+dateChooser.getDate()+"\n"+
        						"\t-------------------------------------------------------------------------------------------------\n"+
        						"\t\tTime:\t\t"+(String)comboBox_2.getSelectedItem()+"\n"+
        						"\t-------------------------------------------------------------------------------------------------\n"+
        						"\t\tAM/PM:\t\t"+(String)comboBox_3.getSelectedItem()+"\n"+
        						"\t-------------------------------------------------------------------------------------------------\n"+
        						"\t\tPrice\t\t"+textField_1.getText()+"\n"+
        						
        						"======================================================================\n"+
        						"          CONGRATULATIONS YOUR CAB HAS BEEN SUCESSFULLY BOOKED!!\n"
        						
        						
        						
        						
        						);
                    }
				
				
					
					}
			
					
				 catch (Exception ex) {
	                
	                JOptionPane.showMessageDialog(null, "Error occurred while searching.");
	                ex.printStackTrace();
	                 // Disable the Book Ticket button
	            }
				
				
				
			
			}});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(447, 149, 128, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PRINT");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
				}
				catch(PrinterException e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton_2.setBounds(454, 198, 121, 23);
		contentPane.add(btnNewButton_2);
		
		
	}
}
