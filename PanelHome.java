import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PanelHome extends JPanel {
	
	private Image img_homescreen = new ImageIcon(Homescreen.class.getResource("Images/homescreen1.png")).getImage().getScaledInstance(870, 626, Image.SCALE_SMOOTH);

	/**
	 * Create the panel.
	 */
	public PanelHome() {
		setBorder(new LineBorder(new Color(0, 255, 0), 3));
		
		setBounds(0, 0, 872, 630);
		setLayout(null);
		
		JLabel lbliconmainimage = new JLabel("");
		lbliconmainimage.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconmainimage.setBounds(2, 2, 868, 626);
		lbliconmainimage.setIcon(new ImageIcon(img_homescreen));
		add(lbliconmainimage);
		setVisible(true);
		

	}

}
