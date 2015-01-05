package boebot;
import stamp.core.*;

public class IrLijnvolger
{
  boolean qtiDigValue;
  private int input, output;
  public IrLijnvolger(int input, int output)
  {
     this.input = input;
     this.output = output;
  }

  public boolean readSensorLijnvolger()
  {
      CPU.writePin(CPU.pins[input],true);           //zet spanning op QTI
      CPU.delay(1);                                 //wacht even
      qtiDigValue = CPU.readPin(CPU.pins[output]);  //lees QTI uit
      CPU.writePin(CPU.pins[input],false);          //haal spanning van QTI
      return qtiDigValue;
  }






 }
