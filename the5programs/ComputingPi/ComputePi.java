import java.lang.Math;
import java.text.DecimalFormat;

public class ComputePi {

   private static DecimalFormat df = new DecimalFormat("#.######");

   public static void main(String[] args) {
      throwDarts(1000);
      throwDarts(10000);
      throwDarts(100000);
      throwDarts(1000000);
      throwDarts(100000000);
   }

   public static void throwDarts(int n) {  // n = number of darts thrown
      double m = 0.0;  // m = number of darts tthat are inside
      double d;  // d = distance from center
      double r = 1.0;   // r = radius of the circle
      for (int i = 0; i < n; i++) {
         Dart newdart = new Dart();
         d = distance(newdart);
         if (d <= r) {
            m++;
         }
      }
      System.out.println("N = " + n + "\nApprox. Pi: " + df.format((4*m)/n) + "\n");
   }
   
   public static double distance(Dart x) {  // Distance from center = (0, 0)
       return Math.sqrt((x.getX()*x.getX())+(x.getY()*x.getY()));
   }

}  // End class