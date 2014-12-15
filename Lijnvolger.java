package boebot;
import stamp.core.*;

public class Lijnvolger
{
    boolean qtiDigValue;
    IrLijnvolger IrMidden;
    IrLijnvolger IrRechts;
    IrLijnvolger IrLinks;

    public Lijnvolger()
    {
      IrMidden = new IrLijnvolger(6, 5);
      IrRechts = new IrLijnvolger(4, 3);
      IrLinks = new IrLijnvolger(8, 7);
    }


    public int readSensor()
    {
      int waarde = -1;
           if(IrL1.readSensorLijnvolger() && IrL2.readSensorLijnvolger() && IrL3.readSensorLijnvolger()){
            waarde = 4;
      } else
           if(IrL1.readSensorLijnvolger()){
           waarde = 0;
           }

      else if(IrL2.readSensorLijnvolger()){
           waarde = 1;
           }

      else if(IrL3.readSensorLijnvolger()){
           waarde = 2;
           }
      else{
           waarde = 3;
           }
      return waarde;

}
