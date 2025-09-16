package abc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newuser;
	private JTextField newpass;
	private JTextField confirmpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1369, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel newuser1 = new JLabel("USER NAME");
		newuser1.setFont(new Font("Serif", Font.BOLD, 30));
		newuser1.setBounds(203, 182, 275, 34);
		contentPane.add(newuser1);
		
		JLabel newpass1 = new JLabel("PASSWORD");
		newpass1.setFont(new Font("Serif", Font.BOLD, 30));
		newpass1.setBounds(203, 275, 179, 46);
		contentPane.add(newpass1);
		
		JLabel confirmpass1 = new JLabel("CONFIRM PASSWORD");
		confirmpass1.setFont(new Font("Serif", Font.BOLD, 30));
		confirmpass1.setBounds(132, 364, 346, 46);
		contentPane.add(confirmpass1);
		
		newuser = new JTextField();
		newuser.setBounds(533, 190, 262, 35);
		contentPane.add(newuser);
		newuser.setColumns(10);
		
		newpass = new JPasswordField();
		newpass.setBounds(533, 285, 264, 34);
		contentPane.add(newpass);
		newpass.setColumns(10);

		confirmpass = new JPasswordField();
		confirmpass.setBounds(533, 378, 264, 34);
		contentPane.add(confirmpass);
		confirmpass.setColumns(10);
		
		JButton signin = new JButton("CONFIRM");
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nu = newuser.getText();
					String np = newpass.getText();
					String cp = confirmpass.getText();

					// Regular expression for password validation
					String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
					
					if (!np.equals(cp)) {
						JOptionPane.showMessageDialog(signin, "Passwords do not match", "Invalid", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					if (!np.matches(passwordPattern)) {
						JOptionPane.showMessageDialog(signin, "Password must contain at least one special character, one uppercase letter, one number, one lowercase letter, and be at least 8 characters long", "Invalid", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
					Statement st1 = con1.createStatement();
					
					String sql1 =  "SELECT * FROM login_details";
					ResultSet res1 = st1.executeQuery(sql1);
					
					String sql2 = "SELECT COUNT(*) AS count FROM login_details";
					PreparedStatement ps2 = con1.prepareStatement(sql2);
					ResultSet res2 = ps2.executeQuery();
					
					int c = 0;
					if (res2.next()) {
						c = res2.getInt(1);
					}
					c += 1;
					
					boolean userExists = false;
					while (res1.next()) {
						String use1 = res1.getString("username");
						if (nu.equals(use1)) {
							userExists = true;
							break;
						}
					}
					
					if (!userExists) {
						String sql3 = "INSERT INTO login_details VALUES (?, ?, ?)";
						PreparedStatement pts = con1.prepareStatement(sql3);
						pts.setInt(1, c + 100);
						pts.setString(2, nu);
						pts.setString(3, np);
						pts.executeUpdate();
						
						JOptionPane.showMessageDialog(signin, "Data created", "Created", JOptionPane.INFORMATION_MESSAGE);
						
						try {
							logintest frame = new logintest();
							frame.setVisible(true);
						} catch (Exception a) {
							JOptionPane.showMessageDialog(signin, "Error while establishing connection failed", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(signin, "Username already exists", "Invalid", JOptionPane.ERROR_MESSAGE);
						newuser.setText("");
						newpass.setText("");
						confirmpass.setText("");
					}
				} catch (Exception os) {
					os.printStackTrace();
				}
			}
		});
		signin.setFont(new Font("Serif", Font.BOLD, 40));
		signin.setBounds(501, 450, 262, 46);
		contentPane.add(signin);
		
		JLabel lblNewLabel = new JLabel("maximum 8 characters,1 uppercase,1lowercase and 1 number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(545, 342, 486, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SIGN UP");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 40));
		lblNewLabel_1.setBounds(487, 102, 122, 34);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					((JPasswordField) newpass).setEchoChar((char) 0);
				} else {
					((JPasswordField) newpass).setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setBounds(881, 295, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\brandi-redd-aJTiW00qqtI-unsplash.jpg"));
		lblNewLabel_2.setBounds(0, 11, 1283, 707);
		contentPane.add(lblNewLabel_2);
	}
}