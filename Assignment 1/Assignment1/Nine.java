package Assignment1;

import java.util.Scanner;
import java.util.Random;

public class Nine {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        
        // Asks if the player is ready to play and generates a random number for the first dice
        System.out.println("Ready to play? (Y/N):");
        char cha = scan.next().charAt(0);
        if(cha == 'Y' || cha == 'y'){
            int player_dice1 = random.nextInt(6)+1;
        System.out.println("You rolled "+ player_dice1 );
        
        // Asks if the player wants to the second dice
        // If yes, generates anew random number else dice 2 will be 0
        System.out.println("Want to roll second dice(Y/N):");
        char ch = scan.next().charAt(0);
        int player_dice2 = 0;
        if(ch=='Y' || cha=='y'){
            player_dice2 = random.nextInt(6)+1;
        }
        // Total sum of player score on dice 1 and dice 2
        int total_player_score = player_dice1 + player_dice2;
        System.out.println("You rolled " + player_dice2 + " and in total you have " + total_player_score);


        // Computer's turn
        // Generates a random number for the computer on the first dice
        int computer_dice1 = random.nextInt(6)+1;
        System.out.println("The computer rolled "+ computer_dice1);

        // If generated number on  first dice is less than or equal to 4 the 
        // second dice will be generated else the second dice will be 0
        int computer_dice2=0;
        if(computer_dice1 <= 4){
            computer_dice2 = random.nextInt(6) + 1;
        }

        // Total sum of computer score on dice 1 and dice 2
        int total_computer_score = computer_dice1 + computer_dice2;
        // If dice 2 is greater than 0, the computer has rolled again
        if(computer_dice2 > 0) {
            System.out.println("The computer rolls again and gets "+ computer_dice2 +" in total " + total_computer_score);
        }else{
            System.out.println("The computer didn't roll again and gets " + total_computer_score +" in total");
        }

        if(total_player_score >= 10){
            System.out.println("You lose!");
        } else if(total_player_score > total_computer_score){
            System.out.println("You won!");
        } else if(total_computer_score <= 9) {
            System.out.println("Computer won!");
        } else{
            System.out.println("No result");
        }
        }
        scan.close();
    }     
}
