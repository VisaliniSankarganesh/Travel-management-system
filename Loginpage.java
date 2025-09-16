package abc;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class logintest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel error;
	private JTextField textField;
	private JPasswordField pass;
	private JTextField captchaField;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;
	private String captcha;
	static String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logintest frame = new logintest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Generate a CAPTCHA.
	 */
	public static String createCaptcha() {
		Random rand = new Random();
		int length = 7 + rand.nextInt(3);
		StringBuffer captcha = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int base = rand.nextInt(62);
			char charN;
			if (base < 26) {
				charN = (char) (65 + base);
			} else if (base < 52) {
				charN = (char) (97 + (base - 26));
			} else {
				charN = (char) (48 + (base - 52));
			}
			captcha.append(charN);
		}
		return captcha.toString();
	}

	/**
	 * Create the frame.
	 */
	public logintest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1287, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBackground(Color.BLACK);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(450, 428, 181, 30);
		contentPane.add(lblNewLabel_6);

		// Generate initial CAPTCHA
		captcha = createCaptcha();
		lblNewLabel_6.setText(captcha);

		JButton btnNewButton = new JButton("Generate CAPTCHA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				captcha = createCaptcha();
				lblNewLabel_6.setText(captcha);
			}
		});
		btnNewButton.setBounds(650, 438, 150, 23);
		contentPane.add(btnNewButton);

		captchaField = new JTextField();
		captchaField.setBounds(442, 379, 260, 30);
		contentPane.add(captchaField);
		captchaField.setColumns(10);

		error = new JLabel("");
		error.setBounds(452, 342, 250, 30);
		error.setForeground(Color.RED);
		contentPane.add(error);

		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		lblNewLabel_1.setBounds(251, 191, 181, 43);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(442, 195, 271, 45);
		contentPane.add(textField);

		JLabel lblNewLabel_2 = new JLabel("SIGN IN ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 45));
		lblNewLabel_2.setBackground(new Color(211, 211, 211));
		lblNewLabel_2.setBounds(450, 64, 181, 62);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("PASSWORD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		lblNewLabel.setBounds(251, 288, 181, 41);
		contentPane.add(lblNewLabel);

		pass = new JPasswordField();
		pass.setBounds(442, 291, 271, 45);
		contentPane.add(pass);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					pass.setEchoChar((char) 0);
				} else {
					pass.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Serif", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(739, 306, 135, 30);
		contentPane.add(rdbtnNewRadioButton);

		JButton btnNewButton_1_1 = new JButton("Forget Password");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset nf1 = new reset();
				nf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1_1).dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(821, 558, 208, 28);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1 = new JButton("SIGNUP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup nf = new signup();
				nf.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Dubai", Font.BOLD, 20));
		btnNewButton_1.setBounds(147, 558, 150, 30);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("LOGIN");
		btnNewButton_3.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				try {
					int et = 0;
					String us = textField.getText();
					String ps = new String(pass.getPassword());
					String captchaText = lblNewLabel_6.getText();
					String enteredCaptcha = captchaField.getText();

					if (!enteredCaptcha.equals(captchaText)) {
						error.setText("Invalid CAPTCHA");
						return;
					}

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha", "root", "Sweth@02");
					Statement st = con.createStatement();
					String sql = "Select * from login_details";
					ResultSet rs = st.executeQuery(sql);

					while (rs.next()) {
						 username = rs.getString("username");
						String password = rs.getString("password");

						if (us.equals(username) && ps.equals(password)) {
							new sample().setVisible(true);
							SwingUtilities.windowForComponent(btnNewButton_3).dispose();
							et = 1;
							break;
						}
					}

					if (et == 0) {
						error.setText("Invalid username or password");
						textField.setText("");
						pass.setText("");
					}
				} catch (Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_3, "Error while establishing connection failed", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 128));
		btnNewButton_3.setFont(new Font("Dubai", Font.BOLD, 30));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(508, 525, 169, 45);
		contentPane.add(btnNewButton_3);

		JLabel lblNewLabel_5 = new JLabel("ENTER CAPTCHA");
		lblNewLabel_5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		lblNewLabel_5.setBounds(189, 379, 260, 30);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\kenrick-mills-uxk0JKMrZts-unsplash.jpg"));
		lblNewLabel_3.setBounds(10, 11, 1253, 671);
		contentPane.add(lblNewLabel_3);
	}
}