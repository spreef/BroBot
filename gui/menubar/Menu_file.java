package menubar;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Menu_file extends JMenu {
	public Menu_file(){
		setText("Bestand");
		addSeparator();
		add(new JMenuItem("Nieuw"));
		add(new JMenuItem("Openen"));
		addSeparator();
		add(new JMenuItem("Opslaan"));
		add(new JMenuItem("Opslaan als"));	
		addSeparator();
		add(new JMenuItem("Afsluiten"));
	}

}
