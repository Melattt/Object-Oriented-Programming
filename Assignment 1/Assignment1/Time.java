package Assignment1;

import java.util.Scanner;

public class Time {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Give a number of seconds: ");
        int seconds = scan.nextInt();

        int hour = seconds / 3600;       // Divide by 3600 to get hour
        int x = seconds % 3600;

        int min = x / 60;               // Divide the remaining seconds by 60 to get minutes
        int s = x % 60;                 // The seconds remaining

        System.out.println( "This corresponds to: " + hour + " hours, " + min+ " minutes and " + s +" seconds.");
        scan.close();
    }
}