package panels;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Iconbar extends JPanel {
	public JButton irremote;
	public JLabel currentroute;
		
	public Iconbar(){
		currentroute = new JLabel();
		irremote = new JButton("Afstandsbediening");
		
		this.setLayout(new GridLayout(0,5,10,10));
		this.add(irremote);
		this.add(currentroute);
	}
	
}
