import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelProduct extends JPanel {
	
	private Image img_product = new ImageIcon(Homescreen.class.getResource("Images/Product.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
	
	
	
	Connection conn = null;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldSupplier;
	private JTextField textFieldBoxQty;
	private JTextField textFieldExpiry;
	private JTextField textFieldRPrice;
	private JTextField textFieldBonus;
	private JTextField textFieldQuantity;
	private JTextField textFieldWPrice;
	private JTextField textFieldDelete;
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	
	public PanelProduct() {
		
		
		
		
		conn = connection.dbConnector();
		setBackground(new Color(255, 228, 181));
		setBorder(new LineBorder(new Color(50, 205, 50), 3));		
		setBounds(0, 0, 872, 630);
		setLayout(null);
		
		
		JLabel lblProductID = new JLabel("Product ID :");
		lblProductID.setFont(new Font("Arial", Font.BOLD, 15));
		lblProductID.setBounds(55, 100, 90, 25);
		add(lblProductID);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setFont(new Font("Arial", Font.BOLD, 15));
		lblQuantity.setBounds(70, 160, 75, 25);
		add(lblQuantity);
		
		JLabel lblWPrice = new JLabel("W.Price :");
		lblWPrice.setFont(new Font("Arial", Font.BOLD, 15));
		lblWPrice.setBounds(70, 221, 75, 25);
		add(lblWPrice);
		
		textFieldID = new JTextField();
		textFieldID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				ShowData();
			}
		});
		textFieldID.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldID.setBounds(145, 100, 100, 25);
		add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(145, 160, 100, 25);
		add(textFieldQuantity);
		
		textFieldWPrice = new JTextField();
		textFieldWPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldWPrice.setColumns(10);
		textFieldWPrice.setBounds(145, 221, 100, 25);
		add(textFieldWPrice);
		
		JPanel panelbackground1 = new JPanel();
		panelbackground1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(50, 205, 50), new Color(255, 0, 0)));
		panelbackground1.setBackground(new Color(176, 196, 222));
		panelbackground1.setBounds(29, 60, 811, 541);
		add(panelbackground1);
		panelbackground1.setLayout(null);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveToDatabase();
				ShowData();
			}
		});
		btnAddProduct.setBounds(90, 207, 140, 40);
		panelbackground1.add(btnAddProduct);
		btnAddProduct.setBackground(new Color(51,204,102));
		btnAddProduct.setForeground(new Color(0, 0, 0));
		btnAddProduct.setFont(new Font("Arial", Font.PLAIN, 17));
		
		JLabel lblSelectaproduct = new JLabel("Select a product to update it:");
		lblSelectaproduct.setFont(new Font("Arial", Font.BOLD, 18));
		lblSelectaproduct.setBounds(35, 280, 260, 25);
		panelbackground1.add(lblSelectaproduct);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateDatabase();
				ShowData();
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 17));
		btnUpdate.setBackground(new Color(51,204,102));
		btnUpdate.setBounds(90, 315, 150, 40);
		panelbackground1.add(btnUpdate);
		
		JLabel lblEnterIdOf = new JLabel("Enter ID of product to deleted :");
		lblEnterIdOf.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterIdOf.setBounds(35, 380, 280, 35);
		panelbackground1.add(lblEnterIdOf);
		
		textFieldDelete = new JTextField();
		textFieldDelete.setBounds(110, 420, 100, 25);
		panelbackground1.add(textFieldDelete);
		textFieldDelete.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteData();
				ShowData();
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDelete.setBackground(new Color(51,204,102));
		btnDelete.setBounds(90, 459, 150, 40);
		panelbackground1.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 205, 447, 308);
		panelbackground1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(221, 160, 221));
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DisplayFromTable();
			}
		});
		scrollPane.setViewportView(table);
		
		textFieldSupplier = new JTextField();
		textFieldSupplier.setBounds(630, 38, 150, 25);
		panelbackground1.add(textFieldSupplier);
		textFieldSupplier.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldSupplier.setColumns(10);
		
		JLabel lblSupplier = new JLabel("Supplier :");
		lblSupplier.setBounds(555, 41, 75, 25);
		panelbackground1.add(lblSupplier);
		lblSupplier.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblBoxQty = new JLabel("Box Quantity :");
		lblBoxQty.setBounds(520, 99, 110, 25);
		panelbackground1.add(lblBoxQty);
		lblBoxQty.setFont(new Font("Arial", Font.BOLD, 15));
		
		textFieldBoxQty = new JTextField();
		textFieldBoxQty.setBounds(630, 99, 100, 25);
		panelbackground1.add(textFieldBoxQty);
		textFieldBoxQty.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldBoxQty.setColumns(10);
		
		textFieldExpiry = new JTextField();
		textFieldExpiry.setBounds(630, 160, 100, 25);
		panelbackground1.add(textFieldExpiry);
		textFieldExpiry.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldExpiry.setColumns(10);
		
		JLabel lblExpiry = new JLabel("Expiry Date :");
		lblExpiry.setBounds(530, 160, 100, 25);
		panelbackground1.add(lblExpiry);
		lblExpiry.setFont(new Font("Arial", Font.BOLD, 15));
		
		textFieldName = new JTextField();
		textFieldName.setBounds(353, 37, 150, 25);
		panelbackground1.add(textFieldName);
		textFieldName.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldName.setColumns(10);
		
		textFieldBonus = new JTextField();
		textFieldBonus.setBounds(353, 98, 100, 25);
		panelbackground1.add(textFieldBonus);
		textFieldBonus.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldBonus.setColumns(10);
		
		textFieldRPrice = new JTextField();
		textFieldRPrice.setBounds(353, 159, 100, 25);
		panelbackground1.add(textFieldRPrice);
		textFieldRPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldRPrice.setColumns(10);
		
		JLabel lblRPrice = new JLabel("R.Price :");
		lblRPrice.setBounds(290, 159, 75, 25);
		panelbackground1.add(lblRPrice);
		lblRPrice.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblBouns = new JLabel("Bouns :");
		lblBouns.setBounds(295, 98, 75, 25);
		panelbackground1.add(lblBouns);
		lblBouns.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(300, 36, 75, 25);
		panelbackground1.add(lblName);
		lblName.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblNAME = new JLabel("PRODUCTS");
		lblNAME.setForeground(new Color(255, 0, 0));
		lblNAME.setBackground(new Color(0, 255, 0));
		lblNAME.setHorizontalAlignment(SwingConstants.CENTER);
		lblNAME.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 29));
		lblNAME.setBounds(370, 21, 178, 31);
		add(lblNAME);
		
		JLabel lblimage = new JLabel("");
		lblimage.setHorizontalAlignment(SwingConstants.CENTER);
		lblimage.setBounds(280, 4, 105, 55);
		lblimage.setIcon(new ImageIcon(img_product));
		add(lblimage);
		
		
		
		
		

	}
	
	
	
	
	private void saveToDatabase() {
		Connection conn = connection.dbConnector();
		int Qty,Bonus,Stock;
		try {
			Qty = Integer.parseInt(textFieldQuantity.getText());
			Bonus = Integer.parseInt(textFieldBonus.getText());
			Stock = Qty + Bonus;
			String Query = "INSERT INTO product VALUES(?,?,?,?,?,?,?,?,?,?)";
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
			ps.setString(10, Integer.toString(Stock));
			
	
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Product  saved successfully");
			
		}catch (Exception e){
			System.out.println("Error: " +e);
		}
	}
	
	private void ShowData() {
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
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(40);
			table.getColumnModel().getColumn(4).setPreferredWidth(40);
			table.getColumnModel().getColumn(5).setPreferredWidth(40);
			table.getColumnModel().getColumn(6).setPreferredWidth(55);
			table.getColumnModel().getColumn(7).setPreferredWidth(55);
			table.getColumnModel().getColumn(8).setPreferredWidth(40);
			table.getColumnModel().getColumn(9).setPreferredWidth(50);
			
			
			
			
		} catch(Exception e1) {
			System.out.println("Error: " + e1);
		}
	}
	private void UpdateDatabase() {
		Connection conn = connection.dbConnector();
		int Qty,Bonus,Stock;
		try {
			Qty = Integer.parseInt(textFieldQuantity.getText());
			Bonus = Integer.parseInt(textFieldBonus.getText());
			Stock = Qty + Bonus;
			String Query = "UPDATE product SET Name=?,Supplier=?,QtyBought=?,Bonus=?,BoxQty=?,WPrice=?,RPrice=?,Exp=?,Stock=? WHERE ItemNO =? ";
			
			PreparedStatement ps = conn.prepareStatement(Query);
			
			ps.setString(1, textFieldName.getText());
			ps.setString(2, textFieldSupplier.getText());
			ps.setString(3, textFieldQuantity.getText());
			ps.setString(4, textFieldBonus.getText());
			ps.setString(5, textFieldBoxQty.getText());
			ps.setString(6, textFieldWPrice.getText());
			ps.setString(7, textFieldRPrice.getText());
			ps.setString(8, textFieldExpiry.getText());
			ps.setString(9, Integer.toString(Stock));
			ps.setString(10, textFieldID.getText());

			
			
			
			
	
			ps.execute();
			
			
			JOptionPane.showMessageDialog(null, "Product  updated successfully");
			
		}catch (Exception e){
			System.out.println("Error: " +e);
		}
	}
	private void DeleteData() {
		try {
			
			String Query = "DELETE FROM product WHERE ItemNO = '"+textFieldDelete.getText()+" ' ";
			PreparedStatement ps = conn.prepareStatement(Query);
			
			ps.execute();
			
			
			JOptionPane.showMessageDialog(null, "Product Deleted");
			
		}catch (Exception e){
			System.out.println("Error: " +e);
		}
	}
	private void DisplayFromTable() {
		try {
			int row = table.getSelectedRow();
			String PID = (table.getModel().getValueAt(row, 0)).toString();
			
			String query = "SELECT * FROM product WHERE ItemNO='" +PID+ "' ";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				textFieldID.setText(rs.getString("ItemNO"));
				textFieldName.setText(rs.getString("Name"));
				textFieldSupplier.setText(rs.getString("Supplier"));
				textFieldQuantity.setText(rs.getString("QtyBought"));
				textFieldBonus.setText(rs.getString("Bonus"));
				textFieldBoxQty.setText(rs.getString("BoxQty"));
				textFieldWPrice.setText(rs.getString("WPrice"));
				textFieldRPrice.setText(rs.getString("RPrice"));
				textFieldExpiry.setText(rs.getString("Exp"));
				
			}
			ps.close();
			
			
		} catch(Exception e1) {
			System.out.println("Error: " + e1);
		}
		
	}
	

}
