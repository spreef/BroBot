package boebot;
import stamp.core.*;

public class IrDetectie{
  PWM irZender;
  boolean irDetect;
  private int pinRead;
  private int pinSend;

 public IrDetectie(int pinS, int pinR){
     irZender = new PWM (CPU.pins[pinS], 1, 2);
     irZender.stop();
     pinRead = pinR;
     pinSend = pinS;

 }
 public void setPinRead(int pin){
   pinRead = pin;
 }
 public boolean detect(){
    for(int i = 0; i < 20; i++){
        irZender.start();
        CPU.delay(5);
        irDetect = CPU.readPin(CPU.pins[pinRead]);
        irZender.stop();
        CPU.delay (20);
    }
    CPU.writePin(pinSend, false);  
    return  !irDetect;
 }

}