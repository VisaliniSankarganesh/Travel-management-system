package abc;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class seat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JButton[] r = new JButton[30];
	private int j = 0;
	private int a1;
	private int c;
	private ActionListener lis;
	private String fr = (String) buses.comboBox.getSelectedItem();
	private String to = (String) buses.comboBox_1.getSelectedItem();
	private ArrayList<Integer> selectedSeats = new ArrayList<>();
	private JTextArea textArea;
	private JTextArea billArea;
	private int hj;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seat frame = new seat();
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
	public seat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1297, 703);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 35, 474, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FROM :"+fr);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(618, 49, 244, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblTonull = new JLabel("TO :"+to);
		lblTonull.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTonull.setBounds(984, 49, 244, 35);
		contentPane.add(lblTonull);
		
		
		a1 = 0;
		c = 0;
        lis = new ActionListener() {
			   public void actionPerformed(ActionEvent ew) {
				   for (int i = 0; i < 30; i++) {
					   if (ew.getSource() == r[i]) {
						   if (r[i].getBackground() == Color.GREEN) {
							   r[i].setBackground(Color.YELLOW);
							   selectedSeats.add(i + 1);
						   } else if (r[i].getBackground() == Color.YELLOW) {
							   r[i].setBackground(Color.GREEN);
							   selectedSeats.remove(Integer.valueOf(i + 1));
						   }
						   updateTextArea();
					   }
				   }
			   }
		};
		
		for (int i = 0; i < 30; i++) {
			if (j <= 9) {
				r[i] = new JButton("" + (i + 1));
				r[i].setFont(new Font("Tahoma", Font.BOLD, 10));
				r[i].setBounds(a1, c, 50, 50);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
					String sql = "select * from booking_bus where from1='" + fr + "' and to1='" + to + "' and seat_no='" + (i + 1) + "'";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						r[i].setBackground(Color.RED);
					} else {
						r[i].setBackground(Color.GREEN);
					}
				} catch (Exception ty) {
					ty.printStackTrace();
				}
				
				r[i].addActionListener(lis);
				panel.add(r[i]);
				c = c + 60;
				j++;
			}
			if (j == 10) {
				j = 0;
				c = 0;
				a1 = a1 + 120;
			}
		}
		
		textArea = new JTextArea();
		textArea.setBounds(591, 95, 595, 187);
		contentPane.add(textArea);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirm.setBounds(591, 313, 150, 40);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmBooking();
			}
		});
		contentPane.add(btnConfirm);
		
		billArea = new JTextArea();
		billArea.setBounds(594, 381, 592, 218);
		contentPane.add(billArea);
		
		JButton btnNewButton = new JButton("PRINT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textArea.print();
                } catch (PrinterException e1) {
                    e1.printStackTrace();
                }
            }
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(946, 313, 112, 34);
		contentPane.add(btnNewButton);
	}
	
	private void updateTextArea() {
		StringBuilder seats = new StringBuilder();
		for (int seat : selectedSeats) {
			seats.append("Seat ").append(seat).append(" selected\n");
		}
		textArea.setText(seats.toString());
	}
	
	private void confirmBooking() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
			String sql = "select * from bus_details where from1='" + fr + "' and to1='" + to + "'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			int busId = 0;
			int pricePerSeat = 0;
			if (rs.next()) {
				busId = rs.getInt(1);
				pricePerSeat = rs.getInt("price"); // Assuming there is a 'price' column
			}
			String sql2 = "select count(*) from booking_bus ";
			PreparedStatement pst2 = con.prepareStatement(sql2);
			ResultSet rs2 = pst2.executeQuery();
			while(rs2.next()) {
				hj=rs2.getInt(1);
			}
			
			for (int seat : selectedSeats) {
				String bn=""+(hj+1);
				String sql1 = "insert into booking_bus values(?,?,?,?,?)";
				PreparedStatement pst1 = con.prepareStatement(sql1);
				pst1.setInt(1, busId);
				pst1.setString(2, fr);
				pst1.setString(3, to);
				pst1.setString(4, String.valueOf(seat));
				pst1.setString(5,bn);
				pst1.executeUpdate();
				hj++;
				
			}
			JOptionPane.showMessageDialog(null, "Booking confirmed for seats: " + selectedSeats);
			generateBill(pricePerSeat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void generateBill(int pricePerSeat) {
		int totalPrice = selectedSeats.size() * pricePerSeat;
		StringBuilder bill = new StringBuilder();
		bill.append("Bill\n");
		bill.append("------\n");
		for (int seat : selectedSeats) {
			bill.append("Seat ").append(seat).append(": ").append(pricePerSeat).append("\n");
		}
		bill.append("------\n");
		bill.append("Total: ").append(totalPrice).append("\n");
		billArea.setText(bill.toString());
	}
}