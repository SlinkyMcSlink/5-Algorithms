import java.util.Random;
import java.text.DecimalFormat;

public class MonteCarlo {
   private static Random rand = new Random();
   private static DecimalFormat df = new DecimalFormat("#.######");
   private static int test;
   
   public static void main(String[] args) {
      
      test = 1;
      System.out.println("");
      System.out.println("Test 1: 4sin(x) + 8");
      double start, end, time;
      double temp;
      start = System.nanoTime();
      temp = dartMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Dart Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      start = System.nanoTime();
      temp = meanMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Mean Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      start = System.nanoTime();
      temp = trapMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Trap Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      test = 2;
      System.out.println("");
      System.out.println("Test 2: 2cos(x+3) + 0.5x");

      start = System.nanoTime();
      temp = dartMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Dart Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      start = System.nanoTime();
      temp = meanMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Mean Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      start = System.nanoTime();
      temp = trapMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Trap Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      test = 3;
      System.out.println("");
      System.out.println("Test 3: 4x^2 + 8x + 2");

      start = System.nanoTime();
      temp = dartMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Dart Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      start = System.nanoTime();
      temp = meanMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Mean Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      start = System.nanoTime();
      temp = trapMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Trap Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      test = 4;
      System.out.println("");
      System.out.println("Test 4: 3.14sin(x+2) + x / 2.0");

      start = System.nanoTime();
      temp = dartMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Dart Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      start = System.nanoTime();
      temp = meanMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Mean Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      start = System.nanoTime();
      temp = trapMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Trap Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      test = 5;
      System.out.println("");
      System.out.println("Test 5: x cos(x / 2) + 3");
      start = System.nanoTime();
      temp = dartMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Dart Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      start = System.nanoTime();
      temp = meanMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Mean Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");

      start = System.nanoTime();
      temp = trapMeth();
      end = System.nanoTime();
      time = end - start;
      time = time * .000000001;
      System.out.println("Trap Meth: " + df.format(temp) + "   Time: " + df.format(time) + " seconds.");
    

      

   }
   
   public static double f(double x) { 
      switch(test) {
         case 1:
            return 4 * Math.sin(x) + 8;

         case 2:
            return 2 * Math.cos(x+3) + 0.5*x;

         case 3:
            return 4 * x * x + 8*x + 2;

         case 4:
            return 3.14 * Math.sin(x+2) + (x / 2.0);

         case 5:
            return x * Math.cos(x / 2.0) + 3;

         default:
            return (x * x) + (x * 2) + 7;
      }
   }

   public static double meanMeth() {
      double count = 0;
      for (int i = 0; i < 1000; i++) {
         count += f(rand.nextInt(11));
      }
      count = count / 1000;
      count = count * 10;
      return count;
   }
   
   public static double dartMeth() { // using a 10 x 10 rectangle
      double count = 0.0;
      for (int i = 0; i < 1000; i++) {
         Dart newDart = new Dart();
         if (newDart.getY() <= f(newDart.getX())) {
            count++;
         }
      }
      return (count / 1000.0) * 100.0;
   }
   
   public static double trapMeth() {  // function
      double temp = (0.5)*(f(0) + (2*f(1)) + (2*f(2)) + (2*f(3)) +(2*f(4)) + (2*f(5)) + (2*f(6)) + (2*f(7)) + (2*f(8))+(2*f(9)) + f(10));
      return temp;
   }
}