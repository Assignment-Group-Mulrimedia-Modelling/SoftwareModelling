import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Homescreen extends JFrame {
	
	private Image img_homescreen = new ImageIcon(Homescreen.class.getResource("Images/homescreen1.png")).getImage().getScaledInstance(500, 563, Image.SCALE_SMOOTH);
	
	private Image img_mainlogo = new ImageIcon(Homescreen.class.getResource("Images/MainLogo.png")).getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
	
	private Image img_Stock = new ImageIcon(Homescreen.class.getResource("Images/stock.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_Customer = new ImageIcon(Homescreen.class.getResource("Images/Customer.png")).getImage().getScaledInstance(45, 35, Image.SCALE_SMOOTH);
	private Image img_Product = new ImageIcon(Homescreen.class.getResource("Images/Product.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_invoice = new ImageIcon(Homescreen.class.getResource("Images/Invoice.png")).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);	
	private Image img_Exit = new ImageIcon(Homescreen.class.getResource("Images/Exit.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	

	private JPanel contentPane;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBorder(new LineBorder(new Color(255, 0, 0)));
		paneMenu.setBackground(new Color(0, 0, 128));
		paneMenu.setBounds(0, 0, 289, 563);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel lbliconlogo = new JLabel("");
		lbliconlogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconlogo.setBounds(10, 45, 110, 101);
		lbliconlogo.setIcon(new ImageIcon(img_mainlogo));
		paneMenu.add(lbliconlogo);
		
		JLabel lblNouCarePharmacy = new JLabel("NouCare Pharmancy");
		lblNouCarePharmacy.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		lblNouCarePharmacy.setForeground(new Color(124, 252, 0));
		lblNouCarePharmacy.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouCarePharmacy.setBounds(95, 76, 184, 54);
		paneMenu.add(lblNouCarePharmacy);
		
		JPanel paneStock = new JPanel();
		paneStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
				@Override
				public void mouseEntered(MouseEvent e) {
					paneStock.setBackground(new Color(55, 150, 200));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					paneStock.setBackground(new Color(0, 191, 255));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					paneStock.setBackground(new Color(10, 250, 255));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					paneStock.setBackground(new Color(55, 150, 200));
				}
		});
		paneStock.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0)));
		paneStock.setBackground(new Color(0, 191, 255));
		paneStock.setBounds(34, 209, 227, 38);
		paneMenu.add(paneStock);
		paneStock.setLayout(null);
		
		JLabel lblStock = new JLabel("STOCK");
		lblStock.setFont(new Font("Arial", Font.BOLD, 15));
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setBounds(81, 10, 106, 18);
		paneStock.add(lblStock);
		
		JLabel lbliconStock = new JLabel("");
		lbliconStock.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconStock.setBounds(10, 0, 38, 38);
		lbliconStock.setIcon(new ImageIcon(img_Stock));
		paneStock.add(lbliconStock);
		
		JPanel paneCustomer = new JPanel();
		paneCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
				@Override
				public void mouseEntered(MouseEvent e) {
					paneCustomer.setBackground(new Color(55, 150, 200));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					paneCustomer.setBackground(new Color(0, 191, 255));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					paneCustomer.setBackground(new Color(10, 250, 255));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					paneCustomer.setBackground(new Color(55, 150, 200));
				}
		});
		paneCustomer.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0)));
		paneCustomer.setLayout(null);
		paneCustomer.setBackground(new Color(0, 191, 255));
		paneCustomer.setBounds(34, 257, 227, 38);
		paneMenu.add(paneCustomer);
		
		JLabel lblCustomer = new JLabel("CUSTOMER");
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setFont(new Font("Arial", Font.BOLD, 15));
		lblCustomer.setBounds(81, 10, 106, 18);
		paneCustomer.add(lblCustomer);
		
		JLabel lbliconQuicksale = new JLabel("");
		lbliconQuicksale.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconQuicksale.setBounds(10, 0, 38, 38);
		lbliconQuicksale.setIcon(new ImageIcon(img_Customer));
		paneCustomer.add(lbliconQuicksale);
		
		JPanel panePrescription = new JPanel();
		panePrescription.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
				@Override
				public void mouseEntered(MouseEvent e) {
					panePrescription.setBackground(new Color(55, 150, 200));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panePrescription.setBackground(new Color(0, 191, 255));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					panePrescription.setBackground(new Color(10, 250, 255));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					panePrescription.setBackground(new Color(55, 150, 200));
				}
		});
		panePrescription.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0)));
		panePrescription.setLayout(null);
		panePrescription.setBackground(new Color(0, 191, 255));
		panePrescription.setBounds(34, 305, 227, 38);
		paneMenu.add(panePrescription);
		
		JLabel lblProduct = new JLabel("PRODUCT");
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setFont(new Font("Arial", Font.BOLD, 15));
		lblProduct.setBounds(79, 10, 116, 18);
		panePrescription.add(lblProduct);
		
		JLabel lbliconPrescription = new JLabel("");
		lbliconPrescription.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconPrescription.setBounds(10, 0, 38, 38);
		lbliconPrescription.setIcon(new ImageIcon(img_Product));
		panePrescription.add(lbliconPrescription);
		
		JPanel paneInvoice = new JPanel();
		paneInvoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
				@Override
				public void mouseEntered(MouseEvent e) {
					paneInvoice.setBackground(new Color(55, 150, 200));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					paneInvoice.setBackground(new Color(0, 191, 255));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					paneInvoice.setBackground(new Color(10, 250, 255));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					paneInvoice.setBackground(new Color(55, 150, 200));
				}
				
			
		});
		paneInvoice.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0)));
		paneInvoice.setLayout(null);
		paneInvoice.setBackground(new Color(0, 191, 255));
		paneInvoice.setBounds(34, 353, 227, 38);
		paneMenu.add(paneInvoice);
		
		JLabel lblInvoice = new JLabel("INVOICE");
		lblInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoice.setFont(new Font("Arial", Font.BOLD, 15));
		lblInvoice.setBounds(60, 10, 152, 18);
		paneInvoice.add(lblInvoice);
		
		JLabel lbliconCashPurchase = new JLabel("");
		lbliconCashPurchase.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconCashPurchase.setBounds(10, 0, 38, 38);
		lbliconCashPurchase.setIcon(new ImageIcon(img_invoice));
		paneInvoice.add(lbliconCashPurchase);
		
		JPanel paneExit = new JPanel();
		paneExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Homescreen.this.dispose();
				}
				
				
			}
				@Override
				public void mouseEntered(MouseEvent e) {
					paneExit.setBackground(new Color(255,69,0));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					paneExit.setBackground(new Color(255, 0, 0));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					paneExit.setBackground(new Color(255,99,71));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					paneExit.setBackground(new Color(255,69,0));
				}
			
		});
		paneExit.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		paneExit.setLayout(null);
		paneExit.setBackground(new Color(255, 0, 0));
		paneExit.setBounds(34, 410, 227, 38);
		paneMenu.add(paneExit);
		
		JLabel lblExit = new JLabel("EXIT");
		lblExit.setForeground(new Color(0, 0, 0));
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Arial", Font.BOLD, 15));
		lblExit.setBounds(70, 10, 106, 18);
		paneExit.add(lblExit);
		
		JLabel lbliconExit = new JLabel("");
		lbliconExit.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconExit.setBounds(10, 3, 35, 33);
		lbliconExit.setIcon(new ImageIcon(img_Exit));
		paneExit.add(lbliconExit);
		
		JLabel lblimagebackground = new JLabel("");
		lblimagebackground.setBounds(289, 0, 500, 563);
		lblimagebackground.setIcon(new ImageIcon(img_homescreen));
		contentPane.add(lblimagebackground);
	}
}
