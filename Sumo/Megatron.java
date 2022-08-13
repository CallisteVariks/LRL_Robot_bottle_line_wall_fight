import lejos.nxt.*;

import java.lang.Math;

public class Megatron
{

   public static void Drive() throws InterruptedException
   {
      MotorPort mr = MotorPort.C;
      MotorPort ml = MotorPort.A;
      mr.controlMotor(90, 2);
      ml.controlMotor(90, 2);
   }

   public static void Reverse() throws InterruptedException
   {
      MotorPort mr = MotorPort.C;
      MotorPort ml = MotorPort.A;
      mr.controlMotor(90, 1);
      ml.controlMotor(90, 1);
   }

   public static void DriveFor(int dist) throws InterruptedException
   {
      MotorPort mr = MotorPort.C;
      MotorPort ml = MotorPort.A;
      double rWheel = 3.1;
      double cWheel = 2 * Math.PI * rWheel; // circumpherence of the wheel
      double cmToTacho = 360 / cWheel; // 1 cm = n tacho
      int distTacho = dist * (int) cmToTacho;
      while (mr.getTachoCount() > -distTacho)
      {
         mr.controlMotor(90, 2);
         ml.controlMotor(90, 2);
      }
   }

   public static void ReverseFor(int dist) throws InterruptedException
   {
      MotorPort mr = MotorPort.C;
      MotorPort ml = MotorPort.A;
      double rWheel = 3.1;
      double cWheel = 2 * Math.PI * rWheel; // circumpherence of the wheel
      double cmToTacho = 360 / cWheel;
      int distTacho = dist * (int) cmToTacho;
      while (mr.getTachoCount() < distTacho)
      {
         mr.controlMotor(90, 1);
         ml.controlMotor(90, 1);
      }
   }

   public static void CWspin() throws InterruptedException
   {
      MotorPort mr = MotorPort.C;
      MotorPort ml = MotorPort.A;
      mr.controlMotor(90, 1);
      ml.controlMotor(90, 2);
   }

   public static void CCWspin() throws InterruptedException
   {
      MotorPort mr = MotorPort.C;
      MotorPort ml = MotorPort.A;
      mr.controlMotor(90, 2);
      ml.controlMotor(90, 1);
   }

   public static void Stop() throws InterruptedException
   {
      MotorPort mr = MotorPort.C;
      MotorPort ml = MotorPort.A;
      mr.controlMotor(90, 3);
      ml.controlMotor(90, 3);
   }

   public static void ResetTacho() throws InterruptedException
   {
      MotorPort mr = MotorPort.C;
      MotorPort ml = MotorPort.A;
      mr.resetTachoCount();
      ml.resetTachoCount();
   }

   public static void SeekAndDestroy() throws InterruptedException
   {
      UltrasonicSensor sound = new UltrasonicSensor(SensorPort.S2);
      LightSensor light = new LightSensor(SensorPort.S1);
      TouchSensor touch = new TouchSensor(SensorPort.S3);
      
      while (true)
      if (sound.getDistance() > 50 && !(touch.isPressed()))
      {
         Megatron.CCWspin();
         Thread.sleep(500);

         Megatron.Stop();
         Megatron.ResetTacho();
         int dist = sound.getDistance();
         LCD.drawInt(dist, 0, 4); // displays distance at which the found obj
                                  // is located
         Megatron.Drive();
      }
      else if (sound.getDistance() > 50 && touch.isPressed())
      {
         while (touch.isPressed())
         {
            Megatron.Reverse();
         }
      }
   }

   public static void ReversePush()
   {
      MotorPort mr = MotorPort.C;
      MotorPort ml = MotorPort.A;
      TouchSensor touch = new TouchSensor(SensorPort.S3);
      LightSensor light = new LightSensor(SensorPort.S1);

      while (touch.isPressed() && light.getLightValue() < 90)
      {
         mr.controlMotor(90, 1);
         ml.controlMotor(90, 1);
      }
   }
}
