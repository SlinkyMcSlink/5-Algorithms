import java.util.Random;
import java.util.Scanner;

public class PrimeTesting {
   
   private static Random rand = new Random();
   private static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      boolean done = false;
      int n = 0;
      while (!done) {
         System.out.println("Random number (r) or custom number (c)?");
         String input = in.nextLine();
         if (input.equals("r")) {
            n = rand.nextInt() +1;
            if (n < 0) {
               n *= -1;
            }
            done = true;
         }
         else if (input.equals("c")) {
            System.out.println("Enter an Integer: ");
            n = in.nextInt();
            if (n < 0) {
               n *= -1;
            }
            done = true;
         }
         else{
            System.out.println("Enter an 'r' or 'c'.");
         }
      }


      System.out.println("Number is: " + n);
      checkIfPrime(10, n);
      checkIfPrime(100, n);
      checkIfPrime(1000, n);
      checkIfPrime(10000, n);
      checkIfPrime(100000, n);
      checkIfPrime(1000000, n);
      truePrime(n);
   }   

   public static void checkIfPrime(int k, int num) {
      boolean prime = true; 
      for (int i = 0; i < k; i++) {
         int x = rand.nextInt(num) + 1;
         if ( x == num) {
            x -= 1;
         }
         else if ( x == 1) {
            x += 1;
         }
        // System.out.println("x = " +x);
         if (num % x == 0) {
            prime = false;
         }
      }
      System.out.println("K value: " + k);
      System.out.println("Number is prime: " + prime + "\n");
   }

   public static void truePrime(int num) {
      boolean prime = true; 
      for (int i = 2; i < num; i++) {;
         if (num % i == 0) {
            prime = false;
         }
      }
      System.out.println("Real Answer");
      System.out.println("Number is prime: " + prime + "\n");
   }

}