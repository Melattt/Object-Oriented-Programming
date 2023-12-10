package main.Recipe;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;


/* Ingredient class contains all the stored ingredients. */
public class IngredientsData {

  private TreeMap<String, Ingredient> ingredients;
  public String CURRENCY = "SEK";

  /* Constructor */
  public IngredientsData() {
    ingredients = new TreeMap<String, Ingredient>();
  }

  /* Adds the ingredient  */
  public void addIngredient(Ingredient i) {
    ingredients.put(i.name, i);
  }

  /* Gets the ingredient  */
  public Ingredient getIngredient(String ingredientName) {
    return ingredients.get(ingredientName);
  }

  /*  Deletes the ingredient  */
  public boolean deleteIngredient(String ingredientName) {
    if (ingredients.containsKey(ingredientName)) {
      ingredients.remove(ingredientName);
      return true;
    } else {
      return false;
    }
  }
  /* Returns list of all ingredients with their details */
  public ArrayList<String> getListOfAllIngredients() {

    ArrayList<String> ingredientStrings = new ArrayList<String>();

    for (Map.Entry<String, Ingredient> entry : ingredients.entrySet()) {
      String s = entry.getValue().details(CURRENCY);
      ingredientStrings.add(s);
    }

    return ingredientStrings;
  }

  /* Brings the contents of the ingredients together */
  public void stringsToIngredients(String Data) {
    String[] lines = Data.split("\n");
    for (String line : lines) {
      String[] characters = line.split(";");
      Ingredient ing;
      if (characters.length == 4) {
        ing = new Ingredient(characters[0], Double.parseDouble(characters[1]), characters[2], Boolean.parseBoolean(characters[3]));
        addIngredient(ing);
      } else if (characters.length == 3) {
        ing = new Ingredient(characters[0], Double.parseDouble(characters[1]), characters[2], true);
        addIngredient(ing);
      }
    }
  }

  /*  Separates contents of the ingredients */
  public String ingredientsToStrings() {

    String str = "";
    for (Map.Entry<String, Ingredient> entry : ingredients.entrySet()) {
      Ingredient i = entry.getValue();
      String s = "";
      s += i.name + ";";
      s += i.price + ";";
      s += i.unit + ";";
      if (!i.dividable) s += String.valueOf(i.dividable) + ";";
      str += s + "\n";
    }
    return str;
  }
}