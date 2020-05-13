import java.util.Random;
import java.util.Scanner;

public class TestQueen
{
    public static final int SIZE=8;
    public static Random rand = new Random();
    public static Scanner in = new Scanner(System.in);
    
    public static void debug(String a) {
       System.out.println(a);
    }

    public static void main(String[] args)
    {
        char[][] board = new char[SIZE][SIZE];
        initBoard(board);
        
        System.out.println("How many queens to place?");
        int x = in.nextInt();
        in.nextLine();
        randomPlaceMethod(x, board);
       
      // System.out.println("Time Testing starting...\n");
      // double start, end, time;
/*
       System.out.println("Backtrack Only:");
       start = System.nanoTime();
       randomPlaceMethod(0, board);
       end = System.nanoTime();
       time = (end - start) * 0.000000001;
       System.out.println("Time taken: " + time + " seconds.");
       System.out.println("");

       
       System.out.println("Glue 1 Queen:");
       start = System.nanoTime();
       randomPlaceMethod(1, board);
       end = System.nanoTime();
       time = (end - start) * 0.000000001;
       System.out.println("Time taken: " + time + " seconds.");
       System.out.println("");

       System.out.println("Glue 2 Queens:");
       start = System.nanoTime();
       randomPlaceMethod(2, board);
       end = System.nanoTime();
       time = (end - start) * 0.000000001;
       System.out.println("Time taken: " + time + " seconds.");
       System.out.println("");

       System.out.println("Glue 3 Queens:");
       start = System.nanoTime();
       randomPlaceMethod(3, board);
       end = System.nanoTime();
       time = (end - start) * 0.000000001;
       System.out.println("Time taken: " + time + " seconds.");
       System.out.println("");

       System.out.println("Glue 4 Queens:");
       start = System.nanoTime();
       randomPlaceMethod(4, board);
       end = System.nanoTime();
       time = (end - start) * 0.000000001;
       System.out.println("Time taken: " + time + " seconds.");
       System.out.println("");

       System.out.println("Glue 5 Queens:");
       start = System.nanoTime();
       randomPlaceMethod(5, board);
       end = System.nanoTime();
       time = (end - start) * 0.000000001;
       System.out.println("Time taken: " + time + " seconds.");
       System.out.println("");

       System.out.println("Glue 6 Queens:");
       start = System.nanoTime();
       randomPlaceMethod(6, board);
       end = System.nanoTime();
       time = (end - start) * 0.000000001;
       System.out.println("Time taken: " + time + " seconds.");
       System.out.println("");

       System.out.println("Glue 7 Queens:");
       start = System.nanoTime();
       randomPlaceMethod(7, board);
       end = System.nanoTime();
       time = (end - start) * 0.000000001;
       System.out.println("Time taken: " + time + " seconds.");
       System.out.println("");

       System.out.println("Glue 8 Queens:");
       start = System.nanoTime();
       randomPlaceMethod(8, board);
       end = System.nanoTime();
       time = (end - start) * 0.000000001;
       System.out.println("Time taken: " + time + " seconds.");
       System.out.println("");
       
       */

    }

    public static void randomPlaceMethod(int x, char[][] board) {
      debug("Placing : " + x);
      randomStart(x, board);
      debug("Starting solve.");
      boolean solved = completeBoard(board);
      if (solved) {
         System.out.println("Solved!");
         printBoard(board);
      }
      else { 
         System.out.println("Solution with this start is not possible.");
       }  
      
   }

    public static void randomStart(int x, char[][] board) {
      if (x > 8) {
         System.out.print("Too many Queens.");
         System.exit(0);
      }
      int count = 1;
      boolean done = false;
      while(!done) {
         int r, c;
         for (int i = 0; i < x; i++) {
            r = rand.nextInt(8);
            c = rand.nextInt(8);
            if(board[r][c] != 'Q') {
               board[r][c] = 'Q';
            }
            else {
               i--;
            }
         }
        // printBoard(board);
         boolean valid = checkValidity(board);
         if(valid) {
            debug("Valid placement. Queens placed: " + x);
            debug("Rounds took to get valid placement: " + count);
          //  printBoard(board);
            done = true;
         }
         else {
          //  debug("Invalid placement. Starting again...");
            count++;
            initBoard(board);
            valid = true;
         }
      }
    }
    
    public static boolean checkValidity(char[][] board) {
       // check rows
       for(int i = 0; i < SIZE; i++) {
          for( int j = 0; j < SIZE; j++) {
             if (board[i][j] == 'Q') {
                if (check(board, i, j)) {}
                else {
                   return false;
                }
             }
          }
       }
       return true;
    }

    public static boolean check(char[][] board, int row, int col)
    {
        int i,j;

        // Check column
        for (i=0; i<SIZE; i++)
            if (board[i][col] == 'Q' && i != row)
                return false;

        // Check row
        for (j=0; j<SIZE; j++)
            if (board[row][j] == 'Q' && j != col)
                return false;

        // Check diagonal down and right
        for (i=row, j=col; i < SIZE && j < SIZE; i++, j++)
            if (board[i][j] == 'Q' && i != row && j != col)
                return false;

        // Check diagonal up and left
        for (i=row, j=col; i >=0 && j >=0 ; i--, j--)
            if (board[i][j] == 'Q' && i != row && j != col)
                return false;

        // Check diagonal up and right
        for (i=row, j=col; i >=0 && j < SIZE; i--, j++)
            if (board[i][j] == 'Q' && i != row && j != col)
                return false;

        // Check diagonal down and left
        for (i=row, j=col; i < SIZE && j >=0 ; i++, j--)
            if (board[i][j] == 'Q' && i != row && j != col)
                return false;

        // Must be safe
        return true;
    }    

     // Everything below this is from:
     // https://cs.carleton.edu/faculty/dmusican/cs201w08/code/recursion/Queens.java
    // Blank out a chessboard. Use a hyphen to indicate no pieces are on
    // a space.
    public static void initBoard(char[][] board)
    {
        for (int i=0; i < SIZE; i++)
            for (int j=0; j < SIZE; j++)
                board[i][j] = ' ';
    }

    // Display a chessboard to the terminal window. Just print out whatever
    // is in each position on the board.
    public static void printBoard(char[][] board)
    {
        for (int i=0; i < SIZE; i++)
        {
            for (int j=0; j < SIZE; j++)
                System.out.print("[" +board[i][j] + "]");
            System.out.println();
        }
        System.out.println();
    }

    // Check to see if a potential location (row, col) on the board is
    // "safe", which means that it cannot be taken by a queen already
    // on the board.
    public static boolean safe(char[][] board, int row, int col)
    {
        int i,j;

        // Check column
        for (i=0; i<SIZE; i++)
            if (board[i][col] == 'Q')
                return false;

        // Check row
        for (j=0; j<SIZE; j++)
            if (board[row][j] == 'Q')
                return false;

        // Check diagonal down and right
        for (i=row, j=col; i < SIZE && j < SIZE; i++, j++)
            if (board[i][j] == 'Q')
                return false;

        // Check diagonal up and left
        for (i=row, j=col; i >=0 && j >=0 ; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Check diagonal up and right
        for (i=row, j=col; i >=0 && j < SIZE; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        // Check diagonal down and left
        for (i=row, j=col; i < SIZE && j >=0 ; i++, j--)
            if (board[i][j] == 'Q')
                return false;

        // Must be safe
        return true;
    }

    // completeBoard fills in the board with a successful set of
    // queens and returns true if it can be done; otherwise, it leaves
    // the board unchanged and returns false
    public static boolean completeBoard(char[][] board)
    {

        // Count queens, return if complete
        int numQueens = 0;
        for (int i=0; i < SIZE; i++)
            for (int j=0; j < SIZE; j++)
                if (board[i][j] == 'Q')
                    numQueens++;

        if (numQueens == SIZE)
            return true;

        // If not eight queens, must be fewer: try to add another
        for (int i=0; i < SIZE; i++)
            for (int j=0; j < SIZE; j++)
                if (safe(board,i,j))
                {
                    board[i][j] = 'Q';
                    if (completeBoard(board))
                        return true;
                    else
                        board[i][j] = ' ';
                }
        
        // Failed to find solution
        return false;
    }

}