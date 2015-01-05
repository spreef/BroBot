package menubar;

import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.border.EmptyBorder;

public class Menubar extends JMenuBar{
	public Menubar(){
    	setBorder(new EmptyBorder(0, 15, 0, 15));
		setLayout(new FlowLayout(80));
		add(new Menu_file());
		add(new Menu_edit());
		add(new Menu_help());
	}
}
