import lejos.nxt.*;
public class Optimus
{
private int pwr;
MotorPort ML = MotorPort.B;
MotorPort MR = MotorPort.A;
UltrasonicSensor eyes = new UltrasonicSensor(SensorPort.S1);
TouchSensor impact = new TouchSensor(SensorPort.S4);

public static void go(int distance)
{
   MotorPort ML = MotorPort.B;
   MotorPort MR = MotorPort.A;
   distance = distance *18;
   while(ML.getTachoCount() < distance)
   {
      MR.controlMotor(100, 1);
      ML.controlMotor(100, 1);
   }
}
public static void goReverse()
{
   MotorPort ML = MotorPort.B;
   MotorPort MR = MotorPort.A;
      MR.controlMotor(90, 2);
      ML.controlMotor(90, 2);
   
}
public static void goReverse(int distance)
{
   MotorPort ML = MotorPort.B;
   MotorPort MR = MotorPort.A;
   distance = distance * 18;
   distance = -distance;
   ML.resetTachoCount();
   MR.resetTachoCount();
   while(ML.getTachoCount() > distance)
   {
      MR.controlMotor(90, 2);
      ML.controlMotor(90, 2);
   }
}
public static void stop()
{
   MotorPort ML = MotorPort.B;
   MotorPort MR = MotorPort.A;
   MR.controlMotor(0, 3);
   ML.controlMotor(0, 3);
}
public static void goRoundTacos(int taco)
{
   MotorPort ML = MotorPort.B;
   MotorPort MR = MotorPort.A;
   ML.resetTachoCount();
   MR.resetTachoCount();
   while (MR.getTachoCount() <taco)
   {
      MR.controlMotor(90, 1);
      ML.controlMotor(90, 2);
   }
}
public static int cmToTacos(int cm)
{
   int dist = cm * 18;
   return dist;
}
public static void go()
{
   MotorPort ML = MotorPort.B;
   MotorPort MR = MotorPort.A;
   
      MR.controlMotor(90, 1);
      ML.controlMotor(90, 1);
   
}
}