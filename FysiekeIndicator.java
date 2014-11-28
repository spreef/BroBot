package boebot;
public class FysiekeIndicator{
  private Led led1;
  private Led led2;

   public FysiekeIndicator(){
      led1 = new Led(1);
      led2 = new Led(10);
   }
   public void setLed1(boolean state){
     led1.setState(state);
   }
   public void setLed2(boolean state){
     led1.setState(state);
   }
}