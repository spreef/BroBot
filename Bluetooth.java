package boebot;
import stamp.core.*;

public class Bluetooth extends Aansturing
{
  final static int SERIAL_RX_PIN  = CPU.pin14;
  final static int SERIAL_TX_PIN  = CPU.pin15;

  static Uart rxUart = new Uart(Uart.dirReceive, SERIAL_RX_PIN, Uart.dontInvert, Uart.speed9600, Uart.stop1);
  static Uart txUart = new Uart(Uart.dirTransmit, SERIAL_TX_PIN, Uart.dontInvert, Uart.speed9600, Uart.stop1);

  private char[] route = new char[40];
  private int counter = 0;

  public void getRoute()
  {
    while (true)
    {
      if (rxUart.byteAvailable())
      {
        route[counter] = (char)rxUart.receiveByte();
        counter ++;
      }

      if (route[counter] == '¿')
      {
        counter = 0;
        givenRoute();
        break;
      }

      if (route[counter] == '¡')
      {
        counter = 0;
        calculateRoute();
        break;
      }

      CPU.delay(100);
    }
  }

  private char[] givenRoute()
  {
    char[] sendRoute = route;
    return sendRoute;
  }

  private char[] calculateRoute()
  {
    char[] sendRoute = new char[40];
    int charTest = 0;
    int addValue = 0;

    while (true)
    {
      if (route[charTest] != ',' && route[charTest] != '!' && route[charTest] != '¡')
      {
        sendRoute[addValue] = route[charTest];
        addValue ++;
      }

      if (route[charTest] == '¡')
      {
        break;
      }

      charTest ++;
    }

    return sendRoute;
  }

  public void remoteControl(int pin)
  {
    while (true)
    {
      if (rxUart.byteAvailable())
      {
        char command = (char)rxUart.receiveByte();
        boolean IR = false;

        switch (command)
        {
          case 'v':
            super.vooruit();
            break;
          case 'a':
            super.achteruit();
            break;
          case 'l':
            super.turnleft();
            break;
          case 'r':
            super.turnrechts();
            break;
          case 's':
            super.stop();
            break;
          case 'i':
            CPU.writePin(CPU.pins[pin], !IR);
            break;
        }
      }
    }
  }
}