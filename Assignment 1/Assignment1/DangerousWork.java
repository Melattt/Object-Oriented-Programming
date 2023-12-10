package Assignment1;

import java.util.Scanner;

public class DangerousWork {
    public static void main(String[] args) {
        // Counter to count the days
        int day = 1;
        Scanner scan = new Scanner( System.in );
        System.out.print("How much would you like to earn? ");

        float money = scan.nextFloat(); 
        // Iterating until the money gets below 0.01
        while (money > 0.01){
            money = money / 2;
            day++;
        }
        // Deduct 1 if money != 0.01
        if(money!=0.01){
            day = day -1;
        }
        System.out.printf("You will have your money in %d days.", day);

        scan.close();
    }
}
