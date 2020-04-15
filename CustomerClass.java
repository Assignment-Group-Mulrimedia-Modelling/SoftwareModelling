

import java.sql.*;

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
import javax.swing.AbstractButton;
import javax.swing.DropMode;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerClass {

	private JFrame frame;
	private JTextField surname;
	private JTextField name;
	private JTextField address;
	private JTextField medical_issues;
	private JTextField id;
	protected AbstractButton sex;

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
		
		surname = new JTextField();
		surname.setDropMode(DropMode.INSERT);
		surname.setBounds(180, 51, 172, 22);
		frame.getContentPane().add(surname);
		surname.setColumns(10);
		
		name = new JTextField();
		name.setDropMode(DropMode.INSERT);
		name.setBounds(180, 86, 172, 22);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setDropMode(DropMode.INSERT);
		address.setBounds(180, 121, 172, 22);
		frame.getContentPane().add(address);
		address.setColumns(10);
		
		JCheckBox male = new JCheckBox("M");
		male.setBounds(106, 223, 40, 25);
		frame.getContentPane().add(male);
		
		JCheckBox female = new JCheckBox("F");
		female.setBounds(180, 223, 40, 25);
		frame.getContentPane().add(female);
		
		JFormattedTextField phone_number = new JFormattedTextField();
		phone_number.setDropMode(DropMode.INSERT);
		phone_number.setBounds(180, 156, 172, 22);
		frame.getContentPane().add(phone_number);
		
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
		
		medical_issues = new JTextField();
		medical_issues.setDropMode(DropMode.INSERT);
		medical_issues.setBounds(180, 257, 172, 48);
		frame.getContentPane().add(medical_issues);
		medical_issues.setColumns(10);
		
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
		
		JButton insertButton = new JButton("INSERT");
		insertButton.addActionListener(new ActionListener() {
			private Object JOptionPane;

			public void actionPerformed(ActionEvent e) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","");
				Statement stmt=conn.createStatement();
				String sql="Select * from customer where id='"+id.getText()+"' and surname='"+surname.getText()+"' and name='"+name.getText()+"' and address='"+address.getText()+"' and phone_number='"+phone_number.getText()+"' and sex='"+sex.getText()+"' and D.O.B='"+spinner.getX()+"' and medical_issues='"+medical_issues.getText()+"'";
				ResultSet rs=stmt.executeQuery(sql);
				
				
			}catch(Exception e) {
				System.out.print(e);			}
			}
		});
		insertButton.setBounds(383, 311, 82, 25);
		frame.getContentPane().add(insertButton);
		
		JLabel lblNewLabel_9 = new JLabel("ID");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(46, 24, 56, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		id = new JTextField();
		id.setBounds(180, 16, 172, 22);
		frame.getContentPane().add(id);
		id.setColumns(10);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{surname, name, address}));
	}
}
