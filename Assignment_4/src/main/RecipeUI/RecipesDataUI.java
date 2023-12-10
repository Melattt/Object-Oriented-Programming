package main.RecipeUI;
import java.util.ArrayList;

import main.Recipe.IngredientsData;
import main.Recipe.Print;
import main.Recipe.Recipe;
import main.Recipe.RecipesData;
import main.Recipe.Input;
/**
 * This class manages the interaction b/n user and RecipesData.
 */
public class RecipesDataUI extends UserInterface {

  /* Constructor */
  public RecipesDataUI(Input vi, Print pp, IngredientsData ingrData, RecipesData rcpData) {
    super(vi, pp, ingrData, rcpData);
  }

  /* Title of the User Interface class */
  protected String Title() { return "Recipes"; }

  // Choices
  protected String[] Choices() {
    return new String[]{
      "List All Recipes",
      "Show Recipe",
      "Create New Recipe",
      "Edit Recipe",
      "Search Recipes",
      "Delete Recipe"
    };
  }

  protected void OnChoice(int choice) {
    switch (choice) {
      case 1:
        printRecipesList();
        break;
      case 2:
        showRecipe();
        break;
      case 3:
        createNewRecipe();
        break;
      case 4:
        editRecipe();
        break;
      case 5:
        search();
        break;
      case 6:
        deleteRecipe();
        break;
      default:
        break;
    }
  }

  // List of all recipes 
  private void printRecipesList() {
    prints.surroundPrintln(" Stored Recipes ", '-');
    ArrayList<String> recipes = recipesData.GetAllRecipeNames();
    for (String string : recipes) {
      System.out.println(string);
    }
    prints.surroundPrintln("", '-');
  }

  // Displays the UI for printing recipe to console 
  private void showRecipe() {
    String recipeName = validIn.nextLine("Enter the name of the recipe you want to show (leave empty to exit): ");
    if (recipeName != null && !recipeName.isBlank()) {
      Recipe recipe = recipesData.GetRecipe(recipeName);
      double portions = validIn.nextDoubleInRange("Enter amount of portions (0 to use recipe default): ", 0.0, 9999999);
      if (portions == 0) {
        prints.Println(recipe.getRecipeAsString(prints, ingredientsData.CURRENCY));
      } else {
        prints.Println(recipe.getRecipeAsString(portions, prints, ingredientsData.CURRENCY));
      }
    }
  }

  // Creating a new recipe 
  private void createNewRecipe() {
    prints.surroundPrintln(" Create New Recipe ", '-');
    Recipe createRecipe = new Recipe("");
    UserInterface recipeEditorUI = new RecipeEditorUI(validIn, prints, ingredientsData, recipesData, createRecipe);
    recipeEditorUI.Enter();
    if (!createRecipe.name.isBlank()) {
      prints.surroundPrintln(" A new recipe was added: " + createRecipe.name + " ", '-');
      recipesData.AddRecipe(createRecipe);
    } else {
      prints.surroundPrintln(" No new recipe was added. ", '-');
    }
  }

  // Editing a recipe 
  private void editRecipe() {
    System.out.print("Name of the recipe you want to edit (empty to exit): ");
    String recipeName = validIn.nextLine();
    Recipe recipe = recipesData.GetRecipe(recipeName);
    if (recipe != null) {
      UserInterface recipeEditorUI = new RecipeEditorUI(validIn, prints, ingredientsData, recipesData, recipe);
      recipeEditorUI.Enter();
    } else {
      System.out.println("No recipe named \"" + recipeName + "\" could be found.");
    }
  }

  // A recipe search 
  private void search() {
    UserInterface recipeSearchUI = new RecipeSearchUI(validIn, prints, ingredientsData, recipesData);
    recipeSearchUI.Enter();
  }

  // Deleting a recipe
  private void deleteRecipe() {
    System.out.print("Name of the recipe you want to delete (empty to exit): ");
    String recipeName = validIn.nextLine();
    if (recipesData.DeleteRecipe(recipeName)) {
      System.out.println("\"" + recipeName + "\" was deleted from Recipe Book.");
    } else {
      System.out.println("No recipe named \"" + recipeName + "\" could be found.");
    }
  }
}