package boebot;
import stamp.core.*;

public class Lijnvolger
{
    boolean qtiDigValue;
    IrLijnvolger IrL1;
    IrLijnvolger IrL2;
    IrLijnvolger IrL3;

    public Lijnvolger()
    {
      IrL1 = new IrLijnvolger(6, 5);
      IrL2 = new IrLijnvolger(4, 3);
      IrL3 = new IrLijnvolger(8, 7);
    }


    public int readSensor()
    {
      int waarde = -1;
           if(IrL1.readSensorLijnvolger()){
           //rijden(100,100,!false);
           waarde = 0;
           }

      else if(IrL2.readSensorLijnvolger()){
           //rijden(20,100,!false);
           waarde = 1;
           }

      else if(IrL3.readSensorLijnvolger()){
           //rijden(100,20,!false);
           waarde = 2;
           }
      else{
           //rijden(50,50,false);
           waarde = 3;
           }
      return waarde;
    }

}
