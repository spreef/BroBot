package boebot;
public class Aansturing{
	private int rotation, x, y;
	private int maxx, maxy;
	private int ex, ey;


   public Aansturing(int maxx, int maxy){
	   this.maxx = maxx;
	   this.maxy = maxy;
	   rotation = 0;
	   x = 0;
       y = 0;
       ex = 0;
       ey = 0;
   }

   public void turnleft(){
	   rotation = rotation - 90;
       if (rotation < 0){
           rotation = 270;
       }
   }

   public void turnright(){
       rotation = rotation + 90;
       if (rotation > 270){
           rotation = 0;
       }
   }

   public void vooruit(){
       if (rotation == 0 && y < maxy){
           y ++;
       }
      
       if (rotation == 90 && x < maxx){
           x ++;
       }

       if (rotation == 180 && y > 0){
           y --;
       }
       
       if (rotation == 270 && x > 0){
    	   x --;
       }
   }


   public char[] berekenRoute(int eindx, int eindy, int beginx, int beginy, int rotatie){
	   char[] route = new char[40];
       int teller = 0;

       x = beginx;
       y = beginy;
       rotation = rotatie;

       if(eindx <= maxx && eindy <= maxy && eindx >= 0 && eindy >= 0){
    	   ex = eindx;
           ey = eindy;
       }else{
    	   return route;
       }
       
       if(beginx <= maxx && beginy <= maxy && beginx >= 0 && beginy >= 0){
    	   x = beginx;
    	   y = beginy;
       }else{
    	   return route;
       }

       while(ex != x){
    	   if(x < ex){
    		   if(rotation == 90){
    			   vooruit();
    			   route[teller] = 'v';
    			   System.out.println("vooruit");
    			   teller ++;
               }else{
            	   turnleft();
            	   route[teller] = 'l';
            	   System.out.println("turnleft");
                   teller ++;
               }
    	   }else{
    		   if(x > ex){
    			   if(rotation == 270){
    				   vooruit();
    				   route[teller] = 'v';
                       System.out.println("vooruit");
                       teller ++;
                   }else{
                	   turnleft();
                	   route[teller] ='l';
                       System.out.println("turnleft");
                       teller ++;
                   }
               }
           }
       }

       while(ey != y){
    	   if(y < ey){
    		   if(rotation == 0){
            	   vooruit();
                   route[teller] = 'v';
                   System.out.println("vooruit");
                   teller ++;
               }else{
            	   turnright();
                   route[teller] = 'r';
                   System.out.println("turnright");
                   teller ++;
               }
           }else{
        	   if(y > ey){
                   if(rotation == 180){
                       vooruit();
                       route[teller] = 'v';
                       System.out.println("vooruit");
                       teller ++;
                   }else{
                	   turnright();
                	   route[teller] = 'r';
                	   System.out.println("turnright");
                	   teller ++;
                   }
               }
           }
       }
       return route;
   }
}
