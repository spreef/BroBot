package boebot;
import stamp.core.*;

public class BoeBot{
        MotorAansturing motor;
        Botsingdetectie botsingdetectie;
        FysiekeIndicator fysiekeindicator;
        Aansturing aansturing;
        Lijnvolger lijnvolger;
        AfstandbedieningIr afir;

        char route[];
        static int currentCase = 4;
        static int currentStep = 0;

        public BoeBot(){
                motor = new MotorAansturing();
                botsingdetectie = new Botsingdetectie();
                fysiekeindicator = new FysiekeIndicator();
                afir = new AfstandbedieningIr(motor);
                aansturing = new Aansturing(5,4);
                lijnvolger = new Lijnvolger();

                motor.setSnelheid(100);
                motor.setRichting(true);
                motor.start();
            route = aansturing.berekenRoute(4,3,0,0,90);


                //variabele om functies in en uit te schakelen.
                boolean afstandsbediening = true;
                boolean obstakelDetectie = false;
                boolean routeplanner = true;
                boolean sparcours = false;

                while(true){
                        if(obstakelDetectie){
                                obstakelDetectie();
                        }
                        if(afstandsbediening){
                                afstandsbediening();
                        }
                        if(routeplanner){
                                routeplanner();
                        }
                        if(sparcours){

                        }
                }
        }

        public void afstandsbediening(){
                int getal = afir.detect(4);
                if(getal == 21){
                        afir.setStatus(!afir.getStatus());
                }
                if(afir.getStatus()){
                        if(getal != -1){
                                afir.verwerkSignaal(getal);
                        }
                        else{
                        }
                }
        }

        public void obstakelDetectie(){
                if(botsingdetectie.detectEdge()){
                        CPU.writePin(CPU.pin1,true);
                        motor.noodStop();
                        motor.setRichting(false);
                        motor.start();
                        CPU.delay(2000);
                        motor.noodStop();
                        motor.turn(180);
                        motor.setRichting(true);
                        motor.start();
                }else if(botsingdetectie.detectObject() == 1){
                        motor.noodStop();
                        motor.setRichting(false);
                        motor.start();
                        CPU.delay(2000);
                        motor.noodStop();
                        motor.turn(90);
                        motor.setRichting(true);
                        motor.start();
                }else if(botsingdetectie.detectObject() == 2){
                        motor.noodStop();
                        motor.setRichting(false);
                        motor.start();
                        CPU.delay(2000);
                        motor.noodStop();
                        motor.turn(270);
                        motor.setRichting(true);
                        motor.start();
                }else if(botsingdetectie.detectObject() == 3){
                        motor.noodStop();
                        motor.setRichting(false);
                        motor.start();
                        CPU.delay(2000);
                        motor.noodStop();
                        motor.turn(180);
                        motor.setRichting(true);
                        motor.start();
                }
        }

        public void routeplanner(){
                if(currentStep == 0){
                        verwerkAansturing(route[currentStep]);
                }
                int getalLijnvolger = lijnvolger.readSensor();
                switch(getalLijnvolger){
                        case 0:
                                if(currentCase != 0){
                                        motor.setSnelheid(100);
                                        motor.setRichting(true);
                                        motor.rijden();
                                        currentCase = 0;
                                }
                                break;
                        case 1:
                                if(currentCase != 1){
                            motor.setSnelheidL(10);
                            motor.setSnelheidR(100);
                            motor.setRichting(true);
                            motor.rijden();
                            currentCase = 1;
                    }
                    break;
                        case 2:
                                if(currentCase != 2){
                                        motor.setSnelheidL(100);
                                        motor.setSnelheidR(10);
                                        motor.setRichting(true);
                                        motor.rijden();
                                        currentCase = 2;
                                }
                                break;
                        case 4:
                                if(currentCase != 4){
                                        if(route[currentStep] != ' '){
                                                verwerkAansturing(route[currentStep]);
                                                System.out.println(route[currentStep]);
                                        }else{
                                                motor.noodStop();
                                        }
                                        currentCase = 4;
                                }
                                break;
                        default:
                                motor.noodStop();
        }
        }

        public void verwerkAansturing(char opdracht){
                switch(opdracht){
                case 'v':
                        break;
                case 'a':
                        CPU.delay(1200);
            motor.noodStop();
            motor.turn(180);
            break;
                case 'r':
                        CPU.delay(1200);
            motor.noodStop();
            motor.turn(90);
            break;
                case 'l':
                        CPU.delay(1200);
            motor.noodStop();
            motor.turn(270);
            break;
                default:
            motor.noodStop();
            break;
                }
                currentStep++;
        }
}
