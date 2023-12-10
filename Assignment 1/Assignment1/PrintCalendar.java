package Assignment1;

import java.util.Scanner;

public class PrintCalendar {
    // Main 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Ask user to enter the year
        System.out.print("Enter a year after 1800: ");
        int year = scan.nextInt();

        // Ask user to enter the month
        System.out.print("Enter a month (1-12): ");
        int month = scan.nextInt();
        scan.close();
        // Printing calendar
        calendar(year, month);
    }

    // Calendar
    public static void calendar(int year, int month) {
        // Heading
        Heading(year, month);
        // Body
        Body(year, month);
    }

    // Heading(printing title)
    public static void Heading (int year, int month) {
        System.out.println(name_of_months(month)+ " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
    }

    // Months
    public static String name_of_months(int month) {
        String month_name = "";
        switch (month) {
            case 1: month_name = "January"; 
                break;
            case 2: month_name = "February";
                break;
            case 3: month_name = "March";
                break;
            case 4: month_name = "April"; 
                break;
            case 5: month_name = "May"; 
                break;
            case 6: month_name = "June"; 
                break;
            case 7: month_name = "July"; 
                break;
            case 8: month_name = "August"; 
                break;
            case 9: month_name = "September"; 
                break;
            case 10: month_name = "October"; 
                break;
            case 11: month_name = "November"; 
                break;
            case 12: month_name = "December";
                break;
            default:
                System.out.println("Invalid");
        }
        return month_name;
    }

    // Body
    public static void Body(int year, int month) {
        // First day for the given month
        int day_1 = first_day_of_week(year, month);

        // Total number of days in the given month
        int days_in_month = no_days_in_month(year, month);

        // Space before the first day of the month
        int i = 0;
        for (i = 0; i < day_1; i++)
            System.out.print("    ");

        for (i = 1; i <= days_in_month; i++) {
            // %4d - minimum width of three spaces, which by default, will be right-justified
            // printf - format
            System.out.printf("%4d", i);

            // To print the numbers in the next line after the 7th char
            if ((i + day_1) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    // To get the first day of the given month and year 
    public static int first_day_of_week(int year, int month) {
        final int First_day_FOR_JAN_1_1800 = 2;
        // Total days from 1800(Jan 1) until the first day of the given month and year
        int days = total_days(year, month);

        // Returns the first day of the given month and year
        return (days + First_day_FOR_JAN_1_1800) % 7;
    }

    // Number of days starting from January 1, 1800
    public static int total_days(int year, int month) {
        int total = 0;

        // Iterating to get the total days from 1800(Jan 1) to the given year(Jan 1)
        for (int i = 1800; i < year; i++)
            if (is_leap_year(i))
                total = total + 366;
            else
                total = total + 365;

        // Adding the days from Jan to the given month
        for (int i = 1; i < month; i++)
            total = total + no_days_in_month(year, i);

        // Returns the total days until the given year and month
        return total;
    }

    // Number of days in a month
    public static int no_days_in_month(int year, int month) {
        // April, June, September and November
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        // January, March, May, July, August, October and December
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        // February
        if (month == 2) 
            return is_leap_year(year) ? 29 : 28;
        // Returns 0 if month is not valid
        return 0; 
    }

    // Leap year
    public static boolean is_leap_year(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}