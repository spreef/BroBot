public class Routeplanner
{
   private int rotation;
   private int x;
   private int y;
   private int maxx;
   private int maxy;
   private int ex;
   private int ey;
   public String coordinaten;
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
   public String geefCoordinaten()
   {
       coordinaten = "(" + x + "," + y + ")";
       return coordinaten;
   }
   public String gaNaarPunt(int eindx, int eindy)
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
                   System.out.println("vooruit");
               }
               else
               {
                   turnleft();
                   System.out.println("turnleft");
               }
           }
           else
           {
               if(x > ex)
               {
                   if(rotation == 270)
                   {
                       vooruit();
                       System.out.println("vooruit");
                   }
                   else
                   {
                       turnleft();
                       System.out.println("turnleft");
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
                   System.out.println("vooruit");
               }
               else
               {
                   turnright();
                   System.out.println("turnright");
               }
           }
           else
           {
               if(y > ey)
               {
                   if(rotation == 180)
                   {
                       vooruit();
                       System.out.println("vooruit");
                   }
                   else
                   {
                       turnright();
                       System.out.println("turnright");
                   }
               }
           }
       }
       return "bestemming bereikt " + geefCoordinaten();
   }
}
