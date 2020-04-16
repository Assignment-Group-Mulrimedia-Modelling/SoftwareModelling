import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Toolkit;


public class InvoiceRecords {

	private JFrame frmInvoiceRecords;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceRecords window = new InvoiceRecords();
					window.frmInvoiceRecords.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;
	protected Object DISPOSE_ON_CLOSE;

	/**
	 * Create the application.
	 */
	public InvoiceRecords() {
		initialize();
		conn = connection.dbConnector();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInvoiceRecords = new JFrame();
		frmInvoiceRecords.setIconImage(Toolkit.getDefaultToolkit().getImage(InvoiceRecords.class.getResource("/Images/Invoice.png")));
		frmInvoiceRecords.setTitle("Invoice Records");
		frmInvoiceRecords.getContentPane().setBackground(Color.CYAN);
		frmInvoiceRecords.setBounds(100, 100, 883, 476);
		frmInvoiceRecords.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInvoiceRecords.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Invoice Records");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(366, 11, 135, 46);
		frmInvoiceRecords.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.GREEN));
		scrollPane.setBounds(10, 112, 847, 287);
		frmInvoiceRecords.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setBackground(new Color(0, 255, 255));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Click to show records");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from invoicerecords";
					PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.setBounds(363, 68, 141, 23);
		frmInvoiceRecords.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String printdata = scrollPane.getUIClassID();
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
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setBounds(768, 410, 89, 23);
		frmInvoiceRecords.getContentPane().add(btnNewButton_1);
	}


	public void setVisible(boolean b) {
		main(null);
		
	}
}
