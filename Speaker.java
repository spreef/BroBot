package boebot;

import stamp.core.*;

public class Speaker
{
  private Freqout speaker;
  private int pinNumber;

  public Speaker (int pinNumberInput)
  {
    pinNumber = pinNumberInput;
  }

  public void playSound(int frequency, int duration)
  {
    speaker = new Freqout(CPU.pins[pinNumber]);
    for (int i = 0; i <= duration; i ++)
    {
      speaker.freqout((frequency / 10), 1);
    }
  }
}
