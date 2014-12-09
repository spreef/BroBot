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

  public static void main()
  {
    Speaker test = new Speaker(3);

    test.playSound(1000, 100);
    test.playSound(7000, 200);
    test.playSound(9000, 100);
    test.playSound(1000, 100);
    test.playSound(10000, 200);
    test.playSound(3000, 100);
    test.playSound(20000, 100);
    test.playSound(15000, 200);
    test.playSound(12000, 100);
  }
}