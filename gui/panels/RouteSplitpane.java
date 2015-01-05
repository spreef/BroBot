package panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class RouteSplitpane extends JSplitPane {
	JPanel leftpanel;
	JPanel rightpanel;
	
	public RouteSplitpane(){
		//Linker paneel van de splitPane
		leftpanel = new JPanel();
		leftpanel.setBackground(Color.red);
		
		//rechter paneel van de splitPane
		rightpanel = new JPanel();
		rightpanel.setBackground(Color.yellow);
		
		
		//aantal opties voor de splitpane
		this.setResizeWeight(0.5);
		this.setContinuousLayout(true);
		Component divider = this.getComponent(2);
		divider.setCursor(new Cursor(Cursor.HAND_CURSOR));

		//panels toevoegen aan de splitpane
		this.setLeftComponent(leftpanel);
		this.setRightComponent(rightpanel);
	}
}
