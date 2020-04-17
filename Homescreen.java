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
	private Image img_home = new ImageIcon(Homescreen.class.getResource("Images/home.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_transaction = new ImageIcon(Homescreen.class.getResource("Images/transaction.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_invoice = new ImageIcon(Homescreen.class.getResource("Images/Invoice.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_product = new ImageIcon(Homescreen.class.getResource("Images/Product.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_customer = new ImageIcon(Homescreen.class.getResource("Images/Customer.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH);
	private Image img_signout = new ImageIcon(Homescreen.class.getResource("Images/Exit.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	

	
	
	
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
		setBounds(250, 100, 1100, 650);		
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
		paneMenu.setBackground(new Color(51, 102, 255));
		paneMenu.setBounds(0, 0, 198, 650);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel lbliconlogo = new JLabel("");
		lbliconlogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconlogo.setBounds(15, 10, 164, 146);
		lbliconlogo.setIcon(new ImageIcon(img_mainlogo));
		paneMenu.add(lbliconlogo);
		
		JLabel lblName1 = new JLabel("NouCare ");
		lblName1.setForeground(new Color(0, 255, 0));
		lblName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 22));
		lblName1.setBounds(45, 160, 130, 50);
		paneMenu.add(lblName1);
		
		JPanel paneHome = new JPanel();
		paneHome.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		paneHome.addMouseListener(new PanelButtonMouseAdapter(paneHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelHome);
			}
		});
		paneHome.setBackground(new Color(60, 179, 113));
		paneHome.setForeground(new Color(248, 248, 255));
		paneHome.setBounds(2, 278, 193, 58);
		paneMenu.add(paneHome);
		paneHome.setLayout(null);
		
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setFont(new Font("Dialog", Font.BOLD, 19));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(70, 10, 98, 38);
		paneHome.add(lblHome);
		
		JLabel lbliconhome = new JLabel("");
		lbliconhome.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconhome.setBounds(2, 0, 58, 58);
		lbliconhome.setIcon(new ImageIcon(img_home));
		paneHome.add(lbliconhome);
		
		JPanel paneTransaction = new JPanel();
		paneTransaction.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		paneTransaction.addMouseListener(new PanelButtonMouseAdapter(paneTransaction) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panelTransaction);
				}
		});
		paneTransaction.setBackground(new Color(60, 179, 113));
		paneTransaction.setForeground(new Color(248, 248, 255));
		paneTransaction.setLayout(null);
		paneTransaction.setBounds(2, 335, 193, 58);
		paneMenu.add(paneTransaction);
		
		JLabel lblTransaction = new JLabel("TRANSACTIONS");
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTransaction.setBounds(41, 9, 152, 38);
		paneTransaction.add(lblTransaction);
		
		JLabel labelicontransactions = new JLabel("");
		labelicontransactions.setHorizontalAlignment(SwingConstants.CENTER);
		labelicontransactions.setBounds(2, 0, 58, 58);
		labelicontransactions.setIcon(new ImageIcon(img_transaction));
		paneTransaction.add(labelicontransactions);
		
		JPanel paneInvoice = new JPanel();
		paneInvoice.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		paneInvoice.addMouseListener(new PanelButtonMouseAdapter(paneInvoice){
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelInvoice);
			}
		});
		paneInvoice.setBackground(new Color(60, 179, 113));
		paneInvoice.setForeground(new Color(248, 248, 255));
		paneInvoice.setLayout(null);
		paneInvoice.setBounds(2, 391, 193, 58);
		paneMenu.add(paneInvoice);
		
		JLabel lblInvoice = new JLabel("INVOICE");
		lblInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoice.setFont(new Font("Dialog", Font.BOLD, 19));
		lblInvoice.setBounds(70, 10, 98, 38);
		paneInvoice.add(lblInvoice);
		
		JLabel labeliconinvoice = new JLabel("");
		labeliconinvoice.setHorizontalAlignment(SwingConstants.CENTER);
		labeliconinvoice.setBounds(1, 0, 58, 58);
		labeliconinvoice.setIcon(new ImageIcon(img_invoice));
		paneInvoice.add(labeliconinvoice);
		
		JPanel paneProduct = new JPanel();
		paneProduct.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		paneProduct.addMouseListener(new PanelButtonMouseAdapter(paneProduct){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelProduct);
			}
		});
		paneProduct.setBackground(new Color(60, 179, 113));
		paneProduct.setForeground(new Color(248, 248, 255));
		paneProduct.setLayout(null);
		paneProduct.setBounds(2, 447, 193, 58);
		paneMenu.add(paneProduct);
		
		JLabel labelProduct = new JLabel("PRODUCTS");
		labelProduct.setHorizontalAlignment(SwingConstants.CENTER);
		labelProduct.setFont(new Font("Dialog", Font.BOLD, 19));
		labelProduct.setBounds(70, 10, 107, 38);
		paneProduct.add(labelProduct);
		
		JLabel labeliconproducts = new JLabel("");
		labeliconproducts.setHorizontalAlignment(SwingConstants.CENTER);
		labeliconproducts.setBounds(2, 5, 50, 50);
		labeliconproducts.setIcon(new ImageIcon(img_product));
		paneProduct.add(labeliconproducts);
		
		JPanel paneCustomer = new JPanel();
		paneCustomer.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		paneCustomer.addMouseListener(new PanelButtonMouseAdapter(paneCustomer) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCustomer);
			}
		});
		paneCustomer.setBackground(new Color(60, 179, 113));
		paneCustomer.setForeground(new Color(248, 248, 255));
		paneCustomer.setLayout(null);
		paneCustomer.setBounds(2, 503, 193, 58);
		paneMenu.add(paneCustomer);
		
		JLabel labelCustomer = new JLabel("CUSTOMERS");
		labelCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		labelCustomer.setFont(new Font("Dialog", Font.BOLD, 19));
		labelCustomer.setBounds(60, 10, 122, 38);
		paneCustomer.add(labelCustomer);
		
		JLabel labeliconcustomers = new JLabel("");
		labeliconcustomers.setHorizontalAlignment(SwingConstants.CENTER);
		labeliconcustomers.setBounds(2, 8, 50, 50);
		labeliconcustomers.setIcon(new ImageIcon(img_customer));
		paneCustomer.add(labeliconcustomers);
		
		JPanel paneSignOut = new JPanel();
		paneSignOut.setBorder(new LineBorder(new Color(0, 255, 255), 2));
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
		paneSignOut.setBounds(2, 560, 193, 58);
		paneMenu.add(paneSignOut);
		
		JLabel labelSignOut = new JLabel("SIGN OUT");
		labelSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		labelSignOut.setFont(new Font("Dialog", Font.BOLD, 19));
		labelSignOut.setBounds(70, 10, 98, 38);
		paneSignOut.add(labelSignOut);
		
		JLabel labeliconsignout = new JLabel("");
		labeliconsignout.setHorizontalAlignment(SwingConstants.CENTER);
		labeliconsignout.setBounds(4, 10, 45, 45);
		labeliconsignout.setIcon(new ImageIcon(img_signout));
		paneSignOut.add(labeliconsignout);
		
		JLabel lblPharmancy = new JLabel("Pharmancy");
		lblPharmancy.setHorizontalAlignment(SwingConstants.LEFT);
		lblPharmancy.setForeground(Color.GREEN);
		lblPharmancy.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 22));
		lblPharmancy.setBounds(30, 201, 150, 50);
		paneMenu.add(lblPharmancy);
		
		JLabel lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblX.setBounds(1070, 2, 34, 16);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					
					Homescreen.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblX.setForeground(Color.WHITE);
			}	
				
		});		
		contentPane.add(lblX);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBounds(205, 10, 872, 630);
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
			panel.setBackground(new Color(0, 255, 0));
		}
		
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 180, 115));
		}
		
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(0, 255, 0));
		}
	}

}
