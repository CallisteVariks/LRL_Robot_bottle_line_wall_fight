import lejos.nxt.*;
public class Bottle
{
public static void main (String[] args) throws InterruptedException
{
   UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
   TouchSensor touch = new TouchSensor(SensorPort.S4);
   MotorPort motorR = MotorPort.A;
   MotorPort motorL = MotorPort.B;
   int pwr = 87;
   Button.waitForAnyPress();
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
