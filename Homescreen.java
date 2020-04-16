import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Homescreen extends JFrame {
	
	private JPanel contentPane;
	private JPanel panelProduct;
	
	private Image img_mainlogo = new ImageIcon(Homescreen.class.getResource("Images/MainLogo.png")).getImage().getScaledInstance(200, 160, Image.SCALE_SMOOTH);	
	private Image img_home = new ImageIcon(Homescreen.class.getResource("Images/home.png")).getImage().getScaledInstance(58, 58, Image.SCALE_SMOOTH);
	private Image img_transaction = new ImageIcon(Homescreen.class.getResource("Images/transaction.png")).getImage().getScaledInstance(58, 58, Image.SCALE_SMOOTH);
	private Image img_invoice = new ImageIcon(Homescreen.class.getResource("Images/Invoice.png")).getImage().getScaledInstance(58, 58, Image.SCALE_SMOOTH);
	private Image img_product = new ImageIcon(Homescreen.class.getResource("Images/Product.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	private Image img_customer = new ImageIcon(Homescreen.class.getResource("Images/Customer.png")).getImage().getScaledInstance(55, 50, Image.SCALE_SMOOTH);
	private Image img_signout = new ImageIcon(Homescreen.class.getResource("Images/Exit.png")).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	

	
	
	
	private PanelHome panelHome;
	private PanelTransaction panelTransaction;
	private PanelInvoice panelInvoice;
	private PanelProduct panelProducts;
	private PanelCustomer panelCustomer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homescreen frame = new Homescreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Homescreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1000, 650);		
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelHome = new PanelHome();
		panelTransaction = new PanelTransaction();
		panelInvoice = new PanelInvoice();
		panelProduct = new PanelProduct();
		panelCustomer = new PanelCustomer();
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBorder(new LineBorder(new Color(255, 0, 0), 2));
		paneMenu.setForeground(new Color(0, 0, 0));
		paneMenu.setBackground(new Color(0, 0, 205));
		paneMenu.setBounds(0, 0, 300, 650);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel lbliconlogo = new JLabel("");
		lbliconlogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconlogo.setBounds(51, 26, 202, 149);
		lbliconlogo.setIcon(new ImageIcon(img_mainlogo));
		paneMenu.add(lbliconlogo);
		
		JLabel lblName = new JLabel("NouCare Pharmancy");
		lblName.setForeground(new Color(0, 255, 0));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
		lblName.setBounds(23, 195, 254, 50);
		paneMenu.add(lblName);
		
		JPanel paneHome = new JPanel();
		paneHome.addMouseListener(new PanelButtonMouseAdapter(paneHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelHome);
			}
		});
		paneHome.setBackground(new Color(60, 179, 113));
		paneHome.setForeground(new Color(248, 248, 255));
		paneHome.setBounds(2, 278, 296, 58);
		paneMenu.add(paneHome);
		paneHome.setLayout(null);
		
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setFont(new Font("Dialog", Font.BOLD, 19));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(105, 10, 98, 38);
		paneHome.add(lblHome);
		
		JLabel lbliconhome = new JLabel("");
		lbliconhome.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconhome.setBounds(10, 0, 58, 58);
		lbliconhome.setIcon(new ImageIcon(img_home));
		paneHome.add(lbliconhome);
		
		JPanel paneTransaction = new JPanel();
		paneTransaction.addMouseListener(new PanelButtonMouseAdapter(paneTransaction) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panelTransaction);
				}
		});
		paneTransaction.setBackground(new Color(60, 179, 113));
		paneTransaction.setForeground(new Color(248, 248, 255));
		paneTransaction.setLayout(null);
		paneTransaction.setBounds(2, 335, 296, 58);
		paneMenu.add(paneTransaction);
		
		JLabel lblTransaction = new JLabel("TRANSACTIONS");
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setFont(new Font("Dialog", Font.BOLD, 19));
		lblTransaction.setBounds(87, 10, 152, 38);
		paneTransaction.add(lblTransaction);
		
		JLabel labelicontransactions = new JLabel("");
		labelicontransactions.setHorizontalAlignment(SwingConstants.CENTER);
		labelicontransactions.setBounds(10, 0, 58, 58);
		labelicontransactions.setIcon(new ImageIcon(img_transaction));
		paneTransaction.add(labelicontransactions);
		
		JPanel paneInvoice = new JPanel();
		paneInvoice.addMouseListener(new PanelButtonMouseAdapter(paneInvoice){
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelInvoice);
			}
		});
		paneInvoice.setBackground(new Color(60, 179, 113));
		paneInvoice.setForeground(new Color(248, 248, 255));
		paneInvoice.setLayout(null);
		paneInvoice.setBounds(2, 391, 296, 58);
		paneMenu.add(paneInvoice);
		
		JLabel lblInvoice = new JLabel("INVOICE");
		lblInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoice.setFont(new Font("Dialog", Font.BOLD, 19));
		lblInvoice.setBounds(104, 10, 98, 38);
		paneInvoice.add(lblInvoice);
		
		JLabel labeliconinvoice = new JLabel("");
		labeliconinvoice.setHorizontalAlignment(SwingConstants.CENTER);
		labeliconinvoice.setBounds(10, 0, 58, 58);
		labeliconinvoice.setIcon(new ImageIcon(img_invoice));
		paneInvoice.add(labeliconinvoice);
		
		JPanel paneProduct = new JPanel();
		paneProduct.addMouseListener(new PanelButtonMouseAdapter(paneProduct){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelProduct);
			}
		});
		paneProduct.setBackground(new Color(60, 179, 113));
		paneProduct.setForeground(new Color(248, 248, 255));
		paneProduct.setLayout(null);
		paneProduct.setBounds(2, 447, 296, 58);
		paneMenu.add(paneProduct);
		
		JLabel labelProduct = new JLabel("PRODUCTS");
		labelProduct.setHorizontalAlignment(SwingConstants.CENTER);
		labelProduct.setFont(new Font("Dialog", Font.BOLD, 19));
		labelProduct.setBounds(105, 10, 107, 38);
		paneProduct.add(labelProduct);
		
		JLabel labeliconproducts = new JLabel("");
		labeliconproducts.setHorizontalAlignment(SwingConstants.CENTER);
		labeliconproducts.setBounds(10, 8, 50, 50);
		labeliconproducts.setIcon(new ImageIcon(img_product));
		paneProduct.add(labeliconproducts);
		
		JPanel paneCustomer = new JPanel();
		paneCustomer.addMouseListener(new PanelButtonMouseAdapter(paneCustomer) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCustomer);
			}
		});
		paneCustomer.setBackground(new Color(60, 179, 113));
		paneCustomer.setForeground(new Color(248, 248, 255));
		paneCustomer.setLayout(null);
		paneCustomer.setBounds(2, 503, 296, 58);
		paneMenu.add(paneCustomer);
		
		JLabel labelCustomer = new JLabel("CUSTOMERS");
		labelCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		labelCustomer.setFont(new Font("Dialog", Font.BOLD, 19));
		labelCustomer.setBounds(98, 10, 122, 38);
		paneCustomer.add(labelCustomer);
		
		JLabel labeliconcustomers = new JLabel("");
		labeliconcustomers.setHorizontalAlignment(SwingConstants.CENTER);
		labeliconcustomers.setBounds(10, 8, 50, 50);
		labeliconcustomers.setIcon(new ImageIcon(img_customer));
		paneCustomer.add(labeliconcustomers);
		
		JPanel paneSignOut = new JPanel();
		paneSignOut.addMouseListener(new PanelButtonMouseAdapter(paneSignOut) {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
				loginUser lu = new loginUser();
				lu.setVisible(true);
				Homescreen.this.dispose();
				}
			}
		});
		
		paneSignOut.setBackground(new Color(60, 179, 113));
		paneSignOut.setForeground(new Color(248, 248, 255));
		paneSignOut.setLayout(null);
		paneSignOut.setBounds(2, 560, 296, 58);
		paneMenu.add(paneSignOut);
		
		JLabel labelSignOut = new JLabel("SIGN OUT");
		labelSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		labelSignOut.setFont(new Font("Dialog", Font.BOLD, 19));
		labelSignOut.setBounds(104, 10, 98, 38);
		paneSignOut.add(labelSignOut);
		
		JLabel labeliconsignout = new JLabel("");
		labeliconsignout.setHorizontalAlignment(SwingConstants.CENTER);
		labeliconsignout.setBounds(10, 10, 45, 45);
		labeliconsignout.setIcon(new ImageIcon(img_signout));
		paneSignOut.add(labeliconsignout);
		
		JLabel lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblX.setBounds(970, 2, 34, 16);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					
					Homescreen.this.dispose();
				}
			}
			
			public void mouseEntered(MouseEvent arg0) {
				lblX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				lblX.setForeground(Color.WHITE);
			}	
				
		});		
		contentPane.add(lblX);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBounds(310, 10, 670, 630);
		contentPane.add(paneMainContent);
		paneMainContent.setLayout(null);
		
		paneMainContent.add(panelHome);
		paneMainContent.add(panelTransaction);
		paneMainContent.add(panelInvoice);
		paneMainContent.add(panelProduct);
		paneMainContent.add(panelCustomer);
		
		menuClicked(panelHome);
	}
	
	public void menuClicked(JPanel panel) {
		panelHome.setVisible(false);
		panelTransaction.setVisible(false);
		panelInvoice.setVisible(false);
		panelProduct.setVisible(false);
		panelCustomer.setVisible(false);
		
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 180, 115));
		}
		
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
	}

}
