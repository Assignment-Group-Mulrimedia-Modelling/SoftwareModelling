import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import java.awt.SystemColor;

public class CustomerClass {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerClass window = new CustomerClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setDropMode(DropMode.INSERT);
		textField.setBounds(180, 22, 135, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setDropMode(DropMode.INSERT);
		textField_1.setBounds(180, 55, 135, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setDropMode(DropMode.INSERT);
		textField_2.setBounds(180, 90, 135, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Male");
		chckbxNewCheckBox.setBounds(180, 155, 55, 25);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Female");
		chckbxNewCheckBox_1.setBounds(244, 155, 113, 25);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setDropMode(DropMode.INSERT);
		formattedTextField.setBounds(180, 124, 135, 22);
		frame.getContentPane().add(formattedTextField);
		
		JLabel lblNewLabel = new JLabel("Surname");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(34, 23, 99, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(44, 58, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(34, 93, 82, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(34, 128, 147, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sex");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(44, 159, 56, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("D.O.B");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(44, 188, 56, 23);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblMedicalIssues = new JLabel("Medical Issues");
		lblMedicalIssues.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMedicalIssues.setBounds(34, 224, 147, 16);
		frame.getContentPane().add(lblMedicalIssues);
		
		textField_4 = new JTextField();
		textField_4.setDropMode(DropMode.INSERT);
		textField_4.setBounds(180, 218, 135, 22);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(212, 189, 30, 22);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_6 = new JLabel("Day");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(180, 192, 30, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Month");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(244, 193, 56, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setBounds(285, 189, 30, 22);
		frame.getContentPane().add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1999, 1950, 2020, 1));
		spinner_2.setBounds(351, 189, 69, 22);
		frame.getContentPane().add(spinner_2);
		
		JLabel lblNewLabel_8 = new JLabel("Year");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(319, 192, 49, 16);
		frame.getContentPane().add(lblNewLabel_8);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, textField_1, textField_2}));
	}
}
