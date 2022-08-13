import lejos.nxt.*;
public class FollowLine
{
public static void main(String[] args) throws InterruptedException
{
   LightSensor scaner = new LightSensor(SensorPort.S1);
   MotorPort MR;
   MotorPort ML;
   ML = MotorPort.B;
   MR = MotorPort.A;
   int counter = 0;
   int power = 0;
   int x =80;
   int y =80;
   boolean right = true;
   int menucontrol = 1;
   boolean flag = true;
   int[] notes = new int[100];
   int index = 0;
    while (flag)
    {
       if(Button.RIGHT.isDown())
       {
          LCD.clear();
          if (menucontrol==3)
          { menucontrol=1;}
          else 
          { menucontrol++;}
          while(Button.RIGHT.isDown())
          {
             ;
          }
       }
       if(Button.LEFT.isDown())
       {
          LCD.clear();
          if(menucontrol==1)
          {menucontrol=3;}
          else
          {menucontrol--;}
          while(Button.LEFT.isDown())
          {
             ;
          }
       }
       if(menucontrol==1)
       {
          LCD.drawString("Speed 1", 1, 1);
          LCD.drawString("Power: 70", 1, 3);
          if(Button.ENTER.isDown())
          {
             power=70;
             while(Button.ENTER.isDown())
             {
                ;
             }
             break;
          }
       }
       if(menucontrol==2)
       {
          LCD.drawString("Speed 2", 1, 1);
          LCD.drawString("Power: 80", 1, 3);
          if(Button.ENTER.isDown())
          {
             power=80;
             while(Button.ENTER.isDown())
             {
                ;
             }
             break;
             
          }
       }
       if(menucontrol==3)
       {
          LCD.drawString("Super Speed", 1, 1);
          LCD.drawString("Power: A LOT", 1, 3);
          if(Button.ENTER.isDown())
          {
             power=100;
            
             while(Button.ENTER.isDown())
             {
                ;
             }
             break;
          }
       }
              
    }
    LCD.clear();
    LCD.drawString("Place on black", 0, 2);
  Button.waitForAnyPress();
  scaner.calibrateLow();
  LCD.clear();
  LCD.drawString("Place on white", 0, 2);
  Button.waitForAnyPress();
  scaner.calibrateHigh();  
  LCD.clear();
  LCD.drawString("Go! Go! Go!", 1, 2);
  Button.waitForAnyPress();

    LCD.clear();
   MR.resetTachoCount();
   ML.resetTachoCount();
   
   while (!(Button.ESCAPE.isDown()))
   {
      MR.resetTachoCount();
      ML.resetTachoCount();
   
      while(scaner.getLightValue()<20)
      {
         Optimus.goSpeed(power);
      }
      Optimus.stop();
      notes[index] = MR.getTachoCount()+207;
      index++;
      MR.resetTachoCount();
      ML.resetTachoCount();
      while(scaner.getLightValue()>=20 && ML.getTachoCount()< x && right)
      {
         ML.controlMotor(90, 1);
         MR.controlMotor(90, 2);
      }
      Optimus.stop();
      MR.resetTachoCount();
      ML.resetTachoCount();
      x = 80;
      y = 160;
      
      if(scaner.getLightValue()>30)
      {
         right = false;
         while(scaner.getLightValue()>=20 && MR.getTachoCount()<y && (!(right)))
         {
            ML.controlMotor(90, 2);
            MR.controlMotor(90, 1);
         }
         MR.resetTachoCount();
         ML.resetTachoCount();
         x = 160;
         y = 80;
         
      if(scaner.getLightValue()>=20)
      {
         right = true;
       
      }
      }
      
      
      
      
      if(scaner.getLightValue()>=20)
      {
         counter++;
         if (counter>9)
         {
         Optimus.stop();
         LCD.drawString("Done", 1, 1);
         for(int i=0;i<index+1;i++)
         {
            Sound.playNote(Sound.PIANO, notes[i], 100);
         }
         break;
         }
      } 
      
      
      
      
      
   }
}
}
