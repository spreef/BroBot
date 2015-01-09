package windows;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Remote extends JFrame {
	public Remote(JPanel jp){
		setup();
		setPane(jp);
	}
	public Remote(){
		setup();
	}
	
	public void setPane(JPanel jp){
		repaint();
		this.setContentPane(jp);
		this.pack();
	}
	
	private void setup(){
		setTitle("Afstandsbediening");
        setMinimumSize(new Dimension(257,345));
        this.setBounds(0, 0, 550, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
