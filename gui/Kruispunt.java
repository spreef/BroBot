
/**
 * Write a description of class Kruispunt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class Kruispunt extends JLabel
{       
    BufferedImage kruispunt;
    public Kruispunt() 
    {
        try{
            kruispunt = ImageIO.read(new File("kruispunt.png"));
        }catch (IOException e){
            
        }
        this.repaint();
    }
    public void setBoebot(int rotation)
    {
        if(rotation == 90)
        {
        try{
            kruispunt = ImageIO.read(new File("boebot.png"));
        }catch (IOException e){
            
        }
    }
        if(rotation == 0)
        {
        try{
            kruispunt = ImageIO.read(new File("boven boebot.png"));
        }catch (IOException e){
            
        }
    }
        if(rotation == 180)
        {
        try{
            kruispunt = ImageIO.read(new File("onder boebot.png"));
        }catch (IOException e){
            
        }
    }
        if(rotation == 270)
        {
        try{
            kruispunt = ImageIO.read(new File("links boebot.png"));
        }catch (IOException e){
            
        }
    }
        this.repaint();
    }
    public void setGat()
    {
        try{
            kruispunt = ImageIO.read(new File("gat.png"));
        }catch (IOException e){
            
        }
        this.repaint();
    }
    public void setFinish()
    {
        try{
            kruispunt = ImageIO.read(new File("finish.png"));
        }catch (IOException e){
            
        }
        this.repaint();
    }
    protected void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(kruispunt, 0, 0, null);
    }
}
