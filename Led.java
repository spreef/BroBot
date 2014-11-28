package boebot;
import stamp.core.*;

public class Led{
 private int pinNumber;
 public Led(int pin){
   pinNumber = pin;
 }
 public void setState(boolean state){
    CPU.writePin(CPU.pins[pinNumber], state);
 }
}