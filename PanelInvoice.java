import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class PanelInvoice extends JPanel {
	
	private Image img_invoice = new ImageIcon(Homescreen.class.getResource("Images/Invoice.png")).getImage().getScaledInstance(85, 55, Image.SCALE_SMOOTH);
	
	private JTable table;

	/**
	 * Create the panel.
	 */
	Connection conn = null;
	private JTextField textFieldSearch;
	private JTextField textFieldQty;
	private JTable table_2;
	private JTable table_1;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldSuppplier;
	private JTextField textFieldQty1;
	private JTextField textFieldBonus;
	private JTextField textFieldBoxQty;
	private JTextField textFieldWPrice;
	private JTextField textFieldRPrice;
	private JTextField textFieldExp;
	
	public PanelInvoice() {
		setForeground(new Color(255, 204, 102));
		setBorder(new LineBorder(new Color(255, 215, 0), 3));
		setBackground(new Color(153, 204, 102));
		conn = connection.dbConnector();
		setBounds(0, 0, 872, 630);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();		
		scrollPane.setBounds(45, 105, 473, 199);		
		scrollPane.setToolTipText("");
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setForeground(new Color(255, 255, 255));
		scrollPane.getViewport().setBackground(new Color(255,255,255));
		add(scrollPane);
		
		
		
		table = new JTable();
		table.setBackground(new Color(255, 160, 122));
		scrollPane.setViewportView(table);
		
		JLabel lblname = new JLabel("NAME :");
		lblname.setFont(new Font("Arial", Font.BOLD, 15));
		lblname.setHorizontalAlignment(SwingConstants.LEFT);
		lblname.setBounds(72, 350, 75, 25);
		add(lblname);
		
		ArrayList<Item> product = new ArrayList<>(); 
		
		textFieldSearch = new JTextField();
		textFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldSearch.setBounds(130, 350, 120, 25);
		
		textFieldSearch.addKeyListener(new KeyAdapter() {
			/*@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {
					
					String query = "SELECT ItemNo,Name,Supplier,QtyBought,Bonus,BoxQty,RPrice,RPrice/BoxQty As UnitPrice FROM product";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
			@Override
			public void keyPressed(KeyEvent e) {
				showData();
			}
		});
		textFieldSearch.setColumns(10);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		textFieldQty = new JTextField();
		textFieldQty.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldQty.setBounds(360, 350, 120, 25);
		add(textFieldQty);
		textFieldQty.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(45, 420, 283, 140);
		add(scrollPane_1);
		
		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		table_2.setBackground(new Color(255, 140, 0));
		table_2.setShowGrid(false);
		table_2.setShowHorizontalLines(false);
		table_2.setShowVerticalLines(false);
		
		JPanel panelbackgroundcolour = new JPanel();
		panelbackgroundcolour.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 0)));
		panelbackgroundcolour.setBackground(SystemColor.activeCaptionBorder);
		panelbackgroundcolour.setBounds(24, 56, 512, 548);
		add(panelbackgroundcolour);
		panelbackgroundcolour.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
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
					
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				showData();
				textFieldSearch.setText("");
				textFieldQty.setText("");
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
		btnAdd.setBackground(new Color(51, 204, 102));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
		btnAdd.setBounds(356, 420, 100, 25);
		panelbackgroundcolour.add(btnAdd);
		
		JLabel lblQty = new JLabel("  QTY :");
		lblQty.setBounds(285, 295, 60, 25);
		panelbackgroundcolour.add(lblQty);
		lblQty.setFont(new Font("Arial", Font.BOLD, 15));
		lblQty.setHorizontalAlignment(SwingConstants.LEFT);
		
				
			
		
		table_1 = new JTable();
		table_1.setBounds(0, 0, 1, 1);
		add(table_1);
		
		

		
		
		JLabel labelname = new JLabel("INVOICE");
		labelname.setForeground(new Color(0, 0, 128));
		labelname.setHorizontalAlignment(SwingConstants.CENTER);
		labelname.setFont(new Font("Arial", Font.BOLD, 24));
		labelname.setBounds(374, 10, 190, 40);
		add(labelname);
		
		JLabel labelimage = new JLabel("");
		labelimage.setHorizontalAlignment(SwingConstants.CENTER);
		labelimage.setBounds(317, 0, 105, 55);
		labelimage.setIcon(new ImageIcon(img_invoice));
		add(labelimage);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBorder(new MatteBorder(3, 0, 3, 3, (Color) new Color(128, 0, 0)));
		panel.setBounds(536, 56, 308, 548);
		add(panel);
		panel.setLayout(null);
		
		JButton btnInsert = new JButton("Inserct Product");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveDB();
			}
		});
		btnInsert.setBackground(new Color(51, 204, 102));
		btnInsert.setFont(new Font("Arial", Font.BOLD, 15));
		btnInsert.setBounds(75, 432, 160, 25);
		panel.add(btnInsert);
		
		JLabel lblNewProduct = new JLabel("New Product");
		lblNewProduct.setBackground(new Color(255, 255, 255));
		lblNewProduct.setForeground(new Color(205, 133, 63));
		lblNewProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewProduct.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblNewProduct.setBounds(91, 30, 140, 36);
		panel.add(lblNewProduct);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(150, 92, 116, 22);
		panel.add(textFieldID);
		
		JLabel lblId = new JLabel("Product ID :");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(52, 96, 100, 16);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(90, 128, 57, 16);
		panel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(150, 124, 116, 22);
		panel.add(textFieldName);
		
		textFieldSuppplier = new JTextField();
		textFieldSuppplier.setColumns(10);
		textFieldSuppplier.setBounds(150, 156, 116, 22);
		panel.add(textFieldSuppplier);
		
		JLabel lblSupplier = new JLabel("Supplier :");
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSupplier.setBounds(70, 160, 75, 16);
		panel.add(lblSupplier);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantity.setBounds(69, 191, 85, 16);
		panel.add(lblQuantity);
		
		textFieldQty1 = new JTextField();
		textFieldQty1.setColumns(10);
		textFieldQty1.setBounds(150, 188, 116, 22);
		panel.add(textFieldQty1);
		
		textFieldBonus = new JTextField();
		textFieldBonus.setColumns(10);
		textFieldBonus.setBounds(150, 220, 116, 22);
		panel.add(textFieldBonus);
		
		JLabel lblBonus = new JLabel("Bouns :");
		lblBonus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBonus.setBounds(89, 226, 75, 16);
		panel.add(lblBonus);
		
		JLabel lblBoxQuantity = new JLabel("Box Quantity :");
		lblBoxQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBoxQuantity.setBounds(37, 256, 120, 16);
		panel.add(lblBoxQuantity);
		
		textFieldBoxQty = new JTextField();
		textFieldBoxQty.setColumns(10);
		textFieldBoxQty.setBounds(150, 252, 116, 22);
		panel.add(textFieldBoxQty);
		
		textFieldWPrice = new JTextField();
		textFieldWPrice.setColumns(10);
		textFieldWPrice.setBounds(150, 284, 116, 22);
		panel.add(textFieldWPrice);
		
		JLabel lblWprice = new JLabel("W.Price :");
		lblWprice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWprice.setBounds(76, 286, 75, 16);
		panel.add(lblWprice);
		
		JLabel lblRprice = new JLabel("R.Price :");
		lblRprice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRprice.setBounds(81, 321, 75, 16);
		panel.add(lblRprice);
		
		textFieldRPrice = new JTextField();
		textFieldRPrice.setColumns(10);
		textFieldRPrice.setBounds(150, 316, 116, 22);
		panel.add(textFieldRPrice);
		
		textFieldExp = new JTextField();
		textFieldExp.setColumns(10);
		textFieldExp.setBounds(150, 348, 116, 22);
		panel.add(textFieldExp);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date :");
		lblExpiryDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExpiryDate.setBounds(48, 352, 100, 16);
		panel.add(lblExpiryDate);
	}
		
		private void showData() {
			Connection conn = connection.dbConnector();
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Name");
			model.addColumn("Supplier");
			model.addColumn("Qty");
			model.addColumn("Bonus");
			model.addColumn("BoxQty");
			model.addColumn("W.Price");
			model.addColumn("R.Price");
			model.addColumn("Expiry");
			model.addColumn("Stock");
			
			try {
				
				String query = "SELECT * FROM product";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {
					
					model.addRow(new Object[] {
							rs.getString("ItemNO"),
							rs.getString("Name"),
							rs.getString("Supplier"),
							rs.getString("QtyBought"),
							rs.getString("Bonus"),
							rs.getString("BoxQty"),
							rs.getString("WPrice"),
							rs.getString("RPrice"),
							rs.getString("Exp"),
							rs.getString("Stock"),
							
							
					});
				}
				rs.close();
				st.close();
				conn.close();
				
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(1).setPreferredWidth(120);
				table.getColumnModel().getColumn(2).setPreferredWidth(120);
				table.getColumnModel().getColumn(3).setPreferredWidth(50);
				table.getColumnModel().getColumn(4).setPreferredWidth(50);
				table.getColumnModel().getColumn(5).setPreferredWidth(60);
				table.getColumnModel().getColumn(6).setPreferredWidth(60);
				table.getColumnModel().getColumn(7).setPreferredWidth(60);
				table.getColumnModel().getColumn(8).setPreferredWidth(60);
				table.getColumnModel().getColumn(9).setPreferredWidth(60);
				
				
				
				
			} catch(Exception e1) {
				System.out.println("Error: " + e1);
			}
	}
		
		private void saveDB() {
			try {
				Connection conn = connection.dbConnector();
				int Qty,Bonus,Stock,BoxQty;
				Qty = Integer.parseInt(textFieldQty1.getText());
				Bonus = Integer.parseInt(textFieldBonus.getText());
				BoxQty = Integer.parseInt(textFieldBoxQty.getText());
				Stock = (Qty * BoxQty) + (Bonus * BoxQty);
				String Query = "INSERT INTO product VALUES(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(Query);
				ps.setString(1, textFieldID.getText());
				ps.setString(2, textFieldName.getText());
				ps.setString(3, textFieldSuppplier.getText());
				ps.setString(4, textFieldQty1.getText());
				ps.setString(5, textFieldBonus.getText());
				ps.setString(6, textFieldBoxQty.getText());
				ps.setString(7, textFieldWPrice.getText());
				ps.setString(8, textFieldRPrice.getText());
				ps.setString(9, textFieldExp.getText());
				ps.setString(10, Integer.toString(Stock));
				
		
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Product  saved successfully");
				showData();
					
				}catch (Exception e){
					System.out.println("Error: " +e);
				}
		}

		
}
