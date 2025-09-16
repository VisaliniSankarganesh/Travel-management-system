package abc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class reset extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user1;
	private JTextField pass1;
	private JTextField cpass1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reset frame = new reset();
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
	public reset() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 641);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userf = new JLabel("USER NAME");
		userf.setFont(new Font("Serif", Font.BOLD, 25));
		userf.setBounds(61, 182, 153, 40);
		contentPane.add(userf);
		
		JLabel newpass1 = new JLabel("NEW PASSWORD");
		newpass1.setFont(new Font("Serif", Font.BOLD, 25));
		newpass1.setBounds(61, 252, 213, 40);
		contentPane.add(newpass1);
		
		JLabel confirmpass = new JLabel("CONFIRM PASSWORD");
		confirmpass.setFont(new Font("Serif", Font.BOLD, 25));
		confirmpass.setBounds(52, 331, 300, 40);
		contentPane.add(confirmpass);
		
		user1 = new JTextField();
		user1.setBounds(530, 182, 245, 40);
		contentPane.add(user1);
		user1.setColumns(10);
		
		pass1 = new JTextField();
		pass1.setBounds(530, 258, 245, 40);
		contentPane.add(pass1);
		pass1.setColumns(10);
		
		cpass1 = new JTextField();
		cpass1.setBounds(530, 337, 245, 40);
		contentPane.add(cpass1);
		cpass1.setColumns(10);
		
		JButton btnNewButton = new JButton("SET");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i=1;
					String us1 = user1.getText();
					String np = pass1.getText();	
					String cp = cpass1.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/swetha","root","Sweth@02");
					Statement st1 = con1.createStatement();
					String sql1 =  "Select * from login_details";
					ResultSet res1 = st1.executeQuery(sql1);
					while(res1.next()) {
						String use1 = res1.getString("username");
						System.out.print("1");
						if(us1.equals(use1) && np.equals(cp)) {
							String sql2 = "update login_details set password = '"+np+"' where username = '"+us1+"'";
							PreparedStatement pts = con1.prepareStatement(sql2);
							System.out.print(np);
						    /*pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println(sql2);*/
							System.out.println("2");
							pts.executeUpdate(sql2);
							System.out.print("success");
							JOptionPane.showMessageDialog(btnNewButton, " data updated", "updated", -1);
							try {
								logintest newframe = new logintest();
								newframe.setVisible(true);
								SwingUtilities.windowForComponent(btnNewButton).dispose();
								
							}
							catch(Exception a)
							{
								JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
							}
						}
						else {
						     userf.setText("");
						     newpass1.setText("");
						     confirmpass.setText("");
						}
						i++;
					}
					}
					catch(Exception os)
					{
						System.out.print(os);
						JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
					}
			}
		});
		btnNewButton.setBounds(410, 460, 128, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\nunzio-guerrera-Ztc8VniT_0Q-unsplash.jpg"));
		lblNewLabel.setBounds(0, 0, 1067, 604);
		contentPane.add(lblNewLabel);
	}
}