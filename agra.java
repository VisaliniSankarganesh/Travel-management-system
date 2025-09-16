package abc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;

public class agra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;
	static JComboBox comboBox;
	static JComboBox comboBox_1;
	static JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agra frame = new agra();
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
	public agra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1194, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new booking_package4().setVisible(true);
                dispose();
			}
		});
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					pack sf1 = new pack();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnBack).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(127, 506, 119, 23);
		contentPane.add(btnBack);
		btnNewButton.setBounds(662, 549, 119, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("INDULGE IN LOVE WITH AGRA");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblNewLabel.setBounds(240, 11, 638, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Taj Mahal - Agra Fort - Itmad-ud-Daulah's Tomb - Akbar’s Tomb - Chini Ka Rauza ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel_1.setBounds(170, 65, 918, 66);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Travellers");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(352, 208, 128, 35);
		contentPane.add(lblNewLabel_2);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox.setBounds(612, 210, 93, 31);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2_1 = new JLabel("Vehicle");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(352, 296, 128, 35);
		contentPane.add(lblNewLabel_2_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"sedan -AC", "SUV-AC"}));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox_1.setBounds(567, 296, 138, 35);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Date");
		lblNewLabel_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(352, 379, 128, 35);
		contentPane.add(lblNewLabel_2_1_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(551, 379, 154, 31);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Total Amount");
		lblNewLabel_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_1_1.setBounds(637, 482, 160, 35);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(874, 488, 119, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		calculateButton.setBounds(408, 470, 154, 35);
		contentPane.add(calculateButton);
		
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numOfTravellers = Integer.parseInt(comboBox.getSelectedItem().toString());
				int totalAmount = numOfTravellers * 35000;
				textField.setText(Integer.toString(totalAmount));
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel(" Ram Bagh (Aram Bagh - Taj Nature Walk - 6 Days (from Chennai)");
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel_3.setBounds(239, 115, 792, 50);
		contentPane.add(lblNewLabel_3);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\jovyn-chamb-iWMfiInivp4-unsplash.jpg"));
		image.setBounds(0, 0, 1180, 663);
		contentPane.add(image);
	}
}