package abc;

import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class done extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Date j;
	private Object ta;
	private Object ta1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					done frame = new done();
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
	public done() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1224, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 25, 1180, 500);
		contentPane.add(scrollPane);
		if(tamilnadu.dateChooser==null&&kerala.dateChooser==null&&manali.dateChooser==null) {
			 j =agra.dateChooser.getDate();
		}
		else if(tamilnadu.dateChooser==null&&kerala.dateChooser==null&&agra.dateChooser==null) {
			 j =manali.dateChooser.getDate();
		}
		else if(tamilnadu.dateChooser==null&&manali.dateChooser==null&&agra.dateChooser==null) {
			 j =kerala.dateChooser.getDate();
		}
		else {
			j=tamilnadu.dateChooser.getDate();
		}
		if(tour.textArea==null&&tour1.textArea==null&&tour3.textArea==null) {
			 ta =tour4.textArea.getText();
			 ta1=tour4.textArea_1.getText();
		}
		else if(tour.textArea==null&&tour4.textArea==null&&tour3.textArea==null) {
			 ta =tour1.textArea.getText();
			 ta1=tour1.textArea_1.getText();
		
		}
		else if(tour4.textArea==null&&tour1.textArea==null&&tour3.textArea==null) {
			 ta =tour.textArea.getText();
			 ta1=tour.textArea_1.getText();
		}
		
		else {
			ta =tour3.textArea.getText();
			 ta1=tour3.textArea_1.getText();
		}
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		textArea.append("Dear "+logintest.username+",\r\n"
				+ "\nThank you for choosing ROUTE RANGER for your upcoming travel adventure!"
				+ "\nWe are thrilled to have you on board and are committed to providing you with an unforgettable experience."
				+ "\nYour booking has been successfully confirmed, and we're excited to help you explore "+pack.s+" in the most delightful way. "
				+ "\nHere are the details of your package:"
				+ "\nBooking Reference Number: 100986\r\n"
				+ "\nItinerary Overview:\n"
				+ "Dates: "+j+"\r\n"
				+ "Destination: "+pack.s+"\r\n"
				+ "Accommodations: "+ta1+"\r\n"
				+ "Activities and Tours: "+ta+"\r\n"
				+ "You can view your detailed itinerary, travel documents, and other important information in your account on our website or app. "
				+ "\nIf you have any special requests or need further assistance, please do not hesitate to contact our customer service team at 044-93580.\r\n"
				+ "We look forward to making your journey with us memorable. Safe travels and see you soon!\r\n"
				+ "Warm regards,\r\n"
				+ "Dear "+logintest.username+"\r\n"
				+ "ROUTE RANGER\r\n"
				+ "Contact No: 98876 65432\r\n"
				+ "Feel free to personalize this message with specific details and your company's branding.");
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					pack sf1 = new pack();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(141, 559, 122, 32);
		contentPane.add(btnNewButton);
		
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
		btnNewButton_1.setBounds(802, 554, 122, 32);
		contentPane.add(btnNewButton_1);
	}
}