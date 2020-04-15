import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;

public class search extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search frame = new search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	private JTextField textFieldSearch;
	private JTable table_1;
	private JTable table_2;
	private JLabel lblSearch;
	private JScrollPane scrollPane_1;
	private JLabel lblInvoice;
	private JButton btnAdd;
	private JTextField textFieldQty;
	/**
	 * Create the frame.
	 */
	public search() {
		conn = connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setForeground(new Color(255, 255, 255));
		scrollPane.setBounds(275, 50, 575, 141);
		scrollPane.getViewport().setBackground(new Color(255,255,255));
		
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ArrayList<Item> product = new ArrayList<>(); 
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
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
		textFieldSearch.setBounds(349, 232, 130, 22);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		table_1 = new JTable();
		table_1.setBounds(148, 322, 1, 1);
		contentPane.add(table_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setForeground(new Color(255, 255, 255));
		scrollPane_1.setBounds(275, 283, 571, 107);
		scrollPane_1.getViewport().setBackground(new Color(255,255,255));
		contentPane.add(scrollPane_1);
		
		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		table_2.setBackground(new Color(255, 255, 255));
		table_2.setShowGrid(false);
		table_2.setShowHorizontalLines(false);
		table_2.setShowVerticalLines(false);
		
		lblSearch = new JLabel("Name");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearch.setBounds(275, 214, 70, 56);
		contentPane.add(lblSearch);
		
		lblInvoice = new JLabel("Invoice");
		lblInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoice.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblInvoice.setBounds(309, 0, 236, 37);
		contentPane.add(lblInvoice);
		
		
		btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Quantity; //To store the value in the textbox
				double UPrice;
				try {
					Quantity = Integer.parseInt(textFieldQty.getText());
					String query = "SELECT * from product where Name = ? ";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, textFieldSearch.getText() );
					
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						Item item = new Item();
						
						item.setQty(Quantity);
						item.setName(rs.getString("Name"));
						item.setRPrice(rs.getDouble("RPrice"));
						item.setBoxQty(rs.getInt("BoxQty"));
						
						product.add(item);
				
						
					}
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				ArrayList <Object[]> inv = new ArrayList<Object[]>();
				for (int i =0;i<product.size();i++) {
					inv.add(new Object[] {
							product.get(i).getQuantity(),
							product.get(i).getName(),
							product.get(i).getUPrice(),
							product.get(i).getPrice()
							
							
							
					});
				}
				table_2.setModel(new DefaultTableModel(inv.toArray(new Object[][] {}),
						new String[] {"Qty", "Name", "UPrice", "Item Total"}));
				
			}
		});
		btnAdd.setBounds(757, 231, 97, 25);
		contentPane.add(btnAdd);
		
		textFieldQty = new JTextField();
		textFieldQty.setBounds(573, 232, 116, 22);
		contentPane.add(textFieldQty);
		textFieldQty.setColumns(10);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQty.setBounds(521, 234, 56, 16);
		contentPane.add(lblQty);
	}
}
