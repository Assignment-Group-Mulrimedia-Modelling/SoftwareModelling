import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanelTransaction extends JPanel {

	/**
	 * Create the panel.
	 */
	
	
	public PanelTransaction() {
		setBorder(new LineBorder(new Color(255, 99, 71), 3));
		
		setBounds(0, 0, 872, 630);
		setLayout(null);
		
		JLabel labelThisistransaction = new JLabel("Transaction");
		labelThisistransaction.setHorizontalAlignment(SwingConstants.CENTER);
		labelThisistransaction.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelThisistransaction.setBounds(203, 171, 501, 219);
		add(labelThisistransaction);

	}

}
