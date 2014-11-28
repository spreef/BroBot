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
           fysiekeindicator.setLed1(false);
           fysiekeindicator.setLed2(false);
      }  else{
           fysiekeindicator.setLed1(true);
           fysiekeindicator.setLed2(true);
          motor.noodStop();
          motor.setRichting(false);
          motor.start();
          CPU.delay(3000);
          motor.noodStop();
          motor.turn(180);
          motor.setRichting(true);
          motor.start();

       }
        CPU.delay(1000);

    }
 }

}