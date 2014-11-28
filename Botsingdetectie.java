package boebot;
public class Botsingdetectie{
  private IrDetectie irL;
  private IrDetectie irR;
  private boolean IrDetectL;
  private boolean IrDetectR;

  public Botsingdetectie(){
       irL = new IrDetectie(8, 9);
       irR = new IrDetectie(2, 0);
  }

  public boolean detectEdge(){

    IrDetectL = irL.detect();
    IrDetectR = irR.detect();
    if(IrDetectL || IrDetectR){
        return true;

    }else{
      return false;

    }



  }
}