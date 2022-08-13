import lejos.nxt.*; 

public class FollowWall
{

   public static void main(String[] args) throws InterruptedException
   {
      //declaring and initializing variables
      
      MotorPort motorR = MotorPort.A;
      MotorPort motorL = MotorPort.B; 
      UltrasonicSensor sound = new UltrasonicSensor(SensorPort.S1);
      
      //LCD clear and "press to start"
      LCD.drawString("Press to start", 0, 0);
      Button.waitForAnyPress();
      LCD.clear();
      
      //avoiding the wall 
      while (true) {
         if (sound.getDistance() <= 35)
         {
            motorR.controlMotor(88, 1 );
            motorL.controlMotor(75, 1 );
         }
         
         else if ((sound.getDistance() > 35) && (sound.getDistance() <=55)) 
         {
            motorR.controlMotor(85, 1);
            motorL.controlMotor(85, 1);
         }
         
         else 
         {
            
            motorR.controlMotor(75, 1);
            motorL.controlMotor(90, 1);
           
         }
         
         if (Button.LEFT.isDown())
         {
         motorR.controlMotor(0, 3);
         motorL.controlMotor(0, 3);
         LCD.drawString("Finished", 3, 4);
         break;
         }
         
      }
   }

}
