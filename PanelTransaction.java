import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelTransaction extends JPanel {

	/**
	 * Create the panel.
	 */
	
	
	public PanelTransaction() {
		
		setBounds(0, 0, 670, 630);
		setLayout(null);
		
		JLabel labelThisistransaction = new JLabel("Transaction");
		labelThisistransaction.setHorizontalAlignment(SwingConstants.CENTER);
		labelThisistransaction.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelThisistransaction.setBounds(63, 167, 501, 219);
		add(labelThisistransaction);

	}

}
