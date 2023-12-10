package Assignment1;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = scan.nextInt();

        System.out.print("Enter month (1-12): ");
        int month = scan.nextInt();

        System.out.print("Enter day of the month (1-31): ");
        int day = scan.nextInt();

        if (month == 1 || month == 2) {
            month = month + 12;
            year = year - 1;
        }

        int j = year / 100;
        int k = year % 100;
        int h = ( day + ((26 * ( month + 1))/ 10) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
        String day_ = "";

        switch(h) {
 
            case 0:
                day_ = "Saturday";
                break;
            case 1:
                day_ = "Sunday";
                break;
            case 2:
                day_ = "Monday";
                break;
            case 3:
                day_ = "Tuesday";
                break;
            case 4:
                day_ = "Wednesday";
                break;
            case 5:
                day_ = "Thursday";
                break;
            case 6:
                day_ = "Friday";
                break;   
            default:
                System.out.println("Invalid");     
        }
        System.out.println("Day of week is " + day_ );
        scan.close();
    }   
}
