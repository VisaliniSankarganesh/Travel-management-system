package abc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class kerala extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    static JTextField textField;
    static JComboBox<String> comboBox;
    static JComboBox<String> comboBox_1;
    static JDateChooser dateChooser;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    kerala frame = new kerala();
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
    public kerala() {
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
                new booking_package2().setVisible(true);
                dispose();
            }
        });
        
        JButton btnNewButton_1 = new JButton("BACK");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try{
					pack sf1 = new pack();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setBounds(115, 537, 113, 35);
        contentPane.add(btnNewButton_1);
        btnNewButton.setBounds(795, 521, 138, 35);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("SCOUT KERALA");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
        lblNewLabel.setBounds(240, 11, 638, 66);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Cochin - Munnar - Vagamon - Varkala - Allappey in 5 Days (from Chennai)");
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
        lblNewLabel_1.setBounds(204, 88, 843, 66);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Travellers");
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(354, 268, 128, 35);
        contentPane.add(lblNewLabel_2);

        comboBox = new JComboBox<>();
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        comboBox.setBounds(615, 270, 93, 31);
        contentPane.add(comboBox);

        JLabel lblNewLabel_2_1 = new JLabel("Vehicle");
        lblNewLabel_2_1.setForeground(Color.BLACK);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2_1.setBounds(354, 335, 128, 35);
        contentPane.add(lblNewLabel_2_1);

        comboBox_1 = new JComboBox<>();
        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[] { "sedan -AC", "SUV-AC" }));
        comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        comboBox_1.setBounds(570, 335, 138, 35);
        contentPane.add(comboBox_1);

        JLabel lblNewLabel_2_1_1 = new JLabel("Date");
        lblNewLabel_2_1_1.setForeground(Color.BLACK);
        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2_1_1.setBounds(354, 418, 128, 35);
        contentPane.add(lblNewLabel_2_1_1);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(554, 418, 154, 31);
        contentPane.add(dateChooser);

        JLabel lblNewLabel_2_1_1_1 = new JLabel("Total Amount");
        lblNewLabel_2_1_1_1.setForeground(Color.BLACK);
        lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2_1_1_1.setBounds(352, 527, 160, 35);
        contentPane.add(lblNewLabel_2_1_1_1);

        textField = new JTextField();
        textField.setBounds(542, 527, 119, 31);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        calculateButton.setBounds(408, 470, 154, 35);
        contentPane.add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numOfTravellers = Integer.parseInt(comboBox.getSelectedItem().toString());
                int totalAmount = numOfTravellers * 30000;
                textField.setText(Integer.toString(totalAmount));
            }
        });

        JLabel image = new JLabel("");
        image.setIcon(new ImageIcon("C:\\Users\\Muthurajan\\Downloads\\abhishek-prasad-N3VzleBhOvk-unsplash.jpg"));
        image.setBounds(0, 0, 1178, 639);
        contentPane.add(image);
    }
}