import lejos.nxt.Sound;

public class Music
{

   private final static int C4 = 262;
   private final static int D4 = 294;
   private final static int E4 = 330;
   private final static int F4 = 349;
   private final static int G4 = 392;
   private final static int A4 = 440;
   private final static int Gs = 415;
   private final static int As4 = 466;
   private final static int B4 = 494;
   private final static int As = 445;
   private final static int C5 = 523;
   private final static int Cs5 = 554;
   private final static int D5 = 587;
   private final static int Ds5 = 622;
   private final static int E5 = 659;
   private final static int F5 = 698;
   private final static int Fs5 = 740;
   private final static int G5 = 784;
   private final static int A5 = 880;
   private final static int Gs5 = 830;
   private final static int C6 = 1047;

   public static void m()
   {
      int vol = Sound.getVolume();
      Sound.setVolume(60);

      play(A4, 100, 500);
      play(A4, 100, 500);
      play(A4, 100, 500);
      play(F4, 100, 350);
      play(C5, 100, 150);
      play(A4, 100, 500);
      play(F4, 100, 350);
      play(C5, 100, 150);
      play(A4, 100, 1000);
      play(E5, 100, 500);
      play(E5, 100, 500);
      play(E5, 100, 500);
      play(F5, 100, 350);
      play(C5, 100, 150);
      play(Gs, 100, 500);
      play(F4, 100, 350);
      play(C5, 100, 150);
      play(A4, 100, 1000);
     // play(A5, 100, 500);
     // play(A4, 100, 350);
     // play(A4, 100, 150);
     // play(A5, 100, 500);
     // play(Gs5, 100, 250);
     // play(G5, 100, 250);
     // play(Fs5, 100, 125);
     // play(F5, 100, 125);
     // play(Fs5, 100, 250);
     // Sound.pause(250);
     // play(As, 100, 250);
     // play(Ds5, 100, 500);
     // play(D5, 100, 250);
     // play(Cs5, 100, 250);
     // play(C5, 100, 125);
     // play(As4, 100, 125);
     // play(C5, 100, 250);
     // Sound.pause(250);
     // play(F4, 100, 125);
     // play(G5, 100, 500);
     // play(F4, 100, 375);
     // play(A4, 100, 125);
     // play(C5, 100, 500);
     // play(A4, 100, 375);
     // play(C5, 100, 125);
     // play(A5, 100, 1000); 
      Sound.setVolume(vol);
   }
   
   public static void f() {
      int vol = Sound.getVolume();
      Sound.setVolume(60);

      play(E5, 100, 150);
      play(E5, 100, 300);
      play(E5, 100, 300);
      play(C5, 100, 100);
      play(E5, 100, 300);
      play(G5, 100, 550);
      play(G4, 100, 575);

      for (int i = 0; i < 2; i++) {
         play(C5, 100, 450);
         play(G4, 100, 400);
         play(E4, 100, 500);
         play(A4, 100, 300);
         play(B4, 80, 330);
         play(As4, 100, 150);
         play(A4, 100, 300);
         play(G4, 100, 200);
         play(E5, 80, 200);
         play(G5, 50, 150);
         play(A5, 100, 300);
         play(F5, 80, 150);
         play(G5, 50, 350);
         play(E5, 80, 300);
         play(C5, 80, 150);
         play(D5, 80, 150);
         play(B4, 80, 500);
      }
      Sound.setVolume(vol);
   }

   private static void play(int freq, int dur, int delay)
   {
      if (100 <= freq && freq <= 12000 && 10 <= dur && dur <= 10000
            && 10 <= delay && delay <= 10000)
      {
         Sound.playTone(freq, dur);
         try
         {
            Thread.sleep(delay);
         }
         catch (Exception e)
         {
         }
      }
   }
}