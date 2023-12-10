package main.RecipeUI;
import java.util.ArrayList;

import main.Recipe.Ingredient;
import main.Recipe.IngredientsData;
import main.Recipe.Print;
import main.Recipe.Recipe;
import main.Recipe.RecipesData;
import main.Recipe.SearchByContainsIngredient;
import main.Recipe.Input;
/**
 * This class manages the interaction b/n user and IngredientsData.
 */
public class IngredientsDataUI extends UserInterface {

  /* Constructor */
  public IngredientsDataUI(Input vi, Print pp, IngredientsData ingrData, RecipesData rcpData) {
    super(vi, pp, ingrData, rcpData);
  }

  // Title
  protected String Title() { 
    return "Ingredients"; 
  }

  // Options
  protected String[] Choices() {
    return new String[]{
      "Create New Ingredient",
      "List All Ingredients",
      "Delete Ingredient"
    };
  }

  // Switch statement for the options
  protected void OnChoice(int choice) {
    switch (choice) {
      case 1:
        createNewIngredient();
        break;
      case 2:
        listAllIngredients();
        break;
      case 3:
        deleteIngredient();
        break;
      default:
        break;
    }
  }

  // Option 1
  protected Ingredient createNewIngredient() {
    prints.surroundPrintln(" CREATE   NEW   INGREDIENT ");
    String name = validIn.nextLine("Name: ");
    if (name == null || name.isBlank()) {
      prints.surroundPrintln(" Ingredient was not created. ");
      return null;
    } else {
      double price = validIn.nextDoubleInRange("Price: ", 0, 9999999);
      String unit = validIn.next("Unit: ");
      Boolean divisible = validIn.YesOrNo("Can ingredient be divided (Y/N) ");

      Ingredient i = new Ingredient(name, price, unit, divisible);
      ingredientsData.addIngredient(i);
      prints.surroundPrintln(" New ingredient was created: " + i.details(ingredientsData.CURRENCY) + " ");
      return i;
    }
  }

  // Option 2
  private void listAllIngredients() {
    prints.surroundPrintln(" INGREDIENTS ");
    ArrayList<String> ingredients = ingredientsData.getListOfAllIngredients();
    for (String string : ingredients) {
      System.out.println(string);
    }
    prints.surroundPrintln("");
  }

  // Option 3
  private void deleteIngredient() {
    String ingredientName = validIn.nextLine("Name of the ingredient to delete: ");
    if (ingredientName != null && !ingredientName.isBlank()) {
      SearchByContainsIngredient search = new SearchByContainsIngredient(validIn);
      ArrayList<Recipe> recipesContaintingIngredient = search.getSearchResults(recipesData.GetAllRecipes(), ingredientName);
      if (recipesContaintingIngredient.size() > 0) {
        System.out.println(ingredientName + " is listed as an ingredient in the following recipes:\n");
        for (Recipe recipe : recipesContaintingIngredient) {
          prints.Println("- " + recipe.name);
        }
        System.out.println("\n The ingredients will be automatically deleted from the recipe,");
        System.out.println("and you might want to update the instructions of each recipes.");
        Boolean proceed = validIn.YesOrNo("Are you sure you want to delete the ingredient? (Y/N) ");
        if (proceed) {
          for (Recipe recipe : recipesContaintingIngredient) {
            ArrayList<Integer> ingredientListEntries = recipe.findIngredientsInList(ingredientName);
            for (int i = ingredientListEntries.size() - 1; i >= 0; i--) {
              recipe.deleteIngredientFromList(ingredientListEntries.get(i));
            }
            System.out.println(ingredientName + " was deleted from " + recipe.name + " recipe.");
          }
          ProceedToDeleteIngredientFromIngredientsData(ingredientName);
        }
      } else {
        ProceedToDeleteIngredientFromIngredientsData(ingredientName);
      }
    }
  }

  /* Method used only by DeleteIngredient() */
  private void ProceedToDeleteIngredientFromIngredientsData(String ingredientName) {
    boolean ingredientWasDeleted = ingredientsData.deleteIngredient(ingredientName);
    if (ingredientWasDeleted) {
      System.out.println("SUCCESS: " + ingredientName + " was deleted from the list of available ingredients.");
    } else {
      System.out.println("ERROR: " + ingredientName + " can not be found ");
    }
  }
}