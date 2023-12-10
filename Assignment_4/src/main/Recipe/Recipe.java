package main.Recipe;
import java.util.ArrayList;
/**
 * A recipe for the Recipe Book Application.
 */
public class Recipe {

  public String name;
  public double portions;
  public ArrayList<IngredientsList> ingredients;
  public ArrayList<String> instructions;

  /* Constructor */
  public Recipe(String n) {
    name = n;
    portions = 0;
    ingredients = new ArrayList<IngredientsList>();
    instructions = new ArrayList<String>();
  }

  /* Constructor */
  public Recipe(String n, double p, ArrayList<IngredientsList> ingr, ArrayList<String> instr) {
    name = n;
    portions = p;
    ingredients = ingr;
    instructions = instr;
  }

  /* Returns all the recipes */
  public String getRecipeAsString(double portionsAmount, Print pp, String currency) {
    String s = pp.SurroundString(" " + name + " (" + portionsAmount + " portions) ", '¤');
    s += "\n\n" + pp.SurroundString(" Ingredients (total price: " + currency + getTotalPrice(portionsAmount) + ") ", '-') + "\n";
    s += getIngredientsListAsString(portionsAmount, pp);
    s += "\n\n" + pp.SurroundString(" Instructions ", '-') + "\n";
    s += getInstructionsAsString(pp);
    s += "\n\n" + pp.SurroundString("", '¤');
    return s;
  }

  public String getRecipeAsString(Print pp, String currency) {
    return getRecipeAsString(portions, pp, currency);
  }

  /* Returns the ingredients list */
  public String getIngredientsListAsString(double portionsAmount, Print pp) {
    String s = "";
    for (IngredientsList ingredientsListEntry : ingredients) {
      s += "\n" + pp.SurroundString(ingredientsListEntry.getDetails(portionsAmount / portions), ' ');
    }
    return s;
  }

  /* Returns the instructions list  */
  public String getInstructionsAsString(Print pp) {
    String s = "";
    int id = 1;
    for (String instruction : instructions) {
      String instructionString = id + ") " + instruction;
      s += "\n" + pp.SurroundString(instructionString, ' ');
      id++;
    }
    return s;
  }

  /* Total price of the recipe depending on the portion */
  public double getTotalPrice(double portionsAmount) {
    int total = 0;
    for (IngredientsList ingredientsListEntry : ingredients) {
      total += (ingredientsListEntry.ingredient.price * (ingredientsListEntry.amount * portionsAmount / portions)) ;
    }
    return total;
  }

  /* Adds a new ingredient */
  public void addIngredientToList (IngredientsList ingredient) {
    ingredients.add(ingredient);
  }

  /* Finds the specified ingredient */
  public ArrayList<Integer> findIngredientsInList(String ingredientName) {
    ArrayList<Integer> results = new ArrayList<Integer>();
    for (int i = 0; i < ingredients.size(); i++) {
      IngredientsList ingredientsListEntry = ingredients.get(i);
      if (ingredientsListEntry.ingredient.name.equals(ingredientName)) {
        results.add(i);
      }
    }
    return results;
  }

  public void addInstructionLine(String instLine) {
    instructions.add(instLine); 
  }

  public void deleteInstructionLine(int delLine) {
    instructions.remove(delLine);
  }

  public void deleteIngredientFromList (int index) {
    ingredients.remove(index);
  }

  public void addInstructionLine(String instLine, int delLine) {
    instructions.add(delLine, instLine); 
  }

}
