package panels;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.activation.UnsupportedDataTypeException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import windows.Remote;
import menubar.Menu_file;
import menubar.Menubar;
import customComponents.ComWriter;


public class MainMenu extends JPanel{
	Menubar menubar;
	RouteSplitpane routeSplitpane;
	Iconbar iconbar;
	ComWriter bluetooth;
	String currentRouteFile;
	Remote remote;
	char[] currentRoute;
	
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	
    public MainMenu(){
    	menubar = new Menubar();
    	routeSplitpane = new RouteSplitpane();
    	iconbar = new Iconbar();
    	bluetooth = new ComWriter();

    	remote = new Remote(new AfstandbedieningPanel(bluetooth));
    	remote.dispose();
    	setLayout(new BorderLayout(0,0));
    	add(menubar, BorderLayout.NORTH);
    	add(routeSplitpane);
    	add(iconbar, BorderLayout.SOUTH);
    	currentRouteFile = "Nieuwe route";
    	iconbar.currentroute.setText("Nieuwe route");
    	menubarMouseListeners();
    }
    
    
    public String getCurrentRouteFile() {
		return currentRouteFile;
	}
	public void setCurrentRouteFile(String route){
		int c = JOptionPane.showConfirmDialog(null, "Weet u zeker dat u de huidige route wilt afsluiten?", "Alert: " + "Weet u het zeker?", JOptionPane.YES_NO_OPTION);	
        if (c == JOptionPane.YES_OPTION) {
    		currentRouteFile = route;
    		iconbar.currentroute.setText(route);
          }
        }
    
    //route uitlezen uit een file en de file controleren
	public void readRouteFile(String aFileName){
		Path path = Paths.get(aFileName);
		try {
			List<String> routebestand = Files.readAllLines(path, ENCODING);
			if(routebestand.size() == 0 || !routebestand.get(0).contains("broboticsrouteplanner")){
				JOptionPane.showConfirmDialog(null, "Route niet geldig!", "Alert: " + "Fout", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Route bestand niet geldig!");	
			}else{
				setCurrentRouteFile(path.toString());
				String[] route = routebestand.get(2).split("|");
				for(String cor:route){
					System.out.println(cor);
				}
				
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Route niet geldig!", "Alert: " + "Fout", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Route bestand niet geldig!");
		}
	}
	
	 //route file schrijven 
	public void writeRouteFile(List<String> aLines, String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    Files.write(path, aLines, ENCODING);
	}
	
	//route verzenden naar de boebot
	public void sendRoute(char[] route){
		char[] newroute = new char[route.length + 2];
		newroute[0] =  '?';
		for(int i=0; i < route.length; i++){
			newroute[i+1] = route[i];
		}
		newroute[newroute.length] = '?';
		bluetooth.writeString(route.toString());
	}
		
	//nieuwe routefile aanmaken
	public void createRouteFile(String filename, List<String> aLines, String aFileName) throws IOException {
		File file = new File("example.txt");
		Path path = Paths.get(aFileName);
	    Files.write(path, aLines, ENCODING);
	}
    
    public void menubarMouseListeners(){
    	//maakt de mouse listners voor de menubar
		menubar.menu_file.openen.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
		      JFileChooser c = new JFileChooser();
		      // Demonstrate "Open" dialog:
		      int rVal = c.showOpenDialog(MainMenu.this);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		        readRouteFile(c.getSelectedFile().getAbsolutePath());
		      }
		      if (rVal == JFileChooser.CANCEL_OPTION) {
		        //filename.setText("You pressed cancel");
		        //dir.setText("");
		      }
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		menubar.menu_file.opslaan.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(currentRouteFile == "Nieuwe Route"){
					
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		menubar.menu_file.nieuw.addMouseListener(new MouseListener() {	
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}	
			@Override
			public void mousePressed(MouseEvent e) {
				setCurrentRouteFile("Nieuwe route");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		iconbar.irremote.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
		    	createRemote();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    public void createRemote(){
    	if(remote.isShowing()){
    		remote.dispose();
    	}else{
    		remote.show();
    	}
    }
}
