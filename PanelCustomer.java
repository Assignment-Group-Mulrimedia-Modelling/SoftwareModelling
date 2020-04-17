import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class PanelCustomer extends JPanel {
	
	private Image img_customer = new ImageIcon(Homescreen.class.getResource("Images/Customer.png")).getImage().getScaledInstance(85, 55, Image.SCALE_SMOOTH);
	
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
	private JLabel lblCustomers;
	private JLabel lblimage;

	/**
	 * Create the panel.
	 */
	public PanelCustomer() {
		setBackground(new Color(128, 128, 128));
		setBorder(new LineBorder(new Color(153, 204, 0), 3));
		
		setBounds(0, 0, 872, 630);
		setLayout(null);
		
		JPanel panelbackground1 = new JPanel();
		panelbackground1.setBorder(new LineBorder(new Color(165, 42, 42), 2));
		panelbackground1.setBackground(SystemColor.inactiveCaption);
		panelbackground1.setBounds(30, 59, 809, 540);
		add(panelbackground1);
		panelbackground1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(353, 458, 120, 30);
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
		btnNewButton_1.setBackground(new Color(51, 204, 102));
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(540, 458, 100, 30);
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
		btnNewButton.setBackground(new Color(51, 204, 102));
		
		JButton insertButton = new JButton("Insert");
		insertButton.setBounds(190, 458, 100, 30);
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
		insertButton.setBackground(new Color(51, 204, 102));
		insertButton.setFont(new Font("Arial", Font.BOLD, 17));
		
		label_7 = new JLabel("ID :");
		label_7.setBounds(307, 27, 40, 31);
		panelbackground1.add(label_7);
		label_7.setFont(new Font("Arial", Font.BOLD, 16));
		
		label_6 = new JLabel("Surname :");
		label_6.setBounds(255, 68, 92, 31);
		panelbackground1.add(label_6);
		label_6.setFont(new Font("Arial", Font.BOLD, 16));
		
		label_5 = new JLabel(" Name :");
		label_5.setBounds(276, 109, 62, 31);
		panelbackground1.add(label_5);
		label_5.setFont(new Font("Arial", Font.BOLD, 16));
		
		label_4 = new JLabel(" Address :");
		label_4.setBounds(255, 150, 92, 31);
		panelbackground1.add(label_4);
		label_4.setFont(new Font("Arial", Font.BOLD, 16));
		
		label_3 = new JLabel("Phone Number :");
		label_3.setBounds(210, 191, 128, 31);
		panelbackground1.add(label_3);
		label_3.setFont(new Font("Arial", Font.BOLD, 16));
		
		label_2 = new JLabel("Sex :");
		label_2.setBounds(298, 237, 49, 31);
		panelbackground1.add(label_2);
		label_2.setFont(new Font("Arial", Font.BOLD, 16));
		
		label_1 = new JLabel("Date of Birth :");
		label_1.setBounds(231, 278, 116, 31);
		panelbackground1.add(label_1);
		label_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		label = new JLabel(" Medical Issues :");
		label.setBounds(210, 327, 137, 31);
		panelbackground1.add(label);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		
		medical_issues = new JTextField();
		medical_issues.setBounds(357, 327, 203, 67);
		panelbackground1.add(medical_issues);
		medical_issues.setColumns(10);
		
		date_of_birth = new JTextField();
		date_of_birth.setBounds(357, 286, 203, 27);
		panelbackground1.add(date_of_birth);
		date_of_birth.setColumns(10);
		
		sexx = new JTextField();
		sexx.setBounds(357, 241, 203, 27);
		panelbackground1.add(sexx);
		sexx.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(357, 196, 203, 27);
		panelbackground1.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		address = new JTextField();
		address.setBounds(357, 155, 203, 27);
		panelbackground1.add(address);
		address.setColumns(10);
		
		name = new JTextField();
		name.setBounds(357, 114, 203, 27);
		panelbackground1.add(name);
		name.setColumns(10);
		
		surname = new JTextField();
		surname.setBounds(357, 73, 203, 27);
		panelbackground1.add(surname);
		surname.setColumns(10);
		
		id = new JTextField();
		id.setBounds(357, 31, 203, 27);
		panelbackground1.add(id);
		id.setColumns(10);
		
		lblCustomers = new JLabel("CUSTOMERS");
		lblCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers.setForeground(new Color(255, 255, 0));
		lblCustomers.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 29));
		lblCustomers.setBackground(Color.GREEN);
		lblCustomers.setBounds(370, 18, 200, 31);
		add(lblCustomers);
		
		lblimage = new JLabel("");
		lblimage.setHorizontalAlignment(SwingConstants.CENTER);
		lblimage.setBounds(280, 4, 105, 55);
		lblimage.setIcon(new ImageIcon(img_customer));
		add(lblimage);

	}
}
