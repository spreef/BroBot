package boebot;
import stamp.core.*;

public class BoeBot{
  MotorAansturing motor;
  Botsingdetectie botsingdetectie;
  FysiekeIndicator fysiekeindicator;

  public BoeBot(){
    motor = new MotorAansturing();
    botsingdetectie = new Botsingdetectie();
    fysiekeindicator = new FysiekeIndicator();
    motor.setSnelheid(100);
    motor.setRichting(true);
    motor.start();

    while(true){
        if(botsingdetectie.detectEdge()){
          CPU.writePin(CPU.pin1,true);
          motor.noodStop();
          motor.setRichting(false);
          motor.start();
          CPU.delay(2000);
          motor.noodStop();
          motor.turn(180);
          motor.setRichting(true);
          motor.start();
       }else if(botsingdetectie.detectObject() == 1){
           motor.noodStop();
           motor.setRichting(false);
           motor.start();
           CPU.delay(2000);
           motor.noodStop();
           motor.turn(90);
           motor.setRichting(true);
           motor.start();
       }else if(botsingdetectie.detectObject() == 2){
           motor.noodStop();
           motor.setRichting(false);
           motor.start();
           CPU.delay(2000);
           motor.noodStop();
           motor.turn(270);
           motor.setRichting(true);
           motor.start();
       }else if(botsingdetectie.detectObject() == 3){
           motor.noodStop();
           motor.setRichting(false);
           motor.start();
           CPU.delay(2000);
           motor.noodStop();
           motor.turn(180);
           motor.setRichting(true);
           motor.start();
       }
        int getal = afir.detect(4);
        if(getal == 21)
        {
        afir.setStatus(!afir.getStatus());
        }
        if(afir.getStatus())
        {
        if(getal != -1){
        afir.verwerkSignaal(getal);
        }
        else
        {
          //some other code
        }

    }
 }

}
