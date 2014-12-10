public class Routeplanner
{
   private int rotation;
   private int x;
   private int y;
   private int maxx;
   private int maxy;
   private int ex;
   private int ey;
   public Routeplanner(int rotation, int maxx, int maxy)
   {
       this.rotation = rotation;
       this.maxx = maxx;
       this.maxy = maxy;
       x = 0;
       y = 0;
       ex = 0;
       ey = 0;
   }
   public void turnleft()
   {
       rotation = rotation - 90;
       if (rotation < 0)
       {
           rotation = 270;
       }
   }
   public void turnright()
   {
       rotation = rotation + 90;
       if (rotation > 270)
       {
           rotation = 0;
       }
   }
   public void vooruit()
   {
       if (rotation == 0 && y < maxy)
       {
           y ++;
       }
       if (rotation == 90 && x < maxx)
       {
           x ++;
       }
       if (rotation == 180 && y > 0)
       {
           y --;
       }
       if (rotation == 270 && x > 0)
       {
           x --;
       }
   }
   public void geefCoordinaten()
   {
       System.out.print("(" + x + "," + y + ")");
   }
   public void gaNaarPunt(int eindx, int eindy)
   {
       if(eindx <= maxx && eindy <= maxy && eindx >= 0 && eindy >= 0)
       {
           ex = eindx;
           ey = eindy;
       }
       while(ex != x)
       {
           if(x < ex)
           {
               if(rotation == 90)
               {
                   vooruit();
                   System.out.print("vooruit");
               }
               else
               {
                   turnleft();
                   System.out.print("turnleft");
               }
           }
           else
           {
               if(x > ex)
               {
                   if(rotation == 270)
                   {
                       vooruit();
                       System.out.print("vooruit");
                   }
                   else
                   {
                       turnleft();
                       System.out.print("turnleft");
                   }
               }
           }
       }
       while(ey != y)
       {
           if(y < ey)
           {
               if(rotation == 0)
               {
                   vooruit();
                   System.out.print("vooruit");
               }
               else
               {
                   turnright();
                   System.out.print("turnright");
               }
           }
           else
           {
               if(y > ey)
               {
                   if(rotation == 180)
                   {
                       vooruit();
                       System.out.print("vooruit");
                   }
                   else
                   {
                       turnright();
                       System.out.print("turnright");
                   }
               }
           }
       }
       System.out.print("bestemming bereikt " + " (" + x + "," + y + ")");
   }
}
