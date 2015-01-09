package boebot;
import stamp.core.*;
public class Bluetooth
{
    final static int SERIAL_RX_PIN  = CPU.pin2;
    final static int SERIAL_TX_PIN  = CPU.pin0;

    static Uart rxUart = new Uart(Uart.dirReceive, SERIAL_RX_PIN, Uart.dontInvert, Uart.speed9600, Uart.stop1);
    static Uart txUart = new Uart(Uart.dirTransmit, SERIAL_TX_PIN,Uart.dontInvert, Uart.speed9600, Uart.stop1);
	
    char tempChar;
    char[] route = new char[40];
    char romoteControl = ' ';

    public int checkBt()
	{
		if (rxUart.byteAvailable())
		{
			tempChar = (char)rxUart.receiveByte();
		
			if (tempChar == '?')
			{
				int i = 0;
				clearRoute();
				
				while (true)
				{
					if (rxUart.byteAvailable())           
					{
						tempChar = (char)rxUart.receiveByte();
						
						if(tempChar == '?')
						{
							return 2;
						}
						
						route[i] = tempChar;
						i++;
					}
				}
			}
		
			else if ((tempChar == 'a') || (tempChar =='v') || (tempChar == 'l') || (tempChar == 'r') || (tempChar == 's'))
			{
				romoteControl = tempChar;
				return 1;
			}
        
			return 0;
		}
		
		return 0;
    }
	
    public char[] getRoute()
	{
        return route;
    }
	
    public int getromoteControl()
	{
		int value = 4;
		
		switch (romoteControl)
		{
			case 'v':
				value = 1;
				break;
			case 'a':
				value = 7;
				break;
			case 's':
				value = 4;
				break;
			case 'r':
				value = 5;
				break;
			case 'l':
				value = 3;
				break;
		}
		
		return value;
    }
	
    public void clearRoute()
	{
        for(int i = 0; i < 40; i++)
		{
			route[i] = ' ';
        }
    }
}