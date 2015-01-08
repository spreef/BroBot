package bluetooth;
import stamp.core.*;

public class Bluetooth
{
  final static int SERIAL_RX_PIN  = CPU.pin14;
  final static int SERIAL_TX_PIN  = CPU.pin15;

  static Uart rxUart = new Uart(Uart.dirReceive, SERIAL_RX_PIN, Uart.dontInvert, Uart.speed9600, Uart.stop1);
  static Uart txUart = new Uart(Uart.dirTransmit, SERIAL_TX_PIN, Uart.dontInvert, Uart.speed9600, Uart.stop1);

  private char[] data = new char[40];

  public void getRoute()
  {
    int adChar = 0;
    char endRoute = '?';

    while (true)
    {
      if (rxUart.byteAvailable())
      {
        char temp = (char)rxUart.receiveByte();
        data[adChar] = temp;

        if (endRoute == temp)
        {
          returnRoute();
          break;
        }

        adChar ++;

        if (adChar == 40)
        {
          System.out.println("De opgegeven route is te groot. Voer maximaal 40 route-aanwijzingen in.");
          break;
        }
      }

      if (!rxUart.byteAvailable())
      {
        break;
      }

      CPU.delay(100);
    }
  }

  private char[] returnRoute()
  {
    System.out.println("Array:");
    System.out.println(data[0]);
    System.out.println(data[1]);
    System.out.println(data[2]);

    return data;
  }
}