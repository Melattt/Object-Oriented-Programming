package main.Recipe;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/**
 * The RecipesData class contains all stored recipes. 
 */
public class RecipesData {

  private TreeMap<String, Recipe> recipes;
  private IngredientsData ingredientsData;

  private String mainDelimiter = "\n";
  private String delimiter1 = ";";
  private String delimiter2 = "_";
  private String delimiter3 = "@";

  /* Constructor */
  public RecipesData(IngredientsData ingrData) {
    recipes = new TreeMap<String, Recipe>();
    ingredientsData = ingrData;
  }

  public ArrayList<Recipe> GetAllRecipes() {
    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    for (Map.Entry<String, Recipe> entry : recipes.entrySet()) {
      recipeList.add(entry.getValue());
    }
    return recipeList;
  }

  /* ArrayList with names of recipes. */
  public ArrayList<String> GetAllRecipeNames() {
    ArrayList<String> recipeStrings = new ArrayList<String>();
    for (Map.Entry<String, Recipe> entry : recipes.entrySet()) {
      String s = entry.getValue().name;
      recipeStrings.add(s);
    }
    return recipeStrings;
  }

  // To a text string. 
  public String RecipesToString() {

    String returnString = "";

    for (Map.Entry<String, Recipe> entry : recipes.entrySet()) {

      Recipe r = entry.getValue();

      String s = "";
      s += r.name + delimiter1;
      s += r.portions + delimiter1;
      for (IngredientsList ingredientsListEntry : r.ingredients) {
        System.out.println(s);
        s += ingredientsListEntry.ingredient.name + delimiter3;
        s += ingredientsListEntry.amount + delimiter3;
        s += ingredientsListEntry.guide + delimiter3;
        s += delimiter2;
      }
      s += delimiter1;
      for (String instruction : r.instructions) {
        s += instruction + delimiter2;
      }
      s += delimiter1;

      returnString += s + mainDelimiter;
    }
    System.out.println(returnString);
    return returnString;
  }

  // Reverse
  public void StringToRecipes(String inData) {
    String[] lines = inData.split(mainDelimiter); 
    for (String line : lines) {
      if (!line.equals("")) {
        String[] characters = line.split(delimiter1, -1);
        String[] ingredients = characters[2].split(delimiter2, -1);
        ArrayList<IngredientsList> ingredientList = new ArrayList<IngredientsList>();
        for (String ingredient : ingredients) {
          if (!ingredient.equals("")) {
            String[] ingredientsListEntry = ingredient.split(delimiter3, -1);
            if (ingredientsListEntry.length > 1) {
              ingredientList.add(new IngredientsList(
                ingredientsData.getIngredient(ingredientsListEntry[0]),
                Double.parseDouble(ingredientsListEntry[1]),
                ingredientsListEntry[2]
                )
              );
            }
          }
        }
        String[] instructions = characters[3].split(delimiter2, -1);
        ArrayList<String> instructionsList = new ArrayList<String>();
        for (String instruction : instructions) {
          if (instruction != null && !instruction.isBlank()) {
             instructionsList.add(instruction);
          }
        }
        Recipe r = new Recipe(characters[0], Double.parseDouble(characters[1]), ingredientList, instructionsList);
        AddRecipe(r);
      }
    }
  }

  // Adds a recipe
  public void AddRecipe(Recipe recipe) {
    recipes.put(recipe.name, recipe);
  }

  // Gets a recipe 
  public Recipe GetRecipe(String recipeName) {
    return recipes.get(recipeName);
  }

  // Deletes a recipe 
  public boolean DeleteRecipe(String recipeName) {
    if (recipes.containsKey(recipeName)) {
      recipes.remove(recipeName);
      return true;
    } else {
      return false;
    }
  }
}
