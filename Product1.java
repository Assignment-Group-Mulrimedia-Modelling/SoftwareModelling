import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Product1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product1 frame = new Product1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	private JTextField textFieldName;
	private JTextField textFieldBonus;
	private JTextField textFieldRPrice;
	private JTextField textFieldSupplier;
	private JTextField textFieldBoxQty;
	private JTextField textFieldExpiry;
	private JTextField textFieldQuantity;
	private JTextField textFieldWPrice;
	private JTextField textFieldID;
	private JLabel lblProductId;

	/**
	 * Create the frame.
	 */
	public Product1() {
		conn = connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(258, 43, 56, 16);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(337, 40, 116, 22);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblBonus = new JLabel("Bonus");
		lblBonus.setBounds(258, 93, 56, 16);
		contentPane.add(lblBonus);
		
		JLabel lblRPrice = new JLabel("R.Price");
		lblRPrice.setBounds(251, 143, 74, 16);
		contentPane.add(lblRPrice);
		
		textFieldBonus = new JTextField();
		textFieldBonus.setBounds(337, 90, 116, 22);
		contentPane.add(textFieldBonus);
		textFieldBonus.setColumns(10);
		
		textFieldRPrice = new JTextField();
		textFieldRPrice.setBounds(337, 140, 116, 22);
		contentPane.add(textFieldRPrice);
		textFieldRPrice.setColumns(10);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setBounds(508, 43, 56, 16);
		contentPane.add(lblSupplier);
		
		JLabel lblBoxQty = new JLabel("Box Quantity");
		lblBoxQty.setBounds(488, 93, 74, 16);
		contentPane.add(lblBoxQty);
		
		JLabel lblExpiry = new JLabel("Expiry Date");
		lblExpiry.setBounds(497, 143, 74, 16);
		contentPane.add(lblExpiry);
		
		textFieldSupplier = new JTextField();
		textFieldSupplier.setBounds(596, 40, 116, 22);
		contentPane.add(textFieldSupplier);
		textFieldSupplier.setColumns(10);
		
		textFieldBoxQty = new JTextField();
		textFieldBoxQty.setBounds(596, 90, 116, 22);
		contentPane.add(textFieldBoxQty);
		textFieldBoxQty.setColumns(10);
		
		textFieldExpiry = new JTextField();
		textFieldExpiry.setBounds(596, 140, 116, 22);
		contentPane.add(textFieldExpiry);
		textFieldExpiry.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(24, 93, 56, 16);
		contentPane.add(lblQuantity);
		
		JLabel lblWPrice = new JLabel("W.Price");
		lblWPrice.setBounds(24, 143, 56, 16);
		contentPane.add(lblWPrice);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(92, 90, 116, 22);
		contentPane.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		textFieldWPrice = new JTextField();
		textFieldWPrice.setBounds(92, 140, 116, 22);
		contentPane.add(textFieldWPrice);
		textFieldWPrice.setColumns(10);
		
		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveToDatabase();
			}
		});
		btnAddProduct.setBackground(new Color(255, 255, 255));
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddProduct.setForeground(new Color(144, 238, 144));
		btnAddProduct.setBounds(309, 192, 128, 25);
		contentPane.add(btnAddProduct);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(92, 40, 116, 22);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(12, 43, 68, 16);
		contentPane.add(lblProductId);
	}
	
	private void saveToDatabase() {
		Connection conn = connection.dbConnector();
		int Qty,Bonus,Stock;
		try {
			Qty = Integer.parseInt(textFieldQuantity.getText());
			Bonus = Integer.parseInt(textFieldBonus.getText());
			Stock = Qty + Bonus;
			String Query = "INSERT INTO product VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(Query);
			ps.setString(1, textFieldID.getText());
			ps.setString(2, textFieldName.getText());
			ps.setString(3, textFieldSupplier.getText());
			ps.setString(4, textFieldQuantity.getText());
			ps.setString(5, textFieldBonus.getText());
			ps.setString(6, textFieldBoxQty.getText());
			ps.setString(7, textFieldWPrice.getText());
			ps.setString(8, textFieldRPrice.getText());
			ps.setString(9, textFieldExpiry.getText());
	
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Product  saved successfully");
			
		}catch (Exception e){
			System.out.println("Error: " +e);
		}
	}
}
