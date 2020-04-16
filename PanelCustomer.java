import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class PanelCustomer extends JPanel {
	
	Connection conn = null;
	private JTextField id;
	private JTextField surname;
	private JTextField name;
	private JTextField address;
	private JTextField textFieldPhone;
	private JTextField sexx;
	private JTextField date_of_birth;
	private JTextField medical_issues;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;

	/**
	 * Create the panel.
	 */
	public PanelCustomer() {
		setBackground(UIManager.getColor("Button.shadow"));
		setBorder(new LineBorder(new Color(0, 255, 255), 2));
		
		setBounds(0, 0, 670, 630);
		setLayout(null);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(311, 88, 203, 27);
		add(id);
		
		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(311, 130, 203, 27);
		add(surname);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(311, 171, 203, 27);
		add(name);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(311, 212, 203, 27);
		add(address);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(311, 253, 203, 27);
		add(textFieldPhone);
		
		sexx = new JTextField();
		sexx.setColumns(10);
		sexx.setBounds(311, 298, 203, 27);
		add(sexx);
		
		date_of_birth = new JTextField();
		date_of_birth.setColumns(10);
		date_of_birth.setBounds(311, 343, 203, 27);
		add(date_of_birth);
		
		medical_issues = new JTextField();
		medical_issues.setColumns(10);
		medical_issues.setBounds(311, 384, 203, 67);
		add(medical_issues);
		
		label = new JLabel(" Medical Issues :");
		label.setFont(new Font("Arial", Font.BOLD, 16));
		label.setBounds(164, 384, 137, 31);
		add(label);
		
		label_1 = new JLabel("Date of Birth :");
		label_1.setFont(new Font("Arial", Font.BOLD, 16));
		label_1.setBounds(185, 335, 116, 31);
		add(label_1);
		
		label_2 = new JLabel("Sex :");
		label_2.setFont(new Font("Arial", Font.BOLD, 16));
		label_2.setBounds(252, 294, 49, 31);
		add(label_2);
		
		label_3 = new JLabel("Phone Number :");
		label_3.setFont(new Font("Arial", Font.BOLD, 16));
		label_3.setBounds(164, 248, 128, 31);
		add(label_3);
		
		label_4 = new JLabel(" Address :");
		label_4.setFont(new Font("Arial", Font.BOLD, 16));
		label_4.setBounds(209, 207, 92, 31);
		add(label_4);
		
		label_5 = new JLabel(" Name :");
		label_5.setFont(new Font("Arial", Font.BOLD, 16));
		label_5.setBounds(230, 166, 62, 31);
		add(label_5);
		
		label_6 = new JLabel("Surname :");
		label_6.setFont(new Font("Arial", Font.BOLD, 16));
		label_6.setBounds(209, 125, 92, 31);
		add(label_6);
		
		label_7 = new JLabel("ID :");
		label_7.setFont(new Font("Arial", Font.BOLD, 16));
		label_7.setBounds(261, 84, 40, 31);
		add(label_7);
		
		JPanel panelbackground1 = new JPanel();
		panelbackground1.setBorder(new LineBorder(new Color(165, 42, 42), 2));
		panelbackground1.setBackground(new Color(70, 130, 180));
		panelbackground1.setBounds(44, 59, 573, 540);
		add(panelbackground1);
		panelbackground1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setBounds(241, 459, 120, 30);
		panelbackground1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = connection.dbConnector();
					String value1= id.getText() ;
					String value2= surname.getText() ;
	            	String value3= name.getText() ;
	            	String value4= address.getText() ;
	            	String value5= textFieldPhone.getText() ;
	            	String value7= date_of_birth.getText() ;
	            	String value6= sexx.getText() ;
			        String value8= medical_issues.getText() ;
					String sql ="Update customer SET Surname =?,Name =?, Address = ?,Number=?,Sex=?,DOB=?,MedicalIssues=? WHERE ID = ? "; 
			       
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setString(1, value2);
					ps.setString(2, value3);
					ps.setString(3, value4);
					ps.setString(4, value5);
					ps.setString(5, value6);
					ps.setString(6, value7);
					ps.setString(7, value8);
					ps.setString(8, value1);
					
			        
			        
					ps.execute();
			        JOptionPane.showMessageDialog(null, "UPDATED successfully");
			        ps.close();
					
				}catch(Exception e2) {
					 System.out.print(e2);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(127, 255, 0));
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setBounds(428, 459, 100, 30);
		panelbackground1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String Query = "DELETE FROM customer WHERE ID = '"+id.getText()+" ' ";
					PreparedStatement ps = conn.prepareStatement(Query);
					
					

					ps.execute();
					
					
					JOptionPane.showMessageDialog(null, "Record Deleted");
					
				}catch (Exception ex){
					System.out.println("Error: " +ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(127, 255, 0));
		
		JButton insertButton = new JButton("INSERT");
		insertButton.setBounds(78, 459, 100, 30);
		panelbackground1.add(insertButton);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			try {
				conn = connection.dbConnector();

				String sql ="insert into customer values(?, ?, ?, ?, ?, ?, ?, ?)";
		        PreparedStatement pstmt =conn.prepareStatement(sql);
		        pstmt.setString(1, id.getText()) ;
		        pstmt.setString(2, surname.getText()) ;
		        pstmt.setString(3, name.getText()) ;
		        pstmt.setString(4, address.getText()) ;
		        pstmt.setString(5, textFieldPhone.getText()) ;
		        pstmt.setString(7, date_of_birth.getText()) ;
		        pstmt.setString(6, sexx.getText()) ;
		        pstmt.setString(8, medical_issues.getText()) ;
		        
		        pstmt.execute();
		        JOptionPane.showMessageDialog(null, "Inserted successfully");
				
				
			}catch(Exception e1) {
				 System.out.print(e1);
				}
			}
		});
		insertButton.setBackground(new Color(127, 255, 0));
		insertButton.setFont(new Font("Arial", Font.BOLD, 17));

	}
}
