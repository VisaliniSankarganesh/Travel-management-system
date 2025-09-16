package abc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;

public class sample extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sample frame = new sample();
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
	public sample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1370, 727);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cabs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					cab sf1 = new cab();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\taxi-driver (2).png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(107, 100, 279, 144);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hotels");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\5-stars.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					hotel sf1 = new hotel();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
			
		});
		btnNewButton_1.setBounds(485, 100, 297, 144);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Stays");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					stay sf1 = new stay();
				    sf1.setVisible(true);
				    SwingUtilities.windowForComponent(btnNewButton).dispose();}
				    catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\bunk-bed.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_3.setBounds(885, 107, 271, 137);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Daily Steel Deals");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		lblNewLabel.setBounds(402, 11, 476, 57);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("LOGOUT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					logintest sf1 = new logintest();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(93, 533, 180, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3_1 = new JButton("Bus");
		btnNewButton_3_1.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\bus.png"));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					buses sf1 = new buses();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_3_1).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_3_1.setBounds(243, 323, 297, 144);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_4 = new JButton("Packages");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					welcome sf1 = new welcome();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_4).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\binoculars.png"));
		btnNewButton_4.setBounds(669, 323, 356, 144);
		contentPane.add(btnNewButton_4);
	}

}