import java.util.Random;
import java.util.Scanner;

public class SearchArray {
   
   private static Random rand = new Random();
   private static Scanner in = new Scanner(System.in);
   private static int[] array = new int[1000];
   private static boolean found = false;
   
   public static void main(String[] args) {
      createArray();
      boolean done = false;
      String input;
      int count = 0;
      int x;
      while (!done) {
         System.out.println("Enter 'r' for a new round, 't' for 100 tests, or 'q' to quit.");
         input = in.nextLine();
         if (input.equals("r")) {
            x = createTarget();
            count = findTarget(x);
            System.out.println(" ");
            System.out.println("Target: " + x );
            System.out.println("Found: " + found);
            System.out.println("Guesses: " + count);
            System.out.println(" ");
         }
         else if (input.equals("t") ){
            System.out.println("100 Tests started...");
            int fails = 0;
            count = 0;
            for (int i = 0; i < 100; i++) {
               x = createTarget();
               int temp = findTarget(x);
               if (temp > 5000) {
                  fails++;
               }
               count += temp;
            }
            System.out.println("Average number of guesses: " + (count/100) );
            System.out.println("Number of number of times over 5000 guesses: " + fails);
         }
         else if (input.equals("q") ){
            done = true;
         }
         else {
            System.out.println("Invalid Input.");
         }
      }      
   }

   public static void createArray() {
      for (int i = 0; i < 1000; i++) {
         array[i] = rand.nextInt();
      }
   }

   public static int findTarget(int target) {
      found = false;
      int count = 0;
      boolean done = false;
      while (!done) {
         if (count > 5000) {
            done = true;
         }
         else {
            int guess = rand.nextInt(1000);
            count++;
            if (array[guess] == target) {
               done = true;
               found = true;
            }
         }
      }
      return count;
   }

   public static int createTarget() {
      int index = rand.nextInt(1000);
      return array[index];
   }

}