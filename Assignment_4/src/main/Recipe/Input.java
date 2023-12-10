package main.Recipe;
import java.util.Scanner;
import java.util.InputMismatchException;

/*Input provides methods for requesting input of different types from the user. */
public class Input {

  private Scanner in;

  /* Constructor */
  public Input(Scanner scanner) {
    in = scanner;
  }

  /* Constructor */
  public Input() {
    in = new Scanner(System.in);
  }

  /* Prompts the user to input an integer. */
  public int nextIntInRange(String prefix, int start, int end) {
    do {
      in = new Scanner(System.in);
      if (prefix != null) {
        System.out.print(prefix);
      }
      try {
        int number = in.nextInt();
        if (number < start || number > end) {
            throw new IllegalArgumentException();
        }
        return number;
      } catch (IllegalArgumentException e) {
        System.out.println("ERROR: Input must be in range from " + start + " to " + end + ".");
      } catch (InputMismatchException e) {
        System.out.println(" Invalid input ");
      } catch (Exception e) {
        System.out.println(" Invalid input ");
      }
    } while (true);
  }

  public int nextIntInRange(int start, int end) {
    return nextIntInRange(null, start, end);
  }

  /* Prompts the user to input a text. */
  public String nextLine(String prefix) {
    do {
      in = new Scanner(System.in);
      if (prefix != null) {
        System.out.print(prefix);
      }
      try {
        return in.nextLine();
      } catch (Exception e) {
        System.out.println(" Invalid input ");
      }
    } while (true);
  }

  public String nextLine() {
    return nextLine(null);
  }

  /* Prompts the user to input text token. */
  public String next(String prefix) {
    do {
      in = new Scanner(System.in);
      if (prefix != null) {
        System.out.print(prefix);
      }
      try {
        return in.next();
      } catch (Exception e) {
        System.out.println(" Invalid input ");
      }
    } while (true);
  }

  public String next() {
    return next(null);
  }

  /* Asks the user to make a decision(Yes/No). */
  public boolean YesOrNo(String prefix) {
    do {
      in = new Scanner(System.in);
      if (prefix != null) {
        System.out.print(prefix);
      }
      try {
        String s = in.next();
        if (s.toLowerCase().equals("yes") || s.toLowerCase().equals("y")) {
          return true;
        } else if (s.toLowerCase().equals("no") || s.toLowerCase().equals("n")) {
          return false;
        }
      } catch (Exception e) {
        System.out.println(" Invalid input ");
      }
    } while (true);
  }

  /* Prompts the user to input a double. */
  public Double nextDoubleInRange(String prefix, double start, double end) {
    do {
      in = new Scanner(System.in);
      if (prefix != null) {
        System.out.print(prefix);
      }
      try {
        String numberString = in.nextLine();
        numberString = numberString.replace(',', '.');
        double number = Double.parseDouble(numberString);
        if (number < start || number > end) {
            throw new IllegalArgumentException();
        }
        return number;
      } catch (IllegalArgumentException e) {
        System.out.println("ERROR: Input must be within range " + start + " to " + end + ".");
      } catch (InputMismatchException e) {
        System.out.println(" Invalid input ");
      } catch (Exception e) {
        System.out.println(" Invalid input ");
      }
    } while (true);
  }

  public Double nextDoubleInRange(double start, double end) {
    return nextDoubleInRange(null, start, end);
  }
}
