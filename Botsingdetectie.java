package boebot;
public class Botsingdetectie{
  private IrDetectie irL;
  private IrDetectie irR;
  private VsDetectie vsL;
  private VsDetectie vsR;
  private boolean IrDetectL;
  private boolean IrDetectR;
  private boolean VsDetectL;
  private boolean VsDetectR;

  public Botsingdetectie(){
       irL = new IrDetectie(8, 9);
       irR = new IrDetectie(2, 0);
       vsL = new VsDetectie(8, 9);
       vsR = new VsDetectie(2, 0);
  }

  public boolean detectEdge(){

    IrDetectL = irL.detect();
    IrDetectR = irR.detect();
    VsDetectL = vsL.detect();
    VsDetectR = vsR.detect();

    if(IrDetectL || IrDetectR || VsDetectL || VsDetectR){
        return true;

    }else{
      return false;

    }
  }
}
