package boebot;
import stamp.core.*;

public class VsDetectie{
PWM vsZender;
  boolean vsDetect;
  private int pinRead;
  private int pinSend;

 public VsDetectie(int pinS, int pinR){
     vsZender = new PWM (CPU.pins[pinS], 1, 2);
     vsZender.stop();
     pinRead = pinR;
     pinSend = pinS;

 }
 public void setPinRead(int pin){
   pinRead = pin;
 }
 public boolean detect(){
    vsDetect = CPU.readPin(CPU.pins[pinRead]);
    return vsDetect;
 }
}
