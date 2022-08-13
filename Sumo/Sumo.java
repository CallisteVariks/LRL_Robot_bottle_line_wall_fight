import lejos.nxt.*;

public class Sumo
{
   public static void main(String[] args) throws InterruptedException
   {
      LightSensor scanner = new LightSensor(SensorPort.S1);
      TouchSensor tiku = new TouchSensor(SensorPort.S3);
      UltrasonicSensor dist = new UltrasonicSensor(SensorPort.S2);

      LCD.drawString("I'm waiting...", 1, 3);
      Button.waitForAnyPress();
      LCD.clear();
      scanner.calibrateHigh();
      while (scanner.getLightValue() > 80)
      {
         Megatron.Drive();
      }
      Megatron.Stop();
      scanner.calibrateLow();
      while (scanner.getLightValue() < 20)
      {
         Megatron.Drive();
      }
      Thread.sleep(200);
      Megatron.Stop();
      Music.m();
    
      LCD.drawString("Let's do this!", 1, 3);
      Button.waitForAnyPress();
      LCD.drawString("Come at me bro!", 1, 3);
      while (true)
      {
         if (scanner.getLightValue() < 21)
         {
            if (tiku.isPressed())
            {
               Megatron.Stop();
               Megatron.Drive();
            }
            else
            {
               Megatron.Stop();
               Megatron.CCWspin();
            }

         }
         if (scanner.getLightValue() > 20 && scanner.getLightValue() < 95)
         {
            if (tiku.isPressed())
            {
               Megatron.Stop();
               Megatron.Reverse();
            }
            else
            {
               if (dist.getDistance() > 39)
               {
                  Megatron.CCWspin();
               }
               else
               {

                  Megatron.Stop();
                  Megatron.Drive();
               }

            }

         }
         if (scanner.getLightValue() > 95)
         {
            LCD.clear();
            Megatron.Stop();
            Music.f();
            break;
         }
      }

   }
}
