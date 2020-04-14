import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	
	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		conn = connection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(0, 102, 204));
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUsername.setBounds(273, 119, 81, 31);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 102, 204));
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(273, 205, 81, 32);
		frame.getContentPane().add(lblPassword);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(366, 112, 131, 45);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JLabel lblLoginSystem = new JLabel("Login System");
		lblLoginSystem.setForeground(new Color(0, 102, 204));
		lblLoginSystem.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblLoginSystem.setBounds(244, 43, 197, 45);
		frame.getContentPane().add(lblLoginSystem);
		
		JButton btnLogin = new JButton("   Login");
		Image Images = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(Images));
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement pst = null;
				ResultSet rs = null;
				try {
					String query = "select * from users where Username =? and password=? ";
					pst = conn.prepareStatement(query); //parsing query to prepared statement
					pst.setString(1,textFieldUN.getText() );
					pst.setString(2,passwordField.getText() );
					
					rs = pst.executeQuery(); //execute query
					
					int count =0;
					while (rs.next()) {
						count++;
					}
					if (count ==1) { //if only 1 result is obtained
						JOptionPane.showMessageDialog(null, "Username and password is correct");
						frame.dispose();
						search home = new search();
						home.setVisible(true);
					}
					else { //if no result
						JOptionPane.showMessageDialog(null, "Username and password is incorrect");
					}
					
				
				rs.close();
				pst.close();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		btnLogin.setBounds(284, 291, 157, 45);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(366, 199, 131, 45);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		label.setBounds(56, 147, 56, 16);
		frame.getContentPane().add(label);
		
		JLabel lbllogin = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/MainLogo.png")).getImage();
		lbllogin.setIcon(new ImageIcon(img2));
		
		lbllogin.setBounds(12, 61, 197, 262);
		frame.getContentPane().add(lbllogin);
	}

}
