package panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import menubar.Menubar;


public class MainMenu extends JPanel{
	Menubar menubar;
	RouteSplitpane routeSplitpane;
	Iconbar iconbar;
	
    public MainMenu(){
    	menubar = new Menubar();
    	routeSplitpane = new RouteSplitpane();
    	iconbar = new Iconbar();
    	
    	setLayout(new BorderLayout(0,0));
    	add(menubar, BorderLayout.NORTH);
    	add(routeSplitpane);
    	add(iconbar, BorderLayout.SOUTH);
    }
    
      

}
