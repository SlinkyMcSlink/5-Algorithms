import java.util.Random;
import java.text.DecimalFormat;

public class Dart {
   private double x;  // X coordinate
   private double y;  // Y coordinate
   private static Random rand =  new Random();
   private static DecimalFormat df = new DecimalFormat("#.####");

   public Dart() {
      x = rand.nextDouble();
      if (rand.nextBoolean()) {
         x *= -1;
      }
      y = rand.nextDouble();
      if (rand.nextBoolean()) {
         y *= -1;
      }
   }

   public double getX() {
      return x;
   }
   
   public double getY() {
      return y;
   }

   public String toString() {
      return "[ " + df.format(x) + ", " + df.format(y) + " ]";
   }
   
}