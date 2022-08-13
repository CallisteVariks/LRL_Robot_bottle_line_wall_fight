import lejos.nxt.*;


public class MenuHandIn1and2
{
   public static void main(String[] args) throws InterruptedException
   {
      UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
      TouchSensor touch = new TouchSensor(SensorPort.S4);
      MotorPort motorR = MotorPort.A;
      MotorPort motorL = MotorPort.B;

      UltrasonicSensor sound = new UltrasonicSensor(SensorPort.S1);
      
      LCD.clear();
      int pwr = 87;
      Button.waitForAnyPress();
      
      int menu = 1;
      boolean flag = false;
      
      while (true)
      {
         if (menu == 1)
         {
            LCD.drawString("Hand in 1 ", 0, 0);
            while (Button.ENTER.isDown())
            {
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
         
         else if (menu == 2)
         {
            LCD.drawString("Hand in 2 ", 0, 0);
            while (Button.ENTER.isDown())
            {
               while (true)
               {
                  while(sonic.getDistance()>40)
                  {
                     motorR.controlMotor(pwr, 1);
                     motorL.controlMotor(pwr, 2);
                  }
                 if (!(motorR.getTachoCount()<100)) 
                  {Optimus.stop();
                  int dist = sonic.getDistance();
                  motorR.resetTachoCount();
                  while ((!touch.isPressed()) && motorR.getTachoCount() < Optimus.cmToTacos(dist+3))
                  {  
                     Optimus.go();   
                  }
                  while (motorR.getTachoCount()>0)
                  {
                     Optimus.goReverse();
                  }
                  motorR.resetTachoCount();
                  }
                 }
            }
         }
         
         else if (menu == 0 || menu > 2)
         {
            LCD.drawString("Error!", 0, 0);
         }
         
         if(Button.RIGHT.isDown() && flag == false)
         {
            menu++;
            while (Button.RIGHT.isDown())
            {}
         }
         
         if(Button.LEFT.isDown() && flag == false)
         {
            menu--;
            while(Button.LEFT.isDown())
            {}
         }
         
      }
   }
}
