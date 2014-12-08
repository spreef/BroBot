package boebot; 
public class Lijnvolger{
 private int input;
 private int output;
 
 public Lijnvolger(int input, int output)){
 this.input = input;
 this.output = output;
 }
 
 public boolean detect(){
 CPU.writePin(CPU.pins[input],true);           //zet spanning op QTI
 CPU.delay(1);                                 //wacht even
 qtiDigValue = CPU.readPin(CPU.pins[output]);  //lees QTI uit
 CPU.writePin(CPU.pins[input],false);          //haal spanning van QTI
 System.out.println(qtiDigValue);
 CPU.delay(1000);
 return qtiDigValue;
 }

}
