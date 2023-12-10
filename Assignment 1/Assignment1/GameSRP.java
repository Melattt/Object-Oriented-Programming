package Assignment1;

import java.util.Scanner;
import java.util.Random;

public class GameSRP {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        int choice_of_player =1;
        int player = 0;
        int computer = 0;
        int draw = 0;
        
        while (choice_of_player !=0 ){            
            int computer_random = random.nextInt(3)+1;
            System.out.print("Scissor (1), rock (2), paper (3) or 0 to quit: ");
            choice_of_player =scan.nextInt();
     
            switch (computer_random) {

                case 1:
                switch (choice_of_player) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("It's a draw!");
                        draw++;
                        break;
                    case 2:
                        System.out.println("You won, computer had scissor");
                        player++;
                        break;
                    case 3:
                        System.out.println("You lost, computer had scissor!");
                        computer++;
                        break;
                    default:
                        System.out.println("Invalid");
                }
                break;

                case 2:
                switch (choice_of_player) {
                    case 1:
                        System.out.println("You lost, computer had rock!");
                        computer++;
                        break;
                    case 2:
                        System.out.println("It's a draw!");
                        draw++;
                        break;
                    case 3:
                        System.out.println("You won, computer had rock!");
                        player++;
                        break;
                    default:
                        System.out.println("Invalid");
                }
                break;

                case 3:
                switch (choice_of_player) {
                    case 1:
                        System.out.println("You won, computer had paper!");
                        player++;
                        break;
                    case 2:
                        System.out.println("You lost, computer had paper!");
                        computer++;
                        break;
                    case 3:
                        System.out.println("It's a draw!");
                        draw++;
                        break;
                    default:
                        System.out.println("Invalid");
                }           
            }
        }
        System.out.println("Score: "+player+" (you) "+computer+" (computer) "+draw+" (draw).");
        scan.close();   
    }
}
