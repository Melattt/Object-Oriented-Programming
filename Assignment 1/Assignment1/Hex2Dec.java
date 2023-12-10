package Assignment1;

import java.util.Scanner;
  
public class Hex2Dec{ 

    // A function to convert hexdecimal to decimal 
    static int hexToDecimal(String hex) { 
        return Integer.parseInt(hex, 16);
    } 
    // Main program
    public static void main (String[] args)  {
        Scanner scan = new Scanner(System.in); 

        System.out.print("Enter a hex number: ");
        String input = scan.nextLine();   

        System.out.println("The decimal value for " + input + " is " + hexToDecimal(input));
        scan.close(); 
    }
} 