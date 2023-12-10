package main.Recipe;
public class IngredientsList {

  public Ingredient ingredient;
  public double amount;
  public String guide;
  
  /* Constructor */
  public IngredientsList(Ingredient i, double a, String g) {
    ingredient = i;
    amount = a;
    guide = g;
  }

  /* Returns details of ingredients */
  public String getDetails(double adjustPortions) {
    double ingredientAmount = (amount * adjustPortions);
    // If the ingredient is not dividable
    if (!ingredient.dividable) {
      ingredientAmount = Math.ceil(ingredientAmount);
    }
    String ingredientString = ingredientAmount + " " + ingredient.unit + "(s) of " + ingredient.name;
    if (guide != null && !guide.isBlank()) {
      ingredientString += " - " + guide;
    }
    return ingredientString;
  }

  public String getDetails() {
    return getDetails(1);
  }
}