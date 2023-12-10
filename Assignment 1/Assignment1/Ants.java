package Assignment1;

import java.util.Random;

public class Ants {
  
   // A function to check if the square is visited or not
    static boolean FullBoard(int chess_board[][]) {
        for(int i=0;i<8;i++) {
           for(int j=0;j<8;j++) {
               if(chess_board[i][j] == 0) {
                   return false;
                }
            }  
        }
        return true;
    }
  
   // Main 
    public static void main(String[] args) {
        // Heading
        System.out.println("Ants");
        System.out.println("===========\n");
        // A variable to store the average number of steps
        double average_of_the_steps = 0;
        // for loop to iterate 10 times
        Random rand = new Random();
        for(int simulation=1; simulation<=10; simulation++) {
            // Creating a chess board
            int chess_board[][] = new int[8][8];
            // Reseting the board
            for(int i=0; i<8; i++) {
                for(int j=0; j<8; j++) {
                    chess_board[i][j] = 0;
                }  
            }
          
            // Generating random number
            int X = rand.nextInt(8);
            int Y = rand.nextInt(8);
            //set location to 1
            chess_board[X][Y] = 1;
            //store number of steps
            int step = 0;
            
            //while loop is not break
            while(!FullBoard(chess_board)) {
                //move ant to any location
                int shift = rand.nextInt(4);
                // Direction the ant moves
                if(shift == 0) {            // If shift = 0
                    if(X>0) {               // And starting location of X is greater than 0
                        X--;                // Deduct
                        step++;
                    }
                }else if(shift == 1) {       // If shift = 1 
                    if(X<7) {                // And starting location of X is less than 7
                        X++;                 // Add
                        step++;
                    }
                }else if(shift == 2) {       // If shift = 2
                    if(Y>0) {                // And starting location of Y is greater than 0
                        Y--;                 // Deduct
                        step++;
                    }
                }else if(shift == 3) {       // If shift = 2
                    if(Y<7) {                // And starting location of Y is less than 7
                        Y++;                 // Add
                        step++;
                    }
                }
                chess_board[X][Y] = 1;
            }
            average_of_the_steps += step;

            System.out.println("Number of steps in simulation "+simulation+" : "+step);
        }
        System.out.println("Average amount of steps : "+average_of_the_steps/10);
    }
}
