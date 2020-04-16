//import java.awt.BorderLayout;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

public class search extends JFrame {



	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel DateLbl;
	private JLabel TimeLbl;
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
	private JPanel menu;
	private JLabel lblMenu;
	private JButton buttonStock;
	private JButton buttonCustomer;
	private JButton buttonProduct;
	private JButton btnNewButton;
	
	

	
	
	/**
	 * Create the frame.
	 */
	public search() {

		setTitle("Create Invoice");
		setIconImage(Toolkit.getDefaultToolkit().getImage(search.class.getResource("/Images/Invoice.png")));
		conn = connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 125, 900, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setForeground(new Color(255, 255, 255));
		scrollPane.setBounds(275, 75, 575, 141);
		scrollPane.getViewport().setBackground(new Color(255,255,255));
		
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setBackground(Color.CYAN);
		scrollPane.setViewportView(table); 
		
		ArrayList<Item> product = new ArrayList<>();  
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {
					
					String query = "SELECT Name,Supplier,QtyBought,Bonus,BoxQty,WPrice,RPrice/BoxQty As UnitPrice FROM product";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		


		textFieldSearch.setBounds(360, 240, 130, 22);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		table_1 = new JTable();
		table_1.setBounds(148, 322, 1, 1);
		contentPane.add(table_1);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBounds(269, 267, 583, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 16, 571, 158);
		panel.add(scrollPane_1);
		scrollPane_1.setForeground(Color.WHITE);
		scrollPane_1.getViewport().setBackground(new Color(255,255,255));
		
		table_2 = new JTable();
		table_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table_2.setBorder(new LineBorder(Color.RED, 2, true));
		table_2.setShowGrid(false);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_1.setViewportView(table_2);
		table_2.setBackground(Color.CYAN);
		table_2.setShowHorizontalLines(false);
		table_2.setShowVerticalLines(false);
		
		lblSearch = new JLabel("Name :");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearch.setBounds(295, 222, 54, 56);
		contentPane.add(lblSearch);
		
		lblInvoice = new JLabel("Invoice");
		lblInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoice.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblInvoice.setBounds(450, 25, 236, 37);
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
						
						
						item.setName(rs.getString("Name"));
						item.setQty(Quantity);
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
		
		btnAdd.setBounds(740, 239, 97, 25);
		contentPane.add(btnAdd);
		
		textFieldQty = new JTextField();
		textFieldQty.setBounds(570, 240, 116, 22);
		contentPane.add(textFieldQty);
		textFieldQty.setColumns(10);
		
		JLabel lblQty = new JLabel("Qty :");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQty.setBounds(525, 242, 38, 16);
		contentPane.add(lblQty);
		
		JPanel panelbackgroundInvoice = new JPanel();
		panelbackgroundInvoice.setBorder(new LineBorder(SystemColor.window, 3));
		panelbackgroundInvoice.setBackground(SystemColor.controlShadow);
		panelbackgroundInvoice.setBounds(250, 15, 624, 429);
		contentPane.add(panelbackgroundInvoice);
		panelbackgroundInvoice.setLayout(null);
		
		menu = new JPanel();
		menu.setBorder(new LineBorder(SystemColor.desktop, 2));
		menu.setBackground(SystemColor.activeCaption);
		menu.setBounds(25, 15, 192, 429);
		contentPane.add(menu);
		menu.setLayout(null);
		
		lblMenu = new JLabel("Menu");
		lblMenu.setForeground(new Color(0, 0, 255));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Arial", Font.BOLD, 21));
		lblMenu.setBounds(22, 22, 145, 45);
		menu.add(lblMenu);
		
		buttonStock = new JButton("Stock");
		buttonStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stock stock1 = new stock();
				stock1.setVisible(true);
			}
		});
		buttonStock.setFont(new Font("Arial", Font.BOLD, 15));
		buttonStock.setBounds(42, 98, 95, 30);
		menu.add(buttonStock);
		
		buttonCustomer = new JButton("Customer");
		buttonCustomer.setFont(new Font("Arial", Font.BOLD, 13));
		buttonCustomer.setBounds(40, 198, 105, 30);
		menu.add(buttonCustomer);
		
		buttonProduct = new JButton("Product");
		buttonProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Product product = new Product();
				product.setVisible(true);
			}
		});
		buttonProduct.setFont(new Font("Arial", Font.BOLD, 15));
		buttonProduct.setBounds(42, 308, 95, 30);
		menu.add(buttonProduct);
		
		btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String printdata = panel.getUIClassID();
				PrinterJob job = PrinterJob.getPrinterJob();
				boolean doprint = job.printDialog();
				if(doprint) {
					try {
						
						job.print();
						
					}catch(PrinterException e2){
						
					}
				}
			}
		});
		btnNewButton.setBounds(761, 450, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

					  int rows=table_2.getRowCount();
					  
					  for(int row = 0; row<rows; row++)
					  {   
					    Integer Qty = (Integer)table_2.getValueAt(row, 0);
					    String Name = (String) table_2.getValueAt(row, 1);
					    Double uPrice = (Double)table_2.getValueAt(row, 2);
					    Double ItemTotal = (Double)table_2.getValueAt(row, 3);
					    
					    String queryco = "INSERT INTO `invoicerecords`(`Qty`, `Name`, `UPrice`, `Item Total`) VALUES ('"+Qty+"','"+Name+"','"+uPrice+"','"+ItemTotal+"')";

					    PreparedStatement pst = conn.prepareStatement(queryco);
					    pst.execute();     
					  }
					  
					}
					catch(SQLException exe){
						exe.printStackTrace();
					}
				
				search.this.dispose();
			}
			
				
			
		});
		btnNewButton_1.setBounds(656, 450, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
