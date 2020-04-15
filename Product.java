import java.awt.BorderLayout;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class Product extends JFrame {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					Product frame = new Product();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	private JPanel contentPane;
	private JTextField textFieldSupplier;
	private JTable table;
	private JTextField textFieldQtyBought;
	private JTextField textFieldBouns;
	private JTextField textFieldWPrice;
	private JTextField textFieldRPrice;
	private JTextField textFieldExit;
	private JTextField textFieldName;
	private JTextField textFieldItemNo;

	/**
	 * Create the frame.
	 */
	public Product() {
		conn = connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(490, 125, 800, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.window, SystemColor.window, SystemColor.window, SystemColor.window));
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(40, 46, 700, 89);
		contentPane.add(panel);
		
		textFieldName = new JTextField();
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {
					
					String query = "SELECT Name,Supplier,QtyBought,Bonus,BoxQty,RPrice,RPrice/BoxQty As UnitPrice FROM product";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textFieldName.setColumns(10);
		textFieldName.setBounds(152, 53, 149, 19);
		panel.add(textFieldName);
		
		JLabel labelName = new JLabel("Name : ");
		labelName.setFont(new Font("Arial", Font.PLAIN, 13));
		labelName.setBounds(98, 53, 51, 24);
		panel.add(labelName);
		
		textFieldItemNo = new JTextField();
		textFieldItemNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {
					
					String query = "SELECT Supplier,WPrice,RPrice,Bonus As UnitPrice FROM product";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textFieldItemNo.setColumns(10);
		textFieldItemNo.setBounds(152, 20, 119, 19);
		panel.add(textFieldItemNo);
		
		JLabel labelItemNo = new JLabel("Item No :");
		labelItemNo.setHorizontalAlignment(SwingConstants.CENTER);
		labelItemNo.setFont(new Font("Arial", Font.PLAIN, 13));
		labelItemNo.setBounds(73, 20, 72, 24);
		panel.add(labelItemNo);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.window, SystemColor.window, SystemColor.window, SystemColor.window));
		panel1.setBackground(SystemColor.activeCaptionBorder);
		panel1.setBounds(40, 145, 700, 300);
		contentPane.add(panel1);
		
		JLabel labelSupplier = new JLabel("Supplier :");
		labelSupplier.setFont(new Font("Arial", Font.PLAIN, 13));
		labelSupplier.setBounds(76, 23, 63, 24);
		panel1.add(labelSupplier);
		
		JButton buttonDelete = new JButton("Delete");
		buttonDelete.setFont(new Font("Arial", Font.BOLD, 12));
		buttonDelete.setBounds(400, 270, 85, 21);
		panel1.add(buttonDelete);
		
		JButton buttonChange = new JButton("Change");
		buttonChange.setFont(new Font("Arial", Font.BOLD, 12));
		buttonChange.setBounds(305, 270, 85, 21);
		panel1.add(buttonChange);
		
		JButton buttonInsert = new JButton("Insert");
		buttonInsert.setFont(new Font("Arial", Font.BOLD, 12));
		buttonInsert.setBounds(210, 270, 85, 21);
		panel1.add(buttonInsert);
		
		textFieldSupplier = new JTextField();
		textFieldSupplier.setColumns(10);
		textFieldSupplier.setBounds(140, 26, 98, 19);
		panel1.add(textFieldSupplier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 123, 643, 137);
		panel1.add(scrollPane);
		
		table = new JTable();	
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Suplier", "WPrice", "RPrice", "Bouns", "BoxQty", "Exp"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		scrollPane.setViewportView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		textFieldQtyBought = new JTextField();
		textFieldQtyBought.setColumns(10);
		textFieldQtyBought.setBounds(140, 60, 56, 19);
		panel1.add(textFieldQtyBought);
		
		JLabel labelQtyBought = new JLabel("Qty Bought :");
		labelQtyBought.setFont(new Font("Arial", Font.PLAIN, 13));
		labelQtyBought.setBounds(58, 57, 101, 24);
		panel1.add(labelQtyBought);
		
		textFieldBouns = new JTextField();
		textFieldBouns.setColumns(10);
		textFieldBouns.setBounds(140, 89, 56, 19);
		panel1.add(textFieldBouns);
		
		JLabel labelBouns = new JLabel("Bouns :");
		labelBouns.setFont(new Font("Arial", Font.PLAIN, 13));
		labelBouns.setBounds(88, 86, 69, 24);
		panel1.add(labelBouns);
		
		JLabel labelWPrice = new JLabel("Wholesale Price :");
		labelWPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		labelWPrice.setBounds(347, 26, 116, 24);
		panel1.add(labelWPrice);
		
		textFieldWPrice = new JTextField();
		textFieldWPrice.setColumns(10);
		textFieldWPrice.setBounds(460, 26, 112, 19);
		panel1.add(textFieldWPrice);
		
		JLabel labelRPrice = new JLabel("Retail Price :");
		labelRPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		labelRPrice.setBounds(375, 60, 83, 24);
		panel1.add(labelRPrice);
		
		textFieldRPrice = new JTextField();
		textFieldRPrice.setColumns(10);
		textFieldRPrice.setBounds(463, 60, 112, 19);
		panel1.add(textFieldRPrice);
		
		textFieldExit = new JTextField();
		textFieldExit.setColumns(10);
		textFieldExit.setBounds(463, 89, 43, 19);
		panel1.add(textFieldExit);
		
		JLabel labelExpiry = new JLabel("Expiry :");
		labelExpiry.setFont(new Font("Arial", Font.PLAIN, 13));
		labelExpiry.setBounds(405, 89, 56, 24);
		panel1.add(labelExpiry);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Arial", Font.BOLD, 12));
		btnOk.setBounds(50, 460, 85, 21);
		contentPane.add(btnOk);
		
		JButton btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Product.this.dispose();
			}
		});
		
		btnClose.setFont(new Font("Arial", Font.BOLD, 12));
		btnClose.setBounds(150, 460, 85, 21);
		contentPane.add(btnClose);
		
		JButton btnStock = new JButton("Stock");
		btnStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  stock stock1 = new stock();
				  stock1.setVisible(true);
			}
		});
		btnStock.setFont(new Font("Arial", Font.BOLD, 14));
		btnStock.setBounds(40, 15, 85, 21);
		contentPane.add(btnStock);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*CustomerClass customer = new CustomerClass();
				customer.setVisible(true);*/
			}
		});
		btnCustomer.setFont(new Font("Arial", Font.BOLD, 11));
		btnCustomer.setBounds(135, 16, 100, 21);
		contentPane.add(btnCustomer);
		
		JButton btnInvoice = new JButton("Invoice");
		btnInvoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search srch = new search();
				srch.setVisible(true);
			}
		});
		btnInvoice.setFont(new Font("Arial", Font.BOLD, 14));
		btnInvoice.setBounds(240, 16, 85, 21);
		contentPane.add(btnInvoice);
	}
}
