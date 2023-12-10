package Assignment1;

import java.util.Scanner;

public class Diamond {
    public static void main (String[] args) {   
        Scanner scan = new Scanner(System.in);
        int number = 1;

        while( number!=0 ){  
            System.out.print("Give a positive number: ");
            number = scan.nextInt();

            // Top of the diamond
            // Iterating to get the top of the diamond(starts by 1 and add in every line )
            for (int i = 1; i < 2 * number; i += 2){    
            
                for (int j = 0; j < number - 1 - i / 2; j++){
                    System.out.print(" ");       // Print space
                }
                for (int j = 0; j < i; j++){                
                    System.out.print("*");       // Print asterix
                }
                System.out.println("");
            }

            // Bottom of the diamond
            // Iterating to get the bottom of the diamond(starts from(2 * number - 3) down to zero )
            for (int i = 2 * number - 3; i > 0; i -= 2){   
            
                for (int j = 0; j < number -1 - i / 2; j++){               
                    System.out.print(" ");     // Print space        
                }
                for (int j = 0; j < i; j++){               
                    System.out.print("*");     // Print asterix  
                }
                System.out.print("\n");                        
            }             
        }
        scan.close();
    }
}
