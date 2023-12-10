package main.Recipe;
public class Ingredient {

  public static String CURRENCY_SIGN = "SEK";
  public String name;
  public String unit;
  public double price;
  public boolean dividable;

  /* Constructor */
  public Ingredient(String nm, double pr, String un, boolean db) {
    name = nm;
    price = pr;
    unit = un;
    dividable = db;
  }

  /* Details */
  public String details(String currency) {
    if (dividable) {
      return name + " ( " + currency + price + " / " + unit + "(s) )";
    } else {
      return name + " ( " + currency + price + " / " + unit + "(s), not divisible )"; 
    }
  }
}