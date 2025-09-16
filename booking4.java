package abc;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class booking_package4 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private details[] y = new details[100];

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    booking_package4 frame = new booking_package4();
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
    public booking_package4() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 963, 581);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(65, 29, 150, 38);
        lblNewLabel.setText(pack.lblNewLabel_1_3.getText());
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setBounds(65, 78, 132, 34);
        lblNewLabel_1.setText(pack.lblNewLabel_2_3.getText());
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBounds(592, 35, 223, 27);
        lblNewLabel_2.setText("Number of Travellers: " + (String) agra.comboBox.getSelectedItem());
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setBounds(592, 85, 122, 27);
        lblNewLabel_3.setText("Car Type: " + (String) agra.comboBox_1.getSelectedItem());
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setBounds(324, 35, 212, 27);
        lblNewLabel_4.setText("Date: " + agra.dateChooser.getDate());
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("New label");
        lblNewLabel_5.setBounds(324, 82, 122, 27);
        lblNewLabel_5.setText("Total: " + (String) agra.textField.getText());
        contentPane.add(lblNewLabel_5);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(62, 140, 730, 300);
        contentPane.add(scrollPane);
        
        JPanel panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JButton btnNewButton = new JButton("CLICK HERE TO CONTINUE");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					tour4 sf1 = new tour4();
					sf1.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				} catch (Exception rt) {
					rt.printStackTrace();
				}
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(448, 481, 372, 38);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("BACK");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					agra sf1 = new agra();
					sf1.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				} catch (Exception rt) {
					rt.printStackTrace();
				}
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setBounds(120, 481, 122, 34);
        contentPane.add(btnNewButton_1);
        
        int n = Integer.parseInt((String) agra.comboBox.getSelectedItem());
        for (int i = 0; i < n; i++) {
            y[i] = new details(i + 1);
            panel.add(y[i]);
        }
    }

    private static class InputFilter extends PlainDocument {
        private static final long serialVersionUID = 1L;
        private int maxLength;

        public InputFilter(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length()) <= maxLength && str.matches("\\d*")) {
                super.insertString(offset, str, attr);
            }
        }

        @Override
        public void replace(int offset, int length, String str, AttributeSet attrs) throws BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length() - length) <= maxLength && str.matches("\\d*")) {
                super.replace(offset, length, str, attrs);
            }
        }
    }

    private class details extends JPanel {
        private static final long serialVersionUID = 1L;
        private JTextField nameField;
        private JTextField cityField;
        private JTextField ageField;
        private JTextField phoneField;
        private JTextField pincodeField;

        public details(int personNumber) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel personLabel = new JLabel("Person " + personNumber);
            personLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
            add(personLabel);

            JLabel nameLabel = new JLabel("Name:");
            add(nameLabel);

            nameField = new JTextField(20);
            add(nameField);

            JLabel cityLabel = new JLabel("City:");
            add(cityLabel);

            cityField = new JTextField(20);
            add(cityField);

            JLabel ageLabel = new JLabel("Age:");
            add(ageLabel);

            ageField = new JTextField(10);
            ageField.setDocument(new InputFilter(3)); // Age: maximum 3 digits
            add(ageField);

            JLabel phoneLabel = new JLabel("Phone Number:");
            add(phoneLabel);

            phoneField = new JTextField(10);
            phoneField.setDocument(new InputFilter(10)); // Phone number: exactly 10 digits
            add(phoneField);

            JLabel pincodeLabel = new JLabel("Pincode:");
            add(pincodeLabel);

            pincodeField = new JTextField(6);
            pincodeField.setDocument(new InputFilter(6)); // Pincode: exactly 6 digits
            add(pincodeField);
        }

        public String getName() {
            return nameField.getText();
        }

        public String getCity() {
            return cityField.getText();
        }

        public String getAge() {
            return ageField.getText();
        }

        public String getPhoneNumber() {
            return phoneField.getText();
        }

        public String getPincode() {
            return pincodeField.getText();
        }
    }
}