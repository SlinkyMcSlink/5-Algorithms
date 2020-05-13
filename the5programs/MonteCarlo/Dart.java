import java.text.DecimalFormat;
import java.util.Random;

public class Dart {
   private int x;  // X coordinate
   private int y;  // Y coordinate
   private static Random rand =  new Random();
   private static DecimalFormat df = new DecimalFormat("#.####");

   public Dart() {
      x = rand.nextInt(10);
      if (rand.nextBoolean()) {
         x *= -1;
      }
      y = rand.nextInt(10);
      if (rand.nextBoolean()) {
         y *= -1;
      }
   }

   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }

   public String toString() {
      return "[ " + df.format(x) + ", " + df.format(y) + " ]";
   }
   
}