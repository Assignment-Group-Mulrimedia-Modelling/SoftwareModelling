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
	private JTextField textField_3;

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
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(100, 100, 526, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setDropMode(DropMode.INSERT);
		textField.setBounds(180, 51, 172, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setDropMode(DropMode.INSERT);
		textField_1.setBounds(180, 86, 172, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setDropMode(DropMode.INSERT);
		textField_2.setBounds(180, 121, 172, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("M");
		chckbxNewCheckBox.setBounds(106, 223, 40, 25);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("F");
		chckbxNewCheckBox_1.setBounds(180, 223, 40, 25);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setDropMode(DropMode.INSERT);
		formattedTextField.setBounds(180, 156, 172, 22);
		frame.getContentPane().add(formattedTextField);
		
		JLabel lblNewLabel = new JLabel("Surname");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(35, 53, 99, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(35, 88, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(35, 123, 82, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(34, 158, 147, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sex");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(35, 223, 56, 22);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("D.O.B");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(35, 187, 56, 23);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblMedicalIssues = new JLabel("Medical Issues");
		lblMedicalIssues.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMedicalIssues.setBounds(34, 273, 147, 16);
		frame.getContentPane().add(lblMedicalIssues);
		
		textField_4 = new JTextField();
		textField_4.setDropMode(DropMode.INSERT);
		textField_4.setBounds(180, 257, 172, 48);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(116, 188, 30, 22);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_6 = new JLabel("Day");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(87, 190, 30, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Month");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(147, 191, 49, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setBounds(190, 186, 30, 22);
		frame.getContentPane().add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1999, 1950, 2020, 1));
		spinner_2.setBounds(254, 186, 62, 22);
		frame.getContentPane().add(spinner_2);
		
		JLabel lblNewLabel_8 = new JLabel("Year");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(221, 191, 49, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setBounds(383, 311, 82, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("ID");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(46, 24, 56, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 16, 172, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, textField_1, textField_2}));
	}
}
